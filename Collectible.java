import java.util.Random;
import javafx.scene.shape.Rectangle;

/** This class creates a collectible */
public class Collectible {

int colXPos, xDefine2;
int colYPos, yDefine2;
int	colWidth = 10;
int colHeight = 10;
Rectangle colWindow;

Random rand = new Random();

public Collectible(){
	this.colXPos = this.setXPos2();
	this.colYPos = this.setYPos2();
	this.colWidth = this.setWidth2();
	this.colHeight = this.setHeight2();
	this.colWindow = this.getCol();

}

//If want to purposefully place collectible
public Collectible(int arbtyX, int arbtyY){
	this.colXPos = arbtyX;
	this.colYPos = arbtyY;

}

public int setXPos2(){
xDefine2 = rand.nextInt(6) + 1;
	
	if (xDefine2 == 1) {
	colXPos = rand.nextInt(10) + 5;
	}
	if (xDefine2 == 2) {
	colXPos = rand.nextInt(100-90) + 90;
	}
	if (xDefine2 == 3) {
	colXPos = rand.nextInt(200-190) + 190;
	}
	if (xDefine2 == 4) {
	colXPos = rand.nextInt(300-290) + 290;
	}
	if (xDefine2 == 5) {
	colXPos = rand.nextInt(400-390) + 390;
	}
	if (xDefine2 == 6) {
	colXPos = rand.nextInt(500-490) + 490;
	}
	return colXPos;
}

public int setYPos2(){
yDefine2 = rand.nextInt(5) + 1;
	
	if (xDefine2 == 1) {
	colYPos = rand.nextInt(10) + 5;
	}
	if (yDefine2 == 2) {
	colYPos = rand.nextInt(100-90) + 90;
	}
	if (yDefine2 == 3) {
	colYPos = rand.nextInt(200-190) + 190;
	}
	if (yDefine2 == 4) {
	colYPos = rand.nextInt(300-290) + 290;
	}
	if (yDefine2 == 5) {
	colYPos = rand.nextInt(400-390) + 390;
	}
	if (yDefine2 == 6) {
	colYPos = rand.nextInt(500-490) + 490;
	}
	return colYPos;
}

public int setWidth2(){
	return colWidth;
}

public int setHeight2(){
	return colHeight;
}

public Rectangle getCol(){
	colWindow = new Rectangle(colXPos, colYPos, colWidth, colHeight);
	return colWindow;
}
}
