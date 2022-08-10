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
	
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
//			System.out.println("Got coin image");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}

