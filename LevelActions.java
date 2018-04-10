
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public abstract class LevelActions extends Application {
	
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
	protected static Timeline timeline = new Timeline();
	protected ObservableList<Node> snake;
	protected static Stage primaryStage = new Stage();
	protected Stage primaryStage2 = new Stage();
	Rectangle head = new Rectangle(PLAYER_SIZE, PLAYER_SIZE);
	protected static boolean twoplayermode = false;
	protected ObservableList<Node> snake2;
	protected Direction direction2 = Direction.DOWN;
	protected boolean moved2 = false;
	protected int scoreChange = 10;
	protected boolean toRemove2;

	public LevelActions() {
		super();
	}

	public void restartGame() {
		stopGame();
		startGame();
	}
	
	public void stopGame() {
		running = false;
		timeline.stop();
		snake.clear();
		snake2.clear();
		//System.out.println("Time Elapsed: " + TimerS.getTotalTime());
	}
	
	/*
	 * puts the snake back to the top left of the screen to start again
	 */
	public void startGame() {
		direction = Direction.RIGHT;
		direction2 = Direction.DOWN;
		Rectangle head2 = new Rectangle(PLAYER_SIZE, PLAYER_SIZE);
		head.setFill(Color.rgb(241, 249, 12));
		head2.setFill(Color.rgb(0, 0, 0));
		head2.setLayoutY(40);
		snake.add(head);
		snake2.add(head2);
		timeline.play();
		this.running = true;	
	}
	//public abstract Scene run();
	
	public static void endGame() {
		timeline.stop();
		primaryStage.close();
		System.out.println("You win.");
		EndGame end = new EndGame();
		try {
			end.start(primaryStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}