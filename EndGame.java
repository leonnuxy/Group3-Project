import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * End game screen for a game of snake that displays score and gives a restart option
 * @author MyPrecious
 *
 */
public class EndGame extends Application{

	//boolean for restarting some key aspects in LevelActions Class
	public static boolean restart;

	
	/*
	 * This method runs the end game screen
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create the pan to put things on
		Pane root = new Pane();
		
		//Create the buttons
		Button butt = new Button("Play Again");
		Button butt2 = new Button("Quit");
		// set button positions
		butt.setLayoutX(100);
		butt.setLayoutY(150);
		butt2.setLayoutX(200);
		butt2.setLayoutY(150);
		
		//set the end time when the end game screen is triggered
		TimerS.setEndTime();
		Label lab = new Label("Your Final Score is "+ Score.getScore() * TimerS.getTotalTime());
		lab.setLayoutX(10);
		lab.setLayoutY(200/2);
		//add the buttons and labels to the screen
		root.getChildren().addAll(butt, butt2, lab);
		Scene newScene = new Scene(root, 300,300, Color.RED);
		primaryStage.setScene(newScene);
		primaryStage.show();
		
		//set an action for the button to restart from the main menu
		butt.setOnAction(e -> {
			restart = true;
			primaryStage.close();
			Menu menu = new Menu();
			menu.start(primaryStage);
		});
		
		//exit button that ends the program
		butt2.setOnAction(e -> {
			System.exit(0);
		});
		
	}

}
