package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


import main.GamePanel;
import main.KeyHandler;  
public class Player extends Entity {
//	
	GamePanel gp;
	KeyHandler keyH;
	

	public  Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH; 
		
		setDefaultValues();
		
		// For Collision Check
		solidArea = new Rectangle(0, 4, 30, gp.tileSize-8); // x+16, y+16, 30, 30
		
		getplayerImage();
	}
	public void setDefaultValues() {
		x = 1280;
		y = 64;
		speed = 4;
		direction="right";
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
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyH.upPressed==true ||keyH.downPressed==true || keyH.leftPressed==true ||keyH.rightPressed==true  )//without pressing key player will not move
		{
			String prevDirection = direction;
			
			if(keyH.upPressed==true) {
				direction="up";
			}else if(keyH.downPressed==true) {
				direction="down";
			}else if(keyH.leftPressed==true) {
				direction="left";
			}else if(keyH.rightPressed   ==true) {
				direction="right";
			}
			
			
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
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
			if(spriteCounter>12)//Image changes every 12 frames
			{
				if(spriteNum==1) {
					spriteNum=2;
				}
				else if(spriteNum==2) {
					spriteNum=1;
				}
				spriteCounter=0;
			}
		}
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
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

	}
}
