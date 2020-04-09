import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class newUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showUI();
	}

	private static void showUI() {
		JFrame mainFrame =  new ConfiguredJFrame().getFrame(600, 400);
		
		JTabbedPane mainContainer =  new JTabbedPane();
		mainContainer.setBounds(0,0,600,400);
		
	JPanel displayPanel = new DisplayPanel().getDisplayPanel(new Rectangle(0,0,600,400));
		
		mainContainer.add("16x2", displayPanel);	
		
		
		JPanel dotMatrixPanel = new DotMatrixPanel().getDotMatrixPanel(new Rectangle(0,0,600,400));
		
		mainContainer.add("Dot Matrix", dotMatrixPanel);
		mainFrame.add(mainContainer);
		mainFrame.setVisible(true);
	}

}
