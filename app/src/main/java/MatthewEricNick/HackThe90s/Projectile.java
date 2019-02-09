package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;

import java.util.ArrayList;

class Projectile extends Entity {

    private final float VELOCITY = 20;
    private float angle;
    private ArrayList<Walkman> walkmanList;

    Projectile(Context con, float angle, ArrayList<Walkman> walkmanList, Score score) {
        super(con, score);
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
            if (isColliding(walkmanList.get(i).imageView)) {
                this.deleteAll();
                walkmanList.get(i).deleteAll();
                score.setScore(score.getScore() + 90);
                score.setCombo(score.getCombo() + 1);
            }
        }
    }

    @Override
    void delete() {

    }
}
