package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import object.OBJ_Heart;
import object.SuperObject;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	//Font maruMonica,purisaB;
	public boolean gameFinished=false;
	public int commandNum=0;
	
	BufferedImage heart_full,heart_half,heart_blank;
	 
	public UI(GamePanel gp) {
		this.gp=gp;
		
		//CREATE HUD OBJECT
		Entity heart=new OBJ_Heart(gp);
		heart_full=heart.image;
		heart_half=heart.image2;
		heart_blank=heart.image3;
		
		
	}
	public void draw(Graphics2D g2) {
		this.g2=g2;
		
		//TITLE STATE
	
		if(gp.gameState==gp.titleState) {
			drawTitleScreen();
		}
		
		//PLAY STATE
		if(gp.gameState==gp.playState) {
			drawPlayerLife();
		}
	}
	
	
	public void drawTitleScreen() {
		//background Color:
		g2.setColor(new Color(0,0,0));//RGB Number
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		//TITLE NAME
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,50F));
		String text="TOMB CLIMBER";
		int x=getXforCenteredText(text);
		int y=gp.tileSize*3;
		
		//TEXT SHADOW:
		g2.setColor(Color.gray);
		g2.drawString(text, x+4, y+4);
	
		
		//MAIN COLOR:
		g2.setColor(Color.white);
		g2.drawString(text,x,y);
		
		//Game Logo Image
		x=gp.screenWidth/2-(gp.tileSize*2)/2;//place the character at the center
		y+=gp.tileSize;
		g2.drawImage(gp.player.down1, x, y,gp.tileSize*2,gp.tileSize*2,null);
		
		//MENU
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,50F));
		
		text="NEW GAME";
		x=getXforCenteredText(text);
		y+=gp.tileSize*3.5;
		g2.drawString(text,x,y);
		if(commandNum==0) {
			g2.drawString(">", x-gp.tileSize, y);
			//if we want to use image icon instead of this ">" we can use drawImage method
			
		}
		
		text="LOAD GAME";
		x=getXforCenteredText(text);
		y+=gp.tileSize;
		g2.drawString(text,x,y);
		if(commandNum==1) {
			g2.drawString(">", x-gp.tileSize, y);
		}
		
		text="QUIT";
		x=getXforCenteredText(text);
		y+=gp.tileSize;
		g2.drawString(text,x,y);
		if(commandNum==2) {
			g2.drawString(">", x-gp.tileSize, y);
		}
		
		
	}
	
	
	public void drawPlayerLife() {

		
		int x=gp.tileSize/2;
		int y=gp.tileSize/2;
		int i=0;
		
		//DRAW BLANK HEART
		while(i<gp.player.maxLife/2) {
			g2.drawImage(heart_full,x,y,null);
			i++;
			x+=gp.tileSize;
		}
//		//RESET
//		 x=gp.tileSize/2;
//		 y=gp.tileSize/2;
//		 i=0;
//		 
//		 //DRAW CURRENT LIFE
//		 while(i<gp.player.life) {
//			 g2.drawImage(heart_full, x, y,null);
//			 i++;
////			 if(i<gp.player.life) {
////				 g2.drawImage(heart_half,x,y,null);
////			 }
//			 i++;
//			 x+=gp.tileSize;
//		 }
//		g2.drawImage(heart_full, x, y, null);
	}


	public int getXforCenteredText(String text) {
		int length=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		int x=gp.screenWidth/2-length/2;
		return x;
		
	}
}