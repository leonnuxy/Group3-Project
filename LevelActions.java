
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
	protected Stage primaryStage = new Stage();
	protected Stage primaryStage2 = new Stage();
	Rectangle head = new Rectangle(PLAYER_SIZE, PLAYER_SIZE);

	public LevelActions() {
		super();
	}

	public void restartGame() {
		stopGame();
		startGame();
	}

	public void stopGame() {
		//timeEnd = TimerS.getTime();
		running = false;
		timeline.stop();
		snake.clear();
		//primaryStage.close();
		
		//System.out.println("Time Elapsed: " + TimerS.getTotalTime());
	}

	public void startGame() {
		//timeStart = TimerS.getTime();
		direction = Direction.RIGHT;
		head.setFill(Color.rgb(241, 249, 12));
		snake.add(head);
		this.timeline.play();
		this.running = true;
	}
	//public abstract Scene run();
	
	public void endGame() {
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