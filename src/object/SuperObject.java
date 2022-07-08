package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.UtilityTool;

public class SuperObject {

	public BufferedImage image,image2,image3;
	public String name;
	public boolean collision=false;
	//public int worldX,worldY;
	public int x=0;
	public int y=0;
	
	
	//may have to change this value
	public Rectangle solidArea=new Rectangle(0,0,100,100);
	public int solidAreaDefaultX=0;
	public int solidAreaDefaultY=0;
	
	UtilityTool uTool=new UtilityTool();
	
	
	public void draw(Graphics2D g2,GamePanel gp) {
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

	}
	
}
