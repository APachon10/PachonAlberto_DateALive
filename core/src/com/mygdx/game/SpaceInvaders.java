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
	private static final int FRAME_COLS2 = 10, FRAME_ROWS2 = 7;

	Animation<TextureRegion> playerAnimation;
	SpriteBatch batch;
	Texture player;
	Texture monster;

	float stateTime;

	@Override
	public void create () {
		player = new Texture("SpaceInvaders2.png");
		monster = new Texture("Monsters.png");
		TextureRegion[][] tmp = TextureRegion.split(player,
				player.getWidth() / FRAME_COLS,
				player.getHeight() / FRAME_ROWS);
		TextureRegion[][] tmp2 = TextureRegion.split(monster,
				monster.getWidth() / FRAME_COLS,
				monster.getHeight() / FRAME_ROWS);

		TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index=0;
		for (int i=0;i<FRAME_COLS;i++) {
			walkFrames[index++] = tmp[0][i];
		}
		for (int i = 0; i < FRAME_COLS2; i++) {

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
