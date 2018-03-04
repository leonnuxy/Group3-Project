import java.util.Random;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/** This class creates an Obstacle */
public class Collectible{

    static int colXPos, xDefine2;
    static int colYPos, yDefine2;
    int    colWidth = 15;
    int colHeight = 15;

    static Random rand = new Random();

    public Collectible(){}

    //If want to purposefully place collectible
    public Collectible(int arbtyX, int arbtyY){
        this.colXPos = arbtyX;
        this.colYPos = arbtyY;

    }

    public static int xPos2(){
        colXPos = rand.nextInt(490) + 1;
        return colXPos;
    }

    public static int yPos2(){
        colYPos = rand.nextInt(490) + 1;
        return colYPos;
    }

    public int setWidth2(){
        return (colWidth = 20);
    }

    public int setHeight2(){
        return (colHeight = 20);
    }

    public Rectangle collectible(){
      Rectangle collectibles = new Rectangle(xPos2(), yPos2(), setWidth2(), setHeight2());
      collectibles.setFill(Color.BLUE);
      return collectibles;
    }

}
