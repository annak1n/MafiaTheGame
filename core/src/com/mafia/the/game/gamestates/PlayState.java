package com.mafia.the.game.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import static com.badlogic.gdx.Gdx.input;

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
    private Music gameMusic;

    protected PlayState(com.mafia.the.game.gamestates.GameStateManager gsm) {
        super(gsm);
        textCam = new OrthographicCamera(); //cam for text
        isDay = true;
        testImage = new Texture(Gdx.files.internal("sprites/smurf.png"));
        mafia = new Rectangle();
        mafia.set(0, 0, testImage.getWidth() / 4, testImage.getHeight() / 4); //divide by 4 because the sprite sheet is 4 x 4.
    }

    @Override
    protected void handleInput() {
        //for now, for testing purposes, if enter is pressed, go back to main menu.
        if(input.isKeyPressed(Input.Keys.ENTER)){
            gsm.set(new MenuState(gsm));
        }

        //**DETERMINE IF NIGHT/DAY STATE NEED TO BE ON TOP OF PLAYSTATE OR NOT**

        else if(input.isKeyPressed(Input.Keys.N)){ //entering the day/night state is to be decided by a button or the game itself. Press N for now for testing purposes.
            gsm.set(new NightState(gsm));
        }
    }
    @Override
    public void update(float dt) {
        cam.update();//it's ideal to update camera per each frame.
        handleInput();

        //each character should introduce themselves. When the introduction of each character is finished, enter Night first.

        //DAY AND NIGHT MAY BE DEALT WITH INSIDE PLAYSTATE CLASS INSTEAD OF THEIR OWN CLASS BECAUSE OF MEMORY EFFICIENCY AND THE GAME STATES STRUCTURE.
        //USING A STACK IS GOOD WITH STATE CHANGES BUT FOR THE NIGHT AND DAY STATES, YOU NEED TO KEEP SWITCHING BACK AND FORTH AND POPPING AND PUSHING OF TWO STATES
        //SEEMS INEFFICIENT BECAUSE IT WILL HAPPEN A LOT. ADDITIONALLY, YOU NEED TO KEEP TRACK OF THE CURRENT GAME, AND IF YOU KEEP POPPING AND PUSHING ON TO GAME STATE STACK,
        //YOU MAY LOSE SOME INFO ABOUT THE GAME.

        /*
        NIGHT STATE ... gsm.push(new NightState());  //push because we want day and night states on top of playstate.
         */

        //change day and night based on the time collapsed.. say 2-5 mins.

        //during the day, Mafia can't be active.
        /*
        DAY STATE //Day state should be set from night state.
         */

        //at night, Mafia is active and allow them to attack civilians.

    }

    @Override
    public void render(SpriteBatch sb) {
//        System.out.print(sb);
        Gdx.gl.glClearColor(0, 0, 1, 1); //clear screen
        sb.setProjectionMatrix(cam.combined); //spritebatch should use coordinate system specified by the cam.
        sb.begin();
        sb.draw(testImage,0,0, MafiaGame.WIDTH, MafiaGame.HEIGHT);
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
