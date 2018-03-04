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


public class Window3 extends Application{
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
  //Obstacle obs = new Obstacle();
  Border bor = new Border();

  Avatar ava = new Avatar();

  //Starts the window
  public void start(Stage primaryStage){
    Scene scene = new Scene(play(), 500, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  //Produces the shape to move and the controls
  public Group play(){

    Rectangle collect2 = createCollect();
    Rectangle player = ava.avatar_Snake(50, 50);
    Button controls = new Button();


    controls.relocate(-50, 100);
    space.getChildren().add(bor.leftBorder());
    space.getChildren().add(bor.rightBorder());
    space.getChildren().add(bor.downBorder());
    space.getChildren().add(bor.upBorder());
    space.getChildren().add(player);

    //space.getChildren().add(obs.obsWindow);
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
      int score = 0;
      Collectible col = new Collectible();
      Label label_score;
      //int score = 0;
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

        if //((player.getBoundsInParent().intersects(obs.obsXPos, obs.obsYPos, obs.obsWidth, obs.obsHeight))||
        ((player.getBoundsInParent().intersects(bor.borLXPos, bor.borLYPos, bor.borLWidth, bor.borLHeight))||
        (player.getBoundsInParent().intersects(bor.borRXPos, bor.borRYPos, bor.borRWidth, bor.borRHeight)) ||
        (player.getBoundsInParent().intersects(bor.borUXPos, bor.borUYPos, bor.borUWidth, bor.borUHeight)) ||
        (player.getBoundsInParent().intersects(bor.borDXPos, bor.borDYPos, bor.borDWidth, bor.borDHeight))){

          System.out.println("You died");
          System.exit(0);

        }
        if (player.getBoundsInParent().intersects(collect2.getBoundsInParent())){
          //Rectangle collect2 = createCollect();
          //createCollect();

          collect2.setTranslateX(rand.nextInt((500 - col.xPos2())/2) + 1);
          collect2.setTranslateY(rand.nextInt((500 - col.xPos2())/2) + 1);
          collect2.getBoundsInParent();
          //collect2 = createCollect();
          score++;
          System.out.println("Your score is " + score);
          /*label_score = new Label("Score is: " + score);
          label_score.setTranslateX(200);
          space.getChildren().add(label_score);*/

        }

      }
    };
    animate.start();
    return space;
  }

  /*public boolean collide(){
    Rectangle player = ava.avatar_Snake(50, 50);
    int score = 0;

    boolean taken = false;



    //if (player.getBoundsInParent().intersects(collect2.getBoundsInParent())){

    //}
    return taken;
  }*/

  public Rectangle createCollect() {
    int score = 0;
    Label label_score;

    Collectible col = new Collectible();
    Rectangle collect = col.collectible();
    space.getChildren().add(collect);
    label_score = new Label("Score is: " + score);
    label_score.setTranslateX(200);
    //space.getChildren().add(label_score);
    return collect;
  }


  public static void main(String[] args){

    launch(args);
  }
}
