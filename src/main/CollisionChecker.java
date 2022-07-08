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

    /// OBJECT COLLISION CHECK:

public
    int checkObject(Entity entity, boolean player)
    {
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++)
        {
            if (gp.obj[i] != null)
            {

                // get entity's solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                // get the object's solid area position

                gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;

                switch (entity.direction)
                {

                case "up":
                    entity.solidArea.y -= entity.speed;
                    if (entity.solidArea.intersects(gp.obj[i].solidArea))
                    {
                        if (gp.obj[i].collision == true)
                        {
                            entity.collisionOn = true;
                        }
                        // to check if they are NPC or player
                        if (player == true)
                        {
                            index = i;
                        }
                    }
                    break;
                case "down":
                    entity.solidArea.y += entity.speed;
                    if (entity.solidArea.intersects(gp.obj[i].solidArea))
                    {
                        if (gp.obj[i].collision == true)
                        {
                            entity.collisionOn = true;
                        }
                        // to check if they are NPC or player
                        if (player == true)
                        {
                            index = i;
                        }
                    }
                    break;
                case "left":
                    entity.solidArea.x -= entity.speed;
                    if (entity.solidArea.intersects(gp.obj[i].solidArea))
                    {
                    
                        if (gp.obj[i].collision == true)
                        {
                            entity.collisionOn = true;
                        }
                        // to check if they are NPC or player
                        if (player == true)
                        {
                            index = i;
                        }
                    }
                    break;
                case "right":
                    entity.solidArea.x += entity.speed;
                    if (entity.solidArea.intersects(gp.obj[i].solidArea))
                    {
                        if (gp.obj[i].collision == true)
                        {
                            entity.collisionOn = true;
                        }
                        // to check if they are NPC or player
                        if (player == true)
                        {
                            index = i;
                        }
                    }
                    break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}