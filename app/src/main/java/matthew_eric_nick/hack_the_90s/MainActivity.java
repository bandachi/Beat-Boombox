package matthew_eric_nick.hack_the_90s;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeToGame(View view) {
        //findViewById(R.id.playButton).setAlpha(0.5f);
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    public void changeToStory(View view) {
        //findViewById(R.id.playButton).setAlpha(0.5f);
        Intent intent = new Intent(this, Story.class);
        startActivity(intent);
    }
    public void changeToInstructions(View view) {
        //findViewById(R.id.playButton).setAlpha(0.5f);
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
    }

}
