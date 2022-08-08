package monster;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class MON_MUMMY extends Entity {
	
	public MON_MUMMY(GamePanel gp) {
		super(gp);
		type=2;
		name="monster";
		speed=1;
		maxLife=4  ;
		life=maxLife;
		
		x = 100;
		y = 100;
		solidArea.x=100;
		solidArea.y=100;
		solidArea.width=42;
		solidArea.height=42;
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
//		
		getImage();
//		
	}

	public void getImage() {
		try {
			left1=ImageIO.read(getClass().getResourceAsStream("monster_left1.png"));
			left2=ImageIO.read(getClass().getResourceAsStream("monster_left2.png"));
			right1=ImageIO.read(getClass().getResourceAsStream("monster_right1.png"));
			right2=ImageIO.read(getClass().getResourceAsStream("monster_right2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setAction() {
		//Simple AI
		
		actionLockCounter++;
		
		if(actionLockCounter==120) {
			Random random=new Random();
			int i=random.nextInt(100)+1;
			if(i<=50) {
				direction="left";
			}
			if(i>50 && i<=100) {
				direction="right";
			}
			actionLockCounter=0;
		}
	}
	
}
