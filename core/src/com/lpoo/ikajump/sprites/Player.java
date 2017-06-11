package com.lpoo.ikajump.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Nuno on 03-06-2017.
 */

public class Player {

    private static final int GRAVITY = -20;
    private static final int MOVEMENT = 160;

    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private int colorType;
    private boolean jumpState;
    private Animation blueAnimation, redAnimation;
    private Texture bluePepsiman, redPepsiman;
    private TextureRegion blueJumpPepsiman, redJumpPepsiman;
    private Sound jumpsfx;

    /*
    * constructor for player
    * @param x
    * @param y*/
    public Player(int x, int y){
        colorType = 1; // 1 = blue / 0 = red
        jumpState = false;
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        jumpsfx = Gdx.audio.newSound(Gdx.files.internal("jump.mp3"));

        bluePepsiman = new Texture("bluePepsiman.png");
        blueAnimation = new Animation(new TextureRegion(bluePepsiman), 3, 0.5f);

        redPepsiman = new Texture("redPepsiman.png");
        redAnimation = new Animation(new TextureRegion(redPepsiman), 3, 0.5f);

        bounds = new Rectangle(x, y, bluePepsiman.getWidth() / 3, bluePepsiman.getHeight());

        Texture blueJump = new Texture("blueJumpingPepsiman.png");
        Texture redJump = new Texture("redJumpingPepsiman.png");

        blueJumpPepsiman = new TextureRegion(blueJump);
        redJumpPepsiman = new TextureRegion(redJump);
    }

    /*
    * update method for player
    * @param dt escalar to be used on vectors*/
    public void update(float dt){
        blueAnimation.update(dt);
        redAnimation.update(dt);

        if(position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);
        if(position.y < 0){
            position.y = 0;
        }
        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);
    }
   /*
    * returns color type
    * @return colorType
    * */
    public int getColorType(){ return colorType; }
    /*
    * @return jumpState
    * */
    public boolean getJumpState(){ return jumpState; }
    /*
    * @return position
    * */
    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {

        if(colorType == 1) {
            if (jumpState) return blueJumpPepsiman;
            else           return blueAnimation.getFrame();
        }
        else{
            if (jumpState) return redJumpPepsiman;
            else           return redAnimation.getFrame();
        }

    }
    /*
    * jumpState = true
    * */
    public void setJumping(){ jumpState = true; }
    /*
    * jumpState = false
    * */
    public void setOnGround(){ jumpState = false; }
    /*
    * change colorType value*/
    public void switchColor(){ if(colorType == 1) colorType = 0; else colorType = 1; }
    /*
    * set velocity.y 666
    * */
    public void jump(){
        velocity.y = 666;
        jumpsfx.play();
    }
    /*
    * @return bounds
    * */
    public Rectangle getBounds(){ return bounds; }
    /*
    * dispose do player*/
    public void dispose(){
        bluePepsiman.dispose();
        redPepsiman.dispose();
        jumpsfx.dispose();
    }

}
