package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

public class ProjectileSpawn {

    private Context con;
    private WalkmanSpawn walkmanSpawn;
    private Score score;

    private float currentX = 0;
    private float currentY = 0;

    private float liftedX = 0;
    private float liftedY = 0;

    ProjectileSpawn(Context con, WalkmanSpawn walkmanSpawn, Score score) {
        this.con = con;
        this.walkmanSpawn = walkmanSpawn;
        this.score = score;
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
                spawnProjectile();
                break;
            default:
                break;
        }
    }

    private void spawnProjectile() {
        Projectile projectile = new Projectile(con, calcAngle(), walkmanSpawn.getWalkmanList(), score);
        projectile.calcAngle();
        projectile.init();
    }

    private float calcAngle() {
        float differenceX = liftedX - currentX;
        float differenceY = liftedY - currentY;

        return (float)Math.toDegrees(Math.atan2(differenceY, differenceX));
    }
}
