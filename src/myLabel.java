import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;

public class myLabel extends JLabel implements KeyListener{
	
	myLabel() {
		this.setBounds(200, 200, 500, 500);
		this.setPreferredSize(new Dimension(500, 500));
		this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
	}
	
	public void paintComponent(Graphics g)	{
		
		g2D = (Graphics2D) g;
		
		g2D.fillOval(500, 500, 200, 200);
	}
	

	
}
