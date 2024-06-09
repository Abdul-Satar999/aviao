import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickHeightBig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrickHeightBig extends Brick
{
    /**
     * Act - do whatever the BrickHeightBig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
      
    }
    public BrickHeightBig(){
        getImage().scale(getImage().getWidth()/1, getImage().getHeight()*59);
    }
}
