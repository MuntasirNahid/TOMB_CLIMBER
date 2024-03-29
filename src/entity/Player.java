package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


import main.GamePanel;
import main.KeyHandler;  
public class Player extends Entity {
//	
	GamePanel gp;
	KeyHandler keyH;
	public int hasCoin;
	

	public  Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH; 
		
		setDefaultValues();
		getplayerImage();
	}
	public void setDefaultValues() {
		// map01 -> (1280, 64)
		// map02 -> (0, 640)
		x = 0;
		y = 640;
		speed = 4;
		direction = "right";
		isLeapingLeft = false;
		isLeapingRight = false;
		isFalling = false;
		maxLife = 6;
		life = 6;
		invincible = false;
		invincibleCounter = 0;
		hasCoin = 0;
	}
	public void getplayerImage() {
		try {

			up1=ImageIO.read(getClass().getResourceAsStream("Up1.png"));
			up2=ImageIO.read(getClass().getResourceAsStream("Up2.png"));
			down1=ImageIO.read(getClass().getResourceAsStream("Down1.png"));
			down2=ImageIO.read(getClass().getResourceAsStream("Down2.png"));
			left1=ImageIO.read(getClass().getResourceAsStream("Left1.png"));
			left2=ImageIO.read(getClass().getResourceAsStream("Left2.png"));
			right1=ImageIO.read(getClass().getResourceAsStream("Right1.png"));
			right2=ImageIO.read(getClass().getResourceAsStream("Right2.png"));
			
		}	catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		
		if(invincible==true) {
			invincibleCounter++;
			if(invincibleCounter>90) {
				invincible=false;
				invincibleCounter=0;
			}
		}
		
		/// Fall handling
		
//		System.out.println("falling state == "+isFalling);
		
		gp.cChecker.checkTile(this, true);
		
		if(isFalling)	{
			y += speed;
			System.out.println("Should be falling");
		}
		else if(isLeapingLeft) {
			x -= speed;
		}
		else if(isLeapingRight) {
			x += speed;
		}

		
		if(isLeapingLeft || isLeapingRight || isFalling)
			return;
		
		
		
		/// Player's collision with tiles
		
		if( keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true  )	{
			
			String prevDirection = direction;
			
			if(keyH.upPressed == true) {
				direction="up";
			}else if(keyH.downPressed == true) {
				direction="down";
			}else if(keyH.leftPressed == true) {
				direction="left";
			}else if(keyH.rightPressed == true) {
				direction="right";
			}
			
			collisionOn = false;
			gp.cChecker.checkTile(this, false);
			
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					y -= speed;
					break;
				case "down":
					y += speed;
					break;
				case "left":
					x -= speed;
					break;
				case "right":
					x += speed;
					break;
				}
			}
			else
				direction = prevDirection;
			
			spriteCounter++;//it increases when we press one of these keys
			/// I'm HERE
			if(spriteCounter > 7 ) //Image is updated every 7 frames(60 FPS)
			{
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
		/// Player's collision with monster
		

		
		int index;
		if(invincible == false) {
			index = gp.cChecker.checkEntity(this, gp.mapId, gp.monster);
//			System.out.println("Index == "+index);
			if(index != -1) {
				System.out.println("Collision with monster with index == " + index);
				life--;
				invincible = true;
			}
		}

		
		//For game Over State
		if(life <= 0) {
			gp.gameState=gp.gameOverState;
		}
		
		/// Player's collision with coin
		
		index = gp.cChecker.checkCoin(this, gp.mapId, gp.obj);
//		System.out.println("Index == "+index);
		if(index != -1) {
			System.out.println("Collision with coin with index == " + index);
			hasCoin++;
			gp.obj[gp.mapId][index] = null;
		}
		
		if(hasCoin == gp.coinCount) {
			gp.gameState = gp.winState;
		}
//		System.out.println("COin == " + hasCoin);
	}
	
	
	public void draw(Graphics2D g2) {
		BufferedImage image=null;
		switch(direction) {
		case "up":
			if(spriteNum==1) {
				image=up1;
			}
			if(spriteNum==2) {
				image=up2;
			}			
			break;
		case "down":
			if(spriteNum==1) {
				image=down1;
			}
			if(spriteNum==2) {
				image=down2;
			}
			break;
		case "left":
			if(spriteNum==1) {
				image=left1;
			}
			if(spriteNum==2) {
				image=left2;
			}
			break;
		case "right":
			if(spriteNum==1) {
				image=right1;
			}
			if(spriteNum==2) {
				image=right2;
			}
			break;
		
			
		}
		if(invincible==true) { 
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.6f));//
		} 
		g2.drawImage(image, x, y, gp.tileSize,gp.tileSize,null); 

		//Reset Alpha 
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));//

	}
}
