package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

public abstract class Entity {

    float velocityX;
    float velocityY;

    Context con;
    private boolean active = true;
    ImageView imageView;
    private Handler moveImage = new Handler();

    public Entity(Context con) {
        this.con = con;
    }

    boolean isColliding(ImageView other) {
        Rect thisRect = new Rect();
        Rect otherRect = new Rect();

        imageView.getHitRect(thisRect);
        other.getHitRect(otherRect);

        return thisRect.intersect(otherRect);

    }

    void startMove() {
        runnableMoveImage.run();
    }

    void stopMove() {
        moveImage.removeCallbacksAndMessages(null);
    }

    final void deleteAll() {
        active = false;
        MainUtility.removeImage(con, imageView);
        stopMove();
        delete();
        Log.d("delete", "deleted");
    }

    abstract void delete();

    void checkBoundaries() {
        if (imageView.getX() + imageView.getLayoutParams().width < -100 ||
                imageView.getX() > MainUtility.getScreenWidth(con) + 100 ||
                imageView.getY() + imageView.getLayoutParams().height < -100 ||
                imageView.getY() > MainUtility.getScreenHeight(con) + 100) {
            deleteAll();
        }
    }

    private Runnable runnableMoveImage = new Runnable() {
        @Override
        public void run() {

            if (active) {
                checkBoundaries();
                imageView.setX(imageView.getX() + velocityX);
                imageView.setY(imageView.getY() + velocityY);
                moveImage.postDelayed(this, 30);
            }
            else {
                deleteAll();
            }

        }
    };

    boolean getActive() {
        return active;
    }
}
