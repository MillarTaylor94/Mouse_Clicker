package AutoClicker.Model.CoordinateLocator;

import java.util.concurrent.ThreadLocalRandom;

public class coordinateLocator {

    int x1,x2,y1,y2;
    int xDif,yDif;
    int randomx, randomy;

    public coordinateLocator(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
       setxDif();
        setyDif();
    }


       //returns random X coordinate
    public int getRandomX(){
        try {
            if (x2 >= x1) {
                return ThreadLocalRandom.current().nextInt(xDif) + x1;

            } else
                return ThreadLocalRandom.current().nextInt(xDif)+ x2;
        }catch(Exception e){
            System.out.println("XDif not yet set");
            return 0;
        }
    }
    //returns random Y coordinate
    public int getRandomY(){
        try {
            if (y2 >= y1) {
                return ThreadLocalRandom.current().nextInt(yDif) + y1;

            } else
                return ThreadLocalRandom.current().nextInt(yDif) + y2;
        }catch(Exception e){
            System.out.println("yDif not yet set");
        return 0;
        }

    }
    //calculates positive difference between x1 nad x2 coordinates
    public void setxDif(){
            if(x2>=x1){
                xDif= (x2-x1+1);


            }else{
                xDif=(x1-x2+1);
            }
    }
    //calculates positive difference between y1 nad y2 coordinates
    public void setyDif(){
            if(y2>=y1) {

                yDif = y2 - y1 + 1;
            }else{
              yDif=(y1-y2+1);
        }

    }
//getters/setters....
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
