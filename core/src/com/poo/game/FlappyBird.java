package com.poo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.poo.game.gameHelper.AssetLoader;
import com.poo.game.screens.GameScreen; 

import java.io.FileNotFoundException;

class FlappyBird extends AbstractBird {
    @Override
    public void create(){
        try {
            AssetLoader.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setScreen(new GameScreen());
    }

    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }
}
