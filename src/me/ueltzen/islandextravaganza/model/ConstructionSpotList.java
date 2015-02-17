package me.ueltzen.islandextravaganza.model;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class ConstructionSpotList extends ArrayList<ConstructionSpot> {
	
	public void initialize() {
		
		ConstructionSpot s0 = new ConstructionSpot(
				new Vector2(0, 0));
		
		ConstructionSpot s1 = new ConstructionSpot(
				new Vector2(48, 0));
		
		StreetSpot s = new StreetSpot(new Vector2(10, 0));

		s0.addAdjacentStreetSpot(s);
		s1.addAdjacentStreetSpot(s);
		
		add(s0);
		add(s1);
		
	}
	
	
}
