package com.mafia.the.game.GameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.the.game.MafiaGame;

/**
 * Created by tb on 2/3/17.
 */

public class MenuState extends State {
    //background and button variables.
    private Texture background;
    private Texture playButton;
    private Texture logo;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
        logo = new Texture("main.jpg");
        cam.setToOrtho(false, MafiaGame.WIDTH/2,MafiaGame.HEIGHT/2);
        playingState=false;
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            playingState=true;
            //NO DISPOSING HERE BECAUSE WE WILL MOST LIKELY BE REUSING THIS STATE.
        }
    }

    @Override
    public void update(float dt) {
        handleInput(); //USER INPUT..SUCH AS MOUSE CLICK OR WHATEVER.
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        //sb is like a container. It needs to open up first and then put the required stuff in there and close it.
        sb.begin(); //open container.
        sb.draw(background,0,0, MafiaGame.WIDTH,MafiaGame.HEIGHT); //@param (img, x,y,width,height)
        sb.draw(logo,cam.position.x - logo.getWidth()/2,cam.position.y/2-200);
        //Game width/2 - buttonwidth/2 is the starting point of the button drawing.
        //This makes the button display in the center.
        sb.draw(playButton,(cam.position.x-playButton.getWidth()/2), cam.position.y);
        sb.end();
    }

    //FOR MEMORY EFFICIENCY, DISPOSE TEXTURES.
    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
