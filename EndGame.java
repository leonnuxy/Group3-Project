import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
* Screen EndGame will appear when player finishes the game/dies. Give the option
to play again or to quit. Displays score from game played
*/
public class EndGame extends Application{

	public static boolean restart;

	@Override
	public void start(Stage primaryStage) throws Exception {
		TimerS.setEndTime(); //End time of current game
		
		/* Creation of the EndGame screen */
		Pane endGamePane = new Pane();
		Scene endGameScene = new Scene(endGamePane, 800 ,800);
		
		/* Creation of buttons and labels */
		Button playAgain = new Button("Play Again?");
		Button quit = new Button("Quit");
		Label deathLabel = new Label("You Died");
		
		//Creation of score which is the time survived multiplied by collectibles collected
		Label scoreLabel = new Label("Your Final Score is "+ Score.getScore() * TimerS.getTotalTime());
		
		/* EndGame BGM file usage. Creation of Media and playing of sound file */
		String diedSoundFile = "diedSound.mp3";     
		Media diedSoundMedia = new Media(new File(diedSoundFile).toURI().toString());
		MediaPlayer diedSoundPlayer = new MediaPlayer(diedSoundMedia);
		diedSoundPlayer.play();
		
		/* ButtonSound file usage. Creation of Media using the sound file */
		String buttonSoundFile = "buttonSound.mp3";     
		Media buttonSoundMedia = new Media(new File(buttonSoundFile).toURI().toString());
		
		/* Set size and position for the playAgain button */
		playAgain.setLayoutX(225);
		playAgain.setLayoutY(400);
		playAgain.setPrefSize(350, 50); 
		
		/* Set size and position for the quit button */
		quit.setLayoutX(225);
		quit.setLayoutY(500);
		quit.setPrefSize(350, 50); 
		
		/* Set size and position for the deathLabel label */
		deathLabel.setLayoutX(250);
		deathLabel.setLayoutY(200);
		deathLabel.setFont(new Font(70));
		
		/* Set size and position for the scoreLabel label */
		scoreLabel.setLayoutX(300);
		scoreLabel.setLayoutY(350);
		scoreLabel.setFont(new Font(20));
		
		/* Set font size and colour for buttons in menu */
        playAgain.setStyle("-fx-font-size: 4em;-fx-background-color: #4682b4 ");
		quit.setStyle("-fx-font-size: 4em;-fx-background-color: #ffff00  ");

		/* Add buttons and labels to settings screen */
		endGamePane.getChildren().addAll(playAgain, quit, deathLabel, scoreLabel);
		
		/* Set primaryStage scene to the endGame screen */
		primaryStage.setScene(endGameScene);
		primaryStage.show();
		
		/* Actions for playAgain button which changes the scene to the initial menu
		screen */
		playAgain.setOnAction(e -> {
			restart = true;
			primaryStage.close();
			Menu menu = new Menu();
			menu.start(primaryStage);
			
			// button sound played
			MediaPlayer buttonSoundPlayer = new MediaPlayer(buttonSoundMedia);
			buttonSoundPlayer.play();
			diedSoundPlayer.stop(); // stop endGame BGM
			
		});
		
		/* Actions for quit button which exits the application */
		quit.setOnAction(e -> {
			System.exit(0);
		});
		
	}

}
