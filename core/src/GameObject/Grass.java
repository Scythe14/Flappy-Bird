package GameObject;

/**
 * Created by bouca-_d on 01/02/16.
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
