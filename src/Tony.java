import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Tony extends JPanel implements KeyListener{
	
	
	Tony()	{
		this.setFocusable(true);
//		this.setSize(50, 50);
		this.setPreferredSize(new Dimension(500, 500));
//		this.setBounds(200, 200, 600, 600);
//		this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		this.addKeyListener(this);
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setPaint(Color.YELLOW);
		
		g2D.fillRect(0, 0, 100, 100);
	}
	
	@Override	
	public void keyTyped(KeyEvent e)	{
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e)	{
		switch(e.getKeyCode())	{
		case KeyEvent.VK_LEFT:
			this.setLocation(this.getX()-5, this.getY());
			break;
		case KeyEvent.VK_RIGHT:
			this.setLocation(this.getX()+5, this.getY());
			break;
		case KeyEvent.VK_UP:
			this.setLocation(this.getX(), this.getY()-5);
			break;
		case KeyEvent.VK_DOWN:
			this.setLocation(this.getX(), this.getY()+5);
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e)	{
		
	}
	
	
}
