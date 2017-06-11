package com.lpoo.ikajump.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Nuno on 02-06-2017.
 */

public abstract class State {


    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;
    /*
    * Construtor da classe
    * @param gsm GameStateManager usado
    * */
    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }
    /*
     * handle de input generico
     * @param sb SpriteBatch usada
     * */
    protected abstract void handleInput(SpriteBatch sb);
    /*
     * update dos objetos em state
     * @param dt escalar para ser aplicado a vetores
     * @param sb SpriteBatch
     */
    public abstract void update(float dt, SpriteBatch sb);
    /*
     * render of images
     * @param sb SpriteBatch that this class uses
     *
     * */
    public abstract void render(SpriteBatch sb);
    /*
     * dispose do que está no batch
     *
     * */
    public  abstract void dispose();

}
