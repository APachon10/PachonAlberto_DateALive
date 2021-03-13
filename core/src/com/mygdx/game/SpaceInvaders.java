package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.Rectangle;

import sun.rmi.runtime.Log;

public class SpaceInvaders extends ApplicationAdapter {

	//Medidas de la pantalla
	public static final int WIDTH = 600, HEIGHT = 400;

	//Filas y Columnas del Sprite Sheet
	public static final int FRAME_ROWS = 2, FRAME_COLS = 6;

	//Elementos que usaremos

	// Animations
	Animation<TextureRegion> kurumi_walk_right
	Animation<TextureRegion> kurumi_walk_left;

	//Ortographic Camera
	OrthographicCamera camara;

	// Rectangles
	Rectangle kurumi;

	//Textures
	Texture kurumiSprite;
	Texture

	float stateTime;

	@Override
	public void create () {

	}

	@Override
	public void render () {

	}

	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
	}
}
