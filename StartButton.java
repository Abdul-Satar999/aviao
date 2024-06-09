import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class StartButton extends Actor
{

    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StartButton() {
        setImage("startButton.png");  // Certifique-se de que a imagem está na pasta images do seu projeto
    }
    public void act(){
         if (Greenfoot.mouseClicked(this)) {
              
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
