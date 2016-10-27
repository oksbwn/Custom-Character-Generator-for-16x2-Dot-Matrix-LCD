#include "LedControl.h"

LedControl lc=LedControl(8,10,9,1);  // Pins: DIN,CLK,CS, # of Display connected

unsigned long delayTime=200;  // Delay between Frames

// Put values in arrays
int custom[2][8]={{129,129,129,129,153,153,165,195},{0,0,0,0,0,0,0,0}};


void setup()
{
  lc.shutdown(0,false);  // Wake up displays
  lc.shutdown(1,false);
  lc.setIntensity(0,5);  // Set intensity levels
  lc.setIntensity(1,5);
  lc.clearDisplay(0);  // Clear Displays
  lc.clearDisplay(1);
}


//  Take values in Arrays and Display them
void sendCustom(int x)
{
  for (int i = 0; i < 8; i++)  
  {
    lc.setRow(0,i,custom[x][i]);
  }
}


void loop()
{
// Put #1 frame on both Display
    sendCustom(0);
delay(1000);
sendCustom(1);
delay(1000);
}
