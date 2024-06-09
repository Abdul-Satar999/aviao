import greenfoot.*;

public class HistoryWorld extends World {
    public HistoryWorld() {
        super(1300, 700, 1);
        prepare();
        
        
          setBackground(new GreenfootImage("ceu.jpg"));
    }

    private void prepare() {
        // Adicione o objeto HistoryDisplay ao mundo
        addObject(new HistoryDisplay(), getWidth() / 2, getHeight() / 2);
    }
}
