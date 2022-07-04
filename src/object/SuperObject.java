package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {

	public BufferedImage image;
	public String name;
	public boolean collision=false;
	//public int worldX,worldY;
	public int x=0;
	public int y=0;
	public void draw(Graphics2D g2,GamePanel gp) {
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
//		x += gp.tileSize;
	}
	
}
