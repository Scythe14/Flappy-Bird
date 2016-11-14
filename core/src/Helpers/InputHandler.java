package Helpers;

import com.badlogic.gdx.InputProcessor;

import GameObject.Bird;
import GameWorld.GameWorld;

/**
 * Created by bouca-_d on 01/02/16.
 */

public class InputHandler implements InputProcessor {
    private Bird bird;
    private GameWorld world;

    public InputHandler(GameWorld w)
    {
        world = w;
        bird = w.getBird();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (world.isReady())
            world.start();

        bird.onClick();

        if (world.isGameOver())
            world.restart();
        return true;
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
