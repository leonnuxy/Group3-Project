import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Creates a portal for the player to pass through, to be called as an object and used in a Scene with javaFX
 */
public class thePortal {
	
	//Initialize the variables
	int window_height = 740;
	int window_width = 740;
	Random random = new Random();
	protected int selection;
	protected int portalX;
	protected int portalY;
	int boundOne = 0;
	int boundTwo = 0;
	ImageView porta;
	Image aPortal;
	String imageName = "Portal.gif";
	
	//Default constructor that picks a quadrant for the portal to go into.
	public thePortal() {
		createSelection();
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
	public ImageView makePortal() {
		aPortal = new Image(imageName);
	    ImageView porta = new ImageView(aPortal);
	    porta.setFitWidth(15);
	    porta.setFitHeight(15);
		return porta;
	}
	
	/* Set the image to a desired .png or .gif */
	public void setImage(String anImage) {
		imageName = anImage;
	}

}