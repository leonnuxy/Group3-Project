import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * Menu which starts the game. Contains quit, start and selection of game difficulty
 */
public class Menu extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		
		/* Creation of initial menu screen */
		primaryStage.setTitle("Python");
		Pane menuPane = new Pane();
		Scene menuScene = new Scene(menuPane, 800, 800);
		
		/* Creation of the settings screen */
		Pane settingsPane = new Pane();
		Scene settingsScene = new Scene(settingsPane, 800, 800);
		
		/* Menu BGM (music) file usage. Creation of Media and playing of sound file */
		String menuBGMFile = "menuBGM.mp3";     
		Media menuBGMMedia = new Media(new File(menuBGMFile).toURI().toString());
		MediaPlayer menuBGMPlayer = new MediaPlayer(menuBGMMedia);
		menuBGMPlayer.play();
		
		/* ButtonClick SoundEffect file usage. Creation of Media using sound file */
		String buttonSoundFile = "buttonSound.mp3";     
		Media buttonSoundMedia = new Media(new File(buttonSoundFile).toURI().toString());
		
		/* Creation of the buttons for menu */
		Button start = new Button("START");
		Button quit = new Button("QUIT");
		Label welcomeCaption = new Label("Welcome to Python!");
		
		/* Set size and position for the start button */
		start.setLayoutX(225);
		start.setLayoutY(400);
		start.setPrefSize(350, 75); 
		
		/* Set size and position for the quit button */
		quit.setLayoutX(225);
		quit.setLayoutY(500);
		quit.setPrefSize(350, 75);
		
		/* Set size and position for the label welcomeCaption */
		welcomeCaption.setLayoutX(75);
		welcomeCaption.setLayoutY(200);
		welcomeCaption.setFont(new Font(70));
		
		/* Set colour for buttons in menu */
        start.setStyle("-fx-font-size: 4em;-fx-background-color: #4682b4 ");
		quit.setStyle("-fx-font-size: 4em;-fx-background-color: #ffff00  ");

		/* Add all buttons and label to the intial menu screen */
		menuPane.getChildren().add(start);
		menuPane.getChildren().add(quit);
		menuPane.getChildren().add(welcomeCaption);
		
		/* set the scene of primaryStage to the initial menu screen */
		primaryStage.setScene(menuScene);
		primaryStage.show();
		
		/* Create buttons and label for settings screen */
		Label chooseDiff = new Label("Choose Difficulty");
		Button easyDiff = new Button("Easy");
		Button mediumDiff = new Button("Medium");
		Button hardDiff = new Button("Hard");
		Button backtoMenu = new Button("Back");
		
		/* Set size and position for the easyDiff button */
		easyDiff.setLayoutX(225);
		easyDiff.setLayoutY(400);
		easyDiff.setPrefSize(350, 75); 
		
		/* Set size and position for the mediumDiff button */
		mediumDiff.setLayoutX(225);
		mediumDiff.setLayoutY(500);
		mediumDiff.setPrefSize(350, 75);
		
		/* Set size and position for the hardDiff button */
		hardDiff.setLayoutX(225);
		hardDiff.setLayoutY(600);
		hardDiff.setPrefSize(350, 75);
		
		/* Set size and position for the chooseDiff label */
		chooseDiff.setLayoutX(125);
		chooseDiff.setLayoutY(200);
		chooseDiff.setFont(new Font(70));
		
		/* Set size and position for the chooseDiff label */
		backtoMenu.setLayoutX(650);
		backtoMenu.setLayoutY(50);
		backtoMenu.setPrefSize(125, 75);
		
		/* Addition buttons and labels to settings screen */
		settingsPane.getChildren().add(easyDiff);
		settingsPane.getChildren().add(mediumDiff);
		settingsPane.getChildren().add(hardDiff);
		settingsPane.getChildren().add(chooseDiff);
		settingsPane.getChildren().add(backtoMenu);
		
		/* Set font size and colour for buttons in settings */
        easyDiff.setStyle("-fx-font-size: 4em;-fx-background-color: #4682b4 ");
		mediumDiff.setStyle("-fx-font-size: 4em;-fx-background-color: #4682b4  ");
		hardDiff.setStyle("-fx-font-size: 4em;-fx-background-color: #4682b4 ");
		backtoMenu.setStyle("-fx-font-size: 4em;-fx-background-color: #ffff00 ");
		
		/* Actions for the quit button, exits the application */
		quit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			System.exit(0);
			}
		}
		);
		
		/* Actions for the start button, which changes menu scene to the settingsScene. */
		start.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			primaryStage.setScene(settingsScene);
			
			// button sound played 
			MediaPlayer buttonSoundPlayer = new MediaPlayer(buttonSoundMedia);
			buttonSoundPlayer.play();

			}
		}
		);
		
		/* Actions for backtoMenu button which returns current scene to the initial menu scene */
		backtoMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			primaryStage.setScene(menuScene);
			
			// button sound played 
			MediaPlayer buttonSoundPlayer = new MediaPlayer(buttonSoundMedia);
			buttonSoundPlayer.play();

			}
		}
		);
		
		/* Actions for easyDiff button which creates a game on an easy difficulty/speed 
		starting on level 1. Game is loaded onto primaryStage and played */
		easyDiff.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Score.initScore();
				Difficulty.setDifficulty(0.1);
				Level game = new Level();
				TimerS.setStartTime(); //start timer on game 
				game.start(primaryStage);
				
				// button sound played
				MediaPlayer buttonSoundPlayer = new MediaPlayer(buttonSoundMedia);
				buttonSoundPlayer.play();
				menuBGMPlayer.stop(); //stop Menu BGM
				
			}
		}
		);
		
		/* Actions for mediumDiff button which creates a game on an medium difficulty/speed 
		starting on Level1. Game is loaded onto primaryStage and played */
		mediumDiff.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Score.initScore();
				Difficulty.setDifficulty(0.075);
				Level game = new Level();
				TimerS.setStartTime(); //start timer on game
				game.start(primaryStage);
				
				// button sound played
				MediaPlayer buttonSoundPlayer = new MediaPlayer(buttonSoundMedia);
				buttonSoundPlayer.play();
				menuBGMPlayer.stop(); //stop Menu BGM
				
			}
		}
		);
		
		/* Actions for hardDiff button which creates a game on an hard difficulty/speed 
		starting on level 1. Game is loaded onto primaryStage and played */
		hardDiff.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Score.initScore();
				Difficulty.setDifficulty(0.05);
				Level game = new Level();
				TimerS.setStartTime(); //start timer on game
				game.start(primaryStage);
				
				// button sound played 
				MediaPlayer buttonSoundPlayer = new MediaPlayer(buttonSoundMedia);
				buttonSoundPlayer.play();
				menuBGMPlayer.stop(); //stop Menu BGM
				
			}
		}
		);
			

	}

}
