package me.ueltzen.islandextravaganza.model;

import com.badlogic.gdx.math.Vector2;

public class StreetSpot {

	private ConstructionSpot[] mAdjacentConstructionSpots;
	
	private Vector2 mPosition;
	
	public StreetSpot(Vector2 position) {
		
		mPosition = position;
		
		mAdjacentConstructionSpots = new ConstructionSpot[2];
		
	}
	
	@Override
	public String toString() {
		return "StreetSpot @" + getPosition().x + "x" + getPosition().y + 
				"\n\t\t (o) FROM: " + getAdjacentConstructionSpots()[0] +
				"\n\t\t  | " + 
				"\n\t\t (o) TO:   " + getAdjacentConstructionSpots()[1];
	}
	
	public Vector2 getPosition() {
		return mPosition;
	}
	
	public void setPosition(Vector2 position) {
		mPosition = position;
	}
	
	public boolean addAdjacentContructionSpot(ConstructionSpot constructionSpot) {
		if(mAdjacentConstructionSpots[0] == null) {
			mAdjacentConstructionSpots[0] = constructionSpot;
		} else if(mAdjacentConstructionSpots[1] == null) {
			mAdjacentConstructionSpots[1] = constructionSpot;
		} else {
			return false;
		}
		
		return true;
	}
	
	public boolean removeAdjacentContructionSpot(ConstructionSpot constructionSpot) {
		if(mAdjacentConstructionSpots[0] == constructionSpot) {
			mAdjacentConstructionSpots[0] = null;
		} else if(mAdjacentConstructionSpots[1] == constructionSpot) {
			mAdjacentConstructionSpots[1] = null;
		} else {
			return false;
		}
		
		return true;
	}
	
	public ConstructionSpot[] getAdjacentConstructionSpots() {
		return mAdjacentConstructionSpots;
	}
	
}
