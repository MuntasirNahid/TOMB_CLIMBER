package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPressed,downPressed,leftPressed,rightPressed;
	
	public KeyHandler (GamePanel gp) {
		this.gp=gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {

			
			if(gp.ui.titleScreenState == 0) { /// Main Menu
				if(code==KeyEvent.VK_UP) {
					gp.ui.commandNum--;
					if(gp.ui.commandNum < 0) {
						gp.ui.commandNum=2;
					}
				}
				if(code==KeyEvent.VK_DOWN) {
					gp.ui.commandNum++;
					if(gp.ui.commandNum > 2) {
						gp.ui.commandNum=0;
					}
				}
				if(code==KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						System.out.println("GOING");
						gp.ui.titleScreenState = 2; // go to map choice screen
//						gp.gameState=gp.ui.titleScreenState;
					}
					if(gp.ui.commandNum == 1) {
						gp.ui.titleScreenState = 1;
					}
					if(gp.ui.commandNum==2) {
						System.exit(0);
					}
					
				}
			}		
		else if(gp.ui.titleScreenState == 1) { // FOR ABOUT SCREEN	-2nd Screen
				if(code==KeyEvent.VK_ENTER) {
						gp.ui.titleScreenState = 0;
						gp.ui.commandNum = 0;
				}	
		  }
		else if(gp.ui.titleScreenState == 2) { // Map Choice
			System.out.println("HERE");
			if(code == KeyEvent.VK_UP) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 3;
				}
			}
			if(code == KeyEvent.VK_DOWN) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 3) {
					gp.ui.commandNum = 0;
				}
			}
			if(code==KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
				gp.mapId = gp.ui.commandNum;
				System.out.println(gp.mapId);
				gp.ui.commandNum = 0;
			}
			
		}
	} /// End of titleState
		
		
		else if(gp.gameState == gp.pauseState) { 
			if(code==KeyEvent.VK_UP) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum<0) {
					gp.ui.commandNum=1;
				}
			}
			if(code==KeyEvent.VK_DOWN) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum>1) {
					gp.ui.commandNum=0;
				}
			}
			if(code==KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum==0) {
					gp.gameState = gp.playState;
				}
				else if(gp.ui.commandNum == 1) {
					gp.gameState=gp.titleState;
					gp.ui.titleScreenState = 0;
				}
				gp.ui.commandNum = 0;
			}
		}
		
	//	FOR GAME OVER STATE
		else if(gp.gameState == gp.gameOverState) {
			if(code==KeyEvent.VK_UP) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum<0) {
					gp.ui.commandNum=1;
				}
			}
			if(code==KeyEvent.VK_DOWN) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum>1) {
					gp.ui.commandNum=0;
				}
			}
			if(code==KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) { // Retry
					gp.gameState = gp.playState;
					gp.reStart();
	
				}
				else if(gp.ui.commandNum == 1) { // Quit Game
					gp.gameState = gp.titleState;
					gp.ui.titleScreenState = 0;
					gp.reStart();
				}
				gp.ui.commandNum = 0;
			}
			
		}
		else if(gp.gameState == gp.winState) {
			if(code==KeyEvent.VK_ENTER) {
//				if(gp.ui.commandNum == 0) { // Main Menu
					gp.gameState = gp.titleState;
					gp.ui.titleScreenState = 0;
					gp.reStart();
//				}
				gp.ui.commandNum = 0;
			}
		}
		//PLAY STATE
		if(gp.gameState == gp.playState)
		{
			if(code==KeyEvent.VK_UP) {
				upPressed=true;
			}
			if(code==KeyEvent.VK_DOWN) {
				downPressed=true;
			}
			if(code==KeyEvent.VK_LEFT) {
				leftPressed=true;
			}
			if(code==KeyEvent.VK_RIGHT) {
				rightPressed=true;
			}
			if(code == KeyEvent.VK_ESCAPE) {
				gp.gameState = gp.pauseState;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code=e.getKeyCode();
			
			if(code==KeyEvent.VK_UP) {
				upPressed=false;
			}
			if(code==KeyEvent.VK_DOWN) {
				downPressed=false;
			}
			if(code==KeyEvent.VK_LEFT) {
				leftPressed=false;
			}
			if(code==KeyEvent.VK_RIGHT) {
				rightPressed=false;
			}
		}

}
