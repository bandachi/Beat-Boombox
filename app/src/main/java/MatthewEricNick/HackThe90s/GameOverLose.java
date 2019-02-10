package MatthewEricNick.HackThe90s;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class GameOverLose extends AppCompatActivity {
    final static String SCORE_PASS = "score pass";
    final static String COMBO_PASS = "combo pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_lose);

        init();
        update();
    }

    private void init() {
        findViewById(R.id.continueText).startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in_fade_out));
    }

    private void update() {
        ((TextView) findViewById(R.id.finalScoreText)).setText("Your final score: " + getIntent().getIntExtra(SCORE_PASS, MODE_PRIVATE));
        ((TextView) findViewById(R.id.finalComboText)).setText("Your final combo: " + getIntent().getIntExtra(COMBO_PASS, MODE_PRIVATE));
    }

    @Override
    public void onBackPressed() {
        //intentionally empty
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        return true;
    }
}
