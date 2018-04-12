import static org.junit.Assert.*;
import org.junit.Test;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.collections.ObservableList;


public class GameTest {

	// to see if the snake moves
	@Test
	public void testSnakeMoves() {
		ObservableList<Node> snake = Snake.getSnake();
		Rectangle head = Snake.getHead();
		snake.add(head);
		Node tail = snake.get(0);
		tail.setTranslateX(head.getTranslateX());
		tail.setTranslateY(head.getTranslateY()+1.0);
		
		assertTrue(tail.getTranslateY() == 1.0);
	}

	// to see if the snake eats the food
	@Test
	public void testSnakeFoodCollision() {
		ObservableList<Node> snake = Snake.getSnake();
		Rectangle head = Snake.getHead();
		snake.add(head);
		Node tail = snake.get(0);
		tail.setTranslateX(10);
		tail.setTranslateY(10);
		Rectangle food = new Rectangle(10,10);
		
		assertTrue(tail.getBoundsInParent().intersects(food.getBoundsInParent()));
	}
	
	// added the head the tail and the new body.
	@Test
	public void testGrowth() {
		ObservableList<Node> snake = Snake.getSnake();
		Rectangle head = Snake.getHead();
		snake.add(head);
		Node tail = snake.get(0);
		Rectangle body2 = new Rectangle(10,10);
		body2.setTranslateX(tail.getTranslateX());
		body2.setTranslateY(tail.getTranslateY());
		snake.add(body2);
		
		assertTrue(snake.size() == (3));
		assertTrue(snake.contains(body2));
	}
	
	//checks to see if the head x and y are within or out of area.
	@Test
	public void testSnakeOutOfBounds() {
		int windowSize = 800;
		Rectangle head = Snake.getHead();
		head.setX(windowSize+1);
		
		assertTrue(head.getX() >= windowSize);
		assertFalse(head.getY() >= windowSize);
	}

	// Checks to see if snake can die
	@Test
	public void testSnakeDies() {
		Rectangle obstacle = new Rectangle(20, 20, 20, 20);
		Rectangle head = Snake.getHead();
		head.setX(21);
		head.setY(21);
		
		assertTrue(head.getBoundsInLocal().intersects(obstacle.getBoundsInLocal()));
	}

}