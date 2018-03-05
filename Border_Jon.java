import javafx.scene.shape.Rectangle;

/**
Creates a border around the outside edge of the game window, can be called and used in a 500 by 500 window
*/
public class Border_Jon {
  double borLXPos = 0.0;
  double borLYPos = 0.0;
  double borLWidth = 5.0;
  double borLHeight = 500.0;

  double borRXPos = 495.0;
  double borRYPos = 0.0;
  double borRWidth = 5.0;
  double borRHeight = 500.0;

  double borUXPos = 0.0;
  double borUYPos = 0.0;
  double borUWidth = 500.0;
  double borUHeight = 5.0;

  double borDXPos = 0.0;
  double borDYPos = 495.0;
  double borDWidth = 500.0;
  double borDHeight = 5.0;

  Rectangle borLeft;
  Rectangle borUp;
  Rectangle borDown;
  Rectangle borRight;

  /* Draws the border for the left side of the window */
  public Rectangle leftBorder(){
    borLeft = new Rectangle(borLXPos, borLYPos, borLWidth, borLHeight);
    return borLeft;

  }
  
  /* Draws the border for the right side of the window */
  public Rectangle rightBorder(){
    borRight = new Rectangle(borRXPos, borRYPos, borRWidth, borRHeight);
    return borRight;

  }
  
  /* Draws the border for the bottom of the window */
  public Rectangle downBorder(){
    borDown = new Rectangle(borDXPos, borDYPos, borDWidth, borDHeight);
    return borDown;

  }

  /* Draws the border for the top of the window */
  public Rectangle upBorder(){
    borUp = new Rectangle(borUXPos, borUYPos, borUWidth, borUHeight);
    return borUp;

  }

}
