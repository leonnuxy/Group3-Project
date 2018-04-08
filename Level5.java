import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level5 extends Application implements FrameKey {

	private static final double SPEED = 2;
	private static final int rad = 1;
	private static final int MID = 400;
	private static final int LEN = 100;
	private static final int CELL, TILE_SIZE = 20;
	private static boolean moved = false;
	private boolean running = false;
	private double difficulty = 0.1;
	boolean collision = false;
	private Timeline timeline = new Timeline();
	Snake obj = new Snake();
	private ObservableList<Node> snake = obj.getSnake();

	// TODO Auto-generated constructor stub
	// Object types of polygons that spin in a circular motion
	Direction direction;
	
	
	public Parent createContent() {
		Pane pane = new Pane();
		pane.setStyle("-fx-background-image: url(Pane.png);");
		Group snakeBody = obj.getSnakeBody();
		snake = snakeBody.getChildren();
		
		Polygon poly1 = new Polygon(MID,LEN,MID+CELL,(LEN*2)-CELL,LEN+MID,LEN*2,MID+CELL,(LEN*2)+CELL,MID,MID-LEN,MID-CELL,(LEN*2)+CELL,MID-LEN,LEN*2,MID-CELL,(LEN*2)-CELL,MID,LEN);
		Polygon poly2 = new Polygon(MID,LEN,MID+CELL,(LEN*2)-CELL,LEN+MID,LEN*2,MID+CELL,(LEN*2)+CELL,MID,MID-LEN,MID-CELL,(LEN*2)+CELL,MID-LEN,LEN*2,MID-CELL,(LEN*2)-CELL,MID,LEN);
		Polygon poly3 = new Polygon(MID,LEN,MID+CELL,(LEN*2)-CELL,LEN+MID,LEN*2,MID+CELL,(LEN*2)+CELL,MID,MID-LEN,MID-CELL,(LEN*2)+CELL,MID-LEN,LEN*2,MID-CELL,(LEN*2)-CELL,MID,LEN);
		Polygon poly4 = new Polygon(MID,LEN,MID+CELL,(LEN*2)-CELL,LEN+MID,LEN*2,MID+CELL,(LEN*2)+CELL,MID,MID-LEN,MID-CELL,(LEN*2)+CELL,MID-LEN,LEN*2,MID-CELL,(LEN*2)-CELL,MID,LEN);
		Circle cir1 = new Circle(MID,LEN*2,rad); Circle cir2 = new Circle(MID,MID+(LEN*2),rad); 
		Circle cir3 = new Circle(LEN*2,MID,rad); Circle cir4 = new Circle(MID+(LEN*2),MID,rad);
		
		//Creates the a new Path Transition for each object
		PathTransition trans = new PathTransition();
		trans.setNode(poly1);
		trans.setPath(cir1);
		trans.setDuration(Duration.seconds(SPEED));
		trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		trans.setCycleCount(PathTransition.INDEFINITE);
		trans.play();
		
		PathTransition trans2 = new PathTransition();
		trans2.setNode(poly2);
		trans2.setPath(cir2);
		trans2.setDuration(Duration.seconds(SPEED));
		trans2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		trans2.setCycleCount(PathTransition.INDEFINITE);
		trans2.play();
		
		PathTransition trans3 = new PathTransition();
		trans3.setNode(poly3);
		trans3.setPath(cir3);
		trans3.setDuration(Duration.seconds(SPEED));
		trans3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		trans3.setCycleCount(PathTransition.INDEFINITE);
		trans3.play();
		
		PathTransition trans4 = new PathTransition();
		trans4.setNode(poly4);
		trans4.setPath(cir4);
		trans4.setDuration(Duration.seconds(SPEED));
		trans4.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		trans4.setCycleCount(PathTransition.INDEFINITE);
		trans4.play();
		
		pane.getChildren().addAll(poly4,poly3,poly2,poly1);
		
		KeyFrame frame = new KeyFrame(Duration.seconds(difficulty), event ->{
			if (!running && !collision)
				return;
			
			
			// checks if the snake has more than one block if yes then it removes the last block that
			// and that becomes the tail if not the head becomes the tail.
			boolean toRemove = snake.size()>1;
			Node tail = obj.getTail();
			tail = toRemove ? snake.remove(snake.size()-1): snake.get(0);
			
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
				collision = true;
//				restartGame();
			}
			
			/* collision with obstacle and wall and fan*/
			if (tail.getBoundsInParent().intersects(obs.getBoundsInLocal()) || tail.getBoundsInParent().intersects(wall.getWall1().getBoundsInLocal())
					|| tail.getBoundsInParent().intersects(wall.getWall2().getBoundsInLocal())
					||tail.getBoundsInParent().intersects(wall.getWall3().getBoundsInLocal()) ||
					tail.getBoundsInParent().intersects(fan.getBoundsInParent())){
//				System.exit(0);
				collision = true;
				
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
	
				score += 1;
				scoreshow = "Your Current Score is "+score;
				scoreLabel.setText(scoreshow);
				scoreLabel.setTextFill(Color.RED);
				
				scoreLabel.setLayoutX(APP_W-150);
				scoreLabel.setLayoutY(APP_H-50);
				root.getChildren().add(scoreLabel);
			}
			
		});
		
		timeline.getKeyFrames().add(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		return pane;
	}
	
	public void restartGame() {
		stopGame();
		startGame();
	}
	
	public void stopGame() {
		running = false;
		timeline.stop();
		snake.clear();
	}
	
	@Override
	public void startGame() {
		direction = Direction.RIGHT;
		Rectangle head = new Rectangle(CELL,CELL);
		head.setFill(Color.rgb(241, 249, 12));
		snake.add(head);
		timeline.play();
		running = true;
	}
	
	@Override
	public Scene run() {
		Scene scene = new Scene(createContent(), MID*2, MID*2);
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
	public void start(Stage primaryStage) {
		primaryStage.setScene(this.run());
		primaryStage.setTitle("Snake");
		primaryStage.show();
		startGame();
	}

	public static void main(String[] args) {
		launch(args);
	
	}

}
