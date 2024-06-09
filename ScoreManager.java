/**
 * Write a description of class ScoreManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreManager {
    private static int score = 0;

    public static void addScore(int points) {
        score += points;
    }

    public static int getScore() {
        return score;
    }

    public static void resetScore() {
        score = 0;
    }
}