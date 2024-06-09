
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld3 extends World
{
  
    private LevelDisplay levelDisplay;
    private Score scoreDisplay;
    
    private Door3 door3;
    
    
    private GreenfootSound backgroundMusic = new GreenfootSound("background.mp3"); // Substitua "background.mp3" pelo nome do seu arquivo de música
    private int timer;
    private int timer2 = 0;
    /**
     * Constructor for objects of class MyWorld3.
     * 
     */
    public MyWorld3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1310, 710, 1); // tamanho 
        
        
        timer = 6000; // 10 minutos em segundos (600 ticks)
        prepare();
         
        
        AddActor();
        
        //insercao de imagem
        GreenfootImage backgroundImage = new GreenfootImage("Ceu3.png");
        backgroundImage.scale(getWidth(), getHeight());// Redimensiona a imagem para o tamanho do mundo
        setBackground(backgroundImage); //Define a imagem como plano de fundo
    
        
         aviao aviao = new aviao();
         
         
         scoreDisplay = new Score();
       addObject(scoreDisplay, 130, 30);
        // Outros inicializadores do seu mundo
    
     
         levelDisplay = new LevelDisplay();
         addObject(levelDisplay, 280, 30); // Ajuste a posição conforme necessário
        
    }
    
    
    
     
    
  public void scheduleBombAppearance() {
        // Agendar a aparição da bomba em intervalos aleatórios
        Greenfoot.delay(Greenfoot.getRandomNumber(200) + 50);
        // Chama o método para fazer a bomba aparecer em uma nova posição aleatória
        appearRandomly();
    }

    private void appearRandomly() {
        // A bomba aparecerá em uma nova posição aleatória
        Bomba bomba = new Bomba();
        addObject(bomba, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        
        // Chama o método para verificar se a bomba está na mesma posição que o avião
        //checkBombPosition(bomba);
    }

  /*  private void checkBombPosition(Bomba bomba) {
        // Verifica se a bomba está na mesma posição que o avião
        aviao aviao = (aviao) getObjects(aviao.class).get(0);
        if (bomba.getX() == aviao.getX() && bomba.getY() == aviao.getY()) {
            // Se a bomba está na mesma posição que o avião, remove a bomba e explode o avião
            removeObject(bomba);
            aviao.explodir();
        } else {
            // Se a bomba não está na mesma posição que o avião, chama o método para a bomba desaparecer
            disappear(bomba);
        }
    }*/

    private void disappear(Bomba bomba) {
        // Agendar o desaparecimento da bomba após um curto intervalo de tempo
        Greenfoot.delay(20);
        removeObject(bomba);
        // Chama o método para agendar a próxima aparição da bomba
        scheduleBombAppearance();
    }
        


     private void prepare()
    {
        //StartButton startButton = new StartButton();
       // addObject(startButton, getWidth() / 2, getHeight() / 2); // adicionando o botão no centro do mundo
    
        
         Bomba bomba = new Bomba();
        addObject(bomba, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
    
        Bomba3 bomba3 = new Bomba3();
        addObject(bomba3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())); // Adiciona uma bomba em uma posição aleatória

        
        
       Door3 door3 = new Door3();
       addObject(new Door3(), 1259, 657); // Posiciona a porta no lado direito 
    
       
    
    }
    
     

    
     // Para garantir que a música pare quando o jogo terminar
    public void stopped() {
        backgroundMusic.stop();
    }
    
    public void act() {
        showText("Time: " + timer / 60, 50, 20);
        if (timer > 0) {
            timer--;
        } else {
            Greenfoot.stop();
            showText("Game Over", getWidth()/2, getHeight()/2);
        }
        
         //Incrementar o temporizador
            timer2++;
            
            //apos 20 segundos (20*60 atos em um mundo  a 60 FPS), adicionar a porta
           
             if (timer2 == 7 * 60)
            {
            addObject(new Door3(), 1259, 657); // Posiciona a porta no lado direito
    }
    
      scoreDisplay.setImage(new GreenfootImage("Score: " + ScoreManager.getScore(), 24, Color.WHITE, Color.BLACK));
       levelDisplay.setImage(new GreenfootImage("Level: " + LevelManager.getLevel(), 24, Color.WHITE, Color.BLACK));
    
    if (Greenfoot.isKeyDown("h")) { // Pressione "h" para exibir o histórico
            Greenfoot.setWorld(new HistoryWorld());
        }
    }
    
    
    
     public void AddActor(){
    
    addObject(new BrickBig(), 426, 9);
        addObject(new BrickBig(), 449, 704);
        
        addObject(new BrickHeightBig(), 1299, 385);
        addObject(new BrickHeightBig(), 5, 278);
         addObject(new aviao(), 84, 92);
        // addObject(new Door(), 1259, 657);
         addObject(new Bomba(), 6, 1148);
          addObject(new Bomba(), 1057, 119);
          addObject(new Bomba(), 1126, 609);
          addObject(new Bomba3(), 800, 223);
          addObject(new Bomba3(), 700, 233);
          addObject(new Bomba3(), 905, 463);
          addObject(new Bomba1(), 349, 643);
          addObject(new Bomba1(), 436, 215);
}

 


}
