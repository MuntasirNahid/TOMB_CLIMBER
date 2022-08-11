package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.IOException;

//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.OBJ_Coin;
import object.SuperObject;
import tile.TileManager;



public class GamePanel extends JPanel implements Runnable{//this class inherits JPanel class
	//Will Make some screen settings here
	final int originalTileSize = 16; // 16*16 tile
	final int scale = 4; //will multiply size 4 times 
	public final int tileSize=originalTileSize*scale;// 64*64 tile//screen size
	
	public final int maxScreenCol = 22;// 22 tiles horizontally
	public final int maxScreenRow = 12;// 12 tiles vertically
	public final int screenWidth = tileSize*maxScreenCol;// 64*22 = 1408(-42 == 1366) Pixels
	public final int screenHeight = tileSize*maxScreenRow;// 64*12 == 768 Pixels
	
	//FPS
	int FPS=60;
	
	// Map
	TileManager[] tileH = new TileManager[4]; 
//	TileManager tileH = new TileManager(this, 0);
	// KeyListener
	KeyHandler keyH = new KeyHandler(this);
	// Collision Checker
	public CollisionChecker cChecker = new CollisionChecker(this);
	
	Thread gameThread;
	
	//***
	public Player player = new Player (this, keyH) ; 
	
	//Object Image
	public AssetSetter aSetter = new AssetSetter(this);
	
	//UI
	public UI ui = new UI(this);
	
	public OBJ_Coin coin = new OBJ_Coin(this);
	
	
	public SuperObject[][] obj = new SuperObject[4][50];
	
	
	//MONSTER ARRAY
	public Entity[][] monster = new Entity[4][10];
	
	//we will put player,entities and object into this list
	//ArrayList<Entity>entityList=new ArrayList<>();
	
	//GameState
	
	public int gameState;
	public int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int gameOverState = 3;
	public final int winState = 4;
	
	public int mapId = 0;
	public int coinCount = 0;
	public long timer = System.nanoTime();
	
	public GamePanel() {
		
		for(int i = 0; i < 4; ++i)
			tileH[i] = new TileManager(this, i);
        	
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));//set the size of this class(JPanel
//		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);//if set to true,all the drawing from this component will be done in an offscreen painting buffer 
		//enabling this can improve game's rendering performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	//Object SetUp
	public void setupGame() {
//		for(int i = 0; i < 4; ++i) {
//			aSetter.setObject(i);
//			aSetter.setMonster(i);
//		}
		aSetter.setObject(mapId);
		aSetter.setMonster(mapId);
		gameState = titleState; //it starts from this state
	}
	
	public void reStart() {
		coinCount = 0;
		timer = System.nanoTime();
		
		
		player.setDefaultValues();
//		for(int i = 0; i < 4; ++i) {
//			aSetter.setObject(i);
//			aSetter.setMonster(i);
//		}
		aSetter.setObject(mapId);
		aSetter.setMonster(mapId);
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();//it calls the run method
	}
	
	@Override
	public void run() {//we will create a game loop,which will be the core of our game
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while(gameThread!=null) {
			
		currentTime = System.nanoTime();
		
		delta+=(currentTime-lastTime)/drawInterval;
		lastTime=currentTime;
		
		if(delta>=1) {
			//Update:Update information such as character position
			update();

				//Draw: draw the screen with the updated information
			repaint();//it's the way to call paintComponent() method
			delta--;
		}		
	}
	 }
	public void update() {
		
		if(gameState == playState) { 
			
			player.update();
			
//			MONSTER
			for(int i=0;i<monster[mapId].length;i++) {
				if(monster[mapId][i]!=null) {
					monster[mapId][i].update(this);
				}
			}
		}
		
		
	}
	
	public void paintComponent(Graphics g) { //it's a built-in method in java
		
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;//Graphics 2D have more functions than graphics
		
	//TITLE SCREEN
	
		if(gameState == titleState)	{
			
			
			ImageIcon bg = new ImageIcon("E:\\sam\\2-1\\CSE-234\\OOP Project\\src\\main\\titleBg.jpg");
			g2.drawImage(bg.getImage(), 0, 0, null);
			
			ui.draw(g2);
		}
		else	{
			
			/// Background Image
			
			ImageIcon bg = new ImageIcon("E:\\sam\\2-1\\CSE-234\\OOP Project\\src\\main\\background.jpg");
			g2.drawImage(bg.getImage(), 0, 0, null);
			
			//Tile
			tileH[mapId].draw(g2);

			
//				COIN
			for(int i = 0; i < obj[mapId].length; i++) {
				if(obj[mapId][i] != null) {	
//				System.out.println("Object Found");
					obj[mapId][i].draw(g2, this);
				}
			}

			//Monster
			for(int i = 0; i < monster[mapId].length; i++) {
				if(monster[mapId][i] != null) {
					
//						System.out.println("Trying to draw a monster");
					monster[mapId][i].draw(g2, this);
				}
			}
			
			
			//Player
			player.draw(g2); 
			
			//Drawing Hearts
			ui.draw(g2);
		}
		g2.dispose();
 	}

	
	
}
