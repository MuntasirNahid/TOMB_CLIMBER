package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;



public class GamePanel extends JPanel implements Runnable{//this class inherites JPanel class
	//Will Make some screen settings here
	final int originalTileSize=16;// 16*16 tile
	final int scale=3;//will multiply size 3 times 
	public final int tileSize=originalTileSize*scale;//48*48 tile//screen size
	
	public final int maxScreenCol=16;//16 tiles horizontally
	public final int maxScreenRow=12;//12 tiles vertically
	public final int screenWidth=tileSize*maxScreenCol;//768 Pixels
	public final int screenHeight=tileSize*maxScreenRow;//576 Pixels
	
	//FPS
	int FPS=60;
	
	TileManager tileH = new TileManager(this); 
	KeyHandler keyH=new KeyHandler();
	Thread gameThread;
//	public CollisionChecker cChecker=new CollisionChecker(this);
	
	//Object Image
	public AssetSetter aSetter=new AssetSetter(this);
	
	
	//***
	public Player player =new Player (this,keyH);//main culprit
	public SuperObject obj[]=new SuperObject[10];//we will add ten coins at a time
	
	
	//player's default position
	int playerX=100;
	int playerY=100;
	int playerSpeed=4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));//set the size of this class(JPanel
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);//if set to true,all the drawing from this component will be done in an offscreen painting buffer 
		//enabling this can improve gane's renderring performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	//Object SetUp
	public void setupGame() {
		aSetter.setObject();
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
			
				//Draw: dreaw the screen with the updated information
			repaint();//it's the way to call paint component method
			delta--;
			}		
		}
	 }
	public void update() {
		
		player.update();
		
//		if(keyH.upPressed==true) {
//			playerY-=playerSpeed;	
//		}
//		else if(keyH.downPressed==true) {
//			playerY+=playerSpeed;//pixels
//		}
//		else if(keyH.leftPressed==true) {
//			playerX-=playerSpeed;
//		}
//		else if(keyH.rightPressed==true) {
//			playerX+=playerSpeed;
//		}
		
		
	}
	
	public void paintComponent(Graphics g) {//it's a builtin method in java
		
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;//Graphics 2D have more functions than graphics
	
		//Tile
		tileH.draw(g2);
		
		//Object
		for(int i=0;i<obj.length;i++) {
			if(obj[i]!=null) {
				obj[i].draw(g2, this);
			}
		}
		
		//Player
		player.draw(g2); 
//		g2.setColor(Color.white);
//		g2.fillRect(playerX, playerY, tileSize,tileSize);
//		
		g2.dispose();
		
		
 	}

	
	
}
