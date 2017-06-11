package com.lpoo.ikajump.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lpoo.ikajump.Ikajump;
import com.lpoo.ikajump.buttons.ImgButton;

/**
 * Created by Nuno on 02-06-2017.
 */

public class MenuState extends State {

    private Texture background, banner;
    private Stage stage;
    private Viewport viewport;
    private boolean changeState;
    private Sound pepsimansfx;

    /*
    * Construtor da classe
    * @param gsm GameStateManager usado
    * @param sb sprtebatch used for this class
    * */
    public MenuState(GameStateManager gsm, SpriteBatch sb) {
        super(gsm);

        changeState = false;
        background = new Texture("bg.png");
        banner = new Texture("pepsijumpbanner.png");
        pepsimansfx = Gdx.audio.newSound(Gdx.files.internal("pepsimanjingle.mp3"));
        viewport = new FitViewport(Ikajump.WIDTH, Ikajump.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Texture startTexture = new Texture("playbtn.png");
        ImgButton startButton = new ImgButton(startTexture, startTexture, startTexture);
        startButton.setWidth(Gdx.graphics.getWidth() / 3);
        startButton.setPosition( (Ikajump.WIDTH / 2) - (startTexture.getWidth() / 2), Ikajump.HEIGHT / 2);
        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y){
                changeState = true;
            }
        });
        stage.addActor(startButton);
        Gdx.input.setInputProcessor(stage);

        pepsimansfx.play(0.5f);
    }

    @Override
     /*
     * handle de input generico
     * sb SpriteBatch usada
     * */
    public void handleInput(SpriteBatch sb) {
        if(changeState) gsm.set(new PlayState(gsm, sb));
    }

    @Override
    /*
   * update dos objetos em state
   * @para dt escalar para ser aplicado a vetores
   * @param sb SpriteBatch
    */
    public void update(float dt, SpriteBatch sb) {
        handleInput(sb);
    }

    @Override
     /*
  * render of images
  * @param sb SpriteBatch that this class uses
  *
  * */
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Ikajump.WIDTH, Ikajump.HEIGHT);
        //sb.draw(banner, (Ikajump.WIDTH / 2) - (banner.getWidth() / 2), Ikajump.HEIGHT);
        //sb.draw(banner, (Ikajump.WIDTH / 2) - (banner.getWidth() / 2), Ikajump.HEIGHT, banner.getWidth(), banner.getHeight());
        sb.draw(banner, 12, Ikajump.HEIGHT - (Ikajump.HEIGHT / 5), banner.getWidth() / 1.5f, banner.getHeight() - 10);
        sb.end();

        stage.act();
        stage.draw();
    }

    @Override
      /*
       * dispose do que está no batch
       *
       * */
    public void dispose() {
        background.dispose();
        banner.dispose();
        pepsimansfx.dispose();
    }




}
