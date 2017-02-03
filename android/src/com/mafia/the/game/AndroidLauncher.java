package com.mafia.the.game;


/**
 * author:tb
 * libgdx games will most likely consist of only one activity, reason being creating an activity requires
 * reloading graphics, new OpenGL context, and that is time consuming. Instead, you should deal with only one activity but
 * switch among multiple screens.
 */

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MafiaGame(), config);
		config.useAccelerometer = false;
		config.useCompass=false;
	}
}
