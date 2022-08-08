package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;



public class GamePanel extends JPanel implements Runnable{//this class inherites JPanel class
	//Will Make some screen settings here
	final int originalTileSize=16;// 16*16 tile
	final int scale=4;//will multiply size 3 times 
	public final int tileSize=originalTileSize*scale;//48*48 tile//screen size
	
	public final int maxScreenCol=22;//16 tiles horizontally
	public final int maxScreenRow=12;//12 tiles vertically
	public final int screenWidth=tileSize*maxScreenCol;//768 Pixels
	public final int screenHeight=tileSize*maxScreenRow;//576 Pixels

	
	
	//	public boolean gameState=true;
	//	public boolean playState=true;
	
	//
	//FPS
	int FPS=60;
	
	//Map
 
	//KeyListener
	KeyHandler keyH=new KeyHandler(this);
	
	//changed this--------------------------------------
	
	TileManager tileH=new TileManager(this);
//	TileManager tileH;
	
	//---------------------------------------------------
	
	//collision checker
	public CollisionChecker cChecker=new CollisionChecker(this);
	
	Thread gameThread;
	
	
	
	
	//Object Image
	public AssetSetter aSetter=new AssetSetter(this);
	
	//UI
	public UI ui=new UI(this);
	//***
	public Player player =new Player (this,keyH);//main culprit
	public SuperObject obj[]=new SuperObject[10];
	
	//Object Array
//	public Entity obj[]=new Entity[10];//we will add ten coins at a time
	
	//MONSTER ARRAY
	public Entity monster[]=new Entity[20];
	
	//we will put player,entities and object into this list
	//ArrayList<Entity>entityList=new ArrayList<>();
	
	//player's default position
	int playerX=100;
	int playerY=100;
	int playerSpeed=4;
	
	
	//GameState
	
	public int gameState;
	public int titleState=0;
	public final int playState=1;
	public final int pauseState=2;
	public final int dialogueState=3;
	
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));//set the size of this class(JPanel
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);//if set to true,all the drawing from this component will be done in an off screen painting buffer 
		//enabling this can improve gane's rendering performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	//Object SetUp
	public void setupGame() {
		aSetter.setObject();
		//aSetter.setNPC();
		aSetter.setMonster();
		gameState=titleState;//it starts from this state
		
		
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
			repaint();//it's the way to call paint component method
			delta--;
			}		
		}
	 }
	public void update() {
		if(gameState==playState) { 
		//PLAYER
			player.update();
			
			//MONSTER
//			for(int i=0;i<monster.length;i++) {
//				if(monster[i]!=null) {
//					monster[i].update();
//				}
//			}
		}
		
		
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
	
	public void paintComponent(Graphics g) {//it's a built in method in java
		
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;//Graphics 2D have more functions than graphics
	
		//TITLE SCREEN
	
		if(gameState==titleState)
		{
			ui.draw(g2);
		}
		//others
		else
		{
			//Tile
			tileH.draw(g2);

			//ADD ENTITIES TO THE LIST	
		//	entityList.add(player);
			
//			Object
			for(int i=0;i<obj.length;i++) {
				if(obj[i]!=null) {
	
				//entityList.add(obj[i]);
			//	System.out.println("Object Found");
					obj[i].draw(g2, this);
					//obj[i].draw(g2, this);
				}
			}
//			
			//Monster
			for(int i=0;i<monster.length;i++) {
				if(monster[i]!=null) {
					//entityList.add(monster[i]);	
//					System.out.println("Trying to draw a monster");
					monster[i].draw(g2, this);
				}
			}
			
//			//SORT ACCORDING TO y
//			Collections.sort(entityList,new Comparator<Entity>(){
//				
//				@Override
//				public int compare(Entity e1,Entity e2) {
//					int result=Integer.compare(e1.x, e2.y);
//					return result;
//				}
//			});
			
			//Draw Entities
			
//			for(int i=0;i<entityList.size();i++) {
//				entityList.get(i).draw(g2);
//			}
//			After Drawing it,we remove everything from the list
			//Empty Entity List
			
//			for(int i=0;i<entityList.size();i++) {
//				entityList.remove(i);
//			}
			
			//Player
			player.draw(g2); 
			
			//UI
			ui.draw(g2);
		}
		
		
		
//		g2.setColor(Color.white);
//		g2.fillRect(playerX, playerY, tileSize,tileSize);
//		
		g2.dispose();
		
		
 	}

	
	
}
