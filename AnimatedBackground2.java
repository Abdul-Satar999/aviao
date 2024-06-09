import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedBackground2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class AnimatedBackground2 extends Actor {
    private GreenfootImage[] frames;
    private int currentFrame = 0;
    private int animationSpeed = 20; // Velocidade da animação (frames por atualização)
    private int counter = 0;
    private int newWidth = 1310;  // Largura desejada
    private int newHeight = 800; // Altura desejada

    public AnimatedBackground2() {
        int numFrames = 20; // Número de quadros para a segunda animação
        frames = new GreenfootImage[numFrames];
        for (int i = 0; i < numFrames; i++) {
            String filename = "frame" + (50 + i) + ".png"; // Ajusta o índice para começar do frame 50
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

