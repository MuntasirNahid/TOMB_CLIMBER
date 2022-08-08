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
		if(gp.gameState==gp.titleState) {
			
			if(code==KeyEvent.VK_W) {
				
				gp.ui.commandNum--;
				if(gp.ui.commandNum<0) {
					gp.ui.commandNum=2;
				}
			}
			if(code==KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum>2) {
					gp.ui.commandNum=0;
				}
			}
			if(code==KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum==0) {
					gp.gameState=gp.playState;
					//gp.playMusic(0);
				}
				if(gp.ui.commandNum==1) {
					//add later
				}
				if(gp.ui.commandNum==2) {
					System.exit(0);
				}
			}
		}
		
		//PLAY STATE
		if(gp.gameState==gp.playState)
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
