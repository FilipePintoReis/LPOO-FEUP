package com.lpoo.ikajump.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Nuno on 04-06-2017.
 */

public class ColorArea {

    public static final int AREA_WIDTH = 150;
    private static final int AREA_Y_POSITION = 16;
    private static final int AREA_Y_OFFSET = 60;
    private static final int MAX_SPACING = 420;
    private static final int MIN_SPACING = 40;

    //private Texture color;
    private Texture blue, red;
    private Vector2 position;
    private int colorType; //1 = blue / 0 = red
    private Rectangle areaBounds;
    private Random random;

    /*
    * constructor for ColorArea
    * @param x position of the ColorArea
    * */
    public ColorArea(float x){
        random = new Random();
        colorType = random.nextInt(2);
        red = new Texture("redArea.png");
        blue = new Texture("blueArea.png");
        x += 200;
        /*
        switch(colorType){
            case 0:
                color = new Texture("redArea.png");
                break;
            case 1:
                color = new Texture("blueArea.png");
                break;
            default:
                break;
        }
        */
        position = new Vector2(x, AREA_Y_POSITION + random.nextInt(AREA_Y_OFFSET));
        areaBounds = new Rectangle(position.x, position.y, blue.getWidth(), blue.getHeight());
    }


    /*
    * @return blue
    * */
    public Texture getBlue(){ return blue; }
    /*
    * @return red*/
    public Texture getRed(){ return red; }
    /*
    * @return position
    * */
    public Vector2 getPosition(){ return position; }
    /*
    * @return colorType*/
    public int getColorType(){ return colorType; }

    /*
    * render ColorArea on
    * @param sb SpriteBatch
    * */
    public void render(SpriteBatch sb){
        //sb.begin();
        if(colorType == 1)
            sb.draw(blue, position.x, position.y);
        else
            sb.draw(red, position.x, position.y);
        //sb.end();
    }
    /*
    * update method for ColorArea
    * */
    public void update(){ colorType = random.nextInt(2); }
    /*
    * reposition ColorArea at
    * @param x*/
    public void reposition(float x){
        position.set(x + random.nextInt(MAX_SPACING) + MIN_SPACING, AREA_Y_POSITION + random.nextInt(AREA_Y_OFFSET));
        areaBounds.setPosition(position.x, position.y);
    }
    /*
    * checks if
    * @param player collides with ColorArea
    * @return boolean
    * */
    public boolean collides(Rectangle player){ return player.overlaps(areaBounds); }
    /*
    * dispose ColorArea
    * */
    public void dispose() {
        //color.dispose(); }
        blue.dispose();
        red.dispose();
    }

}
