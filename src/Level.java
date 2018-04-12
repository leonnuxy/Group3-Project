import java.util.ConcurrentModificationException;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level extends LevelActions {
	
	/*
	 * responsible for moving the snake head
	 */
	/*public Scene run() {
		
		
		return scene;
	
	}*/
	

	@Override
	public void start(Stage primaryStage){
		try {
		Pane root = new Pane();
		root.setStyle("-fx-background-image: url(Pane.png);");
		root.setPrefSize(APP_W, APP_H);
		
		Group snakeBody2 = Snake.getSnake_body2();
		snake2 = snakeBody2.getChildren();
	
		Group snakeBody = new Group();
		snake = snakeBody.getChildren();
	
		Collectible aCol = new Collectible(50,50);
		Rectangle col = aCol.getCol();
		Obstacle borderRight = new Obstacle(802,0,1,800);
		Rectangle rightBorder = borderRight.getObs();
		Obstacle borderLeft = new Obstacle(-2,0,1,800);
		Rectangle leftBorder = borderLeft.getObs();
		Obstacle borderBottom = new Obstacle(0,802,800,1);
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
			
			double tail2X = tail2.getTranslateX();
			double tail2Y = tail2.getTranslateY();
			
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
			Collisions.selfCollision(snake, tail, tailX, tailY);
			Collisions.selfCollision(snake2, tail2, tail2X, tail2Y);
			Collisions.borderCollisions(snakeBody, topBorder, bottomBorder, leftBorder, rightBorder);
			Collisions.borderCollisions(snakeBody2, topBorder, bottomBorder, leftBorder, rightBorder);
			Collisions.Level1SpecificCollisions(snakeBody, slamUP, slamDOWN, slamDOWN1, slamUP1, slamMID, aCol, col, root);
			Collisions.Level1SpecificCollisions(snakeBody2, slamUP, slamDOWN, slamDOWN1, slamUP1, slamMID, aCol, col, root);
			Collisions.collectibleCollision(tail, tail2, col, aCol, root, tailX, tailY, snake, TILE_SIZE);
			Collisions.snakesCollide(tail, tail2);
			if (LevelActions.endGame) {
				endGame();
			}
			
			
			if (Score.getScore() == score + scoreChange) {
				super.primaryStage.close();
				timeline.stop();
				Level2 level2 = new Level2();
				level2.start(super.primaryStage);
				level2.stopGame();
				level2.startGame();
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