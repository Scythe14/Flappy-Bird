package GameWorld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import GameObject.Bird;
import GameObject.ScrollHandler;

/**
 * Created by bouca-_d on 01/02/16.
 */
public class GameWorld {
    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;

    private int score = 0;
    private int midPointY;

    public enum GameState {

        MENU, READY, RUNNING, GAMEOVER

    }

    private GameState currentState;

    public GameWorld(int midPointY)
    {
        currentState = GameState.READY;
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
        this.midPointY = midPointY;
    }

    public void update(float delta) {

        switch (currentState) {
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
            default:
                updateRunning(delta);
                break;
        }
    }

    public void updateMenu(float delta) {

    }

    private void updateReady(float delta)
    {
        scroller.updateGrass(delta);
    }

    private void updateRunning(float delta) {
        if (delta > .15f)
            delta = .15f;

        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            currentState = GameState.GAMEOVER;
            bird.die();
            bird.decelerate();
        }
    }

    public void addScore(int inc) {
        score += inc;
    }

    public Bird getBird() {
        return bird;
    }

    public int getScore() {
        return score;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
        currentState = GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
}
