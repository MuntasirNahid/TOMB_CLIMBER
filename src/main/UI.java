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
	public int commandNum = 0;
	public int titleScreenState = 0;//0: the first screen , 1: second screen
	
	BufferedImage heart_full, heart_half, heart_blank;
	 
	public UI(GamePanel gp) {
		this.gp=gp;
		
		Entity heart= new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
		
		
	}
	public void draw(Graphics2D g2) {
		this.g2=g2;
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		//PLAY STATE
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
		}
		
		//--------------------------------------------
		//GAME OVER state
		if(gp.gameState == gp.gameOverState) {
			
			drawGameOverScreen();
		}
		
		// Pause State
		if(gp.gameState == gp.pauseState) {
			
			drawPauseScreen();
		}
		
		if(gp.gameState == gp.winState) {
			
			drawWinScreen();
		}
	}
	
	public void drawWinScreen() {
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0,gp.screenWidth,gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));
		
		text = "CONGRATULATIONS!!!";
		//SHADOW
		g2.setColor(Color.black);
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
		g2.drawString(text, x, y);
		
		//MAIN
		g2.setColor(Color.white);
		g2.drawString(text, x-4, y-4);
		
		
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "MAIN MENU";
		x = getXforCenteredText(text);
		y += gp.tileSize*4;
		g2.drawString(text,x,y);
		if(commandNum == 0) {
			g2.drawString(">", x-40, y);
		}
		
	}
	
	public void drawPauseScreen() {
		
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0,gp.screenWidth,gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));
		
		text = "GAME PAUSED";
		//SHADOW
		g2.setColor(Color.black);
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
		g2.drawString(text, x, y);
		
		//MAIN
		g2.setColor(Color.white);
		g2.drawString(text, x-4, y-4);
		
		
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "CONTINUE";
		x = getXforCenteredText(text);
		y += gp.tileSize*4;
		g2.drawString(text,x,y);
		if(commandNum == 0) {
			g2.drawString(">", x-40, y);
		}
		
		text = "QUIT GAME";
		x = getXforCenteredText(text);
		y += 65;
		g2.drawString(text,x,y);

		if(commandNum==1) {
			g2.drawString(">", x-40, y);
		}
	}
	
	public void drawGameOverScreen() {
		//g2.setColor(Color.white);
		g2.setColor(new Color(0,0,0,150));//it will make screen half transparent to feel that game is over
		g2.fillRect(0, 0,gp.screenWidth,gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));
		
		text = "YOU  LOSE!";
		//SHADOW
		g2.setColor(Color.black);
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
		g2.drawString(text, x, y);
		
		//MAIN
		g2.setColor(Color.white);
		g2.drawString(text, x-4, y-4);
		
		
		//RETRY
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "RETRY";
		x = getXforCenteredText(text);
		y += gp.tileSize*4;
		g2.drawString(text,x,y);
		if(commandNum == 0) {
			g2.drawString(">", x-40, y);
		}
		
		//BACK TO THE TITLE SCREEN
		text = "MAIN MENU";
		x = getXforCenteredText(text);
		y += 65;
		g2.drawString(text,x,y);

		if(commandNum==1) {
			g2.drawString(">", x-40, y);
		}
	}
	
	public void drawTitleScreen() {
		
		if(titleScreenState == 0) { // main menu
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
			
//			//Game Logo Image
//			x=gp.screenWidth/2-(gp.tileSize*2)/2;//place the character at the center
//			y+=gp.tileSize;
//			g2.drawImage(gp.player.down1, x, y,gp.tileSize*2,gp.tileSize*2,null);
			
			//MENU
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,50F));
			
			text = "NEW GAME";
			x=getXforCenteredText(text);
			y+=gp.tileSize*3.5;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x-gp.tileSize, y);
				//if we want to use image icon instead of this ">" we can use drawImage method
				
			}
			
			text = "ABOUT";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 1 ) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text ="EXIT GAME";
			x =getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text,x,y);
			if(commandNum == 2) {
				g2.drawString(">", x-gp.tileSize, y);
			}
		}
		else if(titleScreenState == 1) {
			
			//ABOUT SECOND SCREEN
			
			g2.setColor(Color.BLACK);
			g2.setFont(g2.getFont().deriveFont(42F));
			
			String text = "INFO:";
			
			int x = getXforCenteredText(text);
			int y = gp.tileSize;
			g2.drawString(text, x, y);
//			if(commandNum == 0) {
//				g2.drawString(">", x-gp.tileSize, y);
//			}
			text="This game was created as a part of our OOP project(CSE-234)";
			 x = getXforCenteredText(text);
			 y = gp.tileSize*2;
			g2.drawString(text, x, y);
			
			text = "Genre: Metroidvania  / Leveller ";
			 x = getXforCenteredText(text);
			 y = gp.tileSize*3;
			g2.drawString(text, x, y);
			
			text = "Created-By : Team Double-N (Nazif and Nahid)";
			 x = getXforCenteredText(text);
			 y = gp.tileSize*4;
			g2.drawString(text, x, y);
			
			text = "Enjoy The Game!";
			 x = getXforCenteredText(text);
			 y = gp.tileSize*5;
			g2.drawString(text, x, y);
			
			text = "BACK";
			 x = getXforCenteredText(text);
			 y = gp.tileSize*6;
			g2.drawString(text, x, y);
			
			if(commandNum == 1) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
		}
		else if(titleScreenState == 2) { /// Map Choice
			g2.setColor(new Color(0,0,0));//RGB Number
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			
			//TITLE NAME
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,50F));
			String text="CHOOSE A MAP: ";
			int x=getXforCenteredText(text);
			int y=gp.tileSize*3;
			
			//TEXT SHADOW:
//			g2.setColor(Color.gray);
//			g2.drawString(text, x+4, y+4);
		
			
			//MAIN COLOR:
			g2.setColor(Color.white);
			g2.drawString(text,x,y);
			
			
			//MENU
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,50F));
			
			text = "MAP 1";
			x=getXforCenteredText(text);
			y+=gp.tileSize*3.5;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "MAP 2";
			x=getXforCenteredText(text);
			y+=gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x-gp.tileSize, y);
			}	
			
			text = "MAP 3";
			x=getXforCenteredText(text);
			y+=gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">", x-gp.tileSize, y);
				
			}
			
			text = "MAP 4";
			x=getXforCenteredText(text);
			y+=gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 3) {
				g2.drawString(">", x-gp.tileSize, y);
				
			}
		}
		
	}
	
	
	public void drawPlayerLife() {

		
		int x = gp.tileSize*19+24;
		int y = 0;
		int i = 0;
		
		//DRAW BLANK HEART
		while(i < gp.player.maxLife) {
			g2.drawImage(heart_blank, x, y, 40, 40, null);
			i++;
			x += 42;
		}
//			RESET
		 x = gp.tileSize*19+24;
		 y = 0;
		 i = 0;

		 //		 //DRAW CURRENT LIFE
		 
		 while( i < gp.player.life ) {
//			 g2.drawImage(heart_half, x, y, 40, 40, null);
//			 i++;
//			 if(i<gp.player.life) {
				 g2.drawImage(heart_full, x, y, 40, 40, null);
//			 }
			 i++;
			 x += 42;
		 }
	}


	public int getXforCenteredText(String text) {
		
		int length=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		int x=gp.screenWidth/2-length/2;
		return x;
		
	}
}
