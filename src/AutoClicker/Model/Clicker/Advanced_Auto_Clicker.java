package AutoClicker.Model.Clicker;
import AutoClicker.Model.CoordinateLocator.*;

import java.awt.*;
import java.awt.event.InputEvent;

public class Advanced_Auto_Clicker implements Auto_Clicker {
   Robot robot;
    runThread runThread;
       Auto_Clicker autoClicker;
       coordinateLocator coordinateLocator;



       public Advanced_Auto_Clicker(Auto_Clicker clicker,coordinateLocator coordinateLocator) throws AWTException {

           runThread=new runThread();
           this.autoClicker=clicker;
           this.coordinateLocator=coordinateLocator;
           robot=autoClicker.getRobot();
       }

    @Override
    public void Start() {
    runThread.run();
    }

    @Override
    public void Stop() {
        runThread.terminate();
    }

    @Override
    public void leftClick() {
        this.robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.robot.delay(100);
        this.robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        this.robot.delay(100);

    }

    @Override
    public void setSeconds(int seconds) {

    }

    @Override
    public void setMilliseconds(int milliseconds) {

    }

    @Override
    public void setTimes(int seconds, int milliseconds) {

    }

    @Override
    public void delay(int totalTimeMs) {

    }
    public void randomDelay(){
           autoClicker.randomDelay();

    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }

    class runThread implements Runnable{
        public volatile boolean execute;
int x, y;
        @Override
        public void run() {
            execute=true;
            while(execute){
                randomDelay();
leftClick();
x=coordinateLocator.getRandomX();
y=coordinateLocator.getRandomY();
System.out.println("Moving mouse to coordinate ("+x+","+y+")");

robot.mouseMove(x,y);
robot.delay(3000);
            }
        }
        public void terminate(){
            execute=false;
        }
    }
}
