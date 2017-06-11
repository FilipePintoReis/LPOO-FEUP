package com.lpoo.ikajump.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lpoo.ikajump.Ikajump;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Ikajump.WIDTH;
		config.height = Ikajump.HEIGHT;
		config.title = Ikajump.TITLE;
		new LwjglApplication(new Ikajump(), config);
	}
}
