package main;

import entity.Entity;
import object.SuperObject;

public class CollisionChecker {
	GamePanel gp;
	
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity, boolean checkForFall) {
		
		
//		int entityLeftX =  entity.x + entity.solidArea.x;
//		int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
//		int entityTopY = entity.y + entity.solidArea.y;
//		int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;
//	
		int entityLeftX =  entity.x;
		int entityRightX = entity.x + gp.tileSize;
		int entityTopY = entity.y;
		int entityBottomY = entity.y + gp.tileSize;
	
		
		int entityLeftCol = entityLeftX/gp.tileSize; // == entityCurCol
		int entityRightCol = entityRightX/gp.tileSize;
		int entityTopRow = entityTopY/gp.tileSize; // == entityCurRow
		int entityBottomRow = entityBottomY/gp.tileSize;
		
		
		
		int tileNum1, tileNum2;
		
//		if(checkForFall) {
//
//			if(entity.isFalling)	{
//				
//				entityBottomRow = (entityBottomRow*gp.tileSize + entity.speed) / gp.tileSize; 
//				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
//				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
////				System.out.println(tileNum1+" "+tileNum2);
////				if(tileNum1 == 2 || tileNum1 == 3 || tileNum2 == 2 || tileNum2 == 3)
////					entity.isFalling = false;
//				System.out.println("TileNum2 == "+tileNum2);
//				if(tileNum2 == 2 || tileNum2 == 3)
//					entity.isFalling = false;
//				
//			}
//			return;
//		}
		

		
		switch(entity.direction) {
			
		case "up":
			
			if(entityTopY - entity.speed < 0)
				entity.collisionOn = true;
			else {
				entityTopRow = ( entityTopY - entity.speed) / gp.tileSize;
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityTopRow];
				
				entity.collisionOn = true;
				if( (tileNum1 == 3 && entityLeftX - entityLeftCol*gp.tileSize <= 24) || (tileNum2 == 3 && (entityRightCol+1)*gp.tileSize - entityRightX <= 24) )
				{
						entity.collisionOn = false;
						if(tileNum1 == 3)
							entity.x = entityLeftCol*gp.tileSize;
						else if(tileNum2 == 3)
							entity.x = entityRightCol*gp.tileSize;
				}
//				if(gp.tileH.tile[tileNum1].collision == true || gp.tileH.tile[tileNum2].collision == true)
//					entity.collisionOn = true;	
			}
			break;
		case "down":
			if(entityBottomY + entity.speed >= gp.screenHeight)
				entity.collisionOn = true;
			else {
				entityBottomRow = ( entityBottomY + entity.speed ) / gp.tileSize;
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
				entity.collisionOn = true;
				if( (tileNum1 == 3 && entityLeftX - entityLeftCol*gp.tileSize <= 24) || (tileNum2 == 3 && (entityRightCol+1)*gp.tileSize - entityRightX <= 24) )
				{
						entity.collisionOn = false;
						if(tileNum1 == 3)
							entity.x = entityLeftCol*gp.tileSize;
						else if(tileNum2 == 3)
							entity.x = entityRightCol*gp.tileSize;
				}
//				if(gp.tileH.tile[tileNum1].collision == true || gp.tileH.tile[tileNum2].collision == true)
//					entity.collisionOn = true;
			}
			break;
		case "left":
			if(entityLeftX - entity.speed < 0)
				entity.collisionOn = true;
			else {
				entityLeftCol = ( entityLeftX - entity.speed ) / gp.tileSize; 
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
//				System.out.println(tileNum1+" "+tileNum2);
				if(entity.up1 != null) { // player
					System.out.println("for left "+tileNum1+" "+tileNum2);
				}
				entity.collisionOn = true;
				if( tileNum1 == 1 || tileNum1 == 3 )	{
					if( entityBottomY - (entityTopRow+1)*gp.tileSize <= 20) {
						entity.collisionOn = false;
						entity.y = (entityTopRow)*gp.tileSize;
					}
				}
				else if(tileNum2 == 1 || tileNum2 == 3)	{
					if( (entityBottomRow+1)*gp.tileSize - entityBottomY <= 20) {
						entity.collisionOn = false;
						entity.y = entityBottomRow*gp.tileSize;
					}
				}
				else // Fall Mechanics
				{
					entity.collisionOn = true;
//					entity.isFalling = true;
				}
			}
			break;
		case "right":
			
			if(entity.x + gp.tileSize + entity.speed >= 1366) // my screen width(1366)
				entity.collisionOn = true;
			else {
				entityRightCol = ( entityRightX + entity.speed) / gp.tileSize; 
				tileNum1 = gp.tileH.mapTileNum[entityRightCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
				if(entity.up1 != null) { // player
					System.out.println("for right "+tileNum1+" "+tileNum2);
				}
				

				entity.collisionOn = true;
				if( tileNum1 == 1 || tileNum1 == 3 )	{
					if( entityBottomY - (entityTopRow+1)*gp.tileSize <= 20) {
						entity.collisionOn = false;
						entity.y = (entityTopRow)*gp.tileSize;
					}
				}
				else if(tileNum2 == 1 || tileNum2 == 3)	{
					if( (entityBottomRow+1)*gp.tileSize - entityBottomY <= 20) {
						entity.collisionOn = false;
						entity.y = entityBottomRow*gp.tileSize;
					}
				}
				else // Fall Mechanics
				{
					entity.collisionOn = true;
//					entity.isFalling = true;
//					System.out.println("Start falling");
					
//					tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
//					tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
//					
//					while(tileNum1 != 2 && tileNum1 != 3 && tileNum2 != 2 && tileNum2 != 3)
//					{
//						entity.y += entity.speed;
//						entityBottomRow = (entity.y + gp.tileSize) / gp.tileSize;
//						tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
//						tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
//						
//					}
//					System.out.println("entityBottomRow == " + entityBottomRow);
				}
					
			}
			break;
			
		}
		
		
	}
	
	/// EXTRA
	
    /// OBJECT COLLISION CHECK:

	public int checkCoin(Entity entity, SuperObject[] obj)	{
		int index = -1;
	    for (int i = 0; i < obj.length && index == -1; i++)
	    {
	        if (obj[i] != null)
	        {
	            
	            if ( ((entity.x >= obj[i].x && entity.x <= obj[i].x + gp.tileSize) && (entity.y >= obj[i].y && entity.y <= obj[i].y + gp.tileSize)) || 
	            		((entity.x + gp.tileSize >= obj[i].x && entity.x + gp.tileSize <= obj[i].x + gp.tileSize) && 
	            		(entity.y + gp.tileSize >= obj[i].y && entity.y + gp.tileSize <= obj[i].y + gp.tileSize)) )
	            {
	                    index = i;
	            }
	        }
	    }
	    return index;	
    }

	public int checkEntity(Entity entity, Entity[] monster) {
		int index = -1;
	    for (int i = 0; i < monster.length && index == -1; i++)
	    {
	        if (monster[i] != null)
	        {
	            
	            if ( ((entity.x >= monster[i].x && entity.x <= monster[i].x + gp.tileSize) && (entity.y >= monster[i].y && entity.y <= monster[i].y + gp.tileSize))
	            		|| ((entity.x + gp.tileSize >= monster[i].x && entity.x + gp.tileSize <= monster[i].x + gp.tileSize) && 
	            		(entity.y + gp.tileSize >= monster[i].y && entity.y + gp.tileSize <= monster[i].y + gp.tileSize)) )
	            {
	                    index = i;
	            }
	        }
	    }
	    return index;	
	}
	
//	public boolean checkPlayer(Entity entity) {
//		
//		boolean contactPlayer=false;
//		
//		
//		//get entity's solid area position:
//		entity.solidArea.x=entity.x+entity.solidArea.x;
//		entity.solidArea.y=entity.y+entity.solidArea.y;
//		
//		//Get the object SOlid area position:
//		
//		gp.player.solidArea.x=gp.player.x+gp.player.solidArea.x;
//		gp.player.solidArea.y=gp.player.y+gp.player.solidArea.y;
//		
//		switch(entity.direction) {
//		case "up":
//			entity.solidArea.y-=entity.speed;break;
//		case "down":
//			entity.solidArea.y+=entity.speed;break;
//		case "left":
//			entity.solidArea.x-=entity.speed;break;
//		case "right":
//			entity.solidArea.x+=entity.speed;break;
//				
//		}
//		if(entity.solidArea.intersects(gp.player.solidArea)){
//			entity.collisionOn=true;
//			contactPlayer=true;
//		}
//		entity.solidArea.x=entity.solidAreaDefaultX;
//		entity.solidArea.y=entity.solidAreaDefaultY;
//		
//		gp.player.solidArea.x=gp.player.solidAreaDefaultX;
//		gp.player.solidArea.y=gp.player.solidAreaDefaultY;
//		
//		return contactPlayer;
//	}
}
