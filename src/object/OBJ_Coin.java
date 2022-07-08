package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;


//This one was done for collision

public class OBJ_Coin extends SuperObject{
	public OBJ_Coin() {
		name="Coin";
		try {
			image=ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}	
		collision=true;
	}

	
}

//when implementing Heart This was done:

//
//public class OBJ_Coin extends SuperObject{
//	GamePanel gp;
//	public OBJ_Coin(GamePanel gp) {
//		this.gp=gp;
//		name="Coin";
//		
//		try {
//			image=ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
//			//uTool.scaleImage(image,gp.tileSize,gp.tileSize);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
