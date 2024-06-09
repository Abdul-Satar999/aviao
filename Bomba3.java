import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomba3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomba3 extends Actor
{
    private int speed = 8; // Velocidade da bomba
    private boolean movingUp = true; // Indica se a bomba está se movendo para cima
  //  private GreenfootSound explosaoSound = new GreenfootSound("explosao.wav"); // Carrega o som da explosão

    public void act()
    {
      //moveVertically();
        explodeOnCollision();
        checkWallCollision();
        
    }
    
     private void checkWallCollision() {
        if (movingUp) {
            setLocation(getX(), getY() - speed);
            if (getY() <= 0) {
                movingUp = false; // Muda a direção para baixo quando atinge o topo
            }
        } else {
            setLocation(getX(), getY() + speed);
            if (getY() >= getWorld().getHeight() - 1) {
                movingUp = true; // Muda a direção para cima quando atinge o fundo
            }
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

    
    
    
    
    
    

