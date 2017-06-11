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
import com.lpoo.ikajump.scenes.Hud;

/**
 * Created by Nuno on 06-06-2017.
 */

public class GameOverState extends State {

    private Texture background, banner;
    private Stage stage;
    private Viewport viewport;
    private int changeState;
    private Hud hud;
    private int score;
    private boolean addscoreflag;
    private Sound pepsimansfx;

    /*
    * Constructor for GameOverState
    * @param gsm this state's GameStateManager
    * @param sb spritebatch used*/
    public GameOverState(GameStateManager gsm, SpriteBatch sb, int score) {
        super(gsm);

        addscoreflag = true;
        this.score = score;
        changeState = 0;
        banner = new Texture("gameoverbanner.png");
        background = new Texture("bg.png");
        pepsimansfx = Gdx.audio.newSound(Gdx.files.internal("pepsimanjingle.mp3"));
        viewport = new FitViewport(Ikajump.WIDTH, Ikajump.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        hud = new Hud(sb);

        Texture replayTexture = new Texture("replaybtn.png");
        ImgButton replayButton = new ImgButton(replayTexture, replayTexture, replayTexture);
        replayButton.setWidth(Gdx.graphics.getWidth() / 3);
        replayButton.setPosition( (Ikajump.WIDTH / 2) - (replayTexture.getWidth() / 2), Ikajump.HEIGHT / 2);
        replayButton.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y){
                changeState = 1;
            }
        });
        stage.addActor(replayButton);

        Texture menuTexture = new Texture("menubtn.png");
        ImgButton menuButton = new ImgButton(menuTexture, menuTexture, menuTexture);
        menuButton.setWidth(Gdx.graphics.getWidth() / 3);
        menuButton.setPosition( (Ikajump.WIDTH / 2) - (menuTexture.getWidth() / 2), Ikajump.HEIGHT / 3);
        menuButton.addListener( new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                changeState = 2;
            }
        });
        stage.addActor(menuButton);
        Gdx.input.setInputProcessor(stage);

        pepsimansfx.play(0.5f);
    }

    @Override
    /*
     * handle de input generico
     * sb SpriteBatch usada
     * */
    public void handleInput(SpriteBatch sb) {

        if(addscoreflag)
            hud.addScore(score);

        addscoreflag = false;

        switch(changeState){
            case 0:
                return;
            case 1:
                gsm.set(new PlayState(gsm, sb));
                break;
            case 2:
                gsm.set(new MenuState(gsm, sb));
                break;
            default:
                break;
        }
    }

    @Override
    /*
   * update dos objetos em GameOverState
   * @para dt escalar para ser aplicado a vetores
   * @param sb SpriteBatch
    */
    public void update(float dt, SpriteBatch sb) {
        handleInput(sb);
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(background, 0, 0, Ikajump.WIDTH, Ikajump.HEIGHT);
        sb.draw(banner, 50, Ikajump.HEIGHT / 1.2f);
        sb.end();

        stage.act();
        stage.draw();

        sb.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    /*
     * dispose do que está no batch
     *
     * */
    public void dispose() {
        background.dispose();
        banner.dispose();
    }







}
