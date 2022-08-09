package object;

import java.io.IOException;

import javax.imageio.ImageIO;

//import java.io.IOException;
//
//import javax.imageio.ImageIO;

import main.GamePanel;
//
public class OBJ_Coin extends SuperObject{
	
	
	public OBJ_Coin(GamePanel gp) {
	
		name="Coin";
//		down1=setup("/object/coin");
//		collision=true;
		
		
//		UtilityTool uTool=new UtilityTool();
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
//			System.out.println("Got coin image");
//			image=uTool.scaleImage(image,gp.tileSize,gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision=true;
		
	}

}

