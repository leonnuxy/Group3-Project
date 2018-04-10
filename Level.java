import java.util.ConcurrentModificationException;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;

public class Level extends LevelActions {
	
	/*
	 * responsible for moving the snake head
	 */
	/*public Scene run() {
		
		
		return scene;
	
	}*/
	
	private Direction direction2 = Direction.DOWN;
	private boolean moved2 = false;
	private ObservableList<Node> snake2;
	
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
		snake.add(head);
		snake2.add(head2);
		this.timeline.play();
		this.running = true;	
	}

	@Override
	public void start(Stage primaryStage){
		try {
		Pane root = new Pane();
		root.setStyle("-fx-background-image: url(Pane.png);");
		root.setPrefSize(APP_W, APP_H);
		
		
		
		Group snakeBody2 = new Group();
		snake2 = snakeBody2.getChildren();
		
		
		
		
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
		
		root.getChildren().addAll(slamMID,slamDOWN1,slamUP1, slamUP, slamDOWN );
		root.getChildren().add(snakeBody);
		if (twoplayermode) {
			root.getChildren().add(snakeBody2);
		}
		root.getChildren().add(rightBorder);
		root.getChildren().add(leftBorder);
		root.getChildren().add(bottomBorder);
		root.getChildren().add(topBorder);
		root.getChildren().add(col);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(Difficulty.getDifficulty()), event ->{
			if (!running)
				return;
			
			//checks if the snake is more than one block in size
			boolean toRemove2 = false;
			boolean toRemove = snake.size()>1;
			if (twoplayermode) {
				toRemove2 = snake2.size()>1;
			}
			
			//if remove is true then the tail of the snake becomes the node behind the head for addition of tail pieces and if not, it 
			// sets the tail to the head
			// the head of the snake is a tail piece. 
			Node tail = toRemove ? snake.remove(snake.size()-1) : snake.get(0);
			Node tail2 = toRemove2 ? snake2.remove(snake2.size()-1) : snake2.get(0);
			
			
			//X and Y coordinates if the tail node
			double tailX = tail.getTranslateX();
			double tailY = tail.getTranslateY();
			if (twoplayermode) {
				double tail2X = tail2.getTranslateX();
				double tail2Y = tail2.getTranslateY();
			}
			
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
		if (twoplayermode) {
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
		if (toRemove2)
			snake2.add(0, tail2);
		
		moved2 = true;
		}
			
		
			
			//checks collision with self
			/*for (Node rect: snake) {				
				if (rect != tail && tailX == rect.getTranslateX() && tailY == rect.getTranslateY()) {
					restartGame();
				}
			}*/
			if (snakeBody.getBoundsInParent().intersects(rightBorder.getBoundsInParent()) || 
					snakeBody.getBoundsInParent().intersects(leftBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(bottomBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
				endGame();
				//System.out.println("Time Elapsed: " + TimerS.getTotalTime(timeStart, timeEnd));
			}
			
			if (snakeBody.getBoundsInParent().intersects(slamDOWN.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(slamUP.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(slamDOWN1.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(slamUP1.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(slamMID.getBoundsInParent())) {
				endGame();
				//System.out.println("Time Elapsed: " + TimerS.getTotalTime(timeStart, timeEnd));
			}
			
			if (col.getBoundsInParent().intersects(slamDOWN.getBoundsInParent()) ||
					col.getBoundsInParent().intersects(slamUP.getBoundsInParent()) ||
					col.getBoundsInParent().intersects(slamDOWN1.getBoundsInParent()) ||
					col.getBoundsInParent().intersects(slamUP1.getBoundsInParent()) ||
					col.getBoundsInParent().intersects(slamMID.getBoundsInParent())) {
				aCol.setXPos();
				aCol.setYPos();
				col.relocate(aCol.getXPos(), aCol.getYPos());       
				col.getBoundsInParent();
				root.getChildren().remove(col);
				root.getChildren().add(col);
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
			
			if (Score.getScore() == score + 1) {
				primaryStage.close();
				timeline.stop();
				Level2 level2 = new Level2();
				level2.start(primaryStage);
				level2.stopGame();
				level2.startGame();
				
				
				//primaryStage.close();
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
		if (twoplayermode) {
		if (!moved2)
			return;

		if (moved2) {
		switch (event.getCode()) {
			case W:
				if (direction2 != Direction.DOWN)
					direction2 = Direction. UP;
				break;
			case S:
				if (direction2 != Direction.UP)
					direction2 = Direction.DOWN;
				break;
			case A:
				if (direction2 != Direction.RIGHT)
					direction2 = Direction.LEFT;
				break;
			case D:
				if (direction2 != Direction.LEFT)
					direction2 = Direction.RIGHT;
				break;
		default:
			break;
		}
	}
	
	moved2 = false;
		}
	});
		
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Snake");
		primaryStage.setScene(scene);
		primaryStage.show();
		startGame();
		
	}
	catch (ConcurrentModificationException e) {
		System.out.println(e.getMessage());
	}
	} 
}