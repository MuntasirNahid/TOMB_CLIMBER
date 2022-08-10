package main;

import entity.Entity;
import object.SuperObject;

public class CollisionChecker {
	GamePanel gp;
	
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity, boolean checkForFall) {
		
		int entityLeftX =  entity.x;
		int entityRightX = entity.x + gp.tileSize;
		int entityTopY = entity.y;
		int entityBottomY = entity.y + gp.tileSize;
	
		
		int entityLeftCol = entityLeftX/gp.tileSize; // == entityCurCol
		int entityRightCol = entityRightX/gp.tileSize;
		int entityTopRow = entityTopY/gp.tileSize; // == entityCurRow
		int entityBottomRow = entityBottomY/gp.tileSize;
		
		
		
		int tileNum1, tileNum2;
		
		// Fall Mechanics
		
		if(checkForFall) {			
			if(entity.isFalling)	{
			
				entityBottomRow = (entityBottomRow*gp.tileSize + entity.speed) / gp.tileSize; 
				
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
//				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
	//			System.out.println(tileNum1+" "+tileNum2);
	//			System.out.println("TileNum2 == "+tileNum2);
				if(entity.isLeapingRight && tileNum1 == 2) {
					entity.isFalling = false;
					entity.isLeapingRight = false;
				}
					
				if(entity.isLeapingLeft && tileNum1 == 2) {
					entity.isFalling = false;
					entity.isLeapingLeft = false;
				}
				
			}
			else if(entity.isLeapingLeft) {
				if(entity.x%gp.tileSize == 0) {
//					entity.isLeapingLeft = false;
					entity.isFalling = true;
				}
			}
			else if(entity.isLeapingRight) {
				if(entity.x%gp.tileSize == 0) {
//					entity.isLeapingRight = false;
					entity.isFalling = true;
				}
			}
			return;
		}
		
		switch(entity.direction) {
			
		case "up":
			if(entityTopY - entity.speed < 0)
				entity.collisionOn = true;
			else {
				entityTopRow = ( entityTopY - entity.speed) / gp.tileSize;
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityTopRow];
				
				entity.collisionOn = true;
				if( (tileNum1 == 3 && entityLeftX - entityLeftCol*gp.tileSize <= 36) || (tileNum2 == 3 && (entityRightCol+1)*gp.tileSize - entityRightX <= 36) )
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
				if( (tileNum1 == 3 && entityLeftX - entityLeftCol*gp.tileSize <= 36) || (tileNum2 == 3 && (entityRightCol+1)*gp.tileSize - entityRightX <= 36) )
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
//				if(entity.up1 != null) { // player
//					System.out.println("for left "+tileNum1+" "+tileNum2);
//				}
				entity.collisionOn = true;
				if( tileNum1 == 1 || tileNum1 == 3 )	{
					if( entityBottomY - (entityTopRow+1)*gp.tileSize <= gp.tileSize) {
						entity.collisionOn = false;
						entity.y = (entityTopRow)*gp.tileSize;
					}
				}
				else if(tileNum2 == 1 || tileNum2 == 3)	{
					if( (entityBottomRow+1)*gp.tileSize - entityBottomY <= gp.tileSize) {
						entity.collisionOn = false;
						entity.y = entityBottomRow*gp.tileSize;
					}
				}
				else if(tileNum1 == 0 && tileNum2 == 0){ // Fall Mechanics, LEFT
					
					if(entity.up1 == null) { // monster
						entity.collisionOn = true;
					}
					else { // Player
						/// From Ladder
						
						if(gp.tileH.mapTileNum[entityRightCol][entityTopRow] == 3) {
							entity.x -= entity.speed;
							entity.isLeapingLeft = true;
						}
						
						/// From Brick
						
						if(gp.tileH.mapTileNum[entityRightCol][entityTopRow] == 1) {
							entity.x -= entity.speed;
							entity.isLeapingLeft = true;
						}
						entity.collisionOn = false;
//						entity.isFalling = true;
						System.out.println("Start falling");
					}
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
//				if(entity.up1 != null) { // player
//					System.out.println("for right "+tileNum1+" "+tileNum2);
//				}
				

				entity.collisionOn = true;
				if( tileNum1 == 1 || tileNum1 == 3 )	{
					if( entityBottomY - (entityTopRow+1)*gp.tileSize <= gp.tileSize) {
						entity.collisionOn = false;
						entity.y = (entityTopRow)*gp.tileSize;
					}
				}
				else if(tileNum2 == 1 || tileNum2 == 3)	{
					if( (entityBottomRow+1)*gp.tileSize - entityBottomY <= gp.tileSize) {
						entity.collisionOn = false;
						entity.y = entityBottomRow*gp.tileSize;
					}
				}
				else if(tileNum1 == 0 && tileNum2 == 0)	{ // Fall Mechanics, RIGHT
					
					if(entity.up1 == null) { // monster
						entity.collisionOn = true;
					}
					else { // Player
						
						/// From Ladder
						
						if(gp.tileH.mapTileNum[entityLeftCol][entityTopRow] == 3) {
							entity.x += entity.speed;
							entity.isLeapingRight = true;
						}
						
						/// From Brick
						
						if(gp.tileH.mapTileNum[entityLeftCol][entityTopRow] == 1) {
							entity.x += entity.speed;
							entity.isLeapingRight = true;
						}
						entity.collisionOn = false;
						System.out.println("Start falling");
					}
				}
					
			}
			break;
			
		}
		
		
	}
	
	
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
	

}
