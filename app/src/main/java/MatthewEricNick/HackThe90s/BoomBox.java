package MatthewEricNick.HackThe90s;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class BoomBox {

    private Context con;
    private ImageView imageView;

    private Handler firstFrame = new Handler();

    private boolean fingerHeld = false;
    private boolean reversed = false;
    private int counter = 4;

    BoomBox(Context con) {
        this.con = con;
        init();
    }

    private void init() {
        imageView = ((Activity) con).findViewById(R.id.boomBox);
        playAnimation();
    }

    void motion(MotionEvent e) {

        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                fingerHeld = true;
                break;

            case MotionEvent.ACTION_UP:
                fingerHeld = false;
                break;
            default:
                break;
        }

    }

    private void playAnimation() {

        firstFrame.postDelayed(new Runnable() {

            @Override
            public void run() {

                String currentFrame = "boom_box_";
                if (fingerHeld) {
                    currentFrame += "clicked_";
                }

                currentFrame += counter;

                imageView.setImageResource(con.getResources().getIdentifier(currentFrame, "drawable", con.getPackageName()));

                if (counter < 2 || counter > 5) {
                    reversed = !reversed;
                }

                if (!reversed) {
                    counter--;
                }
                else {
                    counter++;
                }
                firstFrame.postDelayed(this, 100);

            }
        }, 0);

    }

    int getCounter() {
       return counter;
    }

    boolean getReversed() {
        return reversed;
    }
}