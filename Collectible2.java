import java.util.Random;

/** This class creates an Obstacle */
public class Collectible2 {
    
    static int colXPos, xDefine2;
    static int colYPos, yDefine2;
    int    colWidth = 15;
    int colHeight = 15;
    
    static Random rand = new Random();
    
    public Collectible2(){
    }
    
    //If want to purposefully place collectible
    public Collectible2(int arbtyX, int arbtyY){
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
        return colWidth;
    }
    
    public int setHeight2(){
        return colHeight;
    }
    
    
}
