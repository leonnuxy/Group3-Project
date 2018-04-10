
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import javafx.scene.shape.Rectangle;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

class GameTest {

	// to see if the snake moves
	@Test
	public void testSnakeMoves() {
		Snake.setHead(10, 10);
		ObservableList<Node> snake = Snake.getSnake();
		Rectangle head = Snake.getHead();
		snake.add(head);
		Node tail = snake.get(0);
		
		//Direction Down.
		tail.setTranslateX(head.getTranslateX());
		tail.setTranslateY(head.getTranslateY()+1.0);
		
		
		assertThat(tail.getTranslateY(), is(1.0));
	}

	// to see if the snake eats the food
	@Test
	public void testSnakeFoodCollision() {
		Snake.setHead(0, 0);
		ObservableList<Node> snake = Snake.getSnake();
		Rectangle head = Snake.getHead();
		snake.add(head);
		Node tail = snake.get(0);
		tail.setTranslateX(10);
		tail.setTranslateY(10);
		
//		Collectible collectible = new Collectible();
		Rectangle food = new Rectangle(10,10);
	
				//collectible.getCol();
		
		Assert.assertTrue(tail.getBoundsInParent().intersects(food.getBoundsInParent()));
	}
	
	// added the head the tail and the new body.
	@Test
	public void testGrowth() {
		Snake.setHead(10, 10);
		ObservableList<Node> snake = Snake.getSnake();
		Rectangle head = Snake.getHead();
		snake.add(head);
		Node tail = snake.get(0);
		
		Rectangle body2 = new Rectangle(10,10);
		body2.setTranslateX(tail.getTranslateX());
		body2.setTranslateY(tail.getTranslateY());
		snake.add(body2);
		
		assertThat(snake.size(), is(3));
		assertThat(snake, hasItem(body2));
	}
	
	//checks to see if the head x and y are within or out of area.
	@Test
	public void testSnakeOutOfBounds() {
		int windowSize = 800;
		Snake.setHead(10, 10);
		Rectangle head = Snake.getHead();
		head.setX(windowSize+1);
		
		assertTrue(head.getX() >= windowSize);
		assertFalse(head.getY() >= windowSize);
	}

	// Checks to see if snake can die
	@Test
	public void testSnakeDies() {
		Rectangle obstacle = new Rectangle(20, 20, 20, 20);
		Snake.setHead(10, 10);
		Rectangle head = Snake.getHead();
		head.setX(21);
		head.setY(21);
		
		assertTrue(head.getBoundsInLocal().intersects(obstacle.getBoundsInLocal()));
	}

}