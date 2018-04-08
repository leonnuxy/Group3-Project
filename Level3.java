import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Level3 extends Application {
	
	private static final int TILE_SIZE = 10;
	private static final double PLAYER_SIZE = 9.99;
	private static final int APP_W = 800;
	private static final int APP_H = 800;
	long timeStart;
	long timeEnd;
	private Direction direction = Direction.DOWN;
	private boolean moved = false;
	private boolean running = false;
	private double difficulty = 0.1;	
	private Timeline timeline = new Timeline();
	private ObservableList<Node> snake;
	private Stage primaryStage = new Stage();
	private Stage primaryStage2 = new Stage();

	
	public void restartGame() {
		stopGame();
		startGame();
	}
	
	public void stopGame() {
		timeEnd = TimerS.getTime();
		running = false;
		timeline.stop();
		snake.clear();
		System.out.println("Time Elapsed: " + TimerS.getTotalTime(timeStart, timeEnd));
	}
	
	/*
	 * puts the snake back to the top left of the screen to start again
	 */
	public void startGame() {
		timeStart = TimerS.getTime();
		direction = Direction.RIGHT;
		Rectangle head = new Rectangle(PLAYER_SIZE, PLAYER_SIZE);
		head.setFill(Color.rgb(241, 249, 12));
		snake.add(head);
		timeline.play();
		running = true;
	}
	
	/*
	 * responsible for moving the snake head
	 */
	public Scene run() {
		Pane root = new Pane();
		root.setStyle("-fx-background-image: url(Pane.png);");
		root.setPrefSize(APP_W, APP_H);
		
		Rectangle rectTop = new Rectangle(200, 0, 400, 150);
		rectTop.setFill(Color.RED);
		
		// Done
		Rectangle rectTopRight = new Rectangle(700, 0, 100, 100);
		rectTopRight.setFill(Color.RED);
		
		// Done
		Rectangle rectRight = new Rectangle(650, 200, 150, 400);
		rectRight.setFill(Color.RED);
		
		// Done
		Rectangle rectBottRight = new Rectangle(700, 700, 100, 100);
		rectBottRight.setFill(Color.RED);
		
		// Done
		Rectangle rectBott = new Rectangle(200, 650, 400, 150);
		rectBott.setFill(Color.RED);
		
		// Done
		Rectangle rectBottLeft = new Rectangle(0, 700, 100, 100);
		rectBottLeft.setFill(Color.RED);
		
		// Done
		Rectangle rectLeft = new Rectangle(0, 200, 150, 400);
		rectLeft.setFill(Color.RED);
		
		// Done
		Rectangle rectCen = new Rectangle(300, 350, 200, 100);
		rectCen.setFill(Color.RED);
		
		Group snakeBody = new Group();
		snake = snakeBody.getChildren();
		Collectible aCol = new Collectible(50,50);
		Rectangle col = aCol.getCol();
		Obstacle borderRight = new Obstacle(801,0,1,800);
		Rectangle rightBorder = borderRight.getObs();
		Obstacle borderLeft = new Obstacle(-2,0,1,800);
		Rectangle leftBorder = borderLeft.getObs();
		Obstacle borderBottom = new Obstacle(0,801,800,1);
		Rectangle bottomBorder = borderBottom.getObs();
		Obstacle borderTop = new Obstacle(0,-2,800,1);
		Rectangle topBorder = borderTop.getObs();
		
		root.getChildren().addAll(rectTop, rectCen, rectBott, 
				rectRight, rectLeft, rectBottRight, rectBottLeft, rectTopRight);
		root.getChildren().add(snakeBody);
		root.getChildren().add(rightBorder);
		root.getChildren().add(leftBorder);
		root.getChildren().add(bottomBorder);
		root.getChildren().add(topBorder);
		root.getChildren().add(col);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(difficulty), event ->{
			if (!running)
				return;
			
			boolean toRemove = snake.size()>1;
			Node tail = toRemove ? snake.remove(snake.size()-1) : snake.get(0);
			double tailX = tail.getTranslateX();
			double tailY = tail.getTranslateY();
			switch (direction) {
				case UP:
					tail.setTranslateX(snake.get(0).getTranslateX());
					tail.setTranslateY(snake.get(0).getTranslateY() - TILE_SIZE);
					break;
				case DOWN:
					tail.setTranslateX(snake.get(0).getTranslateX());
					tail.setTranslateY(snake.get(0).getTranslateY() + TILE_SIZE);
					break;
				case LEFT:
					tail.setTranslateX(snake.get(0).getTranslateX() - TILE_SIZE);
					tail.setTranslateY(snake.get(0).getTranslateY());
					break;
				case RIGHT:
					tail.setTranslateX(snake.get(0).getTranslateX() + TILE_SIZE);
					tail.setTranslateY(snake.get(0).getTranslateY() );
				
			}
			if (toRemove)
				snake.add(0, tail);
			moved = true;
			for (Node rect: snake) {				
				if (rect != tail && tailX == rect.getTranslateX() && tailY == rect.getTranslateY()) {
					restartGame();
				}
			}
			if (snakeBody.getBoundsInParent().intersects(rightBorder.getBoundsInParent()) || 
					snakeBody.getBoundsInParent().intersects(leftBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(bottomBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
				restartGame();
				//System.out.println("Time Elapsed: " + TimerS.getTotalTime(timeStart, timeEnd));
			}
			
			/*if (snakeBody.getBoundsInParent().intersects(slamDOWN.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(slamUP.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(slamDOWN1.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(slamUP1.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(slamMID.getBoundsInParent())) {
				restartGame();
				//System.out.println("Time Elapsed: " + TimerS.getTotalTime(timeStart, timeEnd));
			}
			
			/* collision with collectible */
			if (tail.getBoundsInParent().intersects(col.getBoundsInParent())){
				aCol.setXPos();
				aCol.setYPos();
				col.relocate(aCol.getXPos(), aCol.getYPos());       
				col.getBoundsInParent();
				root.getChildren().remove(col);
				root.getChildren().add(col);
				
				Rectangle rect = new Rectangle(TILE_SIZE, TILE_SIZE);
				rect.setFill(Color.rgb(241, 249, 12));
				rect.setTranslateX(tailX);
				rect.setTranslateY(tailY);
				Score.setScore(1);
				snake.add(rect);
	
			}
			/*if (obs.getBoundsInParent().intersects(col.getBoundsInParent())) {
				aCol.setXPos();
				aCol.setYPos();
				col.relocate(aCol.getXPos(), aCol.getYPos()); 
			}
			if (col.getBoundsInParent().intersects(obs.getBoundsInParent())) {
				aCol.setXPos();
				aCol.setYPos();
				col.relocate(aCol.getXPos(), aCol.getYPos()); 
			}
			if (tail.getBoundsInParent().intersects(tail2.getBoundsInParent())) {
				restartGame();
			}*/
			
			if (Score.getScore() == 3) {
				primaryStage.close();
				System.out.println("Yes");
				LevelTwoPlayers level2players = new LevelTwoPlayers();
				primaryStage2.setScene(level2players.run());
				primaryStage2.show();
				level2players.startGame();
				stopGame();
			}

			
		});
		
		timeline.getKeyFrames().add(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		Scene scene = new Scene(root);
		
		scene.setOnKeyPressed(event -> {
			if (!moved)
				return;

		    if (moved) {
			switch (event.getCode()) {
				case UP:
					if (direction != Direction.DOWN)
						direction = Direction. UP;
					break;
				case DOWN:
					if (direction != Direction.UP)
						direction = Direction.DOWN;
					break;
				case LEFT:
					if (direction != Direction.RIGHT)
						direction = Direction.LEFT;
					break;
				case RIGHT:
					if (direction != Direction.LEFT)
						direction = Direction.RIGHT;
					break;
			default:
				break;
			}
		}
		
		moved = false;	
	});
		
		return scene;
	
	}

	@Override
	public void start(Stage primaryStage){
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Snake");
		primaryStage.setScene(run());
		primaryStage.show();
		startGame();
		
	}
}