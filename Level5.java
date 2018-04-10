import java.util.ConcurrentModificationException;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

		
public class Level5 extends LevelActions{
	
	static protected Rectangle obstacle;
	final static double W = 800;
	final static double GAP = 100;
	final static double LEN = W - GAP;
	final static double THICK = 50;
	final static double SPEED = 20.0;
	static Node f;
	static Rectangle fan;
	private static final int TILE_SIZE = 10;
	boolean collision = false;
	private final double height = 20;
	
	@Override
	public void start(Stage primaryStage) {
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
		Rectangle fan = new Rectangle(W/2-(THICK/2), GAP, THICK, W/2-GAP);
		Rectangle wall1 = new Rectangle(GAP, GAP+THICK, THICK, W-(GAP*2));
		Rectangle wall2 = new Rectangle(LEN-THICK, GAP+THICK, THICK, W-(GAP*2));
		Rectangle wall3 = new Rectangle(GAP, 600-THICK-5, LEN-GAP, THICK);
		Circle cyc = new Circle(W/2, 350, 5);
		cyc.setRadius(height/4);
		PathTransition trans = new PathTransition();
		trans.setDuration(Duration.seconds(SPEED));
		trans.setNode(fan);
		trans.setPath(cyc);
		trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		trans.setCycleCount(PathTransition.INDEFINITE);	
		trans.play();
		
		Label pos = new Label();
		root.getChildren().addAll(fan, pos, wall1, wall2, wall3);
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
			Collisions.Level5SpecificCollisions(snakeBody, fan, wall1, wall2, wall3, aCol, col, root);
			Collisions.Level5SpecificCollisions(snakeBody2, fan, wall1, wall2, wall3, aCol, col, root);
			Collisions.collectibleCollision(tail, tail2, col, aCol, root, tailX, tailY, snake, TILE_SIZE);
			Collisions.snakesCollide(tail, tail2);
			if (LevelActions.endGame) {
				endGame();
			}
			
			
			if (Score.getScore() == score + scoreChange) {
				Difficulty.changeDifficulty(0.01);
				primaryStage.close();
				timeline.stop();
				Level level = new Level();
				LevelActions.twoplayermode = true;
				level.start(primaryStage);
				level.stopGame();
				level.startGame();
			}
				
				//primaryStage.close();
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