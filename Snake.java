import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Snake extends Application{
    boolean Right=false;
    boolean Left=false;
    boolean Up=false;
    boolean Down=false;
    //Controls
    double snakeX=0;
    double snakeY=0;
    //Tail
    double t1X=0;
    double t1Y=0;
    double locationX=0;
    double locationY=0;

    public void start(Stage primaryStage){
        Pane pane=new Pane();
        Scene scene=new Scene(game(),800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.show();
    }

    public Pane game(){
        Pane pane=new Pane();
    //Character
        Circle snake=new Circle(400,300,8);
        snake.setFill(Color.BLUE);
        pane.getChildren().add(snake);
    //Tails
        Circle t1=new Circle(416,300,8);
        t1.setFill(Color.BLUE);
        pane.getChildren().add(t1);
    //Pickup
        int a=(int)(Math.random()*(780-1)+1);
        int b=(int)(Math.random()*(580-1)+1);
        Circle p1=new Circle(a,b,8);
        pane.getChildren().add(p1);
    //Controls
        Button controls=new Button();
        controls.relocate(-100, 200);
        pane.getChildren().add(controls);
        controls.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.RIGHT){
                Right=true;
                Left=false;
                Up=false;
                Down=false;
                locationX=snakeX;
                locationY=snakeY;
            }
            if(e.getCode()==KeyCode.LEFT){
                Left=true;
                Right=false;
                Down=false;
                Up=false;
                locationX=snakeX;
                locationY=snakeY;
            }
            if(e.getCode()==KeyCode.UP){
                Left=false;
                Right=false;
                Up=true;
                Down=false;
            }
            if(e.getCode()==KeyCode.DOWN){
                Right=false;
                Left=false;
                Down=true;
                Up=false;
            }
        });
    //Animation
        AnimationTimer animate=new AnimationTimer(){
            public void handle(long arg0) {
                if(Right){
                    snakeX+=1.2;
                    snake.setTranslateX(snakeX);
                    t1X+=1.2;
                    t1.setTranslateX(t1X);
                }
                if(Left){
                    snakeX-=1.2;
                    snake.setTranslateX(snakeX);
                    t1X-=1.2;
                    t1.setTranslateX(t1X);
                }
                if(Up){
                    snakeY-=1.2;
                    snake.setTranslateY(snakeY);
                    t1Y-=1.2;
                    t1.setTranslateY(t1Y);
                }
                if(Down){
                    snakeY+=1.2;
                    snake.setTranslateY(snakeY);
                    t1Y+=1.2;
                    t1.setTranslateY(t1Y);
                }
            //Get Items
                if(snake.getBoundsInParent().intersects(p1.getBoundsInParent())){
                    int a=(int)(Math.random()*(780-1)+1);
                    int b=(int)(Math.random()*(580-1)+1);
                    p1.relocate(a, b);
                //Tail

                }
            }
        };
        animate.start();


        return pane;
    }
    public static void main(String[] args){
        launch(args);
    }


}