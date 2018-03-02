import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Label;
import javafx.scene.shape.*;

public class Window3 extends Application{
  boolean collide = false;
  boolean R = false;
  boolean L = false;
  boolean U = false;
  boolean D = false;
  double rectX=0;
  double rectY=0;
  Rectangle rect =new Rectangle(50, 50, 20, 20);

  Rectangle borderTop =new Rectangle(rectX, rectY, 600, 5);
  Rectangle borderBottom =new Rectangle(0, 595, 600, 5);
  Rectangle borderLeft =new Rectangle(0, 0, 5, 600);
  Rectangle borderRight =new Rectangle(595, 0, 5, 600);




  //Starts the window
  public void start(Stage primaryStage){
    Group space = new Group();
    Scene scene=new Scene(play(), 600,600);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  /*public void collision(){
    //Rectangle rectangle1 = rect.bound();
    //Rectangle rectangleTop = borderTop.bound();
    //Rectangle rectangleRight = borderRight.bounds();
    //Rectangle rectangleLeft = borderLeft.bounds();
    //Rectangle rectangleBottom = borderBottom.bounds();

    if (rect.intersects(borderTop.getBoundsInLocal())) //||
    //(rectangle1.intersects(rectangleBottom)) ||
    //(rectangle1.intersects(rectangleRight)) ||
    //(rectangle1.intersects(rectangleLeft)))
    {
      System.out.println("Collide");
    }

  }*/
  //Produces the shape to move and the controls
  public Group play(){
    Group space = new Group();



    space.getChildren().add(rect);
    space.getChildren().add(borderTop);
    space.getChildren().add(borderLeft);
    space.getChildren().add(borderBottom);
    space.getChildren().add(borderRight);
    Label dead = new Label("Dead");




    Button controls=new Button();
    controls.relocate(-50, 100);
    space.getChildren().add(controls);
    controls.setOnKeyPressed(e->{
      if(e.getCode()==KeyCode.RIGHT){
        R=true;
        L=false;
        U=false;
        D=false;
      }
      if(e.getCode()==KeyCode.LEFT){
        L=true;
        R=false;
        D=false;
        U=false;
      }
      if(e.getCode()==KeyCode.UP){
        L=false;
        R=false;
        U=true;
        D=false;
      }
      if(e.getCode()==KeyCode.DOWN){
        R=false;
        L=false;
        D=true;
        U=false;
      }
    });

    //Animates the movement
    AnimationTimer animate=new AnimationTimer(){
      public void handle(long arg0) {
        if(R){
          rectX+=2.2;
          rect.setTranslateX(rectX);
        }
        if(L){
          rectX-=2.2;
          rect.setTranslateX(rectX);
        }
        if(U){
          rectY-=2.2;
          rect.setTranslateY(rectY);
        }
        if(D){
          rectY+=2.2;
          rect.setTranslateY(rectY);
        }
        if ((rect.getBoundsInParent().intersects(0.0, 0.0, 600.0, 5.0))||
        (rect.getBoundsInParent().intersects(0.0, 595.0, 600.0, 5.0)) ||
        (rect.getBoundsInParent().intersects(0.0, 0.0, 5.0, 600.0)) ||
        (rect.getBoundsInParent().intersects(595.0, 0.0, 5.0, 600.0))){
          System.out.println("Border");

        }
      }

    };

    animate.start();

    return space;
  }



  public static void main(String[] args){
    launch(args);
    Obstacle2 obstacle = new Obstacle2(0, 0, 10, 10);

  }
}
