package main;

import object.OBJ_Coin;

public class AssetSetter {

	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp=gp;
	}
	
	public void setObject() {
	
		gp.obj[0]=new OBJ_Coin();
		gp.obj[0].x= 7 * gp.tileSize;
		gp.obj[0].y= 8 * gp.tileSize;
		
		gp.obj[1]=new OBJ_Coin();
		gp.obj[1].x=3 * gp.tileSize;
		gp.obj[1].y=4 * gp.tileSize;
	}
	
	

}

