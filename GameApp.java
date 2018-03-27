/**
 * 
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.paint.ImagePattern;


/**
 * runs a game of snake
 *
 */
public class GameApp extends Application {
	
	//Instance variables
	private static final int TILE_SIZE = 10;
	private static final int APP_W = 800;
	private static final int APP_H = 800;
	
	private Direction direction = Direction.RIGHT;
	private boolean moved = false;
	private boolean running = false;
	private double difficulty = 0.1;
	
	private Timeline timeline = new Timeline();
	//private Game game;
	//game = new Game(GAME_SIZE);
	// game.getSnake().getBody();
	
	
	private ObservableList<Node> snake;
	
	/*
	 * Creates and adds the objects to the screen and is responsible for all collisions and everything that
	 * happens on screen
	 */
	public Parent createContent() {
		Pane root = new Pane();
		root.setStyle("-fx-background-image: url(Pane.png);");
		root.setPrefSize(APP_W, APP_H);
		
		Group snakeBody = new Group();
		snake = snakeBody.getChildren();
		
		Obstacle anObs = new Obstacle();
		Rectangle obs = anObs.getObs();
		
		Portal aPortal = new Portal();
		Rectangle port = aPortal.makePortal();
		
		Collectible aCol = new Collectible();
		Rectangle col = aCol.getCol();
		
		root.getChildren().add(snakeBody);
		root.getChildren().add(obs);
		root.getChildren().add(col);
		//root.getChildren().add(port);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(difficulty), event ->{
			if (!running)
				return;
			
			boolean toRemove = snake.size()>1;
			
			Node tail = toRemove ? snake.remove(snake.size()-1) : snake.get(0);
			
			double tailX = tail.getTranslateX();
			double tailY = tail.getTranslateY();
			
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
			
			moved = true;
			
			if (toRemove)
				snake.add(0, tail);
			
			/* collision with self */
			for (Node rect: snake) {				
				if (rect != tail && tail.getTranslateX() == rect.getTranslateX() && tail.getTranslateY() == rect.getTranslateY()) {
					restartGame();
					break;
				}
			}
			
			/* collision with window border */
			if (tail.getTranslateX() < 0 || tail.getTranslateX() >= APP_W
				|| tail.getTranslateY() < 0 || tail.getTranslateY() >= APP_H) {
				restartGame();
			}

			
			/* collision with obstacle */
			if (tail.getBoundsInParent().intersects(obs.getBoundsInLocal())){
				System.exit(0);
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
				
				snake.add(rect);
	
			}
			
			/*if (tail.getBoundsInParent().intersects(port.getBoundsInParent())) {
				root.getChildren().remove(snakeBody);
				snakeBody.relocate(100,100);
				root.getChildren().add(snakeBody);
				
			}*/

			
		});
		
		timeline.getKeyFrames().add(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		// add obstacle
		
		return root;
	}
		
	private void restartGame() {
		stopGame();
		startGame();
	}
	
	private void stopGame() {
		running = false;
		timeline.stop();
		snake.clear();
	}
	
	/*
	 * puts the snake back to the top left of the screen to start again
	 */
	public void startGame() {
		direction = Direction.RIGHT;
		Rectangle head = new Rectangle(TILE_SIZE, TILE_SIZE);
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
			}
		}
		
		moved = false;
	});
		
		return scene;
	
	}
	
	/*
	 * start the show
	 */
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Snake");
		primaryStage.setScene(this.run());
		primaryStage.show();
		startGame();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
	
