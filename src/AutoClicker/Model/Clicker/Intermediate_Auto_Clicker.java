package AutoClicker.Model.Clicker;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.ThreadLocalRandom;

public class Intermediate_Auto_Clicker implements Auto_Clicker {
    Robot robot = null;
    int minSeconds, minMilliseconds;
    int maxSeconds, maxMilliseconds;
    int minTotalMs, maxTotalMs;
    runThread runThread;


    public Intermediate_Auto_Clicker() throws AWTException {

        this.robot = new Robot();
        this.runThread=new runThread();

    }
    public Intermediate_Auto_Clicker(int minSeconds, int minMilliseconds,int maxSeconds,int maxMilliseconds) throws AWTException {
this.robot=new Robot();
this.runThread= new runThread();
setTimes(minSeconds, minMilliseconds);
setMaxTimes(maxSeconds,maxMilliseconds);
calculateTimes();

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
this.minSeconds=seconds;
    }

    @Override
    public void setMilliseconds(int milliseconds) {
    this.minMilliseconds=milliseconds;
    }

    public void setMaxSeconds(int maxSeconds) {
        this.maxSeconds = maxSeconds;
    }

    public void setMaxMilliseconds(int maxMilliseconds) {

        this.maxMilliseconds = maxMilliseconds;

    }
    public void calculateTimes(){
        minTotalMs=(minSeconds*1000)+minMilliseconds;
        maxTotalMs=(maxSeconds*1000)+maxMilliseconds;


    }

    @Override
    public void setTimes(int seconds, int milliseconds) {
        setSeconds(seconds);
        setMilliseconds(milliseconds);
    }

    public void setMaxTimes(int sSeconds, int sMilliseconds) {
        setMaxSeconds(sSeconds);
        setMaxMilliseconds(sMilliseconds);
    }

    @Override
    public void delay(int totalTimeMs) {
        this.robot.delay(minTotalMs);
    }

    public void randomDelay(int minTotalMs, int maxTotalMs) {
        int interval = maxTotalMs - minTotalMs + 1;

        int randomMs = ThreadLocalRandom.current().nextInt(interval) + minTotalMs;
        System.out.println("Randomms"+randomMs);
        System.out.println("Waiting: "+ randomMs);
        this.robot.delay(randomMs);

    }
    public void randomDelay() {
        int interval = maxTotalMs - minTotalMs + 1;

        int randomMs = ThreadLocalRandom.current().nextInt(interval) + minTotalMs;
        System.out.println("Waiting: "+ randomMs);

        this.robot.delay(randomMs);

    }
    public Robot getRobot() {
        return this.robot;
    }


    class runThread implements Runnable {
        private volatile boolean execute;

        @Override
        public void run() {
            this.execute = true;
            calculateTimes();
            while (execute) {
                leftClick();
                randomDelay(minTotalMs, maxTotalMs);


            }
        }

        public void terminate() {
            this.execute = false;
        }
    }
}
