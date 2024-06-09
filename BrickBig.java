import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



/**
 * Write a description of class BrickBig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrickBig extends Brick
{
    /**
     * Act - do whatever the BrickBig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       
    }
    public BrickBig(){
    
         getImage().scale(getImage().getWidth()*60, getImage().getHeight()+9);
    }
}

