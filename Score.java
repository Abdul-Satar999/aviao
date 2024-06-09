import greenfoot.*;

public class Score extends Actor {
    private int score;

    public Score() {
        score = 0;
        updateImage();
    }

    public void addScore(int points) {
        score += points;
        updateImage();
    }

    private void updateImage() {
        setImage(new GreenfootImage("Score: " + score, 24, Color.WHITE, Color.BLACK));
    }

    public int getScore() {
        return score;
    }
     public void setScore(int score) {
        this.score = score;
        updateImage();
    }
}