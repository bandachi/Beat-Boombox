package MatthewEricNick.HackThe90s;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

class Score {

    private int score = 0;
    private int combo = 0;
    private Context con;

    Score(Context con) {
        this.con = con;
    }

    void updateScore() {
        TextView scoreText = ((Activity) con).findViewById(R.id.scoreText);
        scoreText.setText("Score: " + Integer.toString(score));

        TextView comboText = ((Activity) con).findViewById(R.id.comboText);
        comboText.setText("Combo: " + Integer.toString(combo));
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
        updateScore();
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
        updateScore();
    }
}
