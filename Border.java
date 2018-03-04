import javafx.scene.shape.Rectangle;





public class Border{



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





  public Rectangle leftBorder(){

    borLeft = new Rectangle(borLXPos, borLYPos, borLWidth, borLHeight);

    return borLeft;

  }



  public Rectangle rightBorder(){

    borRight = new Rectangle(borRXPos, borRYPos, borRWidth, borRHeight);

    return borRight;

  }



  public Rectangle downBorder(){

    borDown = new Rectangle(borDXPos, borDYPos, borDWidth, borDHeight);

    return borDown;

  }



  public Rectangle upBorder(){

    borUp = new Rectangle(borUXPos, borUYPos, borUWidth, borUHeight);

    return borUp;

  }



}
