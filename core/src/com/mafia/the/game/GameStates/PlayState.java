package com.mafia.the.game.GameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by tb on 2/3/17.
 * Actual game state.
 */

public class PlayState extends State {

    private OrthographicCamera textCam;
    private Texture testImage;
    private float lastBirdPositionX;
    private SpriteBatch batch;
    private BitmapFont text;
    private BitmapFont highestScoreText;
    private Rectangle mafia;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

        cam.update();//it's ideal to update camera per each frame.
    }

    @Override
    public void render(SpriteBatch sb) {
//        System.out.print(sb);
        batch.setProjectionMatrix(cam.combined); //spritebatch should use coordinate system specified by the cam.
        batch.begin();
        batch.draw(testImage, mafia.x, mafia.y);
        batch.end();

        //For keyboard.. Add buttons for android later.
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) mafia.x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) mafia.x += 200 * Gdx.graphics.getDeltaTime();

    }

    @Override
    public void dispose() {
    }

    public void repositionCam(int x){
        testImage.dispose();
        text.dispose();
    }
}
