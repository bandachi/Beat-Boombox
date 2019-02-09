package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.os.Handler;

import java.util.ArrayList;

public class WalkmanSpawn {

    private boolean active = true;
    private Context con;
    private ArrayList<Walkman> projectiles = new ArrayList<>();

    private int spawnDelay = 500;
    private Handler spawnWalkman = new Handler();

    WalkmanSpawn(Context con) {
        this.con = con;
    }

    void startSpawning() {
        runnableSpawnWalkman.run();
    }

    void stopSpawning() {
        active = false;
        spawnWalkman.removeCallbacksAndMessages(null);
    }


    private Runnable runnableSpawnWalkman = new Runnable() {
        @Override
        public void run() {

            if (active) {
                addRandomWalkman();
                spawnWalkman.postDelayed(this, spawnDelay);
            }
            else {
                spawnWalkman.removeCallbacksAndMessages(null);
            }

        }
    };

    private void addRandomWalkman() {

        Walkman walkman = new Walkman(con, (int)(Math.random() * 4));
        walkman.spawnImage();
        walkman.startMove();
        projectiles.add(walkman);
    }


}
