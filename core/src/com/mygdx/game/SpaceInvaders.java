package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpaceInvaders extends ApplicationAdapter {
	private static final int FRAME_COLS = 10, FRAME_ROWS = 7;

	Animation<TextureRegion> playerAnimation;
	SpriteBatch batch;
	Texture playerSheet;

	float stateTime;

	@Override
	public void create () {
		playerSheet = new Texture("SpaceInvaders2.png");
		TextureRegion[][] tmp = TextureRegion.split(playerSheet,
				playerSheet.getWidth() / FRAME_COLS,
				playerSheet.getHeight() / FRAME_ROWS);

		TextureRegion[] walkFrames = new TextureRegion[7 * 10];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}
		playerAnimation = new Animation<TextureRegion>(0.25f, walkFrames);
		batch = new SpriteBatch();
		stateTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();

		TextureRegion currentFrame = playerAnimation.getKeyFrame(stateTime, true);
		batch.begin();
		batch.draw(currentFrame, 50, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerSheet.dispose();
	}
}
