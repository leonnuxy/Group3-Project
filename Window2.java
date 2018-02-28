import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.animation.AnimationTimer;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.animation.*;
import javafx.scene.input.KeyCode;

public class Window2 extends Application {
    
    private int row;
    private int column;
    //Rectangle rect = new Rectangle(50, 50, 20, 20);

    @Override
    public void start(Stage primaryStage) {
        
        //Pane root = new Pane();
        Scene scene = new Scene(game(), 600, 600);
        //Canvas canvas = new Canvas(500, 500);
        //GraphicsContext gc = canvas.getGraphicsContext2D();
        
        //root.getChildren().add(canvas);
        //root.getChildren().add(rect);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public Pane game() {
        Pane root = new Pane();
        Rectangle rect = new Rectangle(50, 50, 20, 20);
        root.getChildren().add(rect);
        Button controls = new Button();
        controls.relocate(-50, 0);
        root.getChildren().add(controls);
        controls.setOnKeyPressed(event->{
            boolean count = true;
            //while (count == true){
                if (event.getCharacter().charAt(0) == 'q') {
                    System.exit(0);
                    count = false;
                }
                
                if (event.getCode()== KeyCode.UP) {
                    row = row - 1;
                    rect.setTranslateY(-1.2);
                    System.out.println("up" + row);
                }
                
                if (event.getCode() == KeyCode.DOWN) {
                    row = row + 1;
                    rect.setTranslateY(1.2);
                    System.out.println("down" + row);
                }
                
                if (event.getCode() == KeyCode.LEFT) {
                    column = column - 1;
                    rect.setTranslateX(-1.2);
                    System.out.println("left" + column);
                }
                
                if (event.getCode() == KeyCode.RIGHT) {
                    column = column + 1;
                    rect.setTranslateX(1.2);
                    System.out.println("right" + column);
                }
            //}
        });
        return root;
        //AnimationTimer animate = new AnimationTimer() {
          //  public void handle(long arg0) {
                
           // }
        //};
        //animate.start();
        //return root;
    }
        
    
    public static void main (String[] args) {
        launch(args);
    }
}
