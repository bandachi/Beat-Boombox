package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;

import java.util.ArrayList;

class Projectile extends Entity {

    private final float VELOCITY = 20;
    private float angle;
    private ArrayList<Walkman> walkmanList;

    Projectile(Context con, float angle, ArrayList<Walkman> walkmanList) {
        super(con);
        this.angle = angle;
        this.walkmanList = walkmanList;
    }

    void calcAngle() {
        velocityX = VELOCITY * (float)Math.cos(Math.toRadians(angle));
        velocityY = VELOCITY * (float)Math.sin(Math.toRadians(angle));
    }

    void init() {
        imageView = MainUtility.addImage(con, "gameLayout", "projectile", MainUtility.getScreenWidth(con)/2, MainUtility.getScreenHeight(con)/2);
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(200, 200));
        MainUtility.centerImage(imageView);
        imageView.setRotation(90 + angle);
        startMove();
    }

    @Override
    void checkBoundaries() {
        super.checkBoundaries();
        checkCollision();
    }

    private void checkCollision() {

        for (int i = 0; i < walkmanList.size(); i++) {
            Rect projectileRect = new Rect();
            Rect walkmanRect = new Rect();

            imageView.getHitRect(projectileRect);
            walkmanList.get(i).imageView.getHitRect(walkmanRect);

            if (projectileRect.intersect(walkmanRect)) {
                this.deleteAll();
                walkmanList.get(i).deleteAll();
            }
        }
    }

    @Override
    void delete() {

    }
}
