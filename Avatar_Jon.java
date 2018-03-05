import javafx.scene.shape.Rectangle;

/**
This class is responsible for initializing the rectangle that is used for a player movable object
*/
public class Avatar_Jon{

  //Constructor for the class
  public Avatar_Jon(){}

  //Draws the rectangle to be used
  public Rectangle avatar_Snake(int x, int y){
    Rectangle player_Ava =new Rectangle(x, y, 10, 10);
    return player_Ava;
  }

}
