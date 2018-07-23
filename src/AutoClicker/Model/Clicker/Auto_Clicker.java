package AutoClicker.Model.Clicker;

import java.awt.*;

public interface Auto_Clicker{

Robot robot = null;
     void Start();
     void Stop();
     void leftClick();

     void setSeconds(int seconds);
     void setMilliseconds(int milliseconds);
     void setTimes(int seconds, int milliseconds);
     void delay(int totalTimeMs);
     void randomDelay();
     Robot getRobot();


}


