package com.mafia.the.game.GameStates;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by tb on 2/3/17.
 * Actual game state.
 */

public class PlayState extends State {

    private OrthographicCamera textCam;
    private Texture bg;
    private float lastBirdPositionX;
    private BitmapFont text;
    private BitmapFont highestScoreText;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,cam.position.x - cam.viewportWidth/2,0);
        sb.end();
    }

    @Override
    public void dispose() {
    }

    public void repositionCam(int x){
        bg.dispose();
        text.dispose();
    }
}
