import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.*;

public class Window3 extends Application{
    boolean R = false;
    boolean L = false;
    boolean U = false;
    boolean D = false;
    double rectX=0;
    double rectY=0;
    
    //Starts the window
    public void start(Stage primaryStage){
        Group space = new Group();
        Scene scene=new Scene(play(), 600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //Produces the shape to move and the controls
    public Group play(){
        Group space = new Group();
        
        Rectangle rect =new Rectangle(50, 50, 20, 20);
        space.getChildren().add(rect);
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

