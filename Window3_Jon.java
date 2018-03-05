import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.*;
import javafx.scene.control.Label;
import java.util.Random;


/**
This class initializes the window for a snake game to be played in including the movement and timers
*/
public class Window3_Jon extends Application{
  public int score;
  boolean R = false;
  boolean L = false;
  boolean U = false;
  boolean D = false;
  double rectX=0;
  double rectY=0;
  Random rand = new Random();
  boolean check = true;
  Group space = new Group();

  /* Starts the window */
  public void start(Stage primaryStage){
    Scene scene = new Scene(play(), 500, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /* Produces the shape from avatar class to move and the controls to be used to move it */
  public Group play(){
	Avatar_Jon ava = new Avatar_Jon();
	Collectible_Jon theCollectible = new Collectible_Jon();
	Border_Jon bor = new Border_Jon();
	Obstacle_Jon theObstacle = new Obstacle_Jon();
	Button controls = new Button();
	
	Rectangle col = theCollectible.getCol();
    	Rectangle player = ava.avatar_Snake(50, 50);
	Rectangle obs = theObstacle.getObs();
   
    	controls.relocate(-50, 100);
    	space.getChildren().add(bor.leftBorder());
    	space.getChildren().add(bor.rightBorder());
    	space.getChildren().add(bor.downBorder());
    	space.getChildren().add(bor.upBorder());
    	space.getChildren().add(player);
	space.getChildren().add(col);
	space.getChildren().add(obs);
    	space.getChildren().add(controls);
	  
	//controls event handler  
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
      int score = 0;
      Label label_score;
      
      //handler for the animation of the movement
      public void handle(long arg0) {
        if(R){
          rectX+=2.2;
          player.setTranslateX(rectX);
        }

        if(L){
          rectX-=2.2;
          player.setTranslateX(rectX);
        }

        if(U){
          rectY-=2.2;
          player.setTranslateY(rectY);
        }

        if(D){

          rectY+=2.2;

          player.setTranslateY(rectY);

        }
	
	//collision between player controlled object and borders
        if ((player.getBoundsInParent().intersects(obs.getX(), obs.getY(), obs.getWidth(), obs.getHeight()))||
        (player.getBoundsInParent().intersects(bor.borLXPos, bor.borLYPos, bor.borLWidth, bor.borLHeight))||
        (player.getBoundsInParent().intersects(bor.borRXPos, bor.borRYPos, bor.borRWidth, bor.borRHeight)) ||
        (player.getBoundsInParent().intersects(bor.borUXPos, bor.borUYPos, bor.borUWidth, bor.borUHeight)) ||
        (player.getBoundsInParent().intersects(bor.borDXPos, bor.borDYPos, bor.borDWidth, bor.borDHeight))){

         System.out.println("You died");
         System.exit(0);
        }
	
	//collision between player controlled objects and collectible
        if (player.getBoundsInParent().intersects(col.getBoundsInParent())) {
          col.relocate(theCollectible.setXPos2(), theCollectible.setYPos2());
          col.getBoundsInParent();
   	  space.getChildren().remove(col);
	  space.getChildren().add(col);
          score++;
          System.out.println("Your score is " + score);
        }
      }
    };
    animate.start();
    return space;
  }

  /* Launch all arguments */	
  public static void main(String[] args){

    launch(args);
  }
}
