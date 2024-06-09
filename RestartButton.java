import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class RestartButton extends Actor
{
    public RestartButton() {
        GreenfootImage image = new GreenfootImage("restart.png"); // Crie uma imagem para o botão ou use uma imagem existente
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld()); // Reinicie o jogo definindo o mundo inicial
        }
    }
}