import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 This class creates an Obstacle optimized for a 800 by 800 field
 */
public class Obstacle extends Item {
    Image obsWindow;
    int iteXPos;
    int iteYPos;
    int iteWidth;
    int iteHeight;
    
    /*Constructor */
    public Obstacle(){
        this.setXPos();
        this.setYPos();
		this.setWidth();
		this.setHeight();
        //setImageName("Obstacle.png");
        
    }
    
    // Constructor that allows the creation of an obstacle with a custom shape 
    public Obstacle(int anX, int anY, int anW, int anH){
        this.iteXPos = anX;
        this.iteYPos = anY;
        this.iteWidth = anW;
        this.iteHeight = anH;
    }
        
    
    
    /*Define variables choose a random section(1-5) of the field to place object
     10 pix of section are given to where potential collectibles will be placed for the x-coordinate*/
    
    public void setXPos(){
        xDefine = rand.nextInt(8) + 1;
        if (xDefine == 1) {
            iteXPos = rand.nextInt(80-20) + 10;
        }
        
        if (xDefine == 2) {
            iteXPos = rand.nextInt(180-120) + 120;
        }
        
        if (xDefine == 3) {
            iteXPos = rand.nextInt(280-220) + 220;
        }
        
        if (xDefine == 4) {
            iteXPos = rand.nextInt(380-320) + 320;
        }
        
        if (xDefine == 5) {
            iteXPos = rand.nextInt(480-420) + 420;
        }
        
        if (xDefine == 6) {
            iteXPos = rand.nextInt(580-520) + 520;
        }
        
        if (xDefine == 7) {
            iteXPos = rand.nextInt(680-620) + 620;
        }
        
        if (xDefine == 8) {
            iteXPos = rand.nextInt(780-720) + 720;
        }
        
        
    }
    
    /*Define variables choose a random section(1-5) of the field to place object
     10 pix of section are given to where potential collectibles will be placed for the y-coordinate*/
    
    public void setYPos(){
        yDefine = rand.nextInt(8) + 1;
        
        if (yDefine == 1) {
            iteYPos = rand.nextInt(80-20) + 20;
        }
        
        if (yDefine == 2) {
            iteYPos = rand.nextInt(180-120) + 120;
        }
        
        if (yDefine == 3) {
            iteYPos = rand.nextInt(280-220) + 220;
        }
        
        if (yDefine == 4) {
            iteYPos = rand.nextInt(380-320) + 320;
        }
        
        if (yDefine == 5) {
            iteYPos = rand.nextInt(480-420) + 420;
        }
        
        if (yDefine == 6) {
            iteYPos = rand.nextInt(580-520) + 520;
        }
        
        if (yDefine == 7) {
            iteYPos = rand.nextInt(680-620) + 620;
        }
        
        if (yDefine == 8) {
            iteYPos = rand.nextInt(780-720) + 720;
        }
        
    }
     
    /* Change the width of the obstacle(s) */
    public void setWidth(){
        iteWidth = rand.nextInt(30) + 15;

    }
    
    public int getWidth() {
    		return iteWidth;
    }
    
    public int getHeight() {
		return iteHeight;
    }
    
    
    /* Change the height of the obstacle(s) */
    public void setHeight(){
        iteHeight = rand.nextInt(30) + 15;
        
    }
    
	/*
	 * Create a rectangle with the required values
	 */
	public Rectangle getObs(){
		Rectangle obsRect = new Rectangle(iteXPos, iteYPos, iteWidth, iteHeight);
		return obsRect;
        
    }
	
	
    
}
