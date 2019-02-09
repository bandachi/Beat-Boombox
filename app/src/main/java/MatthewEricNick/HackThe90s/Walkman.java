package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;

public class Walkman {

    private final float VELOCITY = 5;

    private Context con;
    private int direction;
    private boolean active;

    private ImageView imageView;
    private float velocityX;
    private float velocityY;

    private Handler moveImage;

    Walkman(Context con, int direction) {
        this.con = con;
        setDirection(direction);
        active = true;
    }

    void spawnImage(int x, int y) {
        imageView = MainUtility.addImage(con,"GameLayout", "boom_box_base", x, y);
    }

    void calcVelocity() {

    }

    void move() {

    }

    void setDirection(int direction) {
        this.direction = direction;

        float angle = direction * 45;

        velocityX = -VELOCITY * (float)Math.sin(angle);
        velocityY = -VELOCITY * (float)Math.cos(angle);
    }

    private Runnable runnableMoveImage = new Runnable() {
        @Override
        public void run() {

            if (active) {

            }
        }
    };
}
