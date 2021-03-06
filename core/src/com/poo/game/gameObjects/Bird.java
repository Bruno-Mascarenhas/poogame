package com.poo.game.gameObjects;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;
import com.poo.game.gameHelper.AssetLoader;

/**
 * Created by Bruno M on 27/01/2018.
 */

public class Bird {

    private Vector2 position, velocity, acceleration;
    private float rotation;
    private int width, height;
    private Circle boundingCircle;
    private boolean isAlive;

    public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        isAlive = true;
        boundingCircle = new Circle();
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));
        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);
        if (velocity.y > 200)
            velocity.y = 200;

        if (position.y < -13) {
            position.y = -13;
            velocity.y = 0;
        }

        position.add(velocity.cpy().scl(delta));
        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);

        if (velocity.y < 0) {
            rotation -= 600 * delta;

            if (rotation < -20)
                rotation = -20;
        }
        if (isFalling() || !isAlive) {
            rotation += 480 * delta;
            if (rotation > 90)
                rotation = 90;
        }
    }

    public void onClick() {
        if (isAlive) {
            AssetLoader.flap.play(0.5f);
            velocity.y = -140;
        }
    }

    public void onRestart(int y) {
        rotation = 0;
        position.y = y;
        velocity.x = 0;
        velocity.y = 0;
        acceleration.x = 0;
        acceleration.y = 460;
        isAlive = true;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        isAlive = false;
        velocity.y = 0;
    }

    public void decelerate() {
        acceleration.y = 0;
    }

    public float getRotation() {
        return rotation;
    }

    public boolean isFalling() {
        return velocity.y > 110;
    }

    public boolean shouldntFlap() {
        return velocity.y > 70 || !isAlive;
    }

    public Circle getBoundingCircle() {
        return boundingCircle;
    }

}
