package matthew_eric_nick.hack_the_90s;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

public class ProjectileSpawn {

    private Context con;
    private WalkmanSpawn walkmanSpawn;
    private Score score;

    private float currentX = 0;
    private float currentY = 0;

    private float liftedX = 0;
    private float liftedY = 0;

    private SoundUtility soundUtility;

    private boolean coolDown;
    private Handler shootDelay = new Handler();
    private BoomBox boomBox;

    ProjectileSpawn(Context con, WalkmanSpawn walkmanSpawn, Score score, BoomBox boomBox) {
        this.con = con;
        this.walkmanSpawn = walkmanSpawn;
        this.score = score;
        this.boomBox = boomBox;
        soundUtility = new SoundUtility(con);
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

    private Runnable runnableDelay = new Runnable() {
        @Override
        public void run() {
            coolDown = false;
        }
    };

    private void spawnProjectile() {

        if (!coolDown && !boomBox.getReversed()) {
            Projectile projectile = new Projectile(con, calcAngle(), walkmanSpawn.getWalkmanList(), score);
            projectile.calcAngle();
            projectile.init();
            soundUtility.playProjectileShoot();
          //  coolDown = true;

        }
    }

    private float calcAngle() {
        float differenceX = liftedX - currentX;
        float differenceY = liftedY - currentY;

        return (float)Math.toDegrees(Math.atan2(differenceY, differenceX));
    }
}
