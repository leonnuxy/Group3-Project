import java.util.ConcurrentModificationException;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level2 extends LevelActions {

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
		
		Circle big = new Circle(150, Color.BLACK);
		big.setCenterX(400); big.setCenterY(400);
		//26 values to be computed 
		Polygon center = new Polygon(380, 200, 420, 200, 
				420, 380, 600, 380, 600, 420, 420, 420, 
				420, 600, 380, 600, 380, 420, 200, 420, 
				200, 380, 380, 380, 380, 200);
		PathTransition path = new PathTransition();
		path.setDuration(Duration.seconds(5));
		Circle small = new Circle(1);
		small.setCenterX(400); small.setCenterY(400);
		path.setNode(center); path.setPath(small);
		path.setCycleCount(PathTransition.INDEFINITE);
		path.setAutoReverse(true);
		path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		path.play();
		
		root.getChildren().addAll(big, center);
		
		
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
		
		if (twoplayermode) {
			root.getChildren().add(snakeBody2);
		}
		root.getChildren().add(snakeBody);
		root.getChildren().add(rightBorder);
		root.getChildren().add(leftBorder);
		root.getChildren().add(bottomBorder);
		root.getChildren().add(topBorder);
		root.getChildren().add(col);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(Difficulty.getDifficulty()), event ->{
			if (!running)
				return;
			
			boolean toRemove = snake.size()>1;
			if (twoplayermode) {
				boolean toRemove2 = snake2.size()>1;
			}
			
			Node tail = toRemove ? snake.remove(snake.size()-1) : snake.get(0);
			Node tail2 = toRemove2 ? snake2.remove(snake2.size()-1) : snake2.get(0);
			
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
			
			Collisions.selfCollision(snake, tail, tailX, tailY);
			Collisions.selfCollision(snake2, tail2, tail2X, tail2Y);
			Collisions.borderCollisions(snakeBody, topBorder, bottomBorder, leftBorder, rightBorder);
			Collisions.borderCollisions(snakeBody2, topBorder, bottomBorder, leftBorder, rightBorder);
			Collisions.Level2SpecificCollisions(snakeBody, big, center, aCol, col, root);
			Collisions.Level2SpecificCollisions(snakeBody2, big, center, aCol, col, root);
			Collisions.collectibleCollision(tail, tail2, col, aCol, root, tailX, tailY, snake, TILE_SIZE);
			Collisions.snakesCollide(tail, tail2);
			if (LevelActions.endGame) {
				endGame();
			}
			
			if (Score.getScore() == score + scoreChange) {
				primaryStage.close();
				timeline.stop();
				Level3 level2 = new Level3();
				level2.start(primaryStage);
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