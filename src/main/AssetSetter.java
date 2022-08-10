package main;
import monster.MON_MUMMY;
import object.OBJ_Coin;

public class AssetSetter {

	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp=gp;
	}
	
	public void setObject(int ind) {

		// Map 1
		
		if(ind == 0) {
			
			gp.coinCount = 24;
			
			gp.obj[ind][0] = new OBJ_Coin(gp);
			gp.obj[ind][0].x = 17 * gp.tileSize;
			gp.obj[ind][0].y = 4 * gp.tileSize;

			
			gp.obj[ind][1] = new OBJ_Coin(gp);
			gp.obj[ind][1].x = 8 * gp.tileSize;
			gp.obj[ind][1].y = 4 * gp.tileSize;
			
			gp.obj[ind][2] = new OBJ_Coin(gp);
			gp.obj[ind][2].x = 2 * gp.tileSize;
			gp.obj[ind][2].y = 0 * gp.tileSize;
			
			gp.obj[ind][3] = new OBJ_Coin(gp);
			gp.obj[ind][3].x = 4 * gp.tileSize;
			gp.obj[ind][3].y = 0 * gp.tileSize;
			
			gp.obj[ind][4] = new OBJ_Coin(gp);
			gp.obj[ind][4].x = 6 * gp.tileSize;
			gp.obj[ind][4].y = 0 * gp.tileSize;
			
			gp.obj[ind][5] = new OBJ_Coin(gp);
			gp.obj[ind][5].x = 10 * gp.tileSize;
			gp.obj[ind][5].y = 4 * gp.tileSize;

			gp.obj[ind][6] = new OBJ_Coin(gp);
			gp.obj[ind][6].x = 12 * gp.tileSize;
			gp.obj[ind][6].y = 4 * gp.tileSize;
			
			gp.obj[ind][7] = new OBJ_Coin(gp);
			gp.obj[ind][7].x = 1 * gp.tileSize;
			gp.obj[ind][7].y = 5 * gp.tileSize;
			
			gp.obj[ind][8] = new OBJ_Coin(gp);
			gp.obj[ind][8].x = 3 * gp.tileSize;
			gp.obj[ind][8].y = 5 * gp.tileSize;
			
			gp.obj[ind][9] = new OBJ_Coin(gp);
			gp.obj[ind][9].x = 4 * gp.tileSize;
			gp.obj[ind][9].y = 5 * gp.tileSize;
			
			gp.obj[ind][10] = new OBJ_Coin(gp);
			gp.obj[ind][10].x = 5 * gp.tileSize;
			gp.obj[ind][10].y = 5 * gp.tileSize;
			
			gp.obj[ind][11] = new OBJ_Coin(gp);
			gp.obj[ind][11].x = 7 * gp.tileSize;
			gp.obj[ind][11].y = 7 * gp.tileSize;
			
			gp.obj[ind][12] = new OBJ_Coin(gp);
			gp.obj[ind][12].x = 9 * gp.tileSize;
			gp.obj[ind][12].y = 7 * gp.tileSize;
			
			gp.obj[ind][13] = new OBJ_Coin(gp);
			gp.obj[ind][13].x = 10 * gp.tileSize;
			gp.obj[ind][13].y = 7 * gp.tileSize;
			
			gp.obj[ind][14] = new OBJ_Coin(gp);
			gp.obj[ind][14].x = 15 * gp.tileSize;
			gp.obj[ind][14].y = 6 * gp.tileSize;
			
			gp.obj[ind][15] = new OBJ_Coin(gp);
			gp.obj[ind][15].x = 19 * gp.tileSize;
			gp.obj[ind][15].y = 4 * gp.tileSize;
					
			gp.obj[ind][16] = new OBJ_Coin(gp);
			gp.obj[ind][16].x = 19 * gp.tileSize;
			gp.obj[ind][16].y = 4 * gp.tileSize;
			
			gp.obj[ind][17] = new OBJ_Coin(gp);
			gp.obj[ind][17].x = 10 * gp.tileSize;
			gp.obj[ind][17].y = 0 * gp.tileSize;
			
			gp.obj[ind][18] = new OBJ_Coin(gp);
			gp.obj[ind][18].x = 12 * gp.tileSize;
			gp.obj[ind][18].y = 0 * gp.tileSize;

			gp.obj[ind][19] = new OBJ_Coin(gp);
			gp.obj[ind][19].x = 14 * gp.tileSize;
			gp.obj[ind][19].y = 0 * gp.tileSize;
			
			gp.obj[ind][20] = new OBJ_Coin(gp);
			gp.obj[ind][20].x = 18 * gp.tileSize;
			gp.obj[ind][20].y = 0 * gp.tileSize;
			
			gp.obj[ind][21] = new OBJ_Coin(gp);
			gp.obj[ind][21].x = 12 * gp.tileSize;
			gp.obj[ind][21].y = 10 * gp.tileSize;
			
			gp.obj[ind][22] = new OBJ_Coin(gp);
			gp.obj[ind][22].x = 15 * gp.tileSize;
			gp.obj[ind][22].y = 10 * gp.tileSize;
			
			gp.obj[ind][23] = new OBJ_Coin(gp);
			gp.obj[ind][23].x = 4 * gp.tileSize;
			gp.obj[ind][23].y = 10 * gp.tileSize;

		}
		else if(ind == 1) {
			
			gp.coinCount = 17;
			
			gp.obj[ind][0] = new OBJ_Coin(gp);
			gp.obj[ind][0].x = 17 * gp.tileSize;
			gp.obj[ind][0].y = 5 * gp.tileSize;

			
			gp.obj[ind][1] = new OBJ_Coin(gp);
			gp.obj[ind][1].x = 8 * gp.tileSize;
			gp.obj[ind][1].y = 3 * gp.tileSize;
			
			gp.obj[ind][2] = new OBJ_Coin(gp);
			gp.obj[ind][2].x = 2 * gp.tileSize;
			gp.obj[ind][2].y = 1 * gp.tileSize;
			
			gp.obj[ind][3] = new OBJ_Coin(gp);
			gp.obj[ind][3].x = 4 * gp.tileSize;
			gp.obj[ind][3].y = 1 * gp.tileSize;
			
			gp.obj[ind][4] = new OBJ_Coin(gp);
			gp.obj[ind][4].x = 6 * gp.tileSize;
			gp.obj[ind][4].y = 1 * gp.tileSize;
			
			gp.obj[ind][5] = new OBJ_Coin(gp);
			gp.obj[ind][5].x = 10 * gp.tileSize;
			gp.obj[ind][5].y = 3 * gp.tileSize;

			gp.obj[ind][6] = new OBJ_Coin(gp);
			gp.obj[ind][6].x = 11 * gp.tileSize;
			gp.obj[ind][6].y = 3 * gp.tileSize;
			
			gp.obj[ind][7] = new OBJ_Coin(gp);
			gp.obj[ind][7].x = 1 * gp.tileSize;
			gp.obj[ind][7].y = 5 * gp.tileSize;
			
			gp.obj[ind][8] = new OBJ_Coin(gp);
			gp.obj[ind][8].x = 2 * gp.tileSize;
			gp.obj[ind][8].y = 5 * gp.tileSize;
			
			gp.obj[ind][9] = new OBJ_Coin(gp);
			gp.obj[ind][9].x = 4 * gp.tileSize;
			gp.obj[ind][9].y = 7 * gp.tileSize;
			
			gp.obj[ind][10] = new OBJ_Coin(gp);
			gp.obj[ind][10].x = 5 * gp.tileSize;
			gp.obj[ind][10].y = 7 * gp.tileSize;
			
			gp.obj[ind][11] = new OBJ_Coin(gp);
			gp.obj[ind][11].x = 6 * gp.tileSize;
			gp.obj[ind][11].y = 7 * gp.tileSize;
			
			gp.obj[ind][12] = new OBJ_Coin(gp);
			gp.obj[ind][12].x = 9 * gp.tileSize;
			gp.obj[ind][12].y = 6 * gp.tileSize;
			
			gp.obj[ind][13] = new OBJ_Coin(gp);
			gp.obj[ind][13].x = 10 * gp.tileSize;
			gp.obj[ind][13].y = 6 * gp.tileSize;
			
			gp.obj[ind][14] = new OBJ_Coin(gp);
			gp.obj[ind][14].x = 15 * gp.tileSize;
			gp.obj[ind][14].y = 6 * gp.tileSize;
			
			gp.obj[ind][15] = new OBJ_Coin(gp);
			gp.obj[ind][15].x = 18 * gp.tileSize;
			gp.obj[ind][15].y = 4 * gp.tileSize;
			
			gp.obj[ind][16] = new OBJ_Coin(gp);
			gp.obj[ind][16].x = 17 * gp.tileSize;
			gp.obj[ind][16].y = 0 * gp.tileSize;
			
			gp.obj[ind][17] = new OBJ_Coin(gp);
			gp.obj[ind][17].x = 11 * gp.tileSize;
			gp.obj[ind][17].y = 10 * gp.tileSize;
		}
		
				
		// Map 2
		
		
		// Map 3
		
		
		// Map 4
	
	}
	
	public void setMonster(int ind) {
		
		// Map 1
		
		if(ind == 0) {
			gp.monster[ind][0] = new MON_MUMMY(gp);
			gp.monster[ind][0].x = gp.tileSize*10;
			gp.monster[ind][0].y = gp.tileSize*10;
			
			gp.monster[ind][1] = new MON_MUMMY(gp);
			gp.monster[ind][1].x = gp.tileSize*13;
			gp.monster[ind][1].y = gp.tileSize*0;
			
			gp.monster[ind][2] = new MON_MUMMY(gp);
			gp.monster[ind][2].x = gp.tileSize*10;
			gp.monster[ind][2].y = gp.tileSize*4;
			
			gp.monster[ind][3] = new MON_MUMMY(gp);
			gp.monster[ind][3].x = gp.tileSize*2;
			gp.monster[ind][3].y = gp.tileSize*0;
		}
		
		
		// Map 2
		
		else if(ind == 1) {
//			System.out.println(ind);
			gp.monster[ind][0] = new MON_MUMMY(gp);
			gp.monster[ind][0].x = gp.tileSize*6;
			gp.monster[ind][0].y = gp.tileSize*7;
			
			gp.monster[ind][1] = new MON_MUMMY(gp);
			gp.monster[ind][1].x = gp.tileSize*19;
			gp.monster[ind][1].y = gp.tileSize*10;
			
			gp.monster[ind][2] = new MON_MUMMY(gp);
			gp.monster[ind][2].x = gp.tileSize*13;
			gp.monster[ind][2].y = gp.tileSize*6;
			
			gp.monster[ind][3] = new MON_MUMMY(gp);
			gp.monster[ind][3].x = gp.tileSize*16;
			gp.monster[ind][3].y = gp.tileSize*0;
		
			gp.monster[ind][4] = new MON_MUMMY(gp);
			gp.monster[ind][4].x = gp.tileSize*10;
			gp.monster[ind][4].y = gp.tileSize*3;
			
			gp.monster[ind][5] = new MON_MUMMY(gp);
			gp.monster[ind][5].x = gp.tileSize*3;
			gp.monster[ind][5].y = gp.tileSize*1;
		}
		

		
		// Map 3
		
		// Map 4
	}

}

