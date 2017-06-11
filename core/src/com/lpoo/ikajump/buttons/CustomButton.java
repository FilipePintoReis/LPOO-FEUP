package com.lpoo.ikajump.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by Nuno on 05-06-2017.
 */

public class CustomButton {

    private Sprite sprite;

    public CustomButton(Texture texture, float x, float y, float width, float height) {
        sprite = new Sprite(texture);
        sprite.setPosition(x, y);
        sprite.setSize(width, height);
    }

    public void update(float input_x, float input_y){
        checkIfClicked(input_x, input_y);
    }

    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }

    private void checkIfClicked(float input_x, float input_y){
        if(input_x > sprite.getX() && input_x < sprite.getX() + sprite.getWidth()){
            if(input_y > sprite.getY() && input_y < sprite.getY() + sprite.getHeight()){
                System.out.println("Button has been clicked. Vibe on my good chum!");
            }
        }
    }

    public Sprite getSprite(){ return sprite; }




}
