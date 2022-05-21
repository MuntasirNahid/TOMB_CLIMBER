package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{//this class inherites JPanel class

	//Will Make some screen settings here
	final int originalTileSize=16;// 16*16 tile
	final int scale=3;//will multiply size 3 times 
	public final int tileSize=originalTileSize*scale;//48*48 tile//screen size
	
	final int maxScreenCol=16;//16 tiles horizontally
	final int maxScreenRow=12;//12 tiles vertically
	final int screenWidth=tileSize*maxScreenCol;//768 Pixels
	final int screenHeight=tileSize*maxScreenRow;//576 Pixels
	
	//FPS
	int FPS=60;
	
	KeyHandler keyH=new KeyHandler();
	Thread gameThread;
	Player player = new Player();
	
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
	public void startGameThread() {
		
		gameThread=new Thread(this);
		gameThread.start();//it automatically calls run method
		
	}

	@Override
	public void run() {//we will create a game loop,which will be the core of our game
		
		double drawInterval=1000000000/FPS;
		double nextDrawTime=System.nanoTime()+drawInterval;
		
	
		while(gameThread!=null) {
			
			//long currentTime=System.nanoTime();
;			//long currentTime2=System.currentTimeMillis();

			//Update:Update information such as character position
			update();
			
			//Draw: dreaw the screen with the updated information
			repaint();//it's the way to call paint component method
			
			
			try {
				double remainingTime=nextDrawTime-System.nanoTime();
				remainingTime/=1000000;
				
				if(remainingTime<0) {
					remainingTime=0;
				}
					 
				
				Thread.sleep((long) remainingTime);
				nextDrawTime +=drawInterval;
			
			} catch (InterruptedException e) {
				
				e.printStackTrace();
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
		
		player.draw(g2);
//		g2.setColor(Color.white);
//		g2.fillRect(playerX, playerY, tileSize,tileSize);
//		
		g2.dispose();
		
		
	}

	
	
}
