package com.lpoo.ikajump.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lpoo.ikajump.Ikajump;
import com.lpoo.ikajump.buttons.ImgButton;
import com.lpoo.ikajump.scenes.Hud;
import com.lpoo.ikajump.sprites.ColorArea;
import com.lpoo.ikajump.sprites.Player;
import com.lpoo.ikajump.sprites.Obstacle;

/**
 * Created by Nuno on 03-06-2017.
 */

public class PlayState extends State {

    private static final int AREA_SPACING_OFFSET = 40;
    private static final int MIN_AREA_SPACING = 20;
    private static final int AREA_COUNT = 1;

    private static final int OBSTACLE_SPACING = 140;
    private static final int OBSTACLE_COUNT = 50;
    private static final int GROUND_Y_OFFSET = -120;
    private static final int GROUND_CONTACT_OFFSET = -7;

    private Player player;
    private Texture bg;
    private Texture ground;
    private Vector2 groundPos1, groundPos2;
    private int score;

    private Stage stage;
    private Viewport viewport;
    private boolean changeState;
    private ImgButton jumpButton;
    private ImgButton changeButton;
    private Hud hud;
    private Music music;

    private Array<Obstacle> obstacles;
    private Array<ColorArea> areas;
 /*
  *Constructor for PlayState class
  *@param gsm GameStateManager that holds this class
  *@param sb SpriteBatch that this class uses
  *
  * */
    public PlayState(GameStateManager gsm, SpriteBatch sb){
        super(gsm);

        score = 0;
        changeState = false;
        cam.setToOrtho(false, Ikajump.WIDTH / 2, Ikajump.HEIGHT / 2);
        bg = new Texture("bg.png");
        ground = new Texture("ground.png");
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        groundPos1 = new Vector2(cam.position.x - cam.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((cam.position.x - cam.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);
        player = new Player(20, ground.getHeight() - GROUND_Y_OFFSET);
        hud = new Hud(sb);
        viewport = new FitViewport(Ikajump.WIDTH / 2, Ikajump.HEIGHT / 2, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        obstacles = new Array<Obstacle>();
        for(int i = 1; i <= OBSTACLE_COUNT; i++){
            obstacles.add(new Obstacle(i * (OBSTACLE_SPACING + Obstacle.OBSTACLE_WIDTH)));
        }

        areas = new Array<ColorArea>();
        for(int i = 1; i <= AREA_COUNT; i++){
            areas.add(new ColorArea(i * (MIN_AREA_SPACING + ColorArea.AREA_WIDTH)));
        }

        //Declaration of JUMP BUTTON
        Texture jumpTexture = new Texture("jumpbutton.png");
        jumpButton = new ImgButton(jumpTexture, jumpTexture, jumpTexture);
        jumpButton.setWidth(Gdx.graphics.getWidth() / 3);
        jumpButton.setPosition(-28, 0);
        jumpButton.addListener(new ClickListener(){
            //public void clicked(InputEvent e, float x, float y){
            public boolean touchDown(InputEvent e, float x, float y, int pointer, int button){
                if(!player.getJumpState()) player.jump();
                return true;
            }
        });

        //declaration of CHANGE COLOR BUTTON
        Texture changeTexture = new Texture("changebutton.png");
        changeButton = new ImgButton(changeTexture, changeTexture, changeTexture);
        changeButton.setWidth(Gdx.graphics.getWidth() / 3);
        changeButton.setPosition(108, 0);
        changeButton.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y){
                player.switchColor();
            }
        });
        stage.addActor(jumpButton);
        stage.addActor(changeButton);
        Gdx.input.setInputProcessor(stage);

        //music.play();
    }

    @Override
    /*
    * handle de input generico
    * sb SpriteBatch usada
    * */
    protected void handleInput(SpriteBatch sb) {
    }

    @Override
    /*
    * update dos objetos em playstate
    * @para dt escalar para ser aplicado a vetores
    * @param sb SpriteBatch
     */
    public void update(float dt, SpriteBatch sb) {
        handleInput(sb);
        updateGround();
        player.update(dt);
        cam.position.x = player.getPosition().x + 80;

        for(int i = 0; i < obstacles.size; i++){
            if(cam.position.x - (cam.viewportWidth / 2) > obstacles.get(i).getPosition().x + obstacles.get(i).getTexture().getWidth()){
                boolean flag = false;
                for(int k = 0; k < obstacles.size; k++){
                    if (!(obstacles.get(i) == obstacles.get(k)) && (Math.abs(obstacles.get(i).getPosition().x - obstacles.get(k).getPosition().x) < OBSTACLE_SPACING)){
                        flag = true;
                    }
                }
                if(!flag) {
                    obstacles.get(i).reposition(obstacles.get(i).getPosition().x + ((Obstacle.OBSTACLE_WIDTH + OBSTACLE_SPACING) * OBSTACLE_COUNT));
                    score += 10;
                    hud.addScore(10);
                    System.out.println("Score: " + score);
                }
            }
            if(obstacles.get(i).collides(player.getBounds())){
                gsm.set(new GameOverState(gsm, sb, score));
            }
        }

        for(int i = 0; i < areas.size; i++){
            if(cam.position.x - (cam.viewportWidth / 2) > areas.get(i).getPosition().x + obstacles.get(i).getTexture().getWidth() * 3){
                areas.get(i).update();
                areas.get(i).reposition(areas.get(i).getPosition().x + ((ColorArea.AREA_WIDTH + MIN_AREA_SPACING) * AREA_COUNT));
            }

            if(areas.get(i).collides(player.getBounds())){
                if(player.getColorType() != areas.get(i).getColorType()){
                    gsm.set(new GameOverState(gsm, sb, score));
                }
            }
        }

        if(player.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET + GROUND_CONTACT_OFFSET){
            player.setOnGround();
            player.getPosition().set(player.getPosition().x, ground.getHeight() + GROUND_Y_OFFSET + GROUND_CONTACT_OFFSET, 0);
        }
        else{ player.setJumping(); }

        cam.update();
    }

    @Override
    /*
  * render of images
  * @param sb SpriteBatch that this class uses
  *
  * */
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);

        /*
        for(int i = 0; i < areas.size; i++){
            sb.draw(areas.get(i).getTexture(), areas.get(i).getPosition().x, areas.get(i).getPosition().y);
        }
        */

        for(int i = 0; i < areas.size; i++){
            areas.get(i).render(sb);
        }
        for(int i = 0; i < obstacles.size; i++){
            sb.draw(obstacles.get(i).getTexture(), obstacles.get(i).getPosition().x, obstacles.get(i).getPosition().y);
        }

        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);
        sb.draw(player.getTexture(), player.getPosition().x, player.getPosition().y);
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
        bg.dispose();
        player.dispose();
        ground.dispose();

        for(int i = 0; i < obstacles.size; i++){
            obstacles.get(i).dispose();
        }
        for(int i = 0; i < areas.size; i++){
            areas.get(i).dispose();
        }

        music.stop();
        music.dispose();
    }

    private void updateGround(){
        if(cam.position.x - (cam.viewportWidth / 2) > groundPos1.x + ground.getWidth()){
            groundPos1.add(ground.getWidth() * 2, 0);
        }
        if(cam.position.x - (cam.viewportWidth / 2) > groundPos2.x + ground.getWidth()){
            groundPos2.add(ground.getWidth() * 2, 0);
        }
    }
}
