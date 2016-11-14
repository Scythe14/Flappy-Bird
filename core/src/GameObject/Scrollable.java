package GameObject;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by bouca-_d on 01/02/16.
 */
public class Scrollable {
    protected Vector2 position;
    protected Vector2 velocity;
    protected int width;
    protected int height;
    protected boolean isScrolledLeft;

    public Scrollable(float x, float y, int w, int h, float scrollSpedd)
    {
        position = new Vector2(x, y);
        velocity = new Vector2(scrollSpedd, 0);
        width = w;
        height = h;
        isScrolledLeft = false;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));

        if (position.x + width < 0) {
            isScrolledLeft = true;
        }
    }

    public void reset(float newX) {
        position.x = newX;
        isScrolledLeft = false;
    }

    public void stop() {
        velocity.x = 0;
    }

    public boolean isScrolledLeft() {
        return isScrolledLeft;
    }

    public float getTailX() {
        return position.x + width;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
