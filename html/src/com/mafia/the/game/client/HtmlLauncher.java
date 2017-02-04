package com.mafia.the.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.mafia.the.game.MafiaGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(MafiaGame.WIDTH, MafiaGame.HEIGHT);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new MafiaGame();
        }
}