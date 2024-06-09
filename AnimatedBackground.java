import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedBackground extends Actor {
    private GreenfootImage[] frames;
    private int currentFrame = 0;
    private int animationSpeed = 8; // Velocidade da animação (frames por atualização)
    private int counter = 0;
    private int newWidth = 1310;  // Largura desejada
    private int newHeight = 800; // Altura desejada

    public AnimatedBackground() {
        int numFrames = 43; // Substitua pelo número real de quadros
        frames = new GreenfootImage[numFrames];
        for (int i = 0; i < numFrames; i++) {
            String filename = "frame" + (i + 1) + ".png";
            try {
                frames[i] = new GreenfootImage(filename);
                frames[i].scale(newWidth, newHeight); // Redimensiona a imagem
            } catch (Exception e) {
                System.out.println("Erro ao carregar imagem: " + filename);
                e.printStackTrace();
            }
        }
        setImage(frames[currentFrame]); // Define a imagem inicial
    }

    public void act() {
        counter++;
        if (counter % animationSpeed == 0) {
            currentFrame = (currentFrame + 1) % frames.length;
            setImage(frames[currentFrame]);
        }
    }
}