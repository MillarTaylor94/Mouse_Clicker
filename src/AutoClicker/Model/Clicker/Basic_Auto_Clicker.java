package AutoClicker.Model.Clicker;

import java.awt.*;
import java.awt.event.InputEvent;

public class Basic_Auto_Clicker implements Auto_Clicker {

    private Robot robot = null;
    //Time Variables
    int seconds, milliseconds;
    int totalTimeMs;
    //Clicker thread
    runThread runThread;


    public Basic_Auto_Clicker() throws AWTException {
        this.robot = new Robot();
        runThread= new runThread();

    }

    public Basic_Auto_Clicker(int seconds, int milliseconds) throws AWTException {

        this.robot = new Robot();
       setTimes(seconds,milliseconds);
        runThread=new runThread();
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

    public void delay(int totalTimeMs) {
        this.robot.delay(totalTimeMs);
    }
    public void randomDelay(){
        this.delay(this.totalTimeMs);
    }
    //Setters

    public void setSeconds(int seconds) {
        this.seconds = seconds;

    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;

    }

    public void setTimes(int seconds, int milliseconds) {
        setSeconds(seconds);
        setMilliseconds(milliseconds);
        CalculateTotalTime();
    }

    public void CalculateTotalTime() {

        this.totalTimeMs = (seconds * 1000) + milliseconds;
    }

    public Robot getRobot() {
        return robot;
    }

    class runThread implements Runnable {
        private volatile boolean execute;

        @Override
        public void run() {
            this.execute = true;
            CalculateTotalTime();
            while (execute) {
                leftClick();
                delay(totalTimeMs);

            }

        }
        public void terminate(){
            this.execute=false;
        }
    }
}
