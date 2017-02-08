package com.mafia.the.game.GameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by tb on 2/3/17.
 * On the menu screen, display characters to user and allow them to pick a character.
 */

public class MenuState extends State {
    //background and button variables.
    private Texture background;
    private Texture playButton;
    private Texture title;
    private Music introMusic;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("images/initialbackground.png");
        playButton = new Texture("images/playbutton.png");
//        instrButton = new Texture("images/instructionsbutton.png");
        title = new Texture("images/logo.png");
        cam.setToOrtho(false, MafiaGame.WIDTH, MafiaGame.HEIGHT);
        playingState = false;

        //use newSound for music less than 10sec, newMusic for audio longer than 10sec.
        introMusic = Gdx.audio.newMusic(Gdx.files.internal("music/menu_music.mp3"));
        //play music.
        introMusic.setLooping(true); //music should loop.
        introMusic.play();

        //draw sprite at (0,0)
        cam = new OrthographicCamera();
        cam.setToOrtho(false, MafiaGame.WIDTH, MafiaGame.HEIGHT); //cam size same as game world defined in desktoplauncher.
    }
        @Override
        public void handleInput () {
            //For now, enter key will cause transition into playstate.
            if (Gdx.input.justTouched()||Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
                gsm.set(new PlayState(gsm)); //transition into Playstate.
                playingState = true;
                //NO DISPOSING HERE BECAUSE WE WILL MOST LIKELY BE REUSING THIS STATE.
            }
            //if texture for specific character was pressed, then set the user's character as that character here.
            //and create other characters here.
        }

        @Override
        public void update ( float dt){
            handleInput(); //USER INPUT..SUCH AS MOUSE CLICK OR WHATEVER.
        }

        @Override
        public void render (SpriteBatch sb){
            sb.setProjectionMatrix(cam.combined);
            //sb is like a container. It needs to open up first and then put the required stuff in there and close it.
            sb.begin(); //open container.
            sb.draw(background, 0, 0, MafiaGame.WIDTH, MafiaGame.HEIGHT); //@param (img, x,y,width,height)
            sb.draw(title, cam.position.x - title.getWidth() / 2, cam.position.y + 50);
            //This makes the button display in the center.
            sb.draw(playButton, cam.position.x + playButton.getWidth() / 7, cam.position.y - 100);
            sb.end();
        }

        //FOR MEMORY EFFICIENCY, DISPOSE TEXTURES.
        @Override
        public void dispose () {
            background.dispose();
            playButton.dispose();
        }
}
