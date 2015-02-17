package me.ueltzen.islandextravaganza.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import me.ueltzen.islandextravaganza.model.ConstructionSpot;
import me.ueltzen.islandextravaganza.model.StreetSpot;
import me.ueltzen.islandextravaganza.screens.GameScreen;

public class InputController implements InputProcessor {
	
	private GameScreen mGameScreen;
	
	public InputController(GameScreen gameScreen) {
		mGameScreen = gameScreen;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		Vector3 touchPosition = new Vector3(screenX, screenY, 0);
		mGameScreen.getCamera().unproject(touchPosition);
		
		for (ConstructionSpot constructionSpot : mGameScreen.getConstructionSpotList()) {
			if(constructionSpot.getBounds().overlaps(
					new Rectangle(touchPosition.x, touchPosition.y, 1, 1))) {
				
				System.out.println(constructionSpot.toString());
				
				for (StreetSpot streetSpot : constructionSpot.getAdjacentStreetSpots()) {
					System.out.println("\t" + streetSpot.toString());
					
//					if(streetSpot.getAdjacentConstructionSpots()[0] == constructionSpot) {
//						System.out.println("\t\t" + streetSpot.getAdjacentConstructionSpots()[1]);
//					} else {
//						System.out.println("\t\t" + streetSpot.getAdjacentConstructionSpots()[0]);
//					}
				}
				
			}
		}
		
		return true;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		Vector3 touchPosition = new Vector3(screenX, screenY, 0);
		mGameScreen.getCamera().unproject(touchPosition);
		
		for (ConstructionSpot constructionSpot : mGameScreen.getConstructionSpotList()) {
			constructionSpot.setActive(constructionSpot.getBounds().overlaps(
					new Rectangle(touchPosition.x, touchPosition.y, 1, 1)));
		}
		
		return false;
	}

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

}
