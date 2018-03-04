import javafx.scene.shape.Rectangle;

public class Avatar{

  //Constructor for the class
  public Avatar(){}

  // function to draw the rectangle
  public Rectangle avatar_Snake(int x, int y){
    Rectangle player_Ava =new Rectangle(x, y, 10, 10);
    return player_Ava;
  }

}
