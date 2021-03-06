package com.mafia.the.game.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.the.game.player.Civilian;
import com.mafia.the.game.player.Mafia;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tb on 2/3/17.
 * On the menu screen, display characters to user and allow them to pick a character.
 * Arraylists of characters should be initialized here then pass it on to PlayState.
 */

public class MenuState extends State {
    //background and button variables.
    private Texture background;
    private Texture playButton;
    private Texture title;
    private Music introMusic;
    public static ArrayList<Civilian> civilians; //should be a dynamically sized array because the number of players will vary.
    public static ArrayList<Mafia> mafias;
    private static final int NUM_OF_MAFIA = 3;
    private static final int NUM_OF_CIVIL = 10;

    /**
     * random name generator
     */
    private enum randomName {
        Bob,
        Justin,
        Thomas,
        Julie,
        Christina,
        Steve,
        Josh,
        John,
        Emily,
        Emma;

        /**
         *random name picker
         * @return random name
         */
        private static randomName getRandomName(){
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background/characters1.jpg");
        playButton = new Texture("images/playbutton.png");
//        instrButton = new Texture("images/instructionsbutton.png");
        title = new Texture("images/logo.png");
        playingState = false;

        //use newSound for music less than 10sec, newMusic for audio longer than 10sec.
        introMusic = Gdx.audio.newMusic(Gdx.files.internal("music/menu_music.mp3"));
        //play music.
        introMusic.setLooping(true); //music should loop.
        introMusic.play();

        //Initialize civilians and mafia array. Initialization for each element is done in handleInput, after the user chooses a character.
        civilians = new ArrayList<Civilian>();
        mafias = new ArrayList<Mafia>();

        //draw sprite at (0,0)
        cam = new OrthographicCamera();
        cam.setToOrtho(false, MafiaGame.WIDTH, MafiaGame.HEIGHT); //cam size same as game world defined in desktoplauncher.

        //INITIALIZE CIVILIANS
        for(int i = 0; i<NUM_OF_CIVIL;i++){
            civilians.add(new Civilian(randomName.getRandomName().toString(),true,false)); //@param(name,alive,mafia)
        }

        //INITIALIZE MAFIA
        for(int i = 0; i<NUM_OF_MAFIA;i++){
            mafias.add(new Mafia(randomName.getRandomName().toString(),true,true)); //@param(name,alive,mafia)
        }
    }
    @Override
    public void handleInput () {
        //For now, enter key will cause transition into playstate.
        if (Gdx.input.justTouched()) {
            gsm.push(new PlayState(gsm)); //transition into Playstate.
            playingState = true;
            introMusic.stop();
            //NO DISPOSING HERE BECAUSE WE WILL MOST LIKELY BE REUSING THIS STATE.
        }

        //If this game supports multiplayer mode, number of players will be set here, but for now, only single player mode allowed.

        //if texture for specific character was pressed, then set the user's character as that character here. Initialize the array accordingly.
        //and create other characters here.

        //ALLOW DUPLICATE CHARACTERS, BUT EACH USER SHOULD HAVE UNIQUE NAME.
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
        introMusic.dispose();
    }
}
