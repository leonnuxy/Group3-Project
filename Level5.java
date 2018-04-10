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
	
	private Direction direction2 = Direction.DOWN;
	private boolean moved2 = false;
	private ObservableList<Node> snake2;
	boolean toRemove2;
	
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
		head2.setFill(Color.rgb(0,0,0));
		head.setFill(Color.rgb(241, 249, 12));
		head2.setLayoutY(40);
		snake.add(head);
		snake2.add(head2);
		timeline.play();
		running = true;
	}
	
	
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
			/*for (Node rect: snake) {				
				if (rect != tail && tailX == rect.getTranslateX() && tailY == rect.getTranslateY()) {
					restartGame();
				}
			}*/
			if (snakeBody.getBoundsInParent().intersects(rightBorder.getBoundsInParent()) || 
					snakeBody.getBoundsInParent().intersects(leftBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(bottomBorder.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(topBorder.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(rightBorder.getBoundsInParent()) || 
					snakeBody2.getBoundsInParent().intersects(leftBorder.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(bottomBorder.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
				endGame();
				//System.out.println("Time Elapsed: " + TimerS.getTotalTime(timeStart, timeEnd));
			}
			
			if (snakeBody.getBoundsInParent().intersects(fan.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(wall1.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(wall2.getBoundsInParent()) ||
					snakeBody.getBoundsInParent().intersects(wall3.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(fan.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(wall1.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(wall2.getBoundsInParent()) ||
					snakeBody2.getBoundsInParent().intersects(wall3.getBoundsInParent())) {
				endGame();
			}
			
			/* collision with collectible */
			if (tail.getBoundsInParent().intersects(col.getBoundsInParent()) ||
					tail2.getBoundsInParent().intersects(col.getBoundsInParent())){
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