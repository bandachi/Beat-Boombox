package matthew_eric_nick.hack_the_90s;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;

public class BoomBox {

    private Context con;
    private ImageView imageView;

    private Handler firstFrame = new Handler();

    private SoundUtility soundUtility;
    private boolean reversed = false;
    private int counter = 4;

    BoomBox(Context con) {
        this.con = con;
        init();
        soundUtility = new SoundUtility(con);
    }

    private void init() {
        imageView = ((Activity) con).findViewById(R.id.boomBox);
        playAnimation();

    }

    private void playAnimation() {

        firstFrame.postDelayed(new Runnable() {

            @Override
            public void run() {

                String currentFrame = "boom_box_";
                if (!reversed) {
                    currentFrame += "clicked_";
                }

                currentFrame += counter;

                imageView.setImageResource(con.getResources().getIdentifier(currentFrame, "drawable", con.getPackageName()));

                if (counter < 2 || counter > 5) {

                    reversed = !reversed;
                    soundUtility.playBeat();
                }

                if (!reversed) {
                    counter--;
                }
                else {
                    counter++;
                }

                int delay;
                if (reversed) {
                    delay = 50;
                }
                else {
                    delay = 100;
                }

                firstFrame.postDelayed(this, delay);

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