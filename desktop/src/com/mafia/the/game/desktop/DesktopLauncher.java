package com.mafia.the.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mafia.the.game.gamestates.MafiaGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Mafia The Game";
		config.useGL30 = false;
		config.width = 800;
		config.height = 680;
		new LwjglApplication(new MafiaGame(), config);
	}
}
