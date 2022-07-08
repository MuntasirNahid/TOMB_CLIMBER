package main;

import monster.MON_MUMMY;
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
	
	public void setMonster() {
		gp.monster[0]=new MON_MUMMY(gp);
		gp.monster[0].x=gp.tileSize*23;
		gp.monster[0].y=gp.tileSize*37;
		
		gp.monster[1]=new MON_MUMMY(gp);
		gp.monster[1].x=gp.tileSize*23;
		gp.monster[1].y=gp.tileSize*37;
		
	}

}

