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
		
		//MAP 2
		else if(ind == 1) {
			
			gp.coinCount = 28;
			
			gp.obj[ind][0] = new OBJ_Coin(gp);
			gp.obj[ind][0].x = 16 * gp.tileSize;
			gp.obj[ind][0].y = 4* gp.tileSize;

			
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
			gp.obj[ind][14].y = 7 * gp.tileSize;
			
			gp.obj[ind][15] = new OBJ_Coin(gp);
			gp.obj[ind][15].x = 18 * gp.tileSize;
			gp.obj[ind][15].y = 4 * gp.tileSize;
			
			gp.obj[ind][16] = new OBJ_Coin(gp);
			gp.obj[ind][16].x = 17 * gp.tileSize;
			gp.obj[ind][16].y = 0 * gp.tileSize;
			
			gp.obj[ind][17] = new OBJ_Coin(gp);
			gp.obj[ind][17].x = 11 * gp.tileSize;
			gp.obj[ind][17].y = 10 * gp.tileSize;
			
			gp.obj[ind][18] = new OBJ_Coin(gp);
			gp.obj[ind][18].x = 18 * gp.tileSize;
			gp.obj[ind][18].y = 0 * gp.tileSize;
			
			gp.obj[ind][19] = new OBJ_Coin(gp);
			gp.obj[ind][19].x = 15 * gp.tileSize;
			gp.obj[ind][19].y = 10 * gp.tileSize;
			
			gp.obj[ind][20] = new OBJ_Coin(gp);
			gp.obj[ind][20].x = 13 * gp.tileSize;
			gp.obj[ind][20].y = 0 * gp.tileSize;
			
			gp.obj[ind][21] = new OBJ_Coin(gp);
			gp.obj[ind][21].x = 11 * gp.tileSize;
			gp.obj[ind][21].y = 0 * gp.tileSize;
			
			gp.obj[ind][22] = new OBJ_Coin(gp);
			gp.obj[ind][22].x = 15 * gp.tileSize;
			gp.obj[ind][22].y = 0 * gp.tileSize;
			
			gp.obj[ind][23] = new OBJ_Coin(gp);
			gp.obj[ind][23].x = 3 * gp.tileSize;
			gp.obj[ind][23].y = 1 * gp.tileSize;
			
			gp.obj[ind][24] = new OBJ_Coin(gp);
			gp.obj[ind][24].x = 11 * gp.tileSize;
			gp.obj[ind][24].y = 6 * gp.tileSize;
			
			gp.obj[ind][25] = new OBJ_Coin(gp);
			gp.obj[ind][25].x = 12 * gp.tileSize;
			gp.obj[ind][25].y = 6 * gp.tileSize;
			
			gp.obj[ind][26] = new OBJ_Coin(gp);
			gp.obj[ind][26].x = 21 * gp.tileSize;
			gp.obj[ind][26].y = 2 * gp.tileSize;
			
			gp.obj[ind][27] = new OBJ_Coin(gp);
			gp.obj[ind][27].x = 3 * gp.tileSize;
			gp.obj[ind][27].y = 10 * gp.tileSize;
		}
		
		// Map 3
		else if(ind == 2) {
			
			gp.coinCount = 45;
			
			gp.obj[ind][0] = new OBJ_Coin(gp);
			gp.obj[ind][0].x = 16 * gp.tileSize;
			gp.obj[ind][0].y = 4* gp.tileSize;

			
			gp.obj[ind][1] = new OBJ_Coin(gp);
			gp.obj[ind][1].x = 7 * gp.tileSize;
			gp.obj[ind][1].y = 4 * gp.tileSize;
			
			gp.obj[ind][2] = new OBJ_Coin(gp);
			gp.obj[ind][2].x = 2 * gp.tileSize;
			gp.obj[ind][2].y = 0 * gp.tileSize;
			
			gp.obj[ind][3] = new OBJ_Coin(gp);
			gp.obj[ind][3].x = 4 * gp.tileSize;
			gp.obj[ind][3].y = 0 * gp.tileSize;
			
			gp.obj[ind][4] = new OBJ_Coin(gp);
			gp.obj[ind][4].x = 5 * gp.tileSize;
			gp.obj[ind][4].y = 0 * gp.tileSize;
			
			gp.obj[ind][5] = new OBJ_Coin(gp);
			gp.obj[ind][5].x = 10 * gp.tileSize;
			gp.obj[ind][5].y = 4 * gp.tileSize;

			gp.obj[ind][6] = new OBJ_Coin(gp);
			gp.obj[ind][6].x = 11 * gp.tileSize;
			gp.obj[ind][6].y = 4 * gp.tileSize;
			
			gp.obj[ind][7] = new OBJ_Coin(gp);
			gp.obj[ind][7].x = 1 * gp.tileSize;
			gp.obj[ind][7].y = 4 * gp.tileSize;
			
			gp.obj[ind][8] = new OBJ_Coin(gp);
			gp.obj[ind][8].x = 0 * gp.tileSize;
			gp.obj[ind][8].y = 4 * gp.tileSize;
			
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
			gp.obj[ind][12].x = 8 * gp.tileSize;
			gp.obj[ind][12].y = 6 * gp.tileSize;
			
			gp.obj[ind][13] = new OBJ_Coin(gp);
			gp.obj[ind][13].x = 9 * gp.tileSize;
			gp.obj[ind][13].y = 6 * gp.tileSize;
			
			gp.obj[ind][14] = new OBJ_Coin(gp);
			gp.obj[ind][14].x = 16 * gp.tileSize;
			gp.obj[ind][14].y = 7 * gp.tileSize;
			
			gp.obj[ind][15] = new OBJ_Coin(gp);
			gp.obj[ind][15].x = 18 * gp.tileSize;
			gp.obj[ind][15].y = 4 * gp.tileSize;
			
			gp.obj[ind][16] = new OBJ_Coin(gp);
			gp.obj[ind][16].x = 14 * gp.tileSize;
			gp.obj[ind][16].y = 0 * gp.tileSize;
			
			gp.obj[ind][17] = new OBJ_Coin(gp);
			gp.obj[ind][17].x = 12 * gp.tileSize;
			gp.obj[ind][17].y = 10 * gp.tileSize;
			
			gp.obj[ind][18] = new OBJ_Coin(gp);
			gp.obj[ind][18].x = 16 * gp.tileSize;
			gp.obj[ind][18].y = 0 * gp.tileSize;
			
			gp.obj[ind][19] = new OBJ_Coin(gp);
			gp.obj[ind][19].x = 15 * gp.tileSize;
			gp.obj[ind][19].y = 10 * gp.tileSize;
			
			gp.obj[ind][20] = new OBJ_Coin(gp);
			gp.obj[ind][20].x = 13 * gp.tileSize;
			gp.obj[ind][20].y = 0 * gp.tileSize;
			
			gp.obj[ind][21] = new OBJ_Coin(gp);
			gp.obj[ind][21].x = 11 * gp.tileSize;
			gp.obj[ind][21].y = 0 * gp.tileSize;
			
			gp.obj[ind][22] = new OBJ_Coin(gp);
			gp.obj[ind][22].x = 15 * gp.tileSize;
			gp.obj[ind][22].y = 0 * gp.tileSize;
			
			gp.obj[ind][23] = new OBJ_Coin(gp);
			gp.obj[ind][23].x = 3 * gp.tileSize;
			gp.obj[ind][23].y = 0 * gp.tileSize;
			
			gp.obj[ind][24] = new OBJ_Coin(gp);
			gp.obj[ind][24].x = 14 * gp.tileSize;
			gp.obj[ind][24].y = 6 * gp.tileSize;
			
			gp.obj[ind][25] = new OBJ_Coin(gp);
			gp.obj[ind][25].x = 13 * gp.tileSize;
			gp.obj[ind][25].y = 6 * gp.tileSize;
			
			gp.obj[ind][26] = new OBJ_Coin(gp);
			gp.obj[ind][26].x = 21 * gp.tileSize;
			gp.obj[ind][26].y = 1 * gp.tileSize;
			
			gp.obj[ind][27] = new OBJ_Coin(gp);
			gp.obj[ind][27].x = 2 * gp.tileSize;
			gp.obj[ind][27].y = 10 * gp.tileSize;
			
			gp.obj[ind][28] = new OBJ_Coin(gp);
			gp.obj[ind][28].x = 0 * gp.tileSize;
			gp.obj[ind][28].y = 0* gp.tileSize;
			
			gp.obj[ind][29] = new OBJ_Coin(gp);
			gp.obj[ind][29].x = 20 * gp.tileSize;
			gp.obj[ind][29].y = 1 * gp.tileSize;
			
			gp.obj[ind][30] = new OBJ_Coin(gp);
			gp.obj[ind][30].x = 19 * gp.tileSize;
			gp.obj[ind][30].y = 1 * gp.tileSize;
			
			gp.obj[ind][31] = new OBJ_Coin(gp);
			gp.obj[ind][31].x = 4 * gp.tileSize;
			gp.obj[ind][31].y = 2 * gp.tileSize;
			
			gp.obj[ind][32] = new OBJ_Coin(gp);
			gp.obj[ind][32].x = 5 * gp.tileSize;
			gp.obj[ind][32].y = 2 * gp.tileSize;
			
			gp.obj[ind][33] = new OBJ_Coin(gp);
			gp.obj[ind][33].x = 14 * gp.tileSize;
			gp.obj[ind][33].y = 2 * gp.tileSize;
			
			gp.obj[ind][34] = new OBJ_Coin(gp);
			gp.obj[ind][34].x = 13 * gp.tileSize;
			gp.obj[ind][34].y = 2 * gp.tileSize;
			
			gp.obj[ind][35] = new OBJ_Coin(gp);
			gp.obj[ind][35].x = 19 * gp.tileSize;
			gp.obj[ind][35].y = 4 * gp.tileSize;
			
			gp.obj[ind][36] = new OBJ_Coin(gp);
			gp.obj[ind][36].x = 20 * gp.tileSize;
			gp.obj[ind][36].y = 4 * gp.tileSize;
			
			gp.obj[ind][37] = new OBJ_Coin(gp);
			gp.obj[ind][37].x = 14 * gp.tileSize;
			gp.obj[ind][37].y = 6 * gp.tileSize;
			
			gp.obj[ind][38] = new OBJ_Coin(gp);
			gp.obj[ind][38].x = 15 * gp.tileSize;
			gp.obj[ind][38].y = 6 * gp.tileSize;
			
			gp.obj[ind][39] = new OBJ_Coin(gp);
			gp.obj[ind][39].x = 1 * gp.tileSize;
			gp.obj[ind][39].y = 7 * gp.tileSize;
			
			gp.obj[ind][40] = new OBJ_Coin(gp);
			gp.obj[ind][40].x = 2 * gp.tileSize;
			gp.obj[ind][40].y = 7 * gp.tileSize;
			
			gp.obj[ind][41] = new OBJ_Coin(gp);
			gp.obj[ind][41].x = 17 * gp.tileSize;
			gp.obj[ind][41].y = 7 * gp.tileSize;
			
			gp.obj[ind][42] = new OBJ_Coin(gp);
			gp.obj[ind][42].x = 19 * gp.tileSize;
			gp.obj[ind][42].y = 8 * gp.tileSize;
			
			gp.obj[ind][43] = new OBJ_Coin(gp);
			gp.obj[ind][43].x = 20 * gp.tileSize;
			gp.obj[ind][43].y = 8 * gp.tileSize;
			
			gp.obj[ind][44] = new OBJ_Coin(gp);
			gp.obj[ind][44].x = 19 * gp.tileSize;
			gp.obj[ind][44].y = 10 * gp.tileSize;
		}
		
		
		// Map 4
		
		else if(ind == 3) {
			
			gp.coinCount = 45;
			
			gp.obj[ind][0] = new OBJ_Coin(gp);
			gp.obj[ind][0].x = 16 * gp.tileSize;
			gp.obj[ind][0].y = 4* gp.tileSize;

			
			gp.obj[ind][1] = new OBJ_Coin(gp);
			gp.obj[ind][1].x = 9 * gp.tileSize;
			gp.obj[ind][1].y = 4 * gp.tileSize;
			
			gp.obj[ind][2] = new OBJ_Coin(gp);
			gp.obj[ind][2].x = 2 * gp.tileSize;
			gp.obj[ind][2].y = 1 * gp.tileSize;
			
			gp.obj[ind][3] = new OBJ_Coin(gp);
			gp.obj[ind][3].x = 7 * gp.tileSize;
			gp.obj[ind][3].y = 1 * gp.tileSize;
			
			gp.obj[ind][4] = new OBJ_Coin(gp);
			gp.obj[ind][4].x = 6 * gp.tileSize;
			gp.obj[ind][4].y = 1 * gp.tileSize;
			
			gp.obj[ind][5] = new OBJ_Coin(gp);
			gp.obj[ind][5].x = 10 * gp.tileSize;
			gp.obj[ind][5].y = 4 * gp.tileSize;

			gp.obj[ind][6] = new OBJ_Coin(gp);
			gp.obj[ind][6].x = 11 * gp.tileSize;
			gp.obj[ind][6].y = 4 * gp.tileSize;
			
			gp.obj[ind][7] = new OBJ_Coin(gp);
			gp.obj[ind][7].x = 1 * gp.tileSize;
			gp.obj[ind][7].y = 4 * gp.tileSize;
			
			gp.obj[ind][8] = new OBJ_Coin(gp);
			gp.obj[ind][8].x = 0 * gp.tileSize;
			gp.obj[ind][8].y = 4 * gp.tileSize;
			
			gp.obj[ind][9] = new OBJ_Coin(gp);
			gp.obj[ind][9].x = 9 * gp.tileSize;
			gp.obj[ind][9].y = 10 * gp.tileSize;
			
			gp.obj[ind][10] = new OBJ_Coin(gp);
			gp.obj[ind][10].x = 6 * gp.tileSize;
			gp.obj[ind][10].y = 10 * gp.tileSize;
			
			gp.obj[ind][11] = new OBJ_Coin(gp);
			gp.obj[ind][11].x = 7 * gp.tileSize;
			gp.obj[ind][11].y = 10 * gp.tileSize;
			
			gp.obj[ind][12] = new OBJ_Coin(gp);
			gp.obj[ind][12].x = 8 * gp.tileSize;
			gp.obj[ind][12].y = 10 * gp.tileSize;
			
			gp.obj[ind][13] = new OBJ_Coin(gp);
			gp.obj[ind][13].x = 9 * gp.tileSize;
			gp.obj[ind][13].y = 8 * gp.tileSize;
			
			gp.obj[ind][14] = new OBJ_Coin(gp);
			gp.obj[ind][14].x = 16 * gp.tileSize;
			gp.obj[ind][14].y = 10 * gp.tileSize;
			
			gp.obj[ind][15] = new OBJ_Coin(gp);
			gp.obj[ind][15].x = 18 * gp.tileSize;
			gp.obj[ind][15].y = 6 * gp.tileSize;
			
			gp.obj[ind][16] = new OBJ_Coin(gp);
			gp.obj[ind][16].x = 14 * gp.tileSize;
			gp.obj[ind][16].y = 1 * gp.tileSize;
			
			gp.obj[ind][17] = new OBJ_Coin(gp);
			gp.obj[ind][17].x = 12 * gp.tileSize;
			gp.obj[ind][17].y = 10 * gp.tileSize;
			
			gp.obj[ind][18] = new OBJ_Coin(gp);
			gp.obj[ind][18].x = 17 * gp.tileSize;
			gp.obj[ind][18].y = 0 * gp.tileSize;
			
			gp.obj[ind][19] = new OBJ_Coin(gp);
			gp.obj[ind][19].x = 15 * gp.tileSize;
			gp.obj[ind][19].y = 10 * gp.tileSize;
			
			gp.obj[ind][20] = new OBJ_Coin(gp);
			gp.obj[ind][20].x = 13 * gp.tileSize;
			gp.obj[ind][20].y = 1 * gp.tileSize;
			
			gp.obj[ind][21] = new OBJ_Coin(gp);
			gp.obj[ind][21].x = 12 * gp.tileSize;
			gp.obj[ind][21].y = 1 * gp.tileSize;
			
			gp.obj[ind][22] = new OBJ_Coin(gp);
			gp.obj[ind][22].x = 15 * gp.tileSize;
			gp.obj[ind][22].y = 1 * gp.tileSize;
			
			gp.obj[ind][23] = new OBJ_Coin(gp);
			gp.obj[ind][23].x = 3 * gp.tileSize;
			gp.obj[ind][23].y = 1 * gp.tileSize;
			
			gp.obj[ind][24] = new OBJ_Coin(gp);
			gp.obj[ind][24].x = 14 * gp.tileSize;
			gp.obj[ind][24].y = 8 * gp.tileSize;
			
			gp.obj[ind][25] = new OBJ_Coin(gp);
			gp.obj[ind][25].x = 13 * gp.tileSize;
			gp.obj[ind][25].y = 8 * gp.tileSize;
			
			gp.obj[ind][26] = new OBJ_Coin(gp);
			gp.obj[ind][26].x = 18 * gp.tileSize;
			gp.obj[ind][26].y = 2 * gp.tileSize;
			
			gp.obj[ind][27] = new OBJ_Coin(gp);
			gp.obj[ind][27].x = 2 * gp.tileSize;
			gp.obj[ind][27].y = 10 * gp.tileSize;
			
			gp.obj[ind][28] = new OBJ_Coin(gp);
			gp.obj[ind][28].x = 0 * gp.tileSize;
			gp.obj[ind][28].y = 1* gp.tileSize;
			
			gp.obj[ind][29] = new OBJ_Coin(gp);
			gp.obj[ind][29].x = 20 * gp.tileSize;
			gp.obj[ind][29].y = 2 * gp.tileSize;
			
			gp.obj[ind][30] = new OBJ_Coin(gp);
			gp.obj[ind][30].x = 19 * gp.tileSize;
			gp.obj[ind][30].y = 2 * gp.tileSize;
			
			gp.obj[ind][31] = new OBJ_Coin(gp);
			gp.obj[ind][31].x = 4 * gp.tileSize;
			gp.obj[ind][31].y = 6 * gp.tileSize;
			
			gp.obj[ind][32] = new OBJ_Coin(gp);
			gp.obj[ind][32].x = 5 * gp.tileSize;
			gp.obj[ind][32].y = 6 * gp.tileSize;
			
			gp.obj[ind][33] = new OBJ_Coin(gp);
			gp.obj[ind][33].x = 14 * gp.tileSize;
			gp.obj[ind][33].y = 4 * gp.tileSize;
			
			gp.obj[ind][34] = new OBJ_Coin(gp);
			gp.obj[ind][34].x = 13 * gp.tileSize;
			gp.obj[ind][34].y = 4 * gp.tileSize;
			
			gp.obj[ind][35] = new OBJ_Coin(gp);
			gp.obj[ind][35].x = 19 * gp.tileSize;
			gp.obj[ind][35].y = 6 * gp.tileSize;
			
			gp.obj[ind][36] = new OBJ_Coin(gp);
			gp.obj[ind][36].x = 20 * gp.tileSize;
			gp.obj[ind][36].y = 10 * gp.tileSize;
			
			gp.obj[ind][37] = new OBJ_Coin(gp);
			gp.obj[ind][37].x = 12 * gp.tileSize;
			gp.obj[ind][37].y = 4 * gp.tileSize;
			
			gp.obj[ind][38] = new OBJ_Coin(gp);
			gp.obj[ind][38].x = 12 * gp.tileSize;
			gp.obj[ind][38].y = 8 * gp.tileSize;
			
			gp.obj[ind][39] = new OBJ_Coin(gp);
			gp.obj[ind][39].x = 1 * gp.tileSize;
			gp.obj[ind][39].y = 7 * gp.tileSize;
			
			gp.obj[ind][40] = new OBJ_Coin(gp);
			gp.obj[ind][40].x = 2 * gp.tileSize;
			gp.obj[ind][40].y = 7 * gp.tileSize;
			
			gp.obj[ind][41] = new OBJ_Coin(gp);
			gp.obj[ind][41].x = 17 * gp.tileSize;
			gp.obj[ind][41].y = 10 * gp.tileSize;
			
			gp.obj[ind][42] = new OBJ_Coin(gp);
			gp.obj[ind][42].x = 10 * gp.tileSize;
			gp.obj[ind][42].y = 10 * gp.tileSize;
			
			gp.obj[ind][43] = new OBJ_Coin(gp);
			gp.obj[ind][43].x = 11 * gp.tileSize;
			gp.obj[ind][43].y = 10 * gp.tileSize;
			
			gp.obj[ind][44] = new OBJ_Coin(gp);
			gp.obj[ind][44].x = 19 * gp.tileSize;
			gp.obj[ind][44].y = 10 * gp.tileSize;
		}

	
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
		
		//MAP 3
		
		else if(ind == 2) {
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
			gp.monster[ind][4].x = gp.tileSize*12;
			gp.monster[ind][4].y = gp.tileSize*3;
			
			gp.monster[ind][5] = new MON_MUMMY(gp);
			gp.monster[ind][5].x = gp.tileSize*3;
			gp.monster[ind][5].y = gp.tileSize*3;
			
			gp.monster[ind][6] = new MON_MUMMY(gp);
			gp.monster[ind][6].x = gp.tileSize*18;
			gp.monster[ind][6].y = gp.tileSize*4;
		}
		

		
		// Map 3
		
		//MAP 3
		
				else if(ind == 3) {
//					System.out.println(ind);
					gp.monster[ind][0] = new MON_MUMMY(gp);
					gp.monster[ind][0].x = gp.tileSize*6;
					gp.monster[ind][0].y = gp.tileSize*10;
					
					gp.monster[ind][1] = new MON_MUMMY(gp);
					gp.monster[ind][1].x = gp.tileSize*19;
					gp.monster[ind][1].y = gp.tileSize*10;
					
					gp.monster[ind][2] = new MON_MUMMY(gp);
					gp.monster[ind][2].x = gp.tileSize*13;
					gp.monster[ind][2].y = gp.tileSize*8;
					
					gp.monster[ind][3] = new MON_MUMMY(gp);
					gp.monster[ind][3].x = gp.tileSize*16;
					gp.monster[ind][3].y = gp.tileSize*0;
				
					gp.monster[ind][4] = new MON_MUMMY(gp);
					gp.monster[ind][4].x = gp.tileSize*1;
					gp.monster[ind][4].y = gp.tileSize*3;
					
					gp.monster[ind][5] = new MON_MUMMY(gp);
					gp.monster[ind][5].x = gp.tileSize*19;
					gp.monster[ind][5].y = gp.tileSize*2;
					
					gp.monster[ind][6] = new MON_MUMMY(gp);
					gp.monster[ind][6].x = gp.tileSize*18;
					gp.monster[ind][6].y = gp.tileSize*4;
				}
				
		
		// Map 4
	}

}

