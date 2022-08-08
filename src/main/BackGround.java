package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BackGround {
	
	GamePanel gp;
	BufferedImage bg;
	
	public BackGround(GamePanel gp) {
		this.gp = gp;
		
		
	}
	
	public void draw(Graphics2D g2) {
		
		try {
			bg = ImageIO.read(getClass().getResourceAsStream("background.jpg"));
			g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
