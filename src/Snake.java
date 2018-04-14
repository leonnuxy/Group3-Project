import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

/** 
  creates the playable snake to be used in the games application and to be initialised elsewhere
  creates two objects of the snake and all its properties.
 */

public class Snake {
	
	private static ObservableList<Node> snake;
	private static ObservableList<Node> snake2;
	private Node tail;
	private Node tail2;
	private static final double TILE_SIZE = 10;
	private static Group snake_body = new Group();
	private static Group snake_body2 = new Group();
	private static Rectangle head; 
	private static Rectangle head2; 
	
	Snake(){}

	protected static ObservableList<Node> getSnake(){
		snake = snake_body.getChildren();
		return snake;
	}
	
	protected static ObservableList<Node> getSnake2() {
		snake2 = snake_body2.getChildren();
		return snake2;
	}
	
	protected static Rectangle getHead() {
		head = new Rectangle(TILE_SIZE, TILE_SIZE);
		return head;
	}
	
	protected static Rectangle getHead2() {
		head2 = new Rectangle(TILE_SIZE, TILE_SIZE);
		return head2;
	}
	
	protected static Group getSnake_body2() {
		return snake_body;
	}
	
	protected static Group getSnakeBody() {
		return snake_body2;	
	}
	
	protected Node getTail() {
		return tail;	
	}
	
	protected Node getTail2() {
		return tail2;
	}
	
}