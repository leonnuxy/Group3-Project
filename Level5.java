import java.util.ConcurrentModificationException;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class is a Level to be used in a game of Python, configured to have a two snake mode as well as a single snake mode
 * @author MyPrecious
 */
public class Level5 extends LevelActions{
	
	
	//Initialize the instance variables for the creation of the on screen obstacles
	static protected Rectangle obstacle;
	final static double W = 800;
	final static double GAP = 100;
	final static double LEN = W - GAP;
	final static double THICK = 50;
	final static double SPEED = 10.0;
	static Rectangle fan;
	private static final int TILE_SIZE = 10;
	boolean collision = false;
	private final double height = 20;
	
	/*
	 * This method runs the level
	 */
	@Override
	public void start(Stage primaryStage) {
		
		//On runtime there would occasionally be a Concurrent Modification Exception that caused no apparent problems
		try {
			
			//Creating the pane and setting its background to the python logo
			Pane root = new Pane();
			root.setStyle("-fx-background-image: url(Pane.png);");
			root.setPrefSize(APP_W, APP_H);
			
			//Creating the physical group that will be a representation of the Node that is the snake that will be displayed on the screen
			Group snakeBody2 = Snake.getSnake_body2();
			snake2 = snakeBody2.getChildren();
		
			//Creating the physical snake group for the second snake that will be displayed on the screen
			Group snakeBody = Snake.getSnakeBody();
			snake = snakeBody.getChildren();
			
			//Initializes the collectible at a random position on the screen
			Collectible aCol = new Collectible(50,50);
			Rectangle col = aCol.getCol();
			
			//Creates the borders for the level and adds them to just out of view of the window when it is initialized
			Obstacle borderRight = new Obstacle(801,0,1,800);
			Rectangle rightBorder = borderRight.getObs();
			Obstacle borderLeft = new Obstacle(-2,0,1,800);
			Rectangle leftBorder = borderLeft.getObs();
			Obstacle borderBottom = new Obstacle(0,801,800,1);
			Rectangle bottomBorder = borderBottom.getObs();
			Obstacle borderTop = new Obstacle(0,-2,800,1);
			Rectangle topBorder = borderTop.getObs();
			
			//create the fan that will spin and the walls that enclose areas of the screen
			Rectangle fan = new Rectangle(W/2-(THICK/2)-0.05, GAP-0.05, THICK-0.05, W/2-GAP-0.05);
			Rectangle wall1 = new Rectangle(GAP, GAP+THICK, THICK, W-(GAP*2));
			Rectangle wall2 = new Rectangle(LEN-THICK, GAP+THICK, THICK, W-(GAP*2));
			Rectangle wall3 = new Rectangle(GAP, 600-THICK-5, LEN-GAP, THICK);
			//circle for the fan to follow
			Circle cyc = new Circle(W/2, 350, 5);
			cyc.setRadius(height/4);
			//set the path for the fan and bind
			PathTransition trans = new PathTransition();
			trans.setDuration(Duration.seconds(SPEED));
			trans.setNode(fan);
			trans.setPath(cyc);
			trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			trans.setCycleCount(PathTransition.INDEFINITE);	
			trans.play();
			
			//add the fan and wall to the pane
			root.getChildren().addAll(fan, wall1, wall2, wall3);
			
			//only add the second snake if the two snake mode has been activated
			if (twoplayermode) {
				root.getChildren().add(snakeBody2);
			}
			
			//adds the snake and the collectible and adds the borders to just out of view of the window when it is initialized
			root.getChildren().add(snakeBody);
			root.getChildren().add(rightBorder);
			root.getChildren().add(leftBorder);
			root.getChildren().add(bottomBorder);
			root.getChildren().add(topBorder);
			root.getChildren().add(col);
			
			//Main loop of the animation of the game, the game refreshes every interval of time in seconds that is set by the Difficulty class
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
				Node tail = snakeIns.getTail();
				Node tail2 = snakeIns.getTail2();
				tail = toRemove ? snake.remove(snake.size()-1) : snake.get(0);
				tail2 = toRemove2 ? snake2.remove(snake2.size()-1) : snake2.get(0);
				
				//X and Y coordinates of the tail node
				double tailX = tail.getTranslateX();
				double tailY = tail.getTranslateY();
				
				//X and Y coordinates of the second snake tail node
				double tail2X = tail2.getTranslateX();
				double tail2Y = tail2.getTranslateY();
				
				//handles the movement of the snake based on the input that is given to the keyboard keeping in mind that 0,0 is the top left
				// of the screen
				//Translate moves the snake in that specified direction continuously every time the scene is refreshed until new input is given
				// or until the snake encounters something that kills it
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
				
				//checks to make sure that the snake has a size greater than one add if so adds the tail
				if (toRemove)
					snake.add(0, tail);
				moved = true;
				
				//handles the movement of the second snake based on the input that is given to the keyboard keeping in mind that 0,0 is the top
				// left of the screen
				//Translate moves the snake in that specified direction continuously every time the scene is refreshed until new input is given
				// or until the snake encounters something that kills it
				//Is only active if the second snake modifier is triggered
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
					//checks to make sure that the second snake has a size greater than one add if so adds the tail
					if (toRemove2)
						snake2.add(0, tail2);
				
					moved2 = true;
				}
				
				//checks collision of the snakes with itself
				Collisions.selfCollision(snake, tail, tailX, tailY);
				Collisions.selfCollision(snake2, tail2, tail2X, tail2Y);
				
				//checks the collision of the snakes with the borders of the level
				Collisions.borderCollisions(snakeBody, topBorder, bottomBorder, leftBorder, rightBorder);
				Collisions.borderCollisions(snakeBody2, topBorder, bottomBorder, leftBorder, rightBorder);
				
				//checks the collision of the snakes with the obstacles that are on the screen as well as handles if the collectible is
				// struck by the objects on the screen or relocates on top of an obstacle
				Collisions.Level5SpecificCollisions(snakeBody, fan, wall1, wall2, wall3, aCol, col, root);
				Collisions.Level5SpecificCollisions(snakeBody2, fan, wall1, wall2, wall3, aCol, col, root);
				
				//handles the actions for when the snake collides with the collectible item 
				Collisions.collectibleCollision(tail, tail2, col, aCol, root, tailX, tailY, snake, TILE_SIZE);
				
				//handles the collision of the two snakes
				Collisions.snakesCollide(tail, tail2);
				
				//if the snake performs an action or collision that should end the game the endgame modifier is activated to end the game
				if (LevelActions.endGame) {
					endGame();
				}
				
				//if the score reaches a specified number start the next level
				if (Score.getScore() == score + scoreChange) {
					Difficulty.changeDifficulty(0.01);
					primaryStage.close();
					timeline.stop();
					Level level = new Level();
					if (Score.getScore() >= 25)
					LevelActions.twoplayermode = true;
					level.start(primaryStage);
					level.stopGame();
					level.startGame();
				}
			});
			
			//set the timeline loop to contain the frame where visible actions occur and have it continue indefinitely
			timeline.getKeyFrames().add(frame);
			timeline.setCycleCount(Timeline.INDEFINITE);
			Scene scene = new Scene(root);
			
			//Key handler for both of the snakes
			scene.setOnKeyPressed(event -> {
				//if no move was specified, do not continue to the movement
				if (!moved)
					return;
	
				//if a move was specified handle the direction
			    if (moved) {
				switch (event.getCode()) {
					//all statements ensure that the snake cannot turn back on itself
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
			//reset moved to false to await reactivation when there is movement again
			moved = false;	
			
			//activate this part of the listener only if the second snake modifier has been triggered 
			if (twoplayermode) {
				//if no move was specified, do not continue to the movement 
				if (!moved2)
					return;
				
				//if a move was specified handle the direction		
				if (moved2) {
					switch (event.getCode()) {
						//all statements ensure that the snake cannot turn back on itself
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
				//reset moved to false to await reactivation when there is movement again
				moved2 = false;
			}
		});
		//set and show the scene for the user to see
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Snake");
		primaryStage.setScene(scene);
		primaryStage.show();
		//initialize all the starting factors
		startGame();
		}
		
		//print the exception message is the exception does occur
		catch (ConcurrentModificationException e) {
			System.out.println(e.getMessage());
		}	
	}
}