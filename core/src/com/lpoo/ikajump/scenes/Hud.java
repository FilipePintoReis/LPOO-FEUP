package com.lpoo.ikajump.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lpoo.ikajump.Ikajump;

/**
 * Created by Nuno on 09-06-2017.
 */

public class Hud implements Disposable {
    public Stage stage;
    private Viewport viewport;

    private static Integer score;
    static Label scoreLabel;

    public Hud(SpriteBatch sb){
        score = 0;
        viewport = new FitViewport(Ikajump.WIDTH, Ikajump.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true); //makes the table the size of the stage

        scoreLabel = new Label(String.format("%09d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(scoreLabel).expandX().padTop(10);
        stage.addActor(table);
    }

        public void update(float dt) { }
        public static void addScore(int value){
            score += value;
            scoreLabel.setText(String.format("%09d", score));
        }

        @Override
        public void dispose(){ stage.dispose(); }



}
