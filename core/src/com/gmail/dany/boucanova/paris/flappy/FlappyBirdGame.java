package com.gmail.dany.boucanova.paris.flappy;

import com.badlogic.gdx.Game;

import Helpers.AssetLoader;
import Screens.FlappyScreen;

/**
 * Created by bouca-_d on 01/02/16.
 */
public class FlappyBirdGame extends Game {

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new FlappyScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
