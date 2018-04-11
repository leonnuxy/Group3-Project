
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
		head = snakeIns.getHead();
		head2 = snakeIns.getHead();
		head.setFill(Color.rgb(241, 249, 12));
		head2.setFill(Color.rgb(0, 0, 0));
		head2.setLayoutY(40);
		snake.add(head);
		snake2.add(head2);
		endGame = false;
		timeline.play();
		running = true;
	}
	//public abstract Scene run();

	public void endGame() {
		timeline.stop();
		primaryStage.close();
		System.out.println("You win.");
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
