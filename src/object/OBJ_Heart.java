package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//import java.io.IOException;
//
//import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

public class OBJ_Heart extends Entity{

	public OBJ_Heart(GamePanel gp) {
		super(gp);
		name="Heart";
//		image=setup("/object/heart_full");
//		image2=setup("/object/heart_half");
//		image3=setup("/object/heart_empty");
		UtilityTool uTool=new UtilityTool();
//		BufferedImage image=null;
		
		try {
			image=ImageIO.read(getClass().getResourceAsStream("/object/heart_full.png"));
			image2=ImageIO.read(getClass().getResourceAsStream("/object/heart_half.png"));
			image3=ImageIO.read(getClass().getResourceAsStream("/object/heart_empty.png"));
			image=uTool.scaleImage(image,gp.tileSize,gp.tileSize);
			image2=uTool.scaleImage(image2,gp.tileSize,gp.tileSize);
			image3=uTool.scaleImage(image3,gp.tileSize,gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
			}
	}
}