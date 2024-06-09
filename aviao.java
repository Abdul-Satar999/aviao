import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class aviao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class aviao extends Actor
{
    private GreenfootSound explosaoSound = new GreenfootSound("explosao.mp3"); // Carrega o som da explosão

    private GreenfootSound ganhouSound = new GreenfootSound("ganhou.mp3"); // Carrega o som de vitória

     private GreenfootSound nivelSound = new GreenfootSound("nivel.mp3"); //passagem de nivel
     
     private boolean exploded = false;
     
    public int speed = 8;
    
     
    
    public void act()
    {
       Moviment();
checkCollision();

//move(5);
checkCollision1();
checkCollision2();

 


 if (!exploded) {

  if (Greenfoot.isKeyDown("up")) {
            setRotation(270);
            move(1);
            ScoreManager.addScore(1);
        }
        if (Greenfoot.isKeyDown("down")) {
            setRotation(90);
            move(1);
            ScoreManager.addScore(1);
        }
        if (Greenfoot.isKeyDown("left")) {
            setRotation(180);
            move(1);
            ScoreManager.addScore(1);
        }
        if (Greenfoot.isKeyDown("right")) {
            setRotation(0);
            move(1);
            ScoreManager.addScore(1);
        }
        
        // Exemplo de condição para avançar de nível
       /* if (ScoreManager.getScore() >= 100) { // Altere o valor conforme necessário
            Greenfoot.setWorld(new MyWorld2()); // Troca para o próximo mundo
            LevelManager.nextLevel();
            //ScoreManager.resetScore(); // Opcional: reseta a pontuação ao avançar de nível
        }*/
        
        // Verificar colisão com portas e mudar de nível
        if (isTouching(Door.class)) {
            LevelManager.nextLevel();
            Greenfoot.setWorld(new MyWorld2());
            removeTouching(Door.class);
        } else if (isTouching(Door2.class)) {
            LevelManager.nextLevel();
            Greenfoot.setWorld(new MyWorld3());
            removeTouching(Door2.class);
        } else if (isTouching(Door3.class)) {
            LevelManager.nextLevel();
            Greenfoot.setWorld(new MyWorld4());
            removeTouching(Door3.class);
        }
        checkCollision();
       } else {
            // O avião explodiu, registre o resultado do jogo
            GameHistory.addResult(new GameResult(ScoreManager.getScore(), LevelManager.getLevel()));
        }
}

private void explode() {
        exploded = true;
        // Adicione a animação de explosão ou outros efeitos aqui

        // Reinicie o jogo
        Greenfoot.setWorld(new MyWorld());
        ScoreManager.resetScore();
        LevelManager.resetLevel();
    }
    
    public void Moviment(){
        
        //int speed = 1000;  // Aumente a velocidade para 5 ou outro valor desejado
        
      if(Greenfoot.isKeyDown("right")){
            move(speed);
            if(NoTouchBrick()) {
                move(-speed);
            } else {
                setRotation(0); // Define a rotação para 0 (avançando para a direita)
            }
        }
        else if(Greenfoot.isKeyDown("left")){
            move(speed);
            if(NoTouchBrick()) {
                move(speed);
            } else {
                setRotation(180); // Define a rotação para 180 (avançando para a esquerda)
            }
        }
        else if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - speed);
            if(NoTouchBrick()) {
                setLocation(getX(), getY() + speed);
            } else {
                setRotation(270); // Define a rotação para 270 (avançando para cima)
            }
        }
        else if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + speed);
            if(NoTouchBrick()) {
                setLocation(getX(), getY() - speed);
            } else {
                setRotation(90); // Define a rotação para 90 (avançando para baixo)
            }
    }
}

 private void checkCollision() {
        if (isTouching(Bomba.class)) {
            Greenfoot.stop();
            getWorld().showText("Sinderdeste! Game Over !Satardeste", getWorld().getWidth()/2, getWorld().getHeight()/2);
        
            explosaoSound.play(); // Reproduz o som da explosão
       
        
         explode();
        
        }
         if (isTouching(Bomba1.class)) {
            Greenfoot.stop();
            getWorld().showText("Sinderdeste! Game Over !Satardeste", getWorld().getWidth()/2, getWorld().getHeight()/2);

            explosaoSound.play(); // Reproduz o som da explosão
    
             explode();
        
        }
     if (isTouching(Bomba3.class)) {
            Greenfoot.stop();
            getWorld().showText("Sinderdeste! Game Over !Satardeste", getWorld().getWidth()/2, getWorld().getHeight()/2);
        
            explosaoSound.play(); // Reproduz o som da explosão

             explode();        
        }
    }
    
     private void checkCollision1()
    {
        if (isTouching(Door.class)) 
        {
           nivelSound.play(); // Reproduz o som de passagem de nivel
            Greenfoot.setWorld(new MyWorld2());
            
        }
         if (isTouching(Door2.class)) 
        {
            nivelSound.play(); // Reproduz o som de passagem de nivel
            Greenfoot.setWorld(new MyWorld3());
            
        }
        if (isTouching(Door3.class)) 
        {
           nivelSound.play(); // Reproduz o som de passagem de nivel
            Greenfoot.setWorld(new MyWorld4());
            
        }
        if (isTouching(Door4.class)) 
        {
           nivelSound.play(); // Reproduz o som de passagem de nivel
            //Greenfoot.setWorld(new Home());
            
        }
        
    }
    
    
     private void checkCollision2()
    {
        if (isTouching(Door4.class)) 
        {
            getWorld().showText("Ganhou!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
             ganhouSound.play(); // Reproduz o som de vitória
            Greenfoot.stop();
           // ((MyWorld4)getWorld()).showRestartButton(); // Mostra o botão de reinício no segundo mundo
            
        }
    }

    

    public aviao(){
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
   
       
    
    }
    public boolean NoTouchBrick(){
    if(isTouching(Brick.class)){
        return true;
    }
    else{
        return false;
    }
    }
     
}
