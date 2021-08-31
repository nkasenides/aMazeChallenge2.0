package org.inspirecenter.amazechallenge.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import org.inspirecenter.amazechallenge.controller.RuntimeController;
import org.inspirecenter.amazechallenge.model.AMCPlayer;
import org.inspirecenter.amazechallenge.model.AMCWorldSession;
import org.inspirecenter.amazechallenge.model.Game;
import org.inspirecenter.amazechallenge.model.Grid;
import org.inspirecenter.amazechallenge.model.MatrixPosition;
import org.inspirecenter.amazechallenge.model.PickableEntity;
import org.inspirecenter.amazechallenge.model.PlayerEntity;
import org.inspirecenter.amazechallenge.proto.AMCEntityProto;
import org.inspirecenter.amazechallenge.proto.AMCPartialStateProto;
import org.inspirecenter.amazechallenge.proto.AMCPlayerProto;
import org.inspirecenter.amazechallenge.proto.AMCStateUpdateProto;
import org.inspirecenter.amazechallenge.proto.AMCWorldSessionProto;
import org.inspirecenter.amazechallenge.proto.BackgroundImage;
import org.inspirecenter.amazechallenge.proto.Direction4;
import org.inspirecenter.amazechallenge.proto.PickableType;
import org.inspirecenter.amazechallenge.proto.Shape;

import org.inspirecenter.amazechallenge.Installation;
import org.inspirecenter.amazechallenge.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.function.BiConsumer;

import static org.inspirecenter.amazechallenge.generation.AMCTerrainGenerator.SHAPE_ONLY_LEFT_SIDE;
import static org.inspirecenter.amazechallenge.generation.AMCTerrainGenerator.SHAPE_ONLY_LOWER_SIDE;
import static org.inspirecenter.amazechallenge.generation.AMCTerrainGenerator.SHAPE_ONLY_RIGHT_SIDE;
import static org.inspirecenter.amazechallenge.generation.AMCTerrainGenerator.SHAPE_ONLY_UPPER_SIDE;

/**
 * @author Nearchos
 *         Created: 14-Aug-17
 */

public class GameView extends View {

    public static final String TAG = "aMaze";

    public static final int COLOR_BLACK         = Color.rgb(0, 0, 0);
    public static final int COLOR_LIGHT_RED     = Color.rgb(255, 192, 192);
    public static final int COLOR_LIGHT_GREEN   = Color.rgb(192, 255, 192);

    private final Context context;
    private final String you;

    public static final BackgroundImage DEFAULT_MAZE_BACKGROUND = BackgroundImage.TEXTURE_GRASS_BackgroundImage;

    public GameView(final Context context) {
        super(context);
        this.context = context;
        backgroundDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(BackgroundImage.TEXTURE_GRASS_BackgroundImage.getResourceName(), "drawable", context.getPackageName())));
        you = context.getString(R.string.You);
    }

    public GameView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        backgroundDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(BackgroundImage.TEXTURE_GRASS_BackgroundImage.getResourceName(), "drawable", context.getPackageName())));
        you = context.getString(R.string.You);
    }

    private Grid grid = null;
    private int lineColor = Color.BLACK;
    private BitmapDrawable backgroundDrawable;
    public Map<String, AMCPlayer> allIDsToPlayers;
//    public Map<String, PlayerPositionAndDirection> activePlayerIdToPositionAndDirectionMap = new HashMap<>();
    public Map<String, AMCWorldSession> worldSessions = new HashMap<>();
    public Map<String, PlayerEntity> playerEntities = new HashMap<>();
    public List<PickableEntity> pickables = new Vector<>();

    void setGrid(final Grid grid) {
        this.grid = grid;
    }

    void update(final Game game) {
        System.out.println("Players: " + game.getAllPlayers().size());
        this.allIDsToPlayers = game.getAllPlayers();
        for(final String activePlayerId : game.getActivePlayers()) {
            System.out.println("Player: " + activePlayerId);
            playerEntities.put(activePlayerId, game.getPlayerEntities().get(activePlayerId));
//            activePlayerIdToPositionAndDirectionMap.put(activePlayerId, game.getPlayerPositionAndDirectionById(activePlayerId));
        }
        this.pickables = game.getPickables();
    }

    void setLineColor(String lineColor) {
        this.lineColor = Color.parseColor(lineColor);
    }

    void setBackgroundDrawable(int backgroundImage) {
        Bitmap bm = BitmapFactory.decodeResource(getResources(), backgroundImage);
        backgroundDrawable = new BitmapDrawable(getResources(), bm);
    }

    void setBackgroundDrawable(BackgroundImage backgroundImage) {
        Bitmap bm;
        if (backgroundImage != null)
            bm = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(backgroundImage.getResourceName(), "drawable", context.getPackageName()));
        else
            bm = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(DEFAULT_MAZE_BACKGROUND.getResourceName(), "drawable", context.getPackageName()));
        backgroundDrawable = new BitmapDrawable(getResources(), bm);
    }

    /**
     * Initializes the local state after requesting the initial state (/GetState) from the server.
     * @param state The received state.
     */
    void initialize(final AMCPartialStateProto state) {
        //Players:
        allIDsToPlayers = new HashMap<>();
        for (Map.Entry<String, AMCPlayerProto> entry : state.getPlayersMap().entrySet()) {
            allIDsToPlayers.put(entry.getKey(), entry.getValue().toObject());
        }

        //World sessions:
        worldSessions = new HashMap<>();
        for (Map.Entry<String, AMCWorldSessionProto> entry : state.getWorldSessionsMap().entrySet()) {
            worldSessions.put(entry.getKey(), entry.getValue().toObject());
        }

        //Grid/Terrain:
        this.grid = state.getGrid().toObject();

        //Entities:
        for (Map.Entry<String, AMCEntityProto> entry : state.getEntitiesMap().entrySet()) {
            //Pickables:
            if (entry.getValue().hasPickableEntity()) {
                pickables.add(entry.getValue().getPickableEntity().toObject());
            }
            //Player entities:
            else if (entry.getValue().hasPlayerEntity()) {
                playerEntities.put(entry.getKey(), entry.getValue().getPlayerEntity().toObject());
            }
        }

        invalidate();
    }

    /**
     * Updates the local state after receiving an update from the server.
     * Note: The terrain/Grid is omitted from state updates as its state does not change.
     * @param stateUpdate
     */
    void update(final AMCStateUpdateProto stateUpdate) {

        //Players:
        allIDsToPlayers = new HashMap<>();
        for (Map.Entry<String, AMCPlayerProto> entry : stateUpdate.getPartialState().getPlayersMap().entrySet()) {
            allIDsToPlayers.put(entry.getKey(), entry.getValue().toObject());
        }

        //World sessions:
        worldSessions = new HashMap<>();
        for (Map.Entry<String, AMCWorldSessionProto> entry : stateUpdate.getPartialState().getWorldSessionsMap().entrySet()) {
            worldSessions.put(entry.getKey(), entry.getValue().toObject());
        }

        //Grid/Terrain:
//        this.grid = stateUpdate.getPartialState().getGrid().toObject();

        //Entities:
        for (Map.Entry<String, AMCEntityProto> entry : stateUpdate.getPartialState().getEntitiesMap().entrySet()) {
            //Pickables:
            if (entry.getValue().hasPickableEntity()) {
                pickables.add(entry.getValue().getPickableEntity().toObject());
            }
            //Player entities:
            else if (entry.getValue().hasPlayerEntity()) {
                playerEntities.put(entry.getKey(), entry.getValue().getPlayerEntity().toObject());
            }
        }

        invalidate();
    }

    /**
     * This allows this custom view to maintain a 'square' dimension
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int dimen = (width > height) ? height : width;

        setMeasuredDimension(dimen, dimen);
    }

    private final Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        backgroundDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        backgroundDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        backgroundDrawable.draw(canvas);

        if(grid == null) return;

        // compute tile_size and padding
        final int width = canvas.getWidth();
        final int height = canvas.getHeight();
        final int smallestSide = Math.min(width, height);
        // assumes the tiles are squares
        final int tile_size = smallestSide / grid.getWidth();
        final int padding = (smallestSide - (tile_size * grid.getWidth())) / 2;

        // draw maze grid (row 0 is top, and col 0 is left (so move from top left rightwards, then next row, and so on)
        for(int row = 0; row < grid.getWidth(); row++) {
            for(int col = 0; col < grid.getHeight(); col++) {
                final int shape = RuntimeController.getGridCell(grid, row, col);
                drawGridCell(row, col, tile_size, padding, shape, lineColor, canvas);
            }
        }

        // draw starting and target positions
        final MatrixPosition startingPosition = grid.getStartingPosition();
        drawGridCell(startingPosition.getRow(), startingPosition.getCol(), tile_size, padding, 0x0, COLOR_BLACK, COLOR_LIGHT_RED, canvas);
        final MatrixPosition targetPosition = grid.getTargetPosition();
        drawGridCell(targetPosition.getRow(), targetPosition.getCol(), tile_size, padding, 0x0, COLOR_BLACK, COLOR_LIGHT_GREEN, canvas);

        // draw pickables and rewards
        for(final PickableEntity pickable : pickables) {
            drawPickableItem(pickable.getPosition(), getDrawableResourceId(pickable), tile_size, padding, canvas);
        }

        System.out.println("players:");
        allIDsToPlayers.forEach(new BiConsumer<String, AMCPlayer>() {
            @Override
            public void accept(String s, AMCPlayer amcPlayer) {
                System.out.println(s);
            }
        });

        // draw active players
        for(final Map.Entry<String, PlayerEntity> entry : playerEntities.entrySet()) {
            final String activePlayerId = entry.getValue().getPlayerID();
            System.out.println("activePlayerId = " + activePlayerId);
            final AMCPlayer player = allIDsToPlayers.get(activePlayerId);
            final PlayerEntity playerEntity = entry.getValue();
            if (player == null) {
                System.err.println("player == null");
                return;
            }
            drawPlayer(player, playerEntity, playerEntity.getPosition(), playerEntity.getDirection(), tile_size, padding, canvas);
        }
    }

    /**
     * @param shape the hex value of the shape (LSB is top, next is bottom, next is left and MSB is right)
     */
    private void drawGridCell(final int row, final int col, final int tile_size, final int padding, final int shape, final int color, final int background, final Canvas canvas) {

        paint.setColor(background);

        final int topLeftX = col * tile_size + padding;
        final int topLeftY = row * tile_size + padding;

        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(topLeftX + 1, topLeftY + 1, topLeftX + tile_size - 1, topLeftY + tile_size - 1, paint);

        drawGridCell(row, col, tile_size, padding, shape, color, canvas);
    }

    /**
     * @param shape the hex value of the shape (LSB is top, next is bottom, next is left and MSB is right)
     */
    private void drawGridCell(final int row, final int col, final int tile_size, final int padding, final int shape, final int color, final Canvas canvas) {

        paint.setColor(color);
        paint.setStrokeWidth(5f);

        final int topLeftX = col * tile_size + padding;
        final int topLeftY = row * tile_size + padding;

        int gridDimension = Math.max(grid.getHeight(), grid.getWidth());
        if (gridDimension > 25) paint.setStrokeWidth(3f);

        // draw left line
        if((shape & SHAPE_ONLY_LEFT_SIDE) != 0) { canvas.drawLine(topLeftX, topLeftY, topLeftX, topLeftY + tile_size, paint); }
        // draw right line
        if((shape & SHAPE_ONLY_RIGHT_SIDE) != 0) { canvas.drawLine(topLeftX + tile_size, topLeftY, topLeftX + tile_size, topLeftY + tile_size, paint); }
        // draw upper line
        if((shape & SHAPE_ONLY_UPPER_SIDE) != 0) { canvas.drawLine(topLeftX, topLeftY, topLeftX + tile_size, topLeftY, paint); }
        // draw lower line
        if((shape & SHAPE_ONLY_LOWER_SIDE) != 0) { canvas.drawLine(topLeftX, topLeftY + tile_size, topLeftX + tile_size, topLeftY + tile_size, paint); }
    }

    private void drawPlayer(final AMCPlayer player, final PlayerEntity playerEntity, final MatrixPosition position, final Direction4 direction, final int tile_size, final int padding, final Canvas canvas) {

        // draw actual player shape
        if (playerEntities.containsKey(playerEntity.getId())) {
            drawShape(position, Shape.TRIANGLE_Shape, direction, Color.parseColor(player.getColor().getHexCode()), tile_size, padding, canvas);
        }

        // if this is 'this' player then indicate accordingly
        final boolean isSelf = player.getId().equals(Installation.id(context));
        if(isSelf) {
            final int topLeftX = position.getCol() * tile_size + 2 * padding;
            final int topLeftY = position.getRow() * tile_size + 2 * padding;
            paint.setColor(Color.YELLOW);
            canvas.drawRect(topLeftX + 1, topLeftY + 1, topLeftX + 2 * tile_size / 3, topLeftY + tile_size / 3 + 1, paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(tile_size / 3);
            canvas.drawText(you, topLeftX + 2, topLeftY+ tile_size / 3 - 1, paint);
        }
    }

    private void drawPickableItem(final MatrixPosition position, final int imageResourceID, final int tile_size, final int padding, final Canvas canvas) {

        final int topLeftX = position.getCol() * tile_size + padding;
        final int topLeftY = position.getRow() * tile_size + padding;

        Drawable d = getResources().getDrawable(imageResourceID);

        if (d != null) {
            d.setBounds(topLeftX + tile_size / 8, topLeftY + tile_size / 8, topLeftX + tile_size * 7 / 8, topLeftY + tile_size * 7 / 8);
            d.draw(canvas);
        }

    }

    private void drawShape(final MatrixPosition position, final Shape shape, final Direction4 direction, final int color, final int tile_size, final int padding, final Canvas canvas) {

        paint.setColor(color);

        final int topLeftX = position.getCol() * tile_size + padding;
        final int topLeftY = position.getRow() * tile_size + padding;

        switch (shape) {

            //Player shapes:

            case TRIANGLE_Shape:
                // draw directed triangle
                final Point point1, point2, point3;
                switch (direction) {
                    case NORTH:
                        point1 = new Point(topLeftX + tile_size / 2, topLeftY + tile_size / 4);
                        point2 = new Point(topLeftX + tile_size / 4, topLeftY + tile_size * 3 / 4);
                        point3 = new Point(topLeftX + tile_size * 3 / 4, topLeftY + tile_size * 3 / 4);
                        break;
                    case SOUTH:
                        point1 = new Point(topLeftX + tile_size / 2, topLeftY + tile_size * 3 / 4);
                        point2 = new Point(topLeftX + tile_size / 4, topLeftY + tile_size / 4);
                        point3 = new Point(topLeftX + tile_size * 3 / 4, topLeftY + tile_size / 4);
                        break;
                    case WEST:
                        point1 = new Point(topLeftX + tile_size / 4, topLeftY + tile_size / 2);
                        point2 = new Point(topLeftX + tile_size * 3 / 4, topLeftY + tile_size / 4);
                        point3 = new Point(topLeftX + tile_size * 3 / 4, topLeftY + tile_size * 3 / 4);
                        break;
                    case EAST:
                        point1 = new Point(topLeftX + tile_size * 3 / 4, topLeftY + tile_size / 2);
                        point2 = new Point(topLeftX + tile_size / 4, topLeftY + tile_size / 4);
                        point3 = new Point(topLeftX + tile_size / 4, topLeftY + tile_size * 3 / 4);
                        break;
                    default:
                        throw new RuntimeException("Invalid direction: " + direction);
                }

                //Draw the inner part of the triangle:
                Path path = new Path();
                path.setFillType(Path.FillType.EVEN_ODD);
                path.moveTo(point1.x,point1.y);
                path.lineTo(point2.x,point2.y);
                path.lineTo(point3.x,point3.y);
                path.lineTo(point1.x,point1.y);
                path.close();
                canvas.drawPath(path, paint);

                //Draw the outline of the triangle:
                paint.setColor(Color.WHITE);
                canvas.drawLine(point1.x, point1.y, point2.x, point2.y, paint);
                canvas.drawLine(point2.x, point2.y, point3.x, point3.y, paint);
                canvas.drawLine(point1.x, point1.y, point3.x, point3.y, paint);

                break;

            case CIRCLE_Shape:
                // draw full circle
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(topLeftX + tile_size / 2, topLeftY + tile_size / 2, tile_size / 3, paint);
                break;

            case EMPTY_CIRCLE_Shape:
                // draw empty circle
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(topLeftX + tile_size / 2, topLeftY + tile_size / 2, tile_size / 3, paint);
                break;

            default:
                throw new RuntimeException("Invalid shape: " + shape);
        }
    }

    private int getDrawableResourceId(final PickableEntity item) {
        if (item.getPickableType() == PickableType.BOMB_PickableType) {
            if (item.getState() > 5) return R.drawable.bomb;
            else if (item.getState() > 1) return R.drawable.bomb_stage2;
            else return R.drawable.bomb_stage3;
        }
        return getResources().getIdentifier(item.getPickableType().getImageResourceName(), "drawable", context.getPackageName());
    }
}