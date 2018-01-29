package com.poo.game.gameWorld;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.poo.game.gameHelper.AssetLoader;
import com.poo.game.gameObjects.Bird;
import com.poo.game.gameObjects.ScrollHandler;


/**
 * Created by Bruno M on 27/01/2018.
 */

public class GameWorld {

    public enum GameState{
        READY, RUNNING, GAMEOVER, HIGHSCORE;
    }

    private Bird bird;
    private Rectangle ground;
    private ScrollHandler scroller;
    private GameState currentState;
    private int score = 0;
    private int midPointY;


    public GameWorld(int midPointY){
        this.midPointY = midPointY;
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
        currentState = GameState.READY;
    }

    public void update(float delta) {

        switch (currentState) {
            case READY:
                updateReady(delta);
                break;

            case RUNNING:
                updateRunning(delta);
                break;
            default:
                break;
        }
    }

    public void updateRunning(float delta){
        if (delta > .15f)
            delta = .15f;
        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;

            if (score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
        }
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
        currentState = GameState.READY;
    }

    private void updateReady(float delta) {
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public Bird getBird(){
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
