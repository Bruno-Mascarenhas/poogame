package com.poo.game.gameHelper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.poo.game.gameObjects.Bird;
import com.poo.game.gameWorld.GameWorld;

/**
 * Created by Bruno M on 27/01/2018.
 */

public class InputHandler implements InputProcessor {
    private Bird bird;
    private GameWorld world;

    public InputHandler(GameWorld world){
      this.world = world;
      bird = world.getBird();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (world.isReady()) {
            world.start();
        }

        bird.onClick();

        if (world.isGameOver() || world.isHighScore()) {
            world.restart();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
