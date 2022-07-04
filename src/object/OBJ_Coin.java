package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Coin extends SuperObject{
	public OBJ_Coin() {
		name="Coin";
		try {
			image=ImageIO.read(getClass().getResourceAsStream("/object/coin.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

	
}
