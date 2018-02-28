import java.util.Random;

public class Obstacle {

int obsXPos;
int obsYPos;
int	obsWidth;
int obsHeight;

Random rand = new Random();

//This constructor allows the creation of a border;
public Obstacle(int borX, int borY, int borW, int borH){
	this.obsXPos = borX;
	this.obsYPos = borY;
	this.obsWidth = borW;
	this.obsHeight = borH;
}

public int setXPos(int eraseX){
	obsXPos = rand.nextInt(50) + 1;
	return obsXPos;
}

public int setYPos(int eraseY){
	obsYPos = rand.nextInt(50) + 1;
	return obsYPos;
}

public int setWidth(int eraseW){
	obsWidth = rand.nextInt(30) + 1;
	return obsWidth;
}

public int setHeight(int eraseH){
	obsHeight = rand.nextInt(30) + 1;
	return obsHeight;
}



//implementation using graphicscontext in the field: 
//Obstacle obs1 = new Obstacle();
//strokeRect(obs1.setYPos(),obs1.setYPos(), obs1.setWidth(), obs1.setHeight());
//Collectible will work the same but with fixed height and width.


}
