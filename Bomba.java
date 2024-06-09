import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Bomba extends Actor {
 

    public Bomba() {
        // Define a imagem da bomba (certifique-se de ter um arquivo de imagem chamado "bomba.png" no projeto)
        setImage("bomb.png");
    }

  private int speed = 6; // Velocidade da bomba
    
    public void act() {
        
        explodeOnCollision();
           moveContinuously();
        checkWallCollision();
        
    }
     // Método para mover a bomba aleatoriamente
     // Método para mover a bomba continuamente girando
    private void moveContinuously() {
        turn(1); // Gira a bomba em 1 grau a cada ato
        move(speed); // Move a bomba para frente
        
    }
    
    // Método para verificar colisão com as paredes do mundo
    private void checkWallCollision() {
        if (isAtEdge()) {
            turn(Greenfoot.getRandomNumber(90) - 45); // Gira aleatoriamente entre -45 e 45 graus
            move(speed * 1); // Move para frente após a mudança de direção
        }
    }
    private void explodeOnCollision(){
        Actor collidingaviao = getOneIntersectingObject(aviao.class);
        if(collidingaviao!=null){
            getWorld().removeObject(collidingaviao);
            setImage("explosao0.png");
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);

        }
        }
      
         
    
    
    }
    
  
    

    
    

