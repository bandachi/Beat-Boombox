package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;

public class WalkmanSpawn {

    private boolean active = true;
    private Context con;
    private ArrayList<Walkman> walkmanList = new ArrayList<>();
    private Score score;

    private int spawnDelay = 500;
    private Handler spawnWalkman = new Handler();

    WalkmanSpawn(Context con, Score score) {
        this.con = con;
        this.score = score;
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

        Walkman walkman = new Walkman(con, (int)(Math.random() * 4), score);
        walkman.spawnImage();
        walkman.startMove();
        walkmanList.add(walkman);
        checkInactive();
    }

    private void checkInactive() {
        for (int i = 0; i < walkmanList.size(); i++) {
            if (!walkmanList.get(i).getActive()) {
                walkmanList.remove(i);
                Log.d("test", Integer.toString(walkmanList.size()));
            }
        }
    }

    ArrayList<Walkman> getWalkmanList() {
        return walkmanList;
    }

}
