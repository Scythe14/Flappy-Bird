package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import GameWorld.GameRender;
import GameWorld.GameWorld;
import Helpers.InputHandler;

/**
 * Created by bouca-_d on 01/02/16.
 */

public class FlappyScreen implements Screen {
    private GameWorld world;
    private GameRender renderer;
    private Float runtime;

    public FlappyScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        world = new GameWorld(midPointY);
        renderer = new GameRender(world, (int) gameHeight, midPointY);
        runtime = 0f;

        Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        runtime += delta;
        world.update(delta);
        renderer.render(runtime);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
