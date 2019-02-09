package MatthewEricNick.HackThe90s;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class BoomBox {

    private Context con;
    private ImageView imageView;

    private float currentX = 0;
    private float currentY = 0;

    private float liftedX = 0;
    private float liftedY = 0;

    BoomBox(Context con) {
        this.con = con;
        init();
    }

    private void init() {
        imageView = ((Activity) con).findViewById(R.id.boomBox);
    }

    void motion(MotionEvent e) {

        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                currentX = e.getX();
                currentY = e.getY();
                imageView.setImageResource(con.getResources().getIdentifier("boom_box_base_clicked", "drawable", con.getPackageName()));
                break;

            case MotionEvent.ACTION_UP:
                liftedX = e.getX();
                liftedY = e.getY();
                imageView.setImageResource(con.getResources().getIdentifier("boom_box_base", "drawable", con.getPackageName()));
                calcAngle();
                break;
            default:
                break;
        }

    }

    private void calcAngle() {
        float differenceX = liftedX - currentX;
        float differenceY = liftedY - currentY;

        float angle = (float)Math.toDegrees(Math.atan2(differenceY, differenceX));


        Log.d("angle", Float.toString((float)Math.toDegrees(angle)));
    }
}
