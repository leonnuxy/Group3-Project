import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * parent class of all levels that holds some important static variables and performs tasks that are consistent across all the Levels
 * @author MyPrecious
 *
 */
public abstract class LevelActions extends Application {

	//Initialise all instance variables
	protected static final int TILE_SIZE = 10;
	protected static final double PLAYER_SIZE = 9.99;
	protected static final int APP_W = 800;
	protected static final int APP_H = 800;
	long timeStart;
	long timeEnd;
	int score = Score.getScore();
	protected Direction direction;
	protected boolean moved = false;
	protected boolean running = false;
	protected double difficulty = Difficulty.getDifficulty();
	protected Timeline timeline = new Timeline();
	protected ObservableList<Node> snake;
	protected ObservableList<Node> snake2;
	protected Stage primaryStage = new Stage();
	protected Stage primaryStage2 = new Stage();
	protected static Rectangle head;
	protected static Rectangle head2;
	protected static boolean twoplayermode = false;
	protected Direction direction2;
	protected boolean moved2 = false;
	protected int scoreChange = 1;
	protected boolean toRemove2;
	public static boolean endGame = false;
	protected Snake snakeIns = new Snake();
	
	// default constructor
	public LevelActions() {
		super();
	}
	
	/*
	 * restart game, mostly for testing purposes
	 */
	public void restartGame() {
		stopGame();
		startGame();
	}

	/*
	 * set the running value to stop and exit the KekyFrame so there is no animation on screen and clear the snakes from the screen
	 */
	public void stopGame() {
		running = false;
		timeline.stop();
		snake.clear();
		snake2.clear();
	}

	/*
	 * puts the snake back to the top left of the screen to start again
	 */
	public void startGame() {
		if (EndGame.restart) {
			snake.clear();
			snake2.clear();
		}
		//initiailze the direction of the snakes when the game starts
		direction = Direction.RIGHT;
		direction2 = Direction.DOWN;
		
		//create the head of the snakes
		head = Snake.getHead();
		head2 = Snake.getHead();
		
		//set the colour of the snakes
		head.setFill(Color.rgb(241, 249, 12));
		head2.setFill(Color.rgb(0, 0, 0));
		head2.setLayoutY(40);
		
		//add the head to the body
		snake.add(head);
		snake2.add(head2);
		endGame = false;
		
		//start the timeline
		timeline.play();
		running = true;
	}

	/*
	 * triggered when the game ends to create a play again screen after all functions are stopped
	 */
	public void endGame() {
		timeline.stop();
		primaryStage.close();
		twoplayermode = false;
		EndGame end = new EndGame();
		try {
			end.start(primaryStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
