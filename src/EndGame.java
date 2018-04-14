import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
		Button save = new Button("Save");
		TextField textField = new TextField("Enter Name ");
		Button scores = new Button("Scores Board");
		
		scores.setLayoutX(550);
		scores.setLayoutY(0);
		scores.setFont(new Font(30));

		
		//Creation of score which is the time survived multiplied by collectible collected
		Score.setFinalScore(Score.getScore() * TimerS.getTotalTime());
		Label scoreLabel = new Label("Your Final Score is "+ Score.getFinalScore());
		
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
		
		/* Set size and layout*/
		textField.setPrefSize(150, 50);
		textField.setLayoutX(350);
		textField.setLayoutY(100);
		save.setPrefSize(50,50);
		save.setLayoutX(350);
		save.setLayoutY(150);
		
		File scoreFile = new File("scores.txt");
		save.setOnAction(e -> {
			Score.setName(textField.getText());
			FileWriter fileWriter = null;
			PrintWriter writeScore = null;
			Scanner scanFile;

			try {
				if (scoreFile.exists()) {
					scanFile = new Scanner(scoreFile);
					/* if the file has a text in it. */
					if (scanFile.hasNext()) {
						fileWriter = new FileWriter(scoreFile,true);
						writeScore = new PrintWriter(fileWriter);
						writeScore.println("\n");
						writeScore.print(Score.getName()+" "+Score.getFinalScore());
						writeScore.close();
						fileWriter.close();
					}
					/* if there is no text in the file write to the file */
					else {
						fileWriter = new FileWriter(scoreFile,true);
						writeScore = new PrintWriter(fileWriter);
						writeScore.println("Scores");
						writeScore.println("\n");
						writeScore.print(Score.getName()+" "+Score.getFinalScore());
					}
					
					scanFile.close();
				}
				
			} catch (FileNotFoundException e1) {
				System.out.println("File Error Check Your File Path");
			}  catch (IOException e1) {
				System.out.print("File Error Occured");
			}
			
			endGamePane.getChildren().removeAll(textField, save);
			endGamePane.getChildren().add(scores);
			
			
		});
		
		scores.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			Desktop desktop = Desktop.getDesktop();
			if (scoreFile.exists())
				try {
					desktop.open(scoreFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		);
		
		
		
		/* Set font size and colour for buttons in menu */
        playAgain.setStyle("-fx-font-size: 4em;-fx-background-color: #4682b4 ");
		quit.setStyle("-fx-font-size: 4em;-fx-background-color: #ffff00  ");

		/* Add buttons and labels to settings screen */
		endGamePane.getChildren().addAll(playAgain, quit, deathLabel, scoreLabel, textField, save);
		
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
