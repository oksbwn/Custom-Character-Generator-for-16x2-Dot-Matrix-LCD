
public class ExampleSketcehs {
	String sketchFor16x2Display(String dataArray){
		
		return "<html><BODY><CODE> "
				+ "<br>#include &lt;LiquidCrystal.h&gt;"
				+" <br>LiquidCrystal lcd(12, 11, 5, 4, 3, 2);"
				+"<br>"+dataArray
				+"<br>void setup() {"
				+"<br>&nbsp; lcd.createChar(0, custom);"
				+"<br>&nbsp; lcd.begin(16, 2);"
				+"<br>&nbsp; lcd.write(byte(0));"
				+"<br>}"
				+"<br>void loop() {}</BODY></CODE></html>";
	}
	
	String sketchForDotMatrixDisplay(String dataArray){
		
		return "<html><BODY><CODE> "
				+"#include \"LedControl.h\" //https://github.com/wayoda/LedControl"
				+"<br>LedControl lc=LedControl(8,10,9,1);"
				+"<br>"+dataArray
				+"<br>void setup(){"
				+"<br> lc.shutdown(0,false);"
				+"<br> lc.setIntensity(0,8);"
				+"<br> lc.clearDisplay(0);"
				+"<br>}"
				+"<br>void sendCustom(){"
				+"<br> for (int i = 0; i < 8; i++){"
				+"<br>   lc.setRow(0,i,custom[i]);"
				+"<br> }"
				+"<br>}"
				+"<br>void loop(){"
				+"<br>   sendCustom();"
				+"<br>}";
	}
}
