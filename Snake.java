import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/** 
  creates the playable snake to be used in the games application and to be initialised elsewhere
 */
public class Snake {
	
	private static ObservableList<Node> snake;
	private static Node tail;
	private static final double TILE_SIZE = 10;
	private static Group snake_body = new Group();
	private static boolean collsion = false;
	private static double tailX;
	private static double tailY;
	private static boolean toRemove;
	private static Rectangle head; 
	
	Snake(){}
	
	protected static Rectangle getHead() {
		
		return head;
	}

	protected static void setHead(double rectX, double rectY) {
		head = new Rectangle(rectX, rectY);
	}

	public static ObservableList<Node> getSnake(){
		snake = snake_body.getChildren();
		return snake;
	}
	
	public static Group getSnakeBody() {
		return snake_body;	
	}
	
	public static Node getTail() {
		return tail;	
	}
	
	public static void updateSnake() {
		if (toRemove)
			snake.add(0, tail);
		Rectangle rect = new Rectangle(TILE_SIZE, TILE_SIZE);
		rect.setFill(Color.rgb(241, 249, 12));
		rect.setTranslateX(tailX);
		rect.setTranslateY(tailY);
		snake.add(rect);
		
	}
	public static void main(String[] args) {
//		Node tail2 = snake.get(0);
//		setHead(10,10);
//		getSnake().add(head);
//		Rectangle food = new Rectangle(0,0);
//		System.out.println(food.getX());
//		System.out.println(snake.get(0).getLayoutY());
	}
	
}