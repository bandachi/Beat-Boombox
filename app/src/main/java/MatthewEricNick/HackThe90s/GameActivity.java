package MatthewEricNick.HackThe90s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private BoomBox boomBox;
    private WalkmanSpawn walkmanSpawn;
    private ProjectileSpawn projectileSpawn;
    private Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = new Score(this);
        walkmanSpawn = new WalkmanSpawn(this, score);
        walkmanSpawn.startSpawning();
        boomBox = new BoomBox(this);
        projectileSpawn = new ProjectileSpawn(this, walkmanSpawn, score, boomBox);


    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        boomBox.motion(e);

        projectileSpawn.motion(e);

        return true;
    }

    @Override
    public void onBackPressed() {
        //intentionally empty
    }
}
