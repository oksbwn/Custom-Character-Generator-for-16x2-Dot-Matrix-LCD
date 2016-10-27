import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;


public class MainCode {
 JFrame frame= new JFrame();
 JButton[] b= new JButton[64];
 int looper=0;
 JTextField result;
 String arrayVal="{000,201,320,401,502,602,072,082}";
 StringBuilder tempString = new StringBuilder("00011111");
 StringBuilder tempString2 = new StringBuilder(arrayVal);
 int[] individulaBit=new int[64];
 int no=0;
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  new MainCode().show();
 }
void show(){
 frame.setLayout(null);
 frame.setBounds(100,100,600,320);
 frame.setForeground(Color.WHITE);
 frame.setBackground(Color.WHITE);
 frame.getContentPane().setForeground(Color.WHITE);
 frame.getContentPane().setBackground(Color.WHITE);
 frame.setResizable(false);
 frame.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
 result = new JTextField("Array");
 result.setForeground(Color.black);
 result.setBounds(300,20,290,20);
 frame.getContentPane().add(result);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JMenuBar menubar = new JMenuBar();

    JMenu file = new JMenu("Edit");
    file.setMnemonic(KeyEvent.VK_F);
    
    JMenuItem clearMenu = new JMenuItem("Clear");
    clearMenu.setMnemonic(KeyEvent.VK_E);
    clearMenu.setToolTipText("Exit application");
    clearMenu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
           for(int temp=0;temp<40;temp++)
           {
            b[temp].setBackground(Color.WHITE);
            individulaBit[temp]=0;
           }
           putResult();
        }
    });
    file.add(clearMenu);
    
    JMenuItem eMenuItem = new JMenuItem("Exit");
    eMenuItem.setMnemonic(KeyEvent.VK_E);
    eMenuItem.setToolTipText("Exit application");
    eMenuItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    });
    file.add(eMenuItem);
    
    menubar.add(file);

    JMenu abt = new JMenu("About");
    file.setMnemonic(KeyEvent.VK_F);
    
    menubar.add(abt);
    
    frame.setJMenuBar(menubar);
  
 JEditorPane details= new JEditorPane();
 details.setBounds(300,50,290,220);
 details.setContentType("text/html");
 String p = getClass().getResource("logo.png").toString();
// String p="";
 details.setText("<html><table><tr><td align=\"center\"><b>Custom Character Generator V_1.0</b></td></tr>"
   + "<tr><td align=\"center\"><img src=\""+p+"\" width=\"100\" height=\"60\"></td></tr>"
   + "<tr><td><i>Bikash Narayan Panda</i></td></tr>"
   + "<tr><td>WearGenius</td></tr>"
   + "<tr><td>Blog :  <a href=\"http://www.weargenius.in\" style=\"text-decoration:none\">www.weargenius.in</a></td></tr>"
   + "<tr><td><a href=\"http://www.youtube.com/weargenius\" style=\"text-decoration:none\">www.youtube.com/weargenius</a></td></tr>"
   + "</table><html>");
 details.setEditable(false);
 frame.getContentPane().add(details);
 int yLoc =10;
 int xloc=10;
 for(looper=0;looper<64;looper++)
 {
  b[looper]= new JButton();
  b[looper].setForeground(Color.WHITE);
  b[looper].setBackground(Color.WHITE);
  if(looper%8==0)
  {
   yLoc=yLoc+25;
   xloc=0;
  }
  individulaBit[looper]=0;
  b[looper].setBounds(10+xloc*25,yLoc,20,20);
  b[looper].addMouseListener(new MouseAdapter() {
   int tempVar=looper;
   @Override
   public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    Color x = b[tempVar].getBackground();
    if(x==Color.WHITE)
    {
     b[tempVar].setBackground(Color.BLACK);
     individulaBit[tempVar]=1;
    }
    else
    {
     b[tempVar].setBackground(Color.WHITE);
     individulaBit[tempVar]=0;
    }
    //Result Calculatio
    putResult();
   }
  });
  frame.getContentPane().add(b[looper]);
  xloc++;
 }
 frame.setVisible(true);
}
protected void putResult() {
 // TODO Auto-generated method stub
 int x3=1;
 for(int x1=0;x1<64;x1=x1+8){
	 for(int i=0;i<8;i++)
		 tempString.setCharAt(i,(char)(48+individulaBit[x1+i]));
  no=Integer.parseInt(tempString.toString(),2);
  String ting=""+no;
  if(no<9)
  {
   tempString2.setCharAt(x3+1,ting.charAt(0));
   tempString2.setCharAt(x3+2,' ');
   tempString2.setCharAt(x3,' ');
  }
  else if(9<no && no <99)
  {
   tempString2.setCharAt(x3,ting.charAt(0));
   tempString2.setCharAt(x3+1,ting.charAt(1));
   tempString2.setCharAt(x3+2,' ');
  }
  else{

	   tempString2.setCharAt(x3,ting.charAt(0));
	   tempString2.setCharAt(x3+1,ting.charAt(1));
	   tempString2.setCharAt(x3+2,ting.charAt(2));
  }
  System.out.println(no);
  x3=x3+4;
 }
 result.setText("int custom[ ]="+tempString2.toString()+";");
}
}
