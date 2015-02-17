package me.ueltzen.islandextravaganza.screens;

import me.ueltzen.islandextravaganza.input.InputController;
import me.ueltzen.islandextravaganza.model.ConstructionSpot;
import me.ueltzen.islandextravaganza.model.ConstructionSpotList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {
	
	private OrthographicCamera mCamera;
	private SpriteBatch mSpriteBatch;
	
	private ConstructionSpotList mConstructionSpotList;

	@Override
	public void show() {
		
		mCamera = new OrthographicCamera(960, 540);
		mCamera.position.set(
				(mCamera.viewportWidth / 2.f), 
				(mCamera.viewportHeight / 2.f), 
				0.f);
		//mCamera.update();
		
		mSpriteBatch = new SpriteBatch();
		
		mConstructionSpotList = new ConstructionSpotList();
		mConstructionSpotList.initialize();
		
		Gdx.input.setInputProcessor(new InputController(this));
		
	}

	@Override
	public void render(float arg0) {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		mSpriteBatch.setProjectionMatrix(mCamera.combined);
		
		mSpriteBatch.begin();
		
		Texture t = new Texture(Gdx.files.internal("assets/data/sprites/hex.png"));
		
		boolean even = false;
		for (int y = 0; y < 5; y++) {
			
			int rowSize = 0;
			if(y == 0 || y == 4) {
				rowSize = 3;
			} else if(y == 1 || y == 3) {
				rowSize = 4;
			} else {
				rowSize = 5;
			}
			
			for (int x = 0; x < rowSize; x++) {
				int i = (5 - rowSize) / 2;
				
				if(even) {
					mSpriteBatch.draw(
							new Texture(Gdx.files.internal("assets/data/sprites/hex.png")), 
							(84.f * (x + i)) + (5.f * x), 
							(71.f * y) + (5.f * y), 
							84, 
							96);
				} else {
					mSpriteBatch.draw(
							new Texture(Gdx.files.internal("assets/data/sprites/hex.png")), 
							(84.f * (x + i)) - 42.f + (5.f * x), 
							71.f * y + (5.f * y), 
							84, 
							96);
				}
			}
			
			even = !even;
		}
		
		for (ConstructionSpot constructionSpot : mConstructionSpotList) {
			
			Texture constructionSpotTexture = constructionSpot.isActive() ?
					new Texture(Gdx.files.internal("assets/data/sprites/construction_spot_active.png")) :
					new Texture(Gdx.files.internal("assets/data/sprites/construction_spot.png"));
			
			mSpriteBatch.draw(
					constructionSpotTexture, 
					constructionSpot.getBounds().x, 
					constructionSpot.getBounds().y, 
					constructionSpot.getBounds().width, 
					constructionSpot.getBounds().height);
			
		}
		
		mSpriteBatch.end();
	}
	
	public Camera getCamera() {
		return mCamera;
	}
	
	public ConstructionSpotList getConstructionSpotList() {
		return mConstructionSpotList;
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
