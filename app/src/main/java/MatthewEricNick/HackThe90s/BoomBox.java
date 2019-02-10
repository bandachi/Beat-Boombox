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
    private Handler secondFrame = new Handler();

    private boolean fingerHeld = false;
    private int counter = 1;

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

                if (counter < 6) {
                    counter++;
                    firstFrame.postDelayed(this, 100);
                }
                else {
                    firstFrame.removeCallbacksAndMessages(null);
                    playSecondAnimation();
                }


            }
        }, 0);

    }

    private void playSecondAnimation() {

        secondFrame.postDelayed(new Runnable() {

            @Override
            public void run() {

                String currentFrame = "boom_box_";
                if (fingerHeld) {
                    currentFrame += "clicked_";
                }

                currentFrame += counter;

                imageView.setImageResource(con.getResources().getIdentifier(currentFrame, "drawable", con.getPackageName()));

                if (counter > 1) {
                    counter--;
                    secondFrame.postDelayed(this, 100);
                }
                else {
                    secondFrame.removeCallbacksAndMessages(null);
                    playAnimation();
                }
            }
        }, 0);
    }
}