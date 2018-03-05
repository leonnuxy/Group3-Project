import java.util.Random;
import javafx.scene.shape.Rectangle;

/** This class creates a collectible to be called in a window initializing class */
public class Collectible_Jon {

	int colXPos, xDefine2;
	int colYPos, yDefine2;
	int	colWidth = 10;
	int colHeight = 10;
	Rectangle colWindow;

	Random rand = new Random();

	/* Constructor */
	public Collectible_Jon(){
		this.colXPos = this.setXPos2();
		this.colYPos = this.setYPos2();
		this.colWidth = this.setWidth2();
		this.colHeight = this.setHeight2();
		this.colWindow = this.getCol();

	}

	/* Constructor to purposefully place a collectible */
	public Collectible_Jon(int arbtyX, int arbtyY){
		this.colXPos = arbtyX;
		this.colYPos = arbtyY;

	}
	
	/* Creates a new collectible with pre-existing values initialized for a 500x500 window */
	public Rectangle getCol(){
	colWindow = new Rectangle(colXPos, colYPos, colWidth, colHeight);
	return colWindow;
	}

	/* Sets the X co-ordinate of the collectible to be inside a window and not colliding with a border */
	public int setXPos2(){
	xDefine2 = rand.nextInt(4) + 1;

		if (xDefine2 == 1) {
		colXPos = rand.nextInt(100-90) + 90;
		}
		if (xDefine2 == 2) {
		colXPos = rand.nextInt(200-190) + 190;
		}
		if (xDefine2 == 3) {
		colXPos = rand.nextInt(300-290) + 290;
		}
		if (xDefine2 == 4) {
		colXPos = rand.nextInt(400-390) + 390;
		}

		return colXPos;
	}

	/* Sets the Y co-ordinate of the collectible to be inside a window and not colliding with a border */
	public int setYPos2(){
	yDefine2 = rand.nextInt(3) + 1;


		if (yDefine2 == 1) {
		colYPos = rand.nextInt(100-90) + 90;
		}
		if (yDefine2 == 2) {
		colYPos = rand.nextInt(200-190) + 190;
		}
		if (yDefine2 == 3) {
		colYPos = rand.nextInt(300-290) + 290;
		}
		if (yDefine2 == 4) {
		colYPos = rand.nextInt(400-390) + 390;
		}
		return colYPos;
	}

	public int setWidth2(){
		return colWidth;
	}

	public int setHeight2(){
		return colHeight;
	}
}
