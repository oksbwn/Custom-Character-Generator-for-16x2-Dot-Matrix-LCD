import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class DotMatrixPanel {
	private int[] individulaBit;
	private JButton[] digitButtons;
	private int looper;
	private JTextField resultArrayTextField;
	private JTextPane details;

	JPanel getDotMatrixPanel(Rectangle bounds){
//    	initFrame();
		JPanel panel =  new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(bounds);
    	individulaBit = new int[64];
    	digitButtons = new JButton[64];
     int yLoc =10;
     int xloc=10;
     for(looper=0;looper<64;looper++)
     {
    	 digitButtons[looper]= new JButton();
    	 digitButtons[looper].setForeground(Color.WHITE);
    	 digitButtons[looper].setBackground(Color.WHITE);
      if(looper%8==0)
      {
       yLoc=yLoc+25;
       xloc=0;
      }
      individulaBit[looper]=0;
      digitButtons[looper].setBounds(10+xloc*25,yLoc,20,20);
      digitButtons[looper].addMouseListener(new MouseAdapter() {
       int tempVar=looper;
       @Override
       public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        Color x = digitButtons[tempVar].getBackground();
        if(x==Color.WHITE)
        {
        	digitButtons[tempVar].setBackground(Color.BLACK);
         individulaBit[tempVar]=1;
        }
        else
        {
        	digitButtons[tempVar].setBackground(Color.WHITE);
         individulaBit[tempVar]=0;
        }
        //Result Calculatio
        putMatrixResult();
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
     
     details = new DetailsPane().getDetailsPane(new Rectangle(280, 35, 305, 400));
     panel.add(details);

//     JScrollPane scrollPane = new JScrollPane(details);
//     scrollPane.setLayout(null);
//     scrollPane .setVerticalScrollBarPolicy(
//               javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//     panel.add(scrollPane);
     return panel;
		
	}
	
	protected void putMatrixResult() { 
    	String arrayVal="{000,201,320,401,502,602,072,082}";
    StringBuilder tempString = new StringBuilder("00011111");
    StringBuilder tempString2 = new StringBuilder(arrayVal);
//    int[] individulaBit=new int[64];
    int no=0;
        int x3 = 1;
        for (int x1 = 0; x1 < 64; x1 = x1 + 8) {
            for (int i = 0; i < 8; i++)
                tempString.setCharAt(i, (char)(48 + individulaBit[x1 + i]));
            no = Integer.parseInt(tempString.toString(), 2);
            String ting = "" + no;
            if (no < 9) {
                tempString2.setCharAt(x3 + 1, ting.charAt(0));
                tempString2.setCharAt(x3 + 2, ' ');
                tempString2.setCharAt(x3, ' ');
            } else if (9 < no && no < 99) {
                tempString2.setCharAt(x3, ting.charAt(0));
                tempString2.setCharAt(x3 + 1, ting.charAt(1));
                tempString2.setCharAt(x3 + 2, ' ');
            } else {

                tempString2.setCharAt(x3, ting.charAt(0));
                tempString2.setCharAt(x3 + 1, ting.charAt(1));
                tempString2.setCharAt(x3 + 2, ting.charAt(2));
            }
            System.out.println(no);
            x3 = x3 + 4;
        }
        resultArrayTextField.setText("int custom[ ]=" + tempString2.toString() + ";");
        details.setText(new ExampleSketcehs().sketchForDotMatrixDisplay("int custom[8]="+tempString2.toString()+";"));
    }
}
