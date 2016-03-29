package com.mygdx.button;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.*;

public class Buttons extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas buttonAtlas;
	TextButton.TextButtonStyle buttonStyle;
	TextButton button;
	Skin skin;
	BitmapFont font;
	Stage stage;


	@Override
	public void create () {
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		font= new BitmapFont(Gdx.files.internal("Button.fnt"));
		skin= new Skin();
		buttonAtlas= new TextureAtlas(Gdx.files.internal("Button.pack"));
		skin.addRegions(buttonAtlas);
		buttonStyle= new TextButton.TextButtonStyle();
		buttonStyle.up= skin.getDrawable("button");
		buttonStyle.down= skin.getDrawable("ButtonPressed");
		buttonStyle.font= font;
		button= new TextButton("Into The Woods",buttonStyle);
		button.setSize(300,100);
		button.setPosition(100,100);
		button.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Does This Thing Really Work!!!");

				return true;
			}
		});
		stage.addActor(button);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.end();
		stage.draw();
	}
}
