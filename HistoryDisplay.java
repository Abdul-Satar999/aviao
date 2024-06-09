import java.util.ArrayList;
import greenfoot.*;
import greenfoot.Color;
import greenfoot.GreenfootImage;

import greenfoot.Actor;


public class HistoryDisplay extends Actor {

    public HistoryDisplay() {
        
           
          
        
        displayHistory();
        
      
    }

    private void displayHistory() {
        ArrayList<GameResult> history = GameHistory.getHistory();
        
        // Verifica se o histórico não é nulo e não está vazio
        if (history != null && !history.isEmpty()) {
            GreenfootImage image = new GreenfootImage(400, history.size() * 20);

            // Preenche a imagem com fundo branco
            image.setColor(Color.WHITE);
            image.fill();

            // Desenha o histórico na imagem
            image.setColor(Color.BLACK);
            for (int i = 0; i < history.size(); i++) {
                GameResult result = history.get(i);
                String text = "Jogo " + (i + 1) + ": Pontuação " + result.getScore() + ", Nível " + result.getLevel();
                image.drawString(text, 10, (i + 1) * 20);
            }

            setImage(image);
        } else {
            GreenfootImage image = new GreenfootImage(400, 20);
            image.setColor(Color.WHITE);
            image.fill();
            image.setColor(Color.BLACK);
            image.drawString("Nenhum jogo registrado ainda.", 10, 15);
            setImage(image);
        }
    }
}

