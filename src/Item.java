import java.util.Random;


/**
 * Item is anything that can be collected
 */
public abstract class Item {
	
	//instance variables 
	protected int iteXPos;
	protected int iteYPos;
	protected int yDefine;
	protected int xDefine;
	protected int iteWidth = 15;
	protected int iteHeight = 15;

	public Random rand = new Random();
	String image_name;
	
	/*
	 * default constructor
	 */
	public Item() {
		//super();
	}
	
	/*
	 * changes the item to a desired image
	 */
	public void setImageName(String new_image_name) {
		image_name = new_image_name;
	}
	
	/*
	 * sets the x position of any item and must be done in a child class 
	 */
	public abstract void setXPos();
	
	/*
	 * sets the y position of any item and must be done in a child class 
	 */
	public abstract void setYPos();

	public int getXPos(){
		return this.iteXPos;
	}
	
	public int getYPos(){
		return this.iteYPos;
	}
	
	public int getIteWidth() {
	    return this.iteWidth;
	}

	public int getIteHeight() {
	    return this.iteHeight;
	}

}