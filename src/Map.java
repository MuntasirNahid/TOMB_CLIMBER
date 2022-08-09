//    import java.awt.*;
//    import java.awt.event.*;
//import java.awt.image.BufferedImage;
//
//import javax.swing.*;
//
//    public class Map extends JPanel {
//      GridBagConstraints constraints = new GridBagConstraints();
//      
//      BufferedImage l1, l2, l3;
//      
//      public Map() {
//        setLayout(new GridBagLayout());
//        
//        
//        int x, y;  // for clarity
//        l1 = ;
//        l1.setIcon(new ImageIcon("E:\\sam\\2-1\\CSE-234\\OOP Project\\src\\brickSmall.jpg"));
//        l1.setPreferredSize(new Dimension(50, 50));
//        l2 = new JLabel();
//        l2.setIcon(new ImageIcon("E:\\sam\\2-1\\CSE-234\\OOP Project\\src\\brickSmall.jpg"));
//        l2.setPreferredSize(new Dimension(50, 50));
//        l3 = new JLabel();
//        l3.setIcon(new ImageIcon("E:\\sam\\2-1\\CSE-234\\OOP Project\\src\\brickSmall.jpg"));
//        l3.setPreferredSize(new Dimension(50, 50));
////        l2.setSize(50, 50);
//        
//        constraints.gridx = 0;
//        constraints.gridy = 0;
////        constraints.fill = GridBagConstraints.BOTH;
////        constraints.ipady = 10;
////        constraints.gridheight = 1;
////        constraints.gridwidth = 1;
//        add(l1, constraints);
//      
//        constraints.gridx = 1;
//        constraints.gridy = 0;
////        constraints.fill = GridBagConstraints.BOTH;
////        constraints.gridheight = 1;
////        constraints.gridwidth = 1;
//        add(l2, constraints);
////        
////        constraints.gridx = 2;
////        constraints.gridy = 2;
//////        constraints.gridheight = 2;
//////        constraints.gridwidth = 2;
////        add(t3, constraints);
//        
//        constraints.gridx = 2;
//        constraints.gridy = 0;
//        
//        add(l3, constraints);
//      }
//
//      public static void main(String[] args) {
//        JFrame frame = new JFrame("GridBag1");
//        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
////        frame.setLocationRelativeTo(null);
////        frame.setLocation(100, 100);
//    	 
////    	  myFrame frame = new myFrame();
//        Map m = new Map();
//        frame.setVisible(true);
////        frame.setContentPane(m);
//        frame.add(m);
////        frame.pack();
//      }
//    }