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
	//private static final int FRAME_COLS2 = 2, FRAME_ROWS2 = 1;

	Animation<TextureRegion> playerAnimationRigth;
	Animation<TextureRegion> playerAnimationUp;
	Animation<TextureRegion> monsterAnimation;
	Texture player;
	SpriteBatch batch;
	Texture monster;

	float stateTime;

	@Override
	public void create () {
		player = new Texture("SpaceInvaders2.png");
		monster = new Texture("Monster.png");
		TextureRegion[][] tmp = TextureRegion.split(player,
				player.getWidth() / FRAME_COLS,
				player.getHeight() / FRAME_ROWS);

		// Right
		TextureRegion[] walkRight = new TextureRegion[FRAME_COLS-2];
		int indexRight=0;
		for (int i=0;i<FRAME_COLS-2;i++) {
			walkRight[indexRight++] = tmp[0][i];
		}
		// Up
		TextureRegion[] walkUp = new TextureRegion[FRAME_COLS-4];
		int indexLeft=0;
		for (int i = 0; i < FRAME_COLS-4; i++) {
			walkUp[indexLeft++]=tmp[1][i];
		}

		playerAnimationRigth = new Animation<TextureRegion>(0.15f, walkRight);
		playerAnimationUp = new Animation<TextureRegion>(0.15f, walkUp);
		batch = new SpriteBatch();
		stateTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();

		TextureRegion currentFrame = playerAnimationRigth.getKeyFrame(stateTime, true);
		TextureRegion currentFrame2 = playerAnimationUp.getKeyFrame(stateTime, true);
		//TextureRegion enemyFrame = monsterAnimation(stateTime,true);
		batch.begin();
		batch.draw(currentFrame, 270, 50);
		//batch.draw(enemyFrame,70,70);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
	}
}
