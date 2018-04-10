import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * runs a game of snake
 *
 */
public class LevelTwoPlayers extends LevelActions {
	
	//Instance variables
	private static final int TILE_SIZE = 10;
	private static final double PLAYER_SIZE = 9.99;
	private static final int APP_W = 800;
	private static final int APP_H = 800;
	
	Snake2 sn = new Snake2();
	long timeStart;
	long timeEnd;
	private Direction direction = Direction.RIGHT;
	private Direction direction2 = Direction.DOWN;
	private boolean moved = false;
	private boolean moved2 = false;
	private boolean running = false;
	
	private Timeline timeline = new Timeline();
	//private Game game;
	//game = new Game(GAME_SIZE);
	// game.getSnake().getBody();
	
	//private ObservableList<Node> snake = sn.getSnake();
	private ObservableList<Node> snake;
	private ObservableList<Node> snake2;
	
	/*
	 * Creates and adds the objects to the screen and is responsible for all collisions and everything that
	 * happens on screen
	 */
		
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
		Rectangle head = new Rectangle(PLAYER_SIZE, PLAYER_SIZE);
		head.setFill(Color.rgb(241, 249, 12));
		head.setLayoutX(40);
		Rectangle head2 = new Rectangle(PLAYER_SIZE, PLAYER_SIZE);
		snake.add(head);
		snake2.add(head2);
		timeline.play();
		running = true;
	}
	
	/*
	 * responsible for moving the snake head
	 */
	/*public Scene run() {
		
		
		return scene;
	
	}*/
	
	/*
	 * start the show
	 */
	@Override
	public void start(Stage primaryStage){
		Pane root = new Pane();
		root.setStyle("-fx-background-image: url(Pane.png);");
		root.setPrefSize(APP_W, APP_H);
		
	    Group snakeBody = new Group();
		snake = snakeBody.getChildren();
		
		Group snakeBody2 = new Group();
		snake2 = snakeBody2.getChildren();
		
		Obstacle anObs = new Obstacle(391, 21, 8, 758);
		Rectangle obs = anObs.getObs();
		obs.setFill(Color.RED);
		Obstacle movingObs = new Obstacle();
		Rectangle movObs = movingObs.getObs();
		movObs.setFill(Color.GREEN);
		//Path path = new Path();
		
		//Portal aPortal = new Portal();
		//Rectangle port = aPortal.makePortal();
		
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
		
		root.getChildren().add(snakeBody);
		root.getChildren().add(rightBorder);
		root.getChildren().add(leftBorder);
		root.getChildren().add(bottomBorder);
		root.getChildren().add(topBorder);
		root.getChildren().add(snakeBody2);
		root.getChildren().add(obs);
		root.getChildren().add(movObs);
		root.getChildren().add(col);
		
		//Starting position of movement path
		/*PATH path.getElements().add(new MoveTo(20,20));
		path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
		path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
		PathTransition pathTransition = new PathTransition();
		
		//Greater this value the slower it moves
		pathTransition.setDuration(Duration.millis(5000));
		pathTransition.setPath(path);
		pathTransition.setNode(movObs);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		//Make it go back and forth
		pathTransition.setAutoReverse(true);
		pathTransition.play();END PATH*/
		
		KeyFrame frame = new KeyFrame(Duration.seconds(difficulty), event ->{
			if (!running)
				return;
			
			boolean toRemove = snake.size()>1;
			boolean toRemove2 = snake2.size()>1;
			
			Node tail = toRemove ? snake.remove(snake.size()-1) : snake.get(0);
			Node tail2 = toRemove2 ? snake2.remove(snake2.size()-1) : snake2.get(0);
			
			double tailX = tail.getTranslateX();
			double tailY = tail.getTranslateY();
			double tail2X = tail2.getTranslateX();
			double tail2Y = tail2.getTranslateY();
			
			// handles the direction of the tail relative to the head
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
			//sn.tailDirection();
			
			if (toRemove)
				snake.add(0, tail);
			moved = true;
			
			switch (direction2) {
			case UP:
				tail2.setTranslateX(snake2.get(0).getTranslateX());
				tail2.setTranslateY(snake2.get(0).getTranslateY() - TILE_SIZE);
				break;
			case DOWN:
				tail2.setTranslateX(snake2.get(0).getTranslateX());
				tail2.setTranslateY(snake2.get(0).getTranslateY() + TILE_SIZE);
				break;
			case LEFT:
				tail2.setTranslateX(snake2.get(0).getTranslateX() - TILE_SIZE);
				tail2.setTranslateY(snake2.get(0).getTranslateY());
				break;
			case RIGHT:
				tail2.setTranslateX(snake2.get(0).getTranslateX() + TILE_SIZE);
				tail2.setTranslateY(snake2.get(0).getTranslateY() );
			
		}
		
		moved2 = true;
			
		if (toRemove2)
			snake2.add(0, tail2);
			
		/** first snake collisions */
			/* collision with self */
			for (Node rect: snake) {				
				if (rect != tail && tailX == rect.getTranslateX() && tailY == rect.getTranslateY()) {
					restartGame();
					break;
				}
			}
			
			/* collision with window border */
			/*if (tail.getTranslateX() < 0 || tail.getTranslateX() >= APP_W
				|| tail.getTranslateY() < 0 || tail.getTranslateY() >= APP_H) {
				restartGame();
			}*/
			
			if (snakeBody.getBoundsInParent().intersects(rightBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(leftBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(bottomBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
				
				//System.out.println("Time Elapsed: " + TimerS.getTotalTime(timeStart, timeEnd));
			}
			
			if(snakeBody.getBoundsInParent().intersects(movObs.getBoundsInParent())) {
				restartGame();
			}

			
			/* collision with obstacle */
			if (tail.getBoundsInParent().intersects(obs.getX(), obs.getY(), obs.getWidth(), obs.getHeight())) {
				restartGame();
			}
			
			/* collision with collectible */
			if (tail.getBoundsInParent().intersects(col.getBoundsInParent())){
				aCol.setXPos();
				aCol.setYPos();
				col.relocate(aCol.getXPos(), aCol.getYPos());       
				col.getBoundsInParent();
				root.getChildren().remove(col);
				root.getChildren().add(col);
				
				Rectangle rect = new Rectangle(40, 0, TILE_SIZE, TILE_SIZE);
				rect.setFill(Color.rgb(241, 249, 12));
				rect.setTranslateX(tailX);
				rect.setTranslateY(tailY);
				
				snake.add(rect);
	
			}
			
			
			/** the other snake collisions */
			/* collision with self */
			for (Node rect2: snake2) {				
				if (rect2 != tail2 && tail2.getTranslateX() == rect2.getTranslateX() && tail2.getTranslateY() == rect2.getTranslateY()) {
					restartGame();
					break;
				}
			}
			
			/* collision with window border */
			/*if (tail.getTranslateX() < 0 || tail.getTranslateX() >= APP_W
				|| tail.getTranslateY() < 0 || tail.getTranslateY() >= APP_H) {
				restartGame();
			}*/
			
			if (snakeBody2.getBoundsInParent().intersects(rightBorder.getBoundsInParent()) || 
					snakeBody2.getBoundsInParent().intersects(leftBorder.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(bottomBorder.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
				restartGame();
			}
			
			if(snakeBody2.getBoundsInParent().intersects(movObs.getBoundsInParent())) {
				restartGame();
			}

			
			/* collision with obstacle */
			if (tail2.getBoundsInParent().intersects(obs.getX(), obs.getY(), obs.getWidth(), obs.getHeight())) {
				stopGame();
				TimerS.setEndTime();
				System.out.println(TimerS.getTotalTime());
			}
			
			/* collision with collectible */
			if (tail2.getBoundsInParent().intersects(col.getBoundsInParent())){
				aCol.setXPos();
				aCol.setYPos();
				col.relocate(aCol.getXPos(), aCol.getYPos());       
				col.getBoundsInParent();
				root.getChildren().remove(col);
				root.getChildren().add(col);
				
				Rectangle rect2 = new Rectangle(TILE_SIZE, TILE_SIZE);
				rect2.setTranslateX(tail2X);
				rect2.setTranslateY(tail2Y);
				Score.setScore(1);
				
				snake2.add(rect2);
	
			}
			
				
			//General collisions
			if (obs.getBoundsInParent().intersects(col.getBoundsInParent())) {
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
			}
			

			
		});
		
		timeline.getKeyFrames().add(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		// add obstacle
		
		Scene scene = new Scene(root);
		
		scene.setOnKeyPressed(event -> {
			if (!moved2)
				return;

		    if (moved2) {
			switch (event.getCode()) {
				case UP:
					if (direction2 != Direction.DOWN)
						direction2 = Direction. UP;
					break;
				case DOWN:
					if (direction2 != Direction.UP)
						direction2 = Direction.DOWN;
					break;
				case LEFT:
					if (direction2 != Direction.RIGHT)
						direction2 = Direction.LEFT;
					break;
				case RIGHT:
					if (direction2 != Direction.LEFT)
						direction2 = Direction.RIGHT;
					break;
			default:
				break;
			}
		}
		
		moved2 = false;
		
		if (!moved)
			return;

		if (moved) {
		switch (event.getCode()) {
			case W:
				if (direction != Direction.DOWN)
					direction = Direction. UP;
				break;
			case S:
				if (direction != Direction.UP)
					direction = Direction.DOWN;
				break;
			case A:
				if (direction != Direction.RIGHT)
					direction = Direction.LEFT;
				break;
			case D:
				if (direction != Direction.LEFT)
					direction = Direction.RIGHT;
				break;
		default:
			break;
		}
	}
	
	moved = false;	
		
		
	});
		primaryStage.setTitle("Snake");
		primaryStage.setScene(scene);
		primaryStage.show();
		startGame();
		
	}
}
