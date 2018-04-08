import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;

public class Level extends Application{
	
	private static final int TILE_SIZE = 10;
	private static final double PLAYER_SIZE = 9.99;
	long timeStart;
	long timeEnd;
	private Direction direction = Direction.DOWN;
	private boolean moved = false;
	private boolean running = false;
	private double difficulty = 0.1;	
	private Timeline timeline = new Timeline();
	private ObservableList<Node> snake;
	private Stage primaryStage = new Stage();
	//private Stage primaryStage2;
	boolean setStage = false;

	
	public Parent createContent() {
		Pane root = new Pane();
		root.setStyle("-fx-background-image: url(Pane.png);");
		
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
		
		// make it start outside the page
		Rectangle slamUP = new Rectangle(99.98, 380);
		Rectangle slamDOWN = new Rectangle(99.98, 400);
		Rectangle slamUP1 = new Rectangle(99.98, 380);
		Rectangle slamDOWN1 = new Rectangle(99.98, 400);
		Rectangle slamMID = new Rectangle(39.98, 300);
		Line linemid = new Line(400, 200, 400, 600);
		Line line = new Line(600, 800, 600, 600);
		Line lineup = new Line(600, -100, 600, 200);
		Line line1 = new Line(200, 800, 200, 600);
		Line lineup1 = new Line(200, -100, 200, 200);
		int sec = 2;
		
		// Bottom Right
		PathTransition slamDown = new PathTransition();
		slamDown.setDuration(Duration.seconds(sec));
		slamDown.setNode(slamDOWN);
		slamDown.setPath(line);
		slamDown.setCycleCount(PathTransition.INDEFINITE);
		slamDown.setAutoReverse(true);
		slamDown.play();
		
		// Middle 
		PathTransition slamMid = new PathTransition();
		slamMid.setDuration(Duration.seconds(sec));
		slamMid.setNode(slamMID);
		slamMid.setPath(linemid);
		slamMid.setCycleCount(PathTransition.INDEFINITE);
		slamMid.setAutoReverse(true);
		slamMid.play();
		
		// Top Right
		PathTransition slamUp = new PathTransition();
		slamUp.setDuration(Duration.seconds(sec));
		slamUp.setNode(slamUP);
		slamUp.setPath(lineup);
		slamUp.setCycleCount(PathTransition.INDEFINITE);
		slamUp.setAutoReverse(true);
		slamUp.play();
		
		// Top Left
		PathTransition slamUp1 = new PathTransition();
		slamUp1.setDuration(Duration.seconds(sec));
		slamUp1.setNode(slamUP1);
		slamUp1.setPath(lineup1);
		slamUp1.setCycleCount(PathTransition.INDEFINITE);
		slamUp1.setAutoReverse(true);
		slamUp1.play();
		
		//Bottom Left
		PathTransition slamUp2 = new PathTransition();
		slamUp2.setDuration(Duration.seconds(sec));
		slamUp2.setNode(slamDOWN1);
		slamUp2.setPath(line1);
		slamUp2.setCycleCount(PathTransition.INDEFINITE);
		slamUp2.setAutoReverse(true);
		slamUp2.play();
		
		
		
		Label pos = new Label();
		root.getChildren().add(pos);
		root.getChildren().addAll(slamMID,slamDOWN1,slamUP1, slamUP, slamDOWN );
		root.getChildren().add(snakeBody);
		root.getChildren().add(rightBorder);
		root.getChildren().add(leftBorder);
		root.getChildren().add(bottomBorder);
		root.getChildren().add(topBorder);
		root.getChildren().add(col);
		
		root.setOnMouseMoved((evt) -> { 
			String pos1 = ("x = "+ evt.getX() +",  y = " + evt.getY());
			pos.setLayoutX(5);
			pos.setText(pos1);
			pos.setLayoutY(5);		} );
		
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
			
			if (Score.getScore() == 1) {
				setStage = true;
				LevelTwoPlayers level2 = new LevelTwoPlayers();
				primaryStage.setScene(level2.run());
				
			}

			
		});
		
		timeline.getKeyFrames().add(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		return root;
	}
	
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
		Scene scene = new Scene(createContent());
		
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
		if (setStage) {
			LevelTwoPlayers level2 = new LevelTwoPlayers();
			level2.start(primaryStage);
		}
		primaryStage.setTitle("Snake");
		primaryStage.setScene(run());
		primaryStage.show();
		startGame();
		
	}
}