package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import main.GamePanel;

public class Entity {
	public int x,y;
	public int speed;
	
	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
	public String direction = "left";
	public int spriteCounter=0;
	public int spriteNum=1;
	
	// For Collision Check
	public boolean collisionOn = false;
	public boolean isLeapingLeft;
	public boolean isLeapingRight;
	public boolean isFalling;
	
	
	public int actionLockCounter=0;
	
	public boolean invincible;
	public int invincibleCounter;
	public BufferedImage image,image2,image3;
	public String name;
	public boolean collision=false;
	
	//CHARACTEER STATUS
	public int maxLife;
	public int life;
	
	public int type;//0=player ,2=monster
	
	
	// MONSTER UPDATE
	
	public void update(GamePanel gp) {
		actionLockCounter++;
		
//		System.out.println("aLC == " + actionLockCounter);
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1;
//			System.out.println("i == " + i);
			if(i<=50) {
				direction="left";
			}
			if(i>50 && i<=100) {
				direction = "right";
			}
			actionLockCounter = 0;
		}
		
		collisionOn = false;
		gp.cChecker.checkTile(this, false); 
		if(collisionOn == true) {
			if(direction == "left")
				direction = "right";
			else
				direction = "left";
				
		}
		
			switch(direction) {
			case "left" :x-=speed;break;
			case "right" :x+=speed;break;
			}
		
		spriteCounter++;
		 if(spriteCounter>12) {
			 if(spriteNum==1) {
				 spriteNum=2;
			 }
			 else if(spriteNum==2) {
				 spriteNum=1;
			 }
			 spriteCounter=0;
		 }
	}
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
//		System.out.println("DRAWING MONSTER");
		
		image = left1; 
		
//		direction = "right";
		

		switch(direction) {
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
//		System.out.println("HERE????");
//		if(image == null)
//			System.out.println("No image loaded");
//		else
//			System.out.println("Monster image loaded");
		g2.drawImage(image, x, y, gp.tileSize,gp.tileSize,null);			
		
	}


	
}
 