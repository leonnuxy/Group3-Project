import java.util.Random;

/**
 * Item is the parent class of obstacle and collectible, which are objects involving collision
 */
public abstract class Item {
	
	protected int iteXPos; // x-position of the item
	protected int iteYPos; // y-position of the item
	protected int yDefine; // y-position of screen which item can exist
	protected int xDefine; // x-position of screen which item can exist
	protected int iteWidth = 15;
	protected int iteHeight = 15;
	
	public Random rand = new Random(); // random object allowing for setting random position of items
	String image_name; // String name of image file which a file can be linked
	
	/* Default constructor */
	public Item() {
	}
	
	/* Allows an image in same folder to be linked to a string */
	public void setImageName(String new_image_name) {
		image_name = new_image_name;
	}
	
	/* Sets the x position of any item and must be done in a child class  */
	public abstract void setXPos();
	
	/* Sets the y position of any item and must be done in a child class */
	public abstract void setYPos();

	/* Returns the X-Position of the item */
	public int getXPos(){
		return this.iteXPos;
	}
	
	/* Returns the Y-Position of the item */
	public int getYPos(){
		return this.iteYPos;
	}
	
	/* Returns the width of the item */
	public int getIteWidth() {
	    return this.iteWidth;
	}
	
	/* Returns the height of the item */
	public int getIteHeight() {
	    return this.iteHeight;
	}

}
