package entity;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


import main.GamePanel;
import main.KeyHandler;  
public class Player extends Entity {
	
	KeyHandler keyH;
	public int hasCoin=0;
	public final int screenX;
	public final int screenY;

	public Player(GamePanel gp, KeyHandler keyH) {
//	 this.gp =gp;
	 super(gp);
		this.keyH=keyH; 
		
		
				
		screenX=gp.screenWidth/2 -(gp.tileSize/2);
		screenY=gp.screenHeight/2 -(gp.tileSize/2);
		
		//Object collision detection:
		solidArea=new Rectangle(0, 0, gp.tileSize-1, gp.tileSize-1);
//		solidArea.x=0;
//		solidArea.y=16;
//		solidAreaDefaultX=solidArea.x;
//		solidAreaDefaultY=solidArea.y;
//		solidArea.width=32;
//		solidArea.height=32;
		
	setDefaultValues();
		getplayerImage();
	}
	public void setDefaultValues() {
		x=0;
		y=640;
		speed=4;
		direction="down";
		
		//PLAYER STATUS
		maxLife=6;
		life=maxLife;
		
		
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
			if(keyH.upPressed==true) {
				direction="up";
				y-=speed;
			}else if(keyH.downPressed==true) {
				direction="down";
				y+=speed;
			}else if(keyH.leftPressed==true) {
				direction="left";
				x-=speed;
			}else if(keyH.rightPressed ==true) {
				direction="right";
				x+=speed;
			}
			
			//check tile collision
			
			collisionOn=false;
			gp.cChecker.checkTile(this);
			
			
			
			//CHECK OBJECT COLLISION:
		//	int objIndex=gp.cChecker.checkObject(this,true);
		//	pickUpObject(objIndex);
			
			//check monster collision:
			
	//		int monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
	//		contactMonster(monsterIndex);
			//check event
			
			//gp.eHandler.checkEvent();
			
			
			
//			if(collisionOn==false && gp.keyH.enterPressed==false) {
//				switch(direction) {
//				case "up":y-=speed;break;
//				case "down" : y+=speed;break;
//		case "left" : x-=speed;break;
//		case "right" : x+=speed;break;
			
//				}
//			}
			
		//	gp.keyH.enterPressed=false;
			
			spriteCounter++;//it increases when we press one of these keys
			if(spriteCounter>12)//Image changes in every 10 frames
			{
				if(spriteNum==1) {
					spriteNum=2;
				}
				else if(spriteNum==2) {
					spriteNum=1;
				}
				spriteCounter=0;
			}
//			else
//			{
//				standCounter++;
//				if(standCounter==20) {
//					spriteNum=1;
//					standCounter=0;
//				}
//				}
			}
		
		//This needs to be outside of if statement
		if(invincible==true) {
			invincibleCounter++;
			if(invincibleCounter>60) {
				invincible=false;
				invincibleCounter=0;
			}
		}
		}
//		if(keyH.upPressed==true) {
//	y-=speed;	
//		}
//	else if(keyH.downPressed==true) {
//		y+=speed;//pixels
//		}
//	else if(keyH.leftPressed==true) {
//		x-=speed;
//		}
//	else if(keyH.rightPressed==true) {
//		x+=speed;
//		}
////		
	
	
	public void pickUpObject(int index) {
		if(index!=999) {
//			String objectName=gp.obj[index].name;
			hasCoin++;
			gp.obj[index]=null;
		}
	}
	
	public void contactMonster(int i) {
		if(i!=999) {
			if(invincible==false) {
				life-=1;	
				invincible=true;
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
//			if(invincible==true) { 
//				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f));//
////		 * will make player half invincible 
//				} 
			g2.drawImage(image, x, y, gp.tileSize,gp.tileSize,null); 
 
 //Reset Alpha ////
			//	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));//
//		  will make player half invincible
		
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize,gp.tileSize);
			}
////	
	
}
