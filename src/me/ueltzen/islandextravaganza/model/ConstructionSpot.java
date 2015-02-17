package me.ueltzen.islandextravaganza.model;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ConstructionSpot {

	private ArrayList<StreetSpot> mAdjacentStreetSpots;
	
	private Rectangle mPosition;
	private boolean mActive;
	
	public ConstructionSpot(Vector2 position) {
		
		mPosition = new Rectangle(
				position.x, 
				position.y, 
				32, 
				32);
		
		mAdjacentStreetSpots = new ArrayList<StreetSpot>();
		
		mActive = false;
		
	}
	
	@Override
	public String toString() {
		return "ConstructionSpot @" + getBounds().x + "x" + getBounds().y;
	}
	
	public Rectangle getBounds() {
		return mPosition;
	}
	
	public void setPosition(Vector2 position) {
		mPosition =  new Rectangle(
				position.x, 
				position.y, 
				32, 
				32);
	}
	
	public void addAdjacentStreetSpot(StreetSpot streetSpot) {
		if(mAdjacentStreetSpots.contains(streetSpot)) {
			return;
		}
		
		streetSpot.addAdjacentContructionSpot(this);
		mAdjacentStreetSpots.add(streetSpot);
	}
	
	public void removeAdjacentStreetSpot(StreetSpot streetSpot) {
		streetSpot.removeAdjacentContructionSpot(this);
		mAdjacentStreetSpots.remove(streetSpot);
	}
	
	public void removeAdjacentStreetSpot(int index) {
		mAdjacentStreetSpots.remove(index);
	}
	
	public ArrayList<StreetSpot> getAdjacentStreetSpots() {
		return mAdjacentStreetSpots;
	}
	
	public boolean isActive() {
		return mActive;
	}
	
	public void setActive(boolean active) {
		mActive = active;
	}
	
}
