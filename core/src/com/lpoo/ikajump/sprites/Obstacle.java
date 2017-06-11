package com.lpoo.ikajump.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Nuno on 03-06-2017.
 */

public class Obstacle {

    public static final int OBSTACLE_WIDTH = 52;
    private static final int FLUCTUATION = 130;
    private static final int LOWEST_POINT = 20;
    private static final int HIGHEST_POINT = 120;
    private static final int COLUMN_GAP = 100;
    private static final int MAX_SPACING = 420;
    private static final int MIN_SPACING = 42;

    private Texture texture;
    private int type;
    private Vector2 position;
    private Random random;

    private Rectangle obstacleBounds;
    /*
    * obstacle constructor
    * @param x used as new obstacle x coordinate
    * */
    public Obstacle(float x){
        random = new Random();
        type = random.nextInt(3);
        x += 200;

        switch(type){
            case 0:
                texture = new Texture("topColumn.png");
                position = new Vector2(x, random.nextInt(FLUCTUATION) + COLUMN_GAP + HIGHEST_POINT);
                break;
            case 1:
                texture = new Texture("midObstacle.png");
                position = new Vector2(x, (random.nextInt(FLUCTUATION) + LOWEST_POINT));
                break;
            case 2:
                texture = new Texture("bottomColumn.png");
                position = new Vector2(x, (random.nextInt(FLUCTUATION) + COLUMN_GAP + HIGHEST_POINT) - COLUMN_GAP - texture.getHeight());
                break;
        }

        obstacleBounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    public Texture getTexture(){ return texture; }
    public Vector2 getPosition(){ return position; }
    private int getType(){ return type; }
    /*
    * reposition obstacle at x position
    * @param x
    * */
    public void reposition(float x){



        switch(type){
            case 0:
                position.set(x, random.nextInt(FLUCTUATION) + COLUMN_GAP + LOWEST_POINT);
                break;
            case 1:
                position.set(x, (random.nextInt(FLUCTUATION) + LOWEST_POINT));
                break;
            case 2:
                position.set(x, (random.nextInt(FLUCTUATION) + COLUMN_GAP + LOWEST_POINT) - COLUMN_GAP - texture.getHeight());
                break;
        }
        position.add(random.nextInt(MAX_SPACING) + MIN_SPACING, 0);
        obstacleBounds.setPosition(position.x, position.y);
    }

    /*
    * checks if player and the obstacle collide
    * @param player
    * @return boolean*/
    public boolean collides(Rectangle player){ return player.overlaps(obstacleBounds); }
    /*
    * dispose obstacle
    * */
    public void dispose(){ texture.dispose(); }





}
