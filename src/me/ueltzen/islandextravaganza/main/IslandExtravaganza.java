package me.ueltzen.islandextravaganza.main;

import me.ueltzen.islandextravaganza.screens.GameScreen;

import com.badlogic.gdx.Game;

public class IslandExtravaganza extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}

}
