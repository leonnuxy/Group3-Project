/** This class creates a collectible to be called in a window initializing class */
public class Collectible extends Collideable {
    
    /* Constructor */
    public Collectible(){
        this.colXPos = this.setXPos2();
        this.colYPos = this.setYPos2();
        setImageName("Collectible.png");
    }
    
    /* Constructor to purposefully place a collectible */
    public Collectible(int arbtyX, int arbtyY){
        this.colXPos = arbtyX;
        this.colYPos = arbtyY;
        
    }
    
    public int getYPos2() {
		return colYPos;
    }
    
    public int getXPos2() {
    		return colXPos;
    }
}
