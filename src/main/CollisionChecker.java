package main;

import entity.Entity;

public class CollisionChecker {
	GamePanel gp;
	
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftX =  entity.x + entity.solidArea.x;
		int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
		int entityTopY = entity.y + entity.solidArea.y;
		int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftX/gp.tileSize;
		int entityRightCol = entityRightX/gp.tileSize;
		int entityTopRow = entityTopY/gp.tileSize;
		int entityBottomRow = entityBottomY/gp.tileSize;
		
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = ( entityTopY - entity.speed) / gp.tileSize;
//			System.out.println(entityTopRow);
			if(entityTopY - entity.speed < 0)
				entity.collisionOn = true;
			else {
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityTopRow];
				if(gp.tileH.tile[tileNum1].collision == true || gp.tileH.tile[tileNum2].collision == true)
					entity.collisionOn = true;	
			}
			break;
		case "down":
			entityBottomRow = ( entityBottomY + entity.speed ) / gp.tileSize;
			if(entityBottomY + entity.speed >= gp.screenHeight)
				entity.collisionOn = true;
			else {
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
				if(gp.tileH.tile[tileNum1].collision == true || gp.tileH.tile[tileNum2].collision == true)
					entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = ( entityLeftX - entity.speed) / gp.tileSize; 
			if(entityLeftX - entity.speed < 0)
				entity.collisionOn = true;
			else {
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
				if(gp.tileH.tile[tileNum1].collision == true || gp.tileH.tile[tileNum2].collision == true)
					entity.collisionOn = true;
			}
			break;
		case "right":
//			System.out.println("In");
			entityRightCol = ( entityRightX + entity.speed) / gp.tileSize; 
//			System.out.println(entityRightCol);
			if(entityRightX + entity.speed >= 1340) // my screen width(1366) - 26
				entity.collisionOn = true;
			else {
				tileNum1 = gp.tileH.mapTileNum[entityRightCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
//				System.out.println(tileNum1+" "+tileNum2);
				if(gp.tileH.tile[tileNum1].collision == true || gp.tileH.tile[tileNum2].collision == true)
					entity.collisionOn = true;
			}
			break;
		
		}
		
		
	}
}