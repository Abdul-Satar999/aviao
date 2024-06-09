import greenfoot.*;

public class LevelDisplay extends Actor {
    public LevelDisplay() {
        updateImage();
    }

    private void updateImage() {
        setImage(new GreenfootImage("Level: " + LevelManager.getLevel(), 24, Color.WHITE, Color.BLACK));
    }

    public void act() {
        updateImage();
    }
}
