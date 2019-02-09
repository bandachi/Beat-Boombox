package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.widget.AbsListView;
import android.widget.ImageView;

class Walkman {

    private final float VELOCITY = 5;

    private Context con;
    private int direction;
    private boolean active;

    private ImageView imageView;
    private float velocityX;
    private float velocityY;

    private Handler moveImage = new Handler();

    Walkman(Context con, int direction) {
        this.con = con;
        setDirection(direction);
        active = true;
    }

    void spawnImage(int x, int y) {
        imageView = MainUtility.addImage(con,"GameLayout", "boom_box_base", x, y);
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(200, 200));
    }

    void spawnImage() {

        float x;
        float y;

        switch (direction) {
            case 0:
                x = MainUtility.getScreenWidth(con)/2;
                y = 0;
                break;
            case 1:
                x = MainUtility.getScreenWidth(con);
                y = MainUtility.getScreenHeight(con)/2;
                break;
            case 2:
                x = MainUtility.getScreenWidth(con)/2;
                y = MainUtility.getScreenHeight(con);
                break;
            case 3:
                x = 0;
                y = MainUtility.getScreenHeight(con)/2;
                break;
            default:
                x = 0;
                y = 0;
                break;
        }

        imageView = MainUtility.addImage(con,"GameLayout", "boom_box_base", x, y);
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(200, 200));
    }

    void startMove() {
        runnableMoveImage.run();
    }

    void stopMove() {
        moveImage.removeCallbacksAndMessages(null);
    }

    private float getAngle() {
        return direction * (float)Math.PI/2;
    }

    void setDirection(int direction) {
        this.direction = direction;

        float angle = getAngle();

        velocityX = -VELOCITY * (float)Math.sin(angle);
        velocityY = VELOCITY * (float)Math.cos(angle);
    }

    private Runnable runnableMoveImage = new Runnable() {
        @Override
        public void run() {

            if (active) {
                imageView.setX(imageView.getX() + velocityX);
                imageView.setY(imageView.getY() + velocityY);
                moveImage.postDelayed(this, 20);
            }
            else {
                stopMove();
            }

        }
    };
}
