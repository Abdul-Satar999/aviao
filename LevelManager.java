/**
 * Write a description of class LevelManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelManager {
    private static int level = 1;

    public static void nextLevel() {
        level++;
    }

    public static int getLevel() {
        return level;
    }

    public static void resetLevel() {
        level = 1;
    }
}
