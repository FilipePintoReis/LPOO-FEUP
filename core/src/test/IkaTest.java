package test;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoo.ikajump.sprites.Player;
import com.lpoo.ikajump.states.GameStateManager;
import com.lpoo.ikajump.states.MenuState;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class IkaTest {

    private GameStateManager gsm;
    private SpriteBatch batch;

   @Before
    public void initialize(){
       batch = new SpriteBatch();
       gsm = new GameStateManager();
       Gdx.gl.glClearColor(1, 0, 0, 1);
       gsm.push(new MenuState(gsm, batch));
    }

    @Test
    public void gameStarts(){

    }

    @Test
    public void playerJumps(){
       /* Player player = new Player(0,0);
        player.update(5);
        float y = player.getPosition().y;
        System.out.println(y);

        player.jump();
        player.update(5);
        System.out.println(player.getPosition().y);
        //assertTrue(y < player.getPosition().y);*/
        }

}
