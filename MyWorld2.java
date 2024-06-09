import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld2 extends World
{
    
    

    private int timer1;
    private int timer = 0;
    private Door2 door2;
    
     
    private Score scoreDisplay;
    private LevelDisplay levelDisplay;
    
   
    
    
   
    
    
    
    public MyWorld2()
    {    
        
        // Cria um novo mundo com 600x400 células, cada célula com 1x1 pixels.
      super(1310, 710, 1); // tamanho
         timer1 = 6000; // 10 minutos em segundos (600 ticks)
        // Adicione os objetos necessários aqui
        prepare();
        
         
         //insercao de imagem
        GreenfootImage backgroundImage = new GreenfootImage("ceu2.jpg");
        backgroundImage.scale(getWidth(), getHeight());// Redimensiona a imagem para o tamanho do mundo
        setBackground(backgroundImage); //Define a imagem como plano de fundo
    
         AddActor();
         
          // Chama o método para agendar a aparição da bomba
        scheduleBombAppearance();
        
        
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
    
     public void act() {
         
         showText("Time: " + timer1 / 60, 50, 20);
        if (timer1 > 0) {
            timer1--;
        } else {
            Greenfoot.stop();
            showText("Game Over", getWidth()/2, getHeight()/2);
        }
        
            //Incrementar o temporizador
            timer++;
            
            //apos 20 segundos (20*60 atos em um mundo  a 60 FPS), adicionar a porta
           
             if (timer == 20 * 60)
            {
            addObject(door2, 1259, 657); // Posiciona a porta no lado direito
        }
        
        scoreDisplay.setImage(new GreenfootImage("Score: " + ScoreManager.getScore(), 24, Color.WHITE, Color.BLACK));
          levelDisplay.setImage(new GreenfootImage("Level: " + LevelManager.getLevel(), 24, Color.WHITE, Color.BLACK));
    
          
          
           if (Greenfoot.isKeyDown("h")) { // Pressione "h" para exibir o histórico
            Greenfoot.setWorld(new HistoryWorld());
        }
          
    }
          
        
         private void disappear(Bomba bomba) {
        // Agendar o desaparecimento da bomba após um curto intervalo de tempo
        Greenfoot.delay(20);
        removeObject(bomba);
        // Chama o método para agendar a próxima aparição da bomba
        scheduleBombAppearance();
    }
        
    
    private void prepare()
    {
        // Adicione seu avião no mundo
        aviao aviao = new aviao();
        
        
        // Adicione bombas ou outros obstáculos
        Bomba bomba = new Bomba();
        addObject(bomba, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
    
        door2 = new Door2();
    
        
        
        
    }
    

    
    
    public void AddActor(){
    
    addObject(new BrickBig(), 859, 3);
        addObject(new BrickBig(), 881, 704);
        
        addObject(new BrickHeightBig(), 1306, 355);
        addObject(new BrickHeightBig(), 6, 315);
        addObject(new aviao(), 84, 92);
        addObject(new Bomba(), 1200, 293);
}


   
}

