import java.util.ConcurrentModificationException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Level3 extends LevelActions {
	
	/*
	 * responsible for moving the snake head
	 */
	

	@Override
	public void start(Stage primaryStage){
		try {
		Pane root = new Pane();
		

		Group snakeBody2 = Snake.getSnake_body2();
		snake2 = snakeBody2.getChildren();
	
		Group snakeBody = new Group();
		snake = snakeBody.getChildren();
		
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
			boolean toRemove2 = snake2.size()>1;
			
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
			Collisions.Level3SpecificCollisions(snakeBody, rectTop, rectCen, rectBott, rectRight, rectLeft, rectBottRight, rectBottLeft, rectTopRight, aCol, col, root);
			Collisions.Level3SpecificCollisions(snakeBody2, rectTop, rectCen, rectBott, rectRight, rectLeft, rectBottRight, rectBottLeft, rectTopRight, aCol, col, root);
			Collisions.collectibleCollision(tail, tail2, col, aCol, root, tailX, tailY, snake, TILE_SIZE);
			Collisions.snakesCollide(tail, tail2);
			if (LevelActions.endGame) {
				endGame();
			}
			
			if (Score.getScore() == score + scoreChange) {
				primaryStage.close();
				timeline.stop();
				Level4 level2 = new Level4();
				level2.start(primaryStage);
				level2.stopGame();
				level2.startGame();
				
			}

			}
		);
		
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