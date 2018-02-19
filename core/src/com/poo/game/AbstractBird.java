package com.poo.game;

import com.badlogic.gdx.Game;
import com.poo.game.gameHelper.AssetLoader;
import com.poo.game.screens.GameScreen;

import java.io.FileNotFoundException;

/**
 * Created by richardba on 2/19/2018.
 */

abstract class AbstractBird extends Game {
    @Override
    abstract public void create();

    public void dispose()
    {
        super.dispose();
    }
}
