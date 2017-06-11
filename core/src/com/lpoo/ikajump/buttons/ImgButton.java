package com.lpoo.ikajump.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Created by Nuno on 06-06-2017.
 */

public class ImgButton extends ImageButton {

    public ImgButton(Texture texture_up, Texture texture_down, Texture background){
        super(new SpriteDrawable(new Sprite(texture_up)),
              new SpriteDrawable(new Sprite(texture_down)));
        this.setBackground(new SpriteDrawable( new Sprite(background)));
    }
}
