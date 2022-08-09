package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {

	public BufferedImage image;
	public String name;
	public boolean collision=false;
	public int x,y;

	public void draw(Graphics2D g2, GamePanel gp) {
		
		
		
//		int screenX= x - gp.player.x + gp.player.screenX;
//		int screenY= y - gp.player.y + gp.player.screenY;
		
//		int sx = gp.screenWidth/2 -(gp.tileSize/2);
//		int sy = gp.screenHeight/2 -(gp.tileSize/2);
//		
//		int screenX= x - gp.player.x + sx;
//		int screenY= y - gp.player.y + sy;
//		
//		if(x + gp.tileSize > gp.player.x - sx &&
//		   x - gp.tileSize < gp.player.x + sx &&
//		   y + gp.tileSize > gp.player.y - sy &&
//		   y - gp.tileSize < gp.player.y + sy) {
//			g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize,null);			
//
//		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}

}
