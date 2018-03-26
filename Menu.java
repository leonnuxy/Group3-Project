import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/*
 * Make a simple menu with a start and quit button for the user to use.
 */
public class Menu extends Application{
	
	//A new stage for the game
	//private Stage aPrimaryStage = new Stage();
	
	/*
	 * Start the menu as a pane
	 */
	@Override
	public void start(Stage aPrimaryStage) {
		aPrimaryStage.setTitle("Python");
		Pane menuPane = new Pane();
		Scene menuScene = new Scene(menuPane, 800, 800);
		
		//create the buttons for the person to see
		Button start = new Button("START");
		Button quit = new Button("QUIT");
		
		//set size and position for the start button
		start.setLayoutX(225);
		start.setLayoutY(200);
		start.setPrefSize(350, 175); 
		
		//set size and position for the quit button
		quit.setLayoutX(225);
		quit.setLayoutY(400);
		quit.setPrefSize(350, 175);
		
		//Refer to javafx CSS for method
        start.setStyle("-fx-font-size: 4em;-fx-background-color: #00ff00 ");
		quit.setStyle("-fx-font-size: 4em;-fx-background-color: #00ff00  ");
		
		menuPane.getChildren().add(start);
		menuPane.getChildren().add(quit);
		
		aPrimaryStage.setScene(menuScene);
		aPrimaryStage.show();
		
		//actions for the quit button
		quit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			System.exit(0);
			}
		}
		);
		
		//actions fot the start button, if the start button is clicked, start the game.
		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
		import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;


/*
 * Make a simple menu with a start and quit button for the user to use.
 */
public class Menu extends Application{
	
	//A new stage for the game
	//private Stage aPrimaryStage = new Stage();
	
	/*
	 * Start the menu as a pane
	 */
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Python");
		Pane menuPane = new Pane();
		Scene menuScene = new Scene(menuPane, 800, 800);
		
		Pane settingsPane = new Pane();
		Scene settingsScene = new Scene(settingsPane, 800, 800);
		
		
		//create the buttons for the person to see
		Button start = new Button("START");
		Button quit = new Button("QUIT");
		Button settings = new Button("SETTINGS");
		Label welcomeCaption = new Label("Welcome to Python!");
		
		//set size and position for the start button
		start.setLayoutX(225);
		start.setLayoutY(275);
		start.setPrefSize(350, 100); 
		
		//set size and position for the settings button
		settings.setLayoutX(225);
		settings.setLayoutY(400);
		settings.setPrefSize(350, 100);

		//set size and position for the quit button
		quit.setLayoutX(225);
		quit.setLayoutY(525);
		quit.setPrefSize(350, 100);
		
		//Refer to javafx CSS for method
        start.setStyle("-fx-font-size: 4em;-fx-background-color: #00ff00 ");
		quit.setStyle("-fx-font-size: 4em;-fx-background-color: #00ff00  ");
		settings.setStyle("-fx-font-size: 4em;-fx-background-color: #00ff00  ");
		
		menuPane.getChildren().add(start);
		menuPane.getChildren().add(quit);
		menuPane.getChildren().add(settings);
		
		primaryStage.setScene(menuScene);
		primaryStage.show();
		
		//actions for the quit button
		quit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			System.exit(0);
			}
		}
		);
		
		//actions fot the start button, if the start button is clicked, start the game.
		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			GameApp game = new GameApp();
			game.start(primaryStage);

			}
		}
		);
		
		
		settings.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			primaryStage.setScene(settingsScene);
	

			}
		}
		);
		
		
		
		
		

	}

}	GameApp game = new GameApp();
			game.start(aPrimaryStage);

			}
		}
		);
		
		

	}

}
