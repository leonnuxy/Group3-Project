import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


/** This class creates a collectible to be called in a window initializing class */
public class Collectible extends Item {
	
	//instance variables to set the image for the collectible
	private String appleLOC = "file:Collectible.gif";
	private Image apple = new Image(appleLOC);
    
    /* Constructor */
    public Collectible(){
        this.setXPos();
        this.setYPos();
        //setImageName("Collectible.png");
    }
    
    /* Constructor to purposefully place a collectible */
    public Collectible(int arbtyX, int arbtyY){
        this.iteXPos = arbtyX;
        this.iteYPos = arbtyY;
        
    }
	
	
    /*
     * sets the x position of the collectible to a random integer in different zones of the screen
     */
	public void setXPos() {
	    xDefine = rand.nextInt(8 - 1) + 1;
	    
	    if (xDefine == 1) {
	        iteXPos = rand.nextInt(100-90) + 90;
	    }
	    if (xDefine == 2) {
	        iteXPos = rand.nextInt(200-190) + 190;
	    }
	    if (xDefine == 3) {
	        iteXPos = rand.nextInt(300-290) + 290;
	    }
	    if (xDefine == 4) {
	        iteXPos = rand.nextInt(400-390) + 390;
	    }
	    if (xDefine == 5) {
	        iteXPos = rand.nextInt(500-490) + 490;
	    }
	    if (xDefine == 6) {
	        iteXPos = rand.nextInt(600-590) + 590;
	    }
	    if (xDefine == 7) {
	        iteXPos = rand.nextInt(700-690) + 690;
	    }
	    if (xDefine == 8) {
	        iteXPos = rand.nextInt(800-790) + 790;
	    }
	    
	}

	/*
     * sets the y position of the collectible to a random integer in different zones of the screen
     */
	public void setYPos() {
	    yDefine = rand.nextInt(8 - 1) + 1;
	    
	    if (yDefine == 1) {
	        iteYPos = rand.nextInt(100-90) + 90;
	    }
	    if (yDefine == 2) {
	        iteYPos = rand.nextInt(200-190) + 190;
	    }
	    if (yDefine == 3) {
	        iteYPos = rand.nextInt(300-290) + 290;
	    }
	    if (yDefine == 4) {
	        iteYPos = rand.nextInt(400-390) + 390;
	    }
	    if (yDefine == 5) {
	        iteYPos = rand.nextInt(500-490) + 490;
	    }
	    if (yDefine == 6) {
	        iteYPos = rand.nextInt(600-590) + 590;
	    }
	    if (yDefine == 7) {
	        iteYPos = rand.nextInt(700-690) + 690;
	    }
	    if (yDefine == 8) {
	        iteYPos = rand.nextInt(780-770) + 770;
	    }
	    
	}
	
	
	/*
	 * creates the collectible with the desired image and with the desired dimensions
	 */
	public Rectangle getCol() {
		Rectangle colRect = new Rectangle(iteXPos, iteYPos, iteWidth, iteHeight);
		colRect.setFill(new ImagePattern(apple));
		return colRect;
	}
	
    
}