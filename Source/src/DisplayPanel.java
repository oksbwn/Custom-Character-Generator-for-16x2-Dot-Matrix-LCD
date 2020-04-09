import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class DisplayPanel {
	JTextPane details;
	private int[] individulaBit;
	private JButton[] digitButtons;
	private int looper;
	private JTextField resultArrayTextField;

	JPanel getDisplayPanel(Rectangle bounds){
		
		JPanel panel =  new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(bounds);
		
		individulaBit = new int[40];
    	digitButtons = new JButton[40];
//        
        int yLoc = 10;
        int xloc = 10;

        	
        for (looper = 0; looper < 40; looper++) {
            digitButtons[looper] = new JButton();
            digitButtons[looper].setForeground(Color.WHITE);
            digitButtons[looper].setBackground(Color.WHITE);
            if (looper % 5 == 0) {
                yLoc = yLoc + 25;
                xloc = 0;
            }
            individulaBit[looper] = 0;
            digitButtons[looper].setBounds(10 + xloc * 25, yLoc, 20, 20);
            digitButtons[looper].addMouseListener(new MouseAdapter() {
                int tempVar = looper;
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    Color x = digitButtons[tempVar].getBackground();
                    if (x == Color.WHITE) {
                        digitButtons[tempVar].setBackground(Color.BLACK);
                        individulaBit[tempVar] = 1;
                    } else {
                        digitButtons[tempVar].setBackground(Color.WHITE);
                        individulaBit[tempVar] = 0;
                    }
                    //Result Calculatio
                    put16x2Result();
                }
            });
            panel.add(digitButtons[looper]);
            xloc++;
        }
        JLabel arrayLabel = new JLabel("Array : ");
        arrayLabel.setBackground(Color.white);
        arrayLabel.setForeground(Color.black);
        arrayLabel.setBounds(280, 10, 40, 20);
        panel.add(arrayLabel);
        
        resultArrayTextField = new JTextField();
        resultArrayTextField.setForeground(Color.black);
        resultArrayTextField.setBounds(325, 10, 265, 20);
        panel.add(resultArrayTextField);
        
        details = new DetailsPane().getDetailsPane(new Rectangle(280, 35, 305, 200));
        panel.add(details);
  
        
		return panel;
		
	}
	 protected void put16x2Result() {	
	    	String arrayVal="{11,21,32,41,52,62,72,82}";
	    	StringBuilder tempString = new StringBuilder("00011111");
	    	StringBuilder tempString2 = new StringBuilder(arrayVal);

	    	int number_=0;
	    	int x3=1;
	    	for(int x1=0;x1<40;x1=x1+5){
	    		tempString.setCharAt(3,(char)(48+individulaBit[x1]));
	    		tempString.setCharAt(4,(char)(48+individulaBit[x1+1]));
	    		tempString.setCharAt(5,(char)(48+individulaBit[x1+2]));
	    		tempString.setCharAt(6,(char)(48+individulaBit[x1+3]));
	    		tempString.setCharAt(7,(char)(48+individulaBit[x1+4]));
	    		number_=Integer.parseInt(tempString.toString(),2);
	    		String ting=""+number_;
	    		if(number_<9)
	    		{
	    			tempString2.setCharAt(x3+1,ting.charAt(0));
	    			tempString2.setCharAt(x3,' ');
	    		}
	    		else
	    		{
	    			tempString2.setCharAt(x3,ting.charAt(0));
	    			tempString2.setCharAt(x3+1,ting.charAt(1));
	    		}
	    		System.out.println(number_);
	    		x3=x3+3;
	    	}
	    	resultArrayTextField.setText("byte custom[8]="+tempString2.toString()+";");
	    	 details.setText(new ExampleSketcehs().sketchFor16x2Display("byte custom[8]="+tempString2.toString()+";"));
	    }
}
