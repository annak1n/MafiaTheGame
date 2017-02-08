package com.mafia.the.game.GameStates;

import com.badlogic.gdx.Gdx;
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

    private Boolean isDay; //set game as day or night.
    private OrthographicCamera textCam;
    private Texture testImage;
    private BitmapFont text;
    private Rectangle mafia;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        textCam = new OrthographicCamera(); //cam for text
        isDay = true;
        testImage = new Texture(Gdx.files.internal("sprites/smurf.png"));
        mafia = new Rectangle();
        mafia.set(0, 0, testImage.getWidth() / 4, testImage.getHeight() / 4); //divide by 4 because the sprite sheet is 4 x 4.
    }

    @Override
    protected void handleInput() {

    }
    @Override
    public void update(float dt) {
        cam.update();//it's ideal to update camera per each frame.

        //change day and night based on the time collapsed.. say 2-5 mins.

        //during the day, Mafia can't be active.

        //at night, Mafia is active and allow them to attack civilians.
    }

    @Override
    public void render(SpriteBatch sb) {
//        System.out.print(sb);
        Gdx.gl.glClearColor(0, 0, 1, 1); //clear screen
        sb.setProjectionMatrix(cam.combined); //spritebatch should use coordinate system specified by the cam.
        sb.begin();
        sb.draw(testImage, mafia.x, mafia.y);
        sb.end();
    }

    @Override
    public void dispose() {
        testImage.dispose();
        text.dispose();
    }

    public void repositionCam(int x){
    }
}
