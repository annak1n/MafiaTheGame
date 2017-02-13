package com.mafia.the.game.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by tb on 2/9/17.
 * Initial State displays the initial game logo, title, quit button, next button.
 */

public class InitialState extends State {
    private Texture background;
    private Texture playButton;
    private Texture title;
    private Music introMusic;
    protected InitialState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background/onepiecebackground1.jpg");
//        playButton = new Texture("images/playbutton.png");
//        instrButton = new Texture("images/instructionsbutton.png");
//        title = new Texture("images/logo.png");
        cam.setToOrtho(false, MafiaGame.WIDTH, MafiaGame.HEIGHT);
        playingState = false;

        //use newSound for music less than 10sec, newMusic for audio longer than 10sec.
//        introMusic = Gdx.audio.newMusic(Gdx.files.internal("music/menu_music.mp3"));
        //play music.
//        introMusic.setLooping(true); //music should loop.
//        introMusic.play();

        cam = new OrthographicCamera();
        cam.setToOrtho(false, MafiaGame.WIDTH, MafiaGame.HEIGHT); //cam size same as game world defined in desktoplauncher.
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0,MafiaGame.WIDTH, MafiaGame.HEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
//        playButton.dispose();
//        introMusic.dispose();
    }
}
