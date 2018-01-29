package com.poo.game.gameObjects;

/**
 * Created by Bruno M on 27/01/2018.
 */

public class Grass extends Scrollable {

    public Grass(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
    }

    public void onRestart(float x, float scrollSpeed) {
        position.x = x;
        velocity.x = scrollSpeed;
    }

}

