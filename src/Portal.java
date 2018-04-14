import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Creates a portal for the player to pass through, to be called as an object and used in a Scene with javaFX
 */
public class Portal{
	
	//Initialize the variables
	protected Random random = new Random();
	protected int selection;
	protected int portalX;
	protected int portalY;
	private int boundOne = 0;
	private int boundTwo = 0;
	private Point2D position;
	private String portalLOC = "file:Portal.gif";
	private Image portal = new Image(portalLOC);
	
	//Default constructor that picks a quadrant for the portal to go into.
	public Portal() {
		createSelection();
		createPortalX();
		createPortalY();
	}
	
	//Constructor that places the portal at a position on the screen that is passed into, for testing
	public Portal(Point2D position) {
		this.position = position;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}
	
	public int getXCood() {
		return portalX;
	}
	
	public int getYCood() {
		return portalY;
	}
	
	/* picks a number between one and four representing the quadrants on the screen in a cartesian plane */
	public int createSelection() {
		selection = random.nextInt(4 - 1 + 1) + 1;
		return selection;
	}
	
	
	public int getSelection() {
		return selection;
	}
	
	
	/* creates the portalXPosition based on the selection at a random point in that quadrant */
	public int createPortalX() {
		boundTwo = boundTwo();
		boundOne = boundOne();
		if (selection == 1) {
			portalX = boundTwo;
		}
		if (selection == 2) {
			portalX = boundOne;
		}
		if (selection == 3) {
			portalX = boundOne;
		}
		if (selection == 4) {
			portalX = boundTwo;
		}

	return portalX;
	}
	
	/*creates the portalYPosition based on the selection at a random point in that quadrant */
	public int createPortalY() {
		boundTwo = boundTwo();
		boundOne = boundOne();
		if (selection == 1) {
			portalY = boundOne();
		}
		if (selection == 2) {
			portalY = boundOne();
		}
		if (selection == 3) {
			portalY = boundTwo();
		}
		if (selection == 4) {
			portalY = boundTwo();
		}

	return portalY;
	}
	
	/* picks a random number between 360 and 50, these numbers are 
	   used to give the user room to move the character around after exiting the portal */
	public int boundOne() {
		boundOne = random.nextInt((360-50) + 1) + 50;
		return boundOne;
	}
	
	/* picks a random number between 735 and 375, these numbers are 
	   used to give the user room to move the character around after exiting the portal */
	public int boundTwo() {
		boundTwo = random.nextInt((735-375) + 1) + 375;
		return boundTwo;
	}
	
	/* Creates the portal as an Image at a larger size than the player */
	public Rectangle makePortal() {
		Rectangle porRect = new Rectangle(portalX, portalY, 15, 15);
		porRect.setFill(new ImagePattern(portal));
		return porRect;
	}
	

}
