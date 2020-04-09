import java.awt.Rectangle;
import javax.swing.JTextPane;


public class DetailsPane {
		JTextPane getDetailsPane(Rectangle bounds){
	    String wglabzDetails = "<html><table><tr><td align=\"center\"><b>Custom Character Generator V2.0</b></td></tr>" +
        "<tr><td align=\"center\"><img src=\"" + getClass().getResource("logo.png").toString() + "\" width=\"100\" height=\"100\"></td></tr>" +
        "<tr><td align=\"center\">WGLabz</td></tr>" +
        "<tr><td align=\"center\">Website :  <a href=\"http://www.wglabz.in\" style=\"text-decoration:none\">www.wglabz.in</a></td></tr>" +
        "</table><html>";
	    
	    JTextPane details = new JTextPane();
        details.setBounds(bounds);
        details.setContentType("text/html");
        details.setText(wglabzDetails);
        details.setEditable(false);
        
        return details;

	}
}
