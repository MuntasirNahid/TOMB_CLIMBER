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
//
public class OBJ_Coin extends SuperObject{

	public OBJ_Coin(GamePanel gp) {
	
//		name="Coin";
//		down1=setup("/object/coin");
//		collision=true;
		
		
		UtilityTool uTool=new UtilityTool();
		BufferedImage image=null;
		
		try {
			image=ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
			image=uTool.scaleImage(image,gp.tileSize,gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision=true;
		
//		try {
//			image=ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
//			uTool.scaleImage(image,gp.tileSize,gp.tileSize);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	}


}


//
//public class OBJ_Coin extends Entity{
//
//	public OBJ_Coin(GamePanel gp) {
//		super(gp);
//		name="Coin";
////		down1=setup("/object/coin");
////		collision=true;
////		
//		
//		UtilityTool uTool=new UtilityTool();
//		BufferedImage image=null;
//		
//		try {
//			image=ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
//			image=uTool.scaleImage(image,gp.tileSize,gp.tileSize);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		collision=true;
//		
////		try {
////			image=ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
////			uTool.scaleImage(image,gp.tileSize,gp.tileSize);
////		}catch(IOException e) {
////			e.printStackTrace();
////		}
//	}
//}
