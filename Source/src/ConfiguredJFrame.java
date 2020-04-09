import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class ConfiguredJFrame {
	
	JFrame getFrame(int sizeX, int sizeY){
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(100, 100, sizeX, sizeY);
		frame.setForeground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return frame;
	}
}
