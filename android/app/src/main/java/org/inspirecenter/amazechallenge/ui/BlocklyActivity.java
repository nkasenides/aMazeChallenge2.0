package org.inspirecenter.amazechallenge.ui;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.model.BlocklySerializerException;
import com.google.blockly.model.DefaultBlocks;

import org.inspirecenter.amazechallenge.R;
import org.inspirecenter.amazechallenge.utils.ErrorFinderManager;
import org.inspirecenter.amazechallenge.utils.FileManager;

import com.nkasenides.amc.algorithms.InterpreterError;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.nkasenides.amc.algorithms.InterpreterError.InterpreterErrorType.ERROR;
import static com.nkasenides.amc.algorithms.InterpreterError.InterpreterErrorType.WARNING;
import static org.inspirecenter.amazechallenge.ui.MainActivity.setLanguage;

public class BlocklyActivity extends AbstractBlocklyActivity {

    private static final String TAG = "MazeBlocklyActivity";
    private static final String DEFAULT_SAVE_FILENAME = "maze_workspace.xml";
    public static String SAVE_FILENAME = DEFAULT_SAVE_FILENAME;
    public static final String AUTOSAVE_FILENAME = "maze_workspace_temp.xml";
    public static final String KEY_ALGORITHM_ACTIVITY_CODE = "KEY_ALGORITHM_ACTIVITY_CODE";
    public static final String ASSETS_CODES_DIR = "defaultCodes";
    public static ArrayList<String> codeNamesList = new ArrayList<>();
    public static ArrayList<String> codeFilesList = new ArrayList<>();
    public static ArrayList<String> codeFilesLastModifiedList = new ArrayList<>();
    public static AlertDialog loadDialog;
    private final BlocklyActivity instance = this;
    private static final String BLOCKS_FILE = "blocks/maze_blocks.json";
    private static final String BLOCK_GENERATORS_FILE = "generators/maze_blocks.js";
    private static final String AMAZE_TOOLEBOX_XML = "toolboxes/maze_toolbox.xml";
    private static final String ALLOWED_PLAYER_CODE_FILES_REGEX = "[a-zA-Z0-9]*";

    public static final String INTENT_KEY_NEXT_ACTIVITY = "INTENT_KEY_NEXT_ACTIVITY";

    private static final List<String> BLOCK_DEFINITIONS = Arrays.asList(
            DefaultBlocks.COLOR_BLOCKS_PATH,
            DefaultBlocks.LOGIC_BLOCKS_PATH,
            DefaultBlocks.LOOP_BLOCKS_PATH,
            DefaultBlocks.MATH_BLOCKS_PATH,
            DefaultBlocks.TEXT_BLOCKS_PATH,
            DefaultBlocks.VARIABLE_BLOCKS_PATH,
            BLOCKS_FILE
    );//end List BLOCK_DEFINITIONS

    private static final List<String> JAVASCRIPT_GENERATORS = Collections.singletonList(
            BLOCK_GENERATORS_FILE
    );//end List JAVASCRIPT_GENERATORS

    CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback = generatedCode -> {
        Log.d(TAG, "generatedCode:\n" + generatedCode);
        Toast.makeText(getApplicationContext(), R.string.Your_code_has_been_saved, Toast.LENGTH_LONG).show();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(BlocklyActivity.this);
        sharedPreferences.edit().putString (KEY_ALGORITHM_ACTIVITY_CODE, generatedCode).apply();

        if(generatedCode != null && !generatedCode.isEmpty()) {
            sharedPreferences.edit().putBoolean(MainActivity.KEY_PREF_EDITED_CODE, true).apply();
        }

        final boolean goToTraining = TrainingActivity.class.getCanonicalName().equals(getIntent().getSerializableExtra(INTENT_KEY_NEXT_ACTIVITY));
        final boolean goToOnline = OnlineGameActivity.class.getCanonicalName().equals(getIntent().getSerializableExtra(INTENT_KEY_NEXT_ACTIVITY));
        Log.d(TAG, "goToTraining: " + goToTraining);
        Log.d(TAG, "goToOnline: " + goToOnline);

        if(goToTraining) {
            startActivity(new Intent(BlocklyActivity.this, TrainingActivity.class));
        } else  if(goToOnline) {
            startActivity(new Intent(BlocklyActivity.this, OnlineGameActivity.class));
        } else {
            Log.d(TAG, "goToFinish!");
            BlocklyActivity.this.finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setLanguage(this);
        setTitle(getString(R.string.edit_your_code));
        final ActionBar actionBar = getActionBar();
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected View onCreateContentView(int containerId) {
        return getLayoutInflater().inflate(R.layout.activity_blockly, null);
    }

    public void done(final View view) {
        submitCode();
    }

    private void submitCode() {

        //Save the code first, but don't display message:
        try { mBlocklyActivityHelper.saveWorkspaceToAppDir(AUTOSAVE_FILENAME); }
        catch (FileNotFoundException | BlocklySerializerException e) { e.printStackTrace(); }

        //Check the code:
        ArrayList<InterpreterError> errorList = ErrorFinderManager.checkCode(instance);

        int warnings = 0;
        int errors = 0;
        for (final InterpreterError e : errorList) {
            if (e.type == WARNING) warnings++;
            else if (e.type == ERROR) errors++;
        }//end for

        if (errorList.isEmpty()) {
            if (getController().getWorkspace().hasBlocks()) {
                Snackbar compilingSnackbar = Snackbar.make(findViewById(R.id.blocklyView), R.string.Compiling, Snackbar.LENGTH_INDEFINITE);
                View sbCView = compilingSnackbar.getView(); sbCView.setBackgroundColor(getResources().getColor(R.color.snackbarGreen));
                compilingSnackbar.show();
                onRunCode();
            }//end if has blocks and no error occured
            else {
                finish();
            }//end if no blocks and no error
        }//end if no errors
        else {
            if (errors > 1) {
                AlertDialog.Builder errorBuilder = new AlertDialog.Builder(this, R.style.ErrorDialogStyle);
                errorBuilder.setTitle(R.string.errors);
                errorBuilder.setMessage(getString(R.string.multiple_errors_found));
                final AlertDialog errorDialog = errorBuilder.create();
                final AlertDialog errorListDialog = ErrorDialogCreator.createErrorListDialog(instance, errorList);
                errorDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.view), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        errorListDialog.show();
                        dialogInterface.dismiss();
                    }
                });
                errorDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.back_to_menu), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intentBack = new Intent(BlocklyActivity.this, MainActivity.class);
                        startActivity(intentBack);
                    }
                });
                errorDialog.show();
            }//end if multiple errors occurred
            else if (errors > 0) {
                AlertDialog.Builder errorBuilder = new AlertDialog.Builder(this, R.style.ErrorDialogStyle);
                errorBuilder.setTitle(getString(R.string.error));
                errorBuilder.setNegativeButton(R.string.back_to_menu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intentBack = new Intent(BlocklyActivity.this, MainActivity.class);
                        startActivity(intentBack);
                    }
                });
                errorBuilder.setPositiveButton(R.string.try_again, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                InterpreterError e = ErrorFinderManager.getNextError(errorList);
                if (e == null) throw new RuntimeException("FATAL ERROR IN BLOCKLYACTIVITY: Could not find error in a presumably error-containing arraylist");
                else errorBuilder.setMessage(e.toString());
                errorBuilder.create().show();
            }//end if 1 error occurred
            else if (warnings > 1) {
                AlertDialog.Builder warningBuilder = new AlertDialog.Builder(this, R.style.WarningDialogStyle);
                warningBuilder.setTitle(R.string.warnings);
                warningBuilder.setMessage(getString(R.string.multiple_warnings_found));
                final AlertDialog warningDialog = warningBuilder.create();
                final AlertDialog errorListDialog = ErrorDialogCreator.createWarningListDialog(instance, errorList);
                warningDialog.setButton(DialogInterface.BUTTON_NEUTRAL, getString(R.string.back_to_menu), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intentBack = new Intent(BlocklyActivity.this, MainActivity.class);
                        startActivity(intentBack);
                    }
                });
                warningDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.ignore_all), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar compilingSnackbar = Snackbar.make(findViewById(R.id.blocklyView), R.string.Compiling, Snackbar.LENGTH_LONG);
                        View sbCView = compilingSnackbar.getView(); sbCView.setBackgroundColor(getResources().getColor(R.color.snackbarGreen));
                        compilingSnackbar.show();
                        onRunCode();
                    }
                });
                warningDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.view), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        errorListDialog.show();
                    }
                });
                warningDialog.show();
            }//end if multiple warnings occurred
            else if (warnings > 0) {
                AlertDialog.Builder warningBuilder = new AlertDialog.Builder(this, R.style.WarningDialogStyle);
                warningBuilder.setTitle(getString(R.string.warning));
                warningBuilder.setNeutralButton(R.string.back_to_menu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intentBack = new Intent(BlocklyActivity.this, MainActivity.class);
                        startActivity(intentBack);
                    }
                });
                warningBuilder.setNegativeButton(R.string.ignore, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar compilingSnackbar = Snackbar.make(findViewById(R.id.blocklyView), R.string.Compiling, Snackbar.LENGTH_LONG);
                        View sbCView = compilingSnackbar.getView(); sbCView.setBackgroundColor(getResources().getColor(R.color.snackbarGreen));
                        compilingSnackbar.show();
                        onRunCode();
                    }
                });
                warningBuilder.setPositiveButton(R.string.try_again, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                InterpreterError e = ErrorFinderManager.getNextWarning(errorList);
                if (e == null) throw new RuntimeException("FATAL ERROR IN BLOCKLYACTIVITY: Could not find warning in a presumably warning-containing arraylist");
                else warningBuilder.setMessage(e.toString());
                warningBuilder.create().show();
            }//end if 1 warning occurred
        }//end if errors
    }//end submitCode()

    @NonNull
    @Override
    protected List<String> getBlockDefinitionsJsonPaths() {
        return BLOCK_DEFINITIONS;
    }

    @NonNull
    @Override
    protected String getToolboxContentsXmlPath() {
        return AMAZE_TOOLEBOX_XML;
    }

    @NonNull
    @Override
    protected List<String> getGeneratorsJsPaths() {
        return JAVASCRIPT_GENERATORS;
    }

    @NonNull
    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {
        return mCodeGeneratorCallback;
    }

    @Override
    @NonNull
    protected String getWorkspaceSavePath() {
        return SAVE_FILENAME;
    }

    @Override
    @NonNull
    protected String getWorkspaceAutosavePath() {
        return AUTOSAVE_FILENAME;
    }

    @Override
    protected int getActionBarMenuResId() {
        return R.menu.blockly_action_bar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                submitCode();
                return true;

            case R.id.action_save:
                final EditText input = new EditText(BlocklyActivity.this);
                final AlertDialog SAVE_DIALOG = ErrorDialogCreator.createSaveDialog(instance, input);
                SAVE_DIALOG.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button b = SAVE_DIALOG.getButton(AlertDialog.BUTTON_POSITIVE);
                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (FileManager.internalPlayerFileExists(instance, input.getText().toString())) {
                                    AlertDialog.Builder confirmOverwriteDialog = new AlertDialog.Builder(BlocklyActivity.this);
                                    confirmOverwriteDialog.setTitle(R.string.code_overwrite)
                                            .setMessage(R.string.code_overwrite_message)
                                            .setPositiveButton(R.string.code_overwrite_yes, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    String savedFileName = FileManager.PLAYER_CODE_FILENAME_PREFIX + input.getText().toString() + FileManager.XML_FILE_EXTENSION;
                                                    FileManager.setSaveFilename(savedFileName);
                                                    onSaveWorkspace();
                                                    dialogInterface.dismiss();
                                                    SAVE_DIALOG.dismiss();
                                                }
                                            })
                                            .setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    dialogInterface.dismiss();
                                                }
                                            }).create().show();
                                }
                                else if (input.getText().toString().isEmpty())
                                    Snackbar.make(view, R.string.save_code_error_empty, Snackbar.LENGTH_SHORT).show();
                                else if (!input.getText().toString().matches(ALLOWED_PLAYER_CODE_FILES_REGEX))
                                    Snackbar.make(view, R.string.save_code_error_invalid, Snackbar.LENGTH_SHORT).show();
                                else {
                                    String savedFileName = FileManager.PLAYER_CODE_FILENAME_PREFIX + input.getText().toString() + FileManager.XML_FILE_EXTENSION;
                                    FileManager.setSaveFilename(savedFileName);
                                    onSaveWorkspace();
                                    SAVE_DIALOG.dismiss();
                                }//end else
                            }//end onClick()
                        });//end clicklistener
                    }//end onShow()
                });//end onShowListener
                SAVE_DIALOG.show();
                return true;


            case R.id.action_load:
                FileManager.updateInternalStorageCodes(instance);
                FileManager.getCodes(instance);
                final ListView list = new ListView(BlocklyActivity.this);
                loadDialog = ErrorDialogCreator.createLoadDialog(instance, list);
                list.setOnItemClickListener((adapterView, view, i, l) -> {
                    FileManager.setSaveFilename(codeFilesList.get(i));
                    onLoadWorkspace();
                    loadDialog.dismiss();
                });
                loadDialog.show();
                return true;


            case R.id.action_clear:
                // show confirm dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.Clear_code)
                        .setMessage(R.string.Are_you_sure_you_want_to_erase_the_code)
                        .setPositiveButton(R.string.Clear, (dialogInterface, i) -> onClearWorkspace())
                        .setNegativeButton(R.string.Cancel, (dialogInterface, i) -> dialogInterface.cancel()).create().show();
                return true;
        }//end switch
        return super.onOptionsItemSelected(item);
    }//end onOptionsItemSelected()

    @Override
    public void onBackPressed() {
        getIntent().putExtra(INTENT_KEY_NEXT_ACTIVITY, ""); // reset intent extra so that the activity returns to main after it finishes compiling
        submitCode();
    }

    public void runCode() {
        onRunCode();
    }

}//end activity BlocklyActivity