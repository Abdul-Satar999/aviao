import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Home extends World
{

       
    
   private AnimatedBackground animatedBackground;
   
    public Home()
    {
        super(1300, 710, 1);
        prepare();
        
        GreenfootImage backgroundImage = new GreenfootImage("ceu.jpg");
        backgroundImage.scale(getWidth(), getHeight());// Redimensiona a imagem para o tamanho do mundo
        setBackground(backgroundImage); //Define a imagem como plano de fundo
      
        // Adiciona o plano de fundo animado
       /* animatedBackground = new AnimatedBackground();
        addObject(animatedBackground, getWidth() / 2, getHeight() / 2);*/
        
        
    

    }
    
   

    private void prepare() {
        StartButton startButton = new StartButton();
        addObject(startButton, getWidth()/2, getHeight()/2);
       
          

  
        
    }
    
     public void act() {
       
    }

  
    
}