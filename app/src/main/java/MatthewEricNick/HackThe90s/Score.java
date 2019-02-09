package MatthewEricNick.HackThe90s;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

class Score {

    private int score = 0;
    private int combo = 0;
    private int health = 3;
    private Context con;

    Score(Context con) {
        this.con = con;
    }

    private void updateScore() {
        TextView scoreText = ((Activity) con).findViewById(R.id.scoreText);
        scoreText.setText("Score: " + Integer.toString(score));

        TextView comboText = ((Activity) con).findViewById(R.id.comboText);
        comboText.setText("Combo: " + Integer.toString(combo));
    }

    private void updateHealth() {
        ImageView heart1 = ((Activity) con).findViewById(R.id.heart1);
        ImageView heart2 = ((Activity) con).findViewById(R.id.heart2);
        ImageView heart3 = ((Activity) con).findViewById(R.id.heart3);

        switch (health) {
            case 1:
                setEmptyHeart(heart2);
                break;
            case 2:
                setEmptyHeart(heart3);
                break;
            case 3:
                setFullHeart(heart1);
                setFullHeart(heart2);
                setFullHeart(heart3);
                break;

            case 0:
                gameOver();
            default:
                setEmptyHeart(heart1);
                setEmptyHeart(heart2);
                setEmptyHeart(heart3);
                break;
        }
    }

    private void setEmptyHeart(ImageView heart) {
        heart.setImageResource(con.getResources().getIdentifier("empty_heart", "drawable", con.getPackageName()));

    }

    private void setFullHeart(ImageView heart) {
        heart.setImageResource(con.getResources().getIdentifier("heart", "drawable", con.getPackageName()));
    }

    private void gameOver() {
        Intent intent = new Intent(con, GameOverLose.class);
        intent.putExtra(GameOverLose.SCORE_PASS, score);
        intent.putExtra(GameOverLose.COMBO_PASS, combo);
        con.startActivity(intent);
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
        updateScore();
    }

    int getCombo() {
        return combo;
    }

    void setCombo(int combo) {
        this.combo = combo;
        updateScore();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        updateHealth();
    }
}
