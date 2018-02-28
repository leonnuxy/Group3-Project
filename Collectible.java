import java.util.Random;

/** This class creates an Obstacle */
public class Collectible {

int colXPos, xDefine2;
int colYPos, yDefine2;
int	colWidth = 10;
int colHeight = 10;

Random rand = new Random();

public Collectible(){
}

//If want to purposefully place collectible
public Collectible(int arbtyX, int arbtyY){
	this.colXPos = arbtyX;
	this.colYPos = arbtyY;

}

public int setXPos2(){
xDefine2 = rand.nextInt(5) + 1;
	
	if (xDefine2 == 1) {
	colXPos = rand.nextInt(100) + 90;
	}
	if (xDefine2 == 2) {
	colXPos = rand.nextInt(200) + 190;
	}
	if (xDefine2 == 3) {
	colXPos = rand.nextInt(300) + 290;
	}
	if (xDefine2 == 4) {
	colXPos = rand.nextInt(400) + 390;
	}
	if (xDefine2 == 5) {
	colXPos = rand.nextInt(500) + 490;
	}
	return colXPos;
}

public int setYPos2(){
yDefine2 = rand.nextInt(5) + 1;
	
	if (yDefine2 == 1) {
	colYPos = rand.nextInt(100) + 90;
	}
	if (yDefine2 == 2) {
	colYPos = rand.nextInt(200) + 190;
	}
	if (yDefine2 == 3) {
	colYPos = rand.nextInt(300) + 290;
	}
	if (yDefine2 == 4) {
	colYPos = rand.nextInt(400) + 390;
	}
	if (yDefine2 == 5) {
	colYPos = rand.nextInt(500) + 490;
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