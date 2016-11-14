package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by bouca-_d on 01/02/16.
 */
public class AssetLoader {
    private static Texture texture;

    public static TextureRegion bg;
    public static TextureRegion grass;
    public static TextureRegion bird;
    public static TextureRegion birdDown;
    public static TextureRegion birdUp;
    public static TextureRegion skullUp;
    public static TextureRegion skullDown;
    public static TextureRegion playButton;
    public static TextureRegion rateButton;
    public static TextureRegion rankingButton;
    public static TextureRegion screenScore;
    public static TextureRegion bar;

    public static Sound die;
    public static Sound hit;
    public static Sound scored;
    public static Sound fly;
    public static Sound gamescore;

    public static Animation birdAnimation;


    public static BitmapFont font, shadow;

    public static void load() {
        texture = new Texture(Gdx.files.internal("data/original.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        loadEnvironment(texture);
        loadButtons(texture);
        loadTubes(texture);
        loadBirds(texture);
        loadSounds();
        loadText();
    }

    private static void loadText() {
        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.getData().setScale(.25f, -.25f);
        shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        shadow.getData().setScale(.25f, -.25f);
    }

    private static void loadSounds() {
        die = Gdx.audio.newSound(Gdx.files.internal("data/sounds/die.mp3"));
        hit = Gdx.audio.newSound(Gdx.files.internal("data/sounds/hit.mp3"));
        scored = Gdx.audio.newSound(Gdx.files.internal("data/sounds/point.mp3"));
        fly = Gdx.audio.newSound(Gdx.files.internal("data/sounds/wing.mp3"));
        gamescore = Gdx.audio.newSound(Gdx.files.internal("data/sounds/swooshing.mp3"));
    }

    private static void loadButtons(Texture texture) {
        playButton = new TextureRegion(texture, 708, 236, 104, 58);
        playButton.flip(false, true);

        rankingButton = new TextureRegion(texture, 828, 236, 104, 58);
        rankingButton.flip(false, true);

        rateButton = new TextureRegion(texture, 930, 2, 62, 36);
        rateButton.flip(false, true);

        screenScore = new TextureRegion(texture, 6, 518, 226, 114);
        screenScore.flip(false, true);
    }

    private static void loadEnvironment(Texture texture) {
        bg = new TextureRegion(texture, 0, 305, 288, 97);
        bg.flip(false, true);

        grass = new TextureRegion(texture, 585, 0, 334, 22);
        grass.flip(false, true);
    }

    private static void loadTubes(Texture texture) {
        skullUp = new TextureRegion(texture, 168, 646, 52, 26);
        skullDown = new TextureRegion(skullUp);
        skullDown.flip(false, true);

        bar = new TextureRegion(texture, 170, 672, 48, 200);
        bar.flip(false, true);
    }

    private static void loadBirds(Texture texture) {
        birdDown = new TextureRegion(texture, 118, 982, 34, 24);
        birdDown.flip(false, true);

        bird = new TextureRegion(texture, 62, 982, 34, 24);
        bird.flip(false, true);

        birdUp = new TextureRegion(texture, 6, 982, 34, 24);
        birdUp.flip(false, true);

        TextureRegion[] birds = { birdDown, bird, birdUp };
        birdAnimation = new Animation(0.06f, birds);
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public static void dispose() {
        texture.dispose();
        font.dispose();
        shadow.dispose();
        die.dispose();
        hit.dispose();
        scored.dispose();
        fly.dispose();
        gamescore.dispose();
    }
}
