package MatthewEricNick.HackThe90s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private BoomBox boomBox;
    private WalkmanSpawn walkmanSpawn;
    private ProjectileSpawn projectileSpawn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        walkmanSpawn = new WalkmanSpawn(this);
        walkmanSpawn.startSpawning();

        projectileSpawn = new ProjectileSpawn(this, walkmanSpawn);

        boomBox = new BoomBox(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        boomBox.motion(e);

        projectileSpawn.motion(e);

        return true;
    }
}
