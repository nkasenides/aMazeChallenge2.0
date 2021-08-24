package org.inspirecenter.amazechallenge.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;

import org.inspirecenter.amazechallenge.R;
import org.inspirecenter.amazechallenge.utils.Language;

import static org.inspirecenter.amazechallenge.ui.MainActivity.KEY_PREF_LANG;

public class HelpActivity extends AppCompatActivity {

    public static final String KEY_PREF_LAST_HELP_PAGE_INDEX = "pref-last-help-page";

    public static final String [] ASSET_URLS_EN = new String [] {
            "file:///android_asset/help/en/index.html",
            "file:///android_asset/help/en/personalization.html",
            "file:///android_asset/help/en/coding.html",
            "file:///android_asset/help/en/writingCode_part1.html",
            "file:///android_asset/help/en/writingCode_part2.html",
            "file:///android_asset/help/en/writingCode_part3.html",
            "file:///android_asset/help/en/samplecode.html",
            "file:///android_asset/help/en/training.html",
            "file:///android_asset/help/en/mazedesigner.html",
            "file:///android_asset/help/en/online.html"
    };

    //TODO
    public static final String [] ASSET_URLS_GR = new String [] {
            "file:///android_asset/help/el/index.html",
            "file:///android_asset/help/el/personalization.html",
            "file:///android_asset/help/el/coding.html",
            "file:///android_asset/help/el/writingCode_part1.html",
            "file:///android_asset/help/el/writingCode_part2.html",
            "file:///android_asset/help/el/writingCode_part3.html",
            "file:///android_asset/help/el/samplecode.html",
            "file:///android_asset/help/el/training.html",
            "file:///android_asset/help/el/mazedesigner.html",
            "file:///android_asset/help/el/online.html"
    };

    public static String[] ASSET_URLS;

    /** The {@link ViewPager} that will host the section contents. */
    private ViewPager viewPager;

    private ImageButton imageButtonPrevious;
    private ImageButton imageButtonNext;
    private FloatingActionButton buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        MainActivity.setLanguage(this);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String currentLocale = sharedPreferences.getString(KEY_PREF_LANG, Language.ENGLISH.getLocale());
        if (currentLocale.equals("el")) ASSET_URLS = ASSET_URLS_GR;
        else ASSET_URLS = ASSET_URLS_EN;

        setContentView(R.layout.activity_help);

        // Create the adapter that will return a fragment for each of the three primary sections of
        // the activity. The {@link android.support.v4.view.PagerAdapter} that will provide
        // fragments for each of the sections. We use a {@link FragmentPagerAdapter} derivative,
        // which will keep every loaded fragment in memory. If this becomes too memory intensive,
        // it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
        final SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        buttonNext = findViewById(R.id.activity_help_button_next);

        // Set up the ViewPager with the sections adapter.
        viewPager = findViewById(R.id.container);
        viewPager.setAdapter(sectionsPagerAdapter);

        imageButtonPrevious = findViewById(R.id.fragment_help_previous);
        imageButtonNext = findViewById(R.id.fragment_help_next);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateButtonVisibility(position);
                final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(HelpActivity.this);
                sharedPreferences.edit().putInt(KEY_PREF_LAST_HELP_PAGE_INDEX, position).apply();
                if(position == ASSET_URLS.length - 1) { // when the last help page is viewed, then remember that 'learn' has completed
                    sharedPreferences.edit().putBoolean(MainActivity.KEY_PREF_LEARNED, true).apply();
                }
            }
        });
        imageButtonPrevious.setOnClickListener(view -> viewPager.arrowScroll(View.FOCUS_LEFT));
        imageButtonNext.setOnClickListener(view -> viewPager.arrowScroll(View.FOCUS_RIGHT));
    }

    @Override
    protected void onResume() {
        super.onResume();
        final int lastHelpPage = PreferenceManager.getDefaultSharedPreferences(this).getInt(KEY_PREF_LAST_HELP_PAGE_INDEX, 0);
        viewPager.setCurrentItem(lastHelpPage);
        updateButtonVisibility(lastHelpPage);
    }

    private void updateButtonVisibility(final int position) {
        // access and set 'next' button's visibility
        imageButtonPrevious.setVisibility(position > 0 ? View.VISIBLE : View.GONE);
        imageButtonNext.setVisibility(position < ASSET_URLS.length - 1 ? View.VISIBLE : View.GONE);
        buttonNext.setVisibility(position < ASSET_URLS.length - 1 ? View.GONE : View.VISIBLE);
    }

    public void done(final View view) {
        startActivity(new Intent(this, PersonalizeActivity.class));
        finish();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section index.
         */
        public static PlaceholderFragment newInstance(final int index) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, index);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_help, container, false);
            final int index = getArguments().getInt(ARG_SECTION_NUMBER);
            final String assetPage = ASSET_URLS[index];
            // access and set 'previous' button's visibility
            final WebView webView = rootView.findViewById(R.id.fragment_help_web_view);
            webView.loadUrl(assetPage);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the
     * sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return ASSET_URLS.length;
        }
    }
}