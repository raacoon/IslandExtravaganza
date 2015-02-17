package me.ueltzen.islandextravaganza.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class IslandExtravaganzaDesktop {
	
	public static void main(String[] args) {
		
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		cfg.width = 960;
		cfg.height = 540;
		
		cfg.fullscreen = false;
		cfg.vSyncEnabled = true;
		
		new LwjglApplication(new IslandExtravaganza(), cfg);
	}
	
}
