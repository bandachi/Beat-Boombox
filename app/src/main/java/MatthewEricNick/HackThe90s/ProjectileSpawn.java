package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

public class ProjectileSpawn {

    private Context con;
    private WalkmanSpawn walkmanSpawn;

    private float currentX = 0;
    private float currentY = 0;

    private float liftedX = 0;
    private float liftedY = 0;

    ProjectileSpawn(Context con, WalkmanSpawn walkmanSpawn) {
        this.con = con;
        this.walkmanSpawn = walkmanSpawn;
    }

    void motion(MotionEvent e) {
        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                currentX = e.getX();
                currentY = e.getY();
                break;

            case MotionEvent.ACTION_UP:
                liftedX = e.getX();
                liftedY = e.getY();
                Projectile projectile = new Projectile(calcAngle());
                break;
            default:
                break;
        }
    }

    private float calcAngle() {
        float differenceX = liftedX - currentX;
        float differenceY = liftedY - currentY;

        return (float)Math.toDegrees(Math.atan2(differenceY, differenceX));
    }
}
