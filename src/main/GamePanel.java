package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import entity.Player;
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
	TileManager tileH = new TileManager(this); 
	// KeyListener
	KeyHandler keyH= new KeyHandler();
	// Collision Checker
	public CollisionChecker cChecker = new CollisionChecker(this);
	// Background
//	public BackGround background = new BackGround(this);
	
	Thread gameThread;
	
	//***
	Player player = new Player (this,keyH) ; 
	
	
	
	public GamePanel() {
        
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));//set the size of this class(JPanel
//		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);//if set to true,all the drawing from this component will be done in an offscreen painting buffer 
		//enabling this can improve game's rendering performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	public void startGameThread() {
		
		gameThread=new Thread(this);
		gameThread.start();//it automatically calls run method
		
	}
	
	@Override
	public void run() {//we will create a game loop,which will be the core of our game
		
		double drawInterval=1000000000/FPS;
		double delta=0;
		long lastTime=System.nanoTime();
		long currentTime;

		while(gameThread!=null) {
			
		currentTime=System.nanoTime();
		
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
		
		player.update();
		
		
	}
	
	public void paintComponent(Graphics g) { //it's a built-in method in java
		
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;//Graphics 2D have more functions than graphics
		
		ImageIcon bg = new ImageIcon("E:\\sam\\2-1\\CSE-234\\OOP Project\\src\\main\\background.jpg");
		
		g2.drawImage(bg.getImage(), 0, 0, null);
		
		
		tileH.draw(g2);
		
		player.draw(g2); 
		
		
		g2.dispose();
		
		
 	}

	
	
}
