package com.lpoo.ikajump.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Nuno on 02-06-2017.
 */

public class GameStateManager {

    private Stack<State> states;

    /*
    * Constructor of GameStateManager
    * */
    public GameStateManager(){
        states = new Stack<State>();
    }

    /*
    * push state into gsm
    * @param state*/
    public void push(State state){
        states.push(state);
    }

    /*
    * dispose top
    * */
    public void pop(){
        states.pop().dispose();
    }

    /*
    * Add state to stack
    * @param state*/
    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    /*
   * update dos objetos em gsm
   * @para dt escalar para ser aplicado a vetores
   * @param sb SpriteBatch
    */
    public void update(float dt, SpriteBatch sb){
        states.peek().update(dt, sb);
    }
    /*
     * render of images
     * @param sb SpriteBatch that this class uses
     *
     * */
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
