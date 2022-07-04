import javax.swing.BorderFactory;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

public class myPanel extends JPanel{
	
	Tony tony;
	
	myPanel() {
		tony = new Tony();
		
//		this.setPreferredSize(getMaximumSize());
		this.setLayout(null);
		
		this.add(tony);
		
		
//		this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 10));
		this.setBackground(Color.YELLOW);
	}
	
	
	

}
