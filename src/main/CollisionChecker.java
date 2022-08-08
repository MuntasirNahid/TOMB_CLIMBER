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
		
		int entityLeftCol = entityLeftX/gp.tileSize; // == entityCurCol
		int entityRightCol = entityRightX/gp.tileSize;
		int entityTopRow = entityTopY/gp.tileSize; // == entityCurRow
		int entityBottomRow = entityBottomY/gp.tileSize;
		
		
		// 1 = left/right allowed; 3 = up/down allowed
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":

			entityTopRow = ( entityTopY - entity.speed) / gp.tileSize;
//			System.out.println("entityLeftCol == "+entityLeftCol);
//			System.out.println("entityRightCol == "+entityRightCol);
//			System.out.println("entityTopRow == "+entityTopRow);
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
//			System.out.println("entityLeftCol == "+entityLeftCol);
//			System.out.println("entityRightCol == "+entityRightCol);
//			System.out.println("entityBottomRow == "+entityBottomRow);
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
			
			int entityCurCol = entityLeftCol;
			entityLeftCol = ( entityLeftX - entity.speed ) / gp.tileSize; 
//			System.out.println("left col == "+entityLeftCol);
//			System.out.println("top row == "+entityTopRow);
//			System.out.println("bottom row == "+entityBottomRow);
			if(entityLeftX - entity.speed < 0)
				entity.collisionOn = true;
			else {
				tileNum1 = gp.tileH.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityLeftCol][entityBottomRow];
				System.out.println(tileNum1+" "+tileNum2);
				if(gp.tileH.tile[tileNum1].collision == true || gp.tileH.tile[tileNum2].collision == true)
					entity.collisionOn = true;
				else if(tileNum1 == 3 || tileNum2 == 3) { // brick -> ladder
					entity.x = entityLeftCol * gp.tileSize;
					entity.direction = "up";
					entity.collisionOn = true;
				}
				else if(tileNum2 == 1 && tileNum1 != 1) { // ladder -> brick
					entity.x = entityLeftCol * gp.tileSize;
					entity.y = entityBottomRow * gp.tileSize;
					entity.direction = "left";
					entity.collisionOn = true;
				}
			}
			break;
		case "right":
			
			entityRightCol = ( entityRightX + entity.speed) / gp.tileSize; 
//			System.out.println("right col == "+entityRightCol);
//			System.out.println("top row == "+entityTopRow);
//			System.out.println("bottom row == "+entityBottomRow);
			
			if(entity.x + gp.tileSize + entity.speed >= 1366) // my screen width(1366)
				entity.collisionOn = true;
			else {
				tileNum1 = gp.tileH.mapTileNum[entityRightCol][entityTopRow];
				tileNum2 = gp.tileH.mapTileNum[entityRightCol][entityBottomRow];
//				System.out.println(tileNum1+" "+tileNum2);
				if(gp.tileH.tile[tileNum1].collision == true || gp.tileH.tile[tileNum2].collision == true)
					entity.collisionOn = true;
				else if(tileNum1 == 3 || tileNum2 == 3) { // brick -> ladder
					entity.x = entityRightCol * gp.tileSize;
					entity.direction = "up";
					entity.collisionOn = true;
				}
				else if(tileNum2 == 1 && tileNum1 != 1) { // ladder -> brick
					entity.x = entityRightCol * gp.tileSize;
					entity.y = entityBottomRow * gp.tileSize;
					entity.direction = "right";
					entity.collisionOn = true;
				}
			}
			break;
		
		}
		
		
	}

    /// OBJECT COLLISION CHECK:

//public int checkObject(Entity entity, boolean player)
//    {
//        int index = 999;
//        for (int i = 0; i < gp.obj.length; i++)
//        {
//            if (gp.obj[i] != null)
//            {
//
//                // get entity's solid area position
//                entity.solidArea.x = entity.x + entity.solidArea.x;
//                entity.solidArea.y = entity.y + entity.solidArea.y;
//
//                // get the object's solid area position
//
////                gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
////                gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;
//
//                switch (entity.direction)
//                {
//
//                case "up":
//                    entity.solidArea.y -= entity.speed;break;
//                case "down":
//                    entity.solidArea.y += entity.speed; break;
//                case "left":
//                    entity.solidArea.x -= entity.speed;break;
//                case "right":
//                    entity.solidArea.x += entity.speed;break;
//                }
//                
//                if (entity.solidArea.intersects(gp.obj[i].solidArea))
//                 {
//                    if (gp.obj[i].collision == true)
//                    {
//                        entity.collisionOn = true;
//                    }
//                    // to check if they are NPC or player
//                    if (player == true)
//                    {
//                        index = i;
//                    }
//                }
//                 entity.solidArea.x = entity.solidAreaDefaultX;
//                entity.solidArea.y = entity.solidAreaDefaultY;
//                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
//                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
//            }
//        }
//        return index;
//    }

public int checkEntity(Entity entity,Entity[] target) {
	int index = 999;
    for (int i = 0; i < target.length; i++)
    {
        if (target[i] != null)
        {

            // get entity's solid area position
            entity.solidArea.x = entity.x + entity.solidArea.x;
            entity.solidArea.y = entity.y + entity.solidArea.y;

            // get the object's solid area position
//
//          target[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
//          target[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;

            switch (entity.direction)
            {
            case "up":
                entity.solidArea.y -= entity.speed;break;
            case "down":
                entity.solidArea.y += entity.speed;break;
            case "left":
                entity.solidArea.x -= entity.speed;break;
            case "right":
                entity.solidArea.x += entity.speed;break;
            }
            if (entity.solidArea.intersects(target[i].solidArea))
            {
            	if(target[i]!=entity) {
            		entity.collision = true;
                    index = i;
            	}           	              
            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            target[i].solidArea.x = target[i].solidAreaDefaultX;
            target[i].solidArea.y = target[i].solidAreaDefaultY;
        }
    }
    return index;	
}
public boolean checkPlayer(Entity entity) {
	
	boolean contactPlayer=false;
	
	
	//get entity's solid area position:
	entity.solidArea.x=entity.x+entity.solidArea.x;
	entity.solidArea.y=entity.y+entity.solidArea.y;
	
	//Get the object SOlid area position:
	
	gp.player.solidArea.x=gp.player.x+gp.player.solidArea.x;
	gp.player.solidArea.y=gp.player.y+gp.player.solidArea.y;
	
	switch(entity.direction) {
	case "up":
		entity.solidArea.y-=entity.speed;break;
	case "down":
		entity.solidArea.y+=entity.speed;break;
	case "left":
		entity.solidArea.x-=entity.speed;break;
	case "right":
		entity.solidArea.x+=entity.speed;break;
			
	}
	if(entity.solidArea.intersects(gp.player.solidArea)){
		entity.collisionOn=true;
		contactPlayer=true;
	}
	entity.solidArea.x=entity.solidAreaDefaultX;
	entity.solidArea.y=entity.solidAreaDefaultY;
	
	gp.player.solidArea.x=gp.player.solidAreaDefaultX;
	gp.player.solidArea.y=gp.player.solidAreaDefaultY;
	
	return contactPlayer;
}

}