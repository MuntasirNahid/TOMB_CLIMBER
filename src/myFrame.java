import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class myFrame extends JFrame {
	
	myPanel panel;
	
	myFrame()
	{
		panel = new myPanel();
		
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		
		this.add(panel);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		
//		this.setLocationRelativeTo(null);
//		this.setSize(300, 300);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setResizable(false);
	}
	
	
}
