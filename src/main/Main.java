package main;

import javax.swing.JFrame;

public class Main{

	public static void main(String[]args) {
		JFrame window=new JFrame();
		
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setUndecorated(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("TOMB CLIMBER");
		
		GamePanel gamePanel= new GamePanel();
		window.add(gamePanel);
		window.pack();//causes this Window to be sized to fit the preferred size and layouts of it's subcomponents(=GamePanel)
		
		window.setLocationRelativeTo(null);//windows gonna be displayed at the centre of the screen
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
	}
}
