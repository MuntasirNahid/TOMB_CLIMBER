package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
GamePanel gp;
KeyHandler keyH;
	
	public void player(GamePanel gp, KeyHandler keyH) {
		this.gp =gp;
		this.keyH=keyH; 
		setDefaultValues();
		
	}
	public void setDefaultValues() {
		x=100;
		y=100;
		speed=4;
		direction="down";
		
	}
	public void getplayerImage() {
		try {

			up1=ImageIO.read(getClass().getResourceAsStream("/player/Up1.png"));
			up2=ImageIO.read(getClass().getResourceAsStream("/player/Up2.png"));
			down1=ImageIO.read(getClass().getResourceAsStream("/player/Down1.png"));
			down2=ImageIO.read(getClass().getResourceAsStream("/player/Down2.png"));
			left1=ImageIO.read(getClass().getResourceAsStream("/player/Left1.png"));
			left2=ImageIO.read(getClass().getResourceAsStream("/player/Left2.png"));
			right1=ImageIO.read(getClass().getResourceAsStream("/player/Right1.png"));
			right2=ImageIO.read(getClass().getResourceAsStream("/player/Right2.png"));
			
			
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
			}else if(keyH.rightPressed   ==true) {
				direction="right";
				x+=speed;
			}
			
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
		g2.drawImage(image, x, y, gp.tileSize,gp.tileSize,null);
    }
	
}
