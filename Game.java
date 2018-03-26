//package game.snake;
import java.util.Random;

import javafx.geometry.Point2D;


/**
 * Responsible for handling snake actions and state of the game
 */
public class Game {
	
	//instance variables
	private final int size;
	private Snake snake;
	private Food food;
	private Portal portal;
	private boolean isOver = false;
	private Random random = new Random(123);
	
	/*
	 * Constructor to create all of the wanted objects
	 */
	public Game(int size) {
		this.size = size;	
		
		snake = new Snake(new Point2D(size/2, size/2));
		food = new Food(getRandomPosition());
		portal = new Portal();
	}
	
	/*
	 * Method to update the snake and tell the snake what to do upon actions taken on the screen
	 */
	public void update() {
		snake.update();
		
		// what to do when the snake collides with the food/item
		if (snake.isCollidingWith(food)) {
			snake.grow();
			food.setPosition(getRandomPosition());
		}
		
		//what to do if the snake collides with the portal
		if (snake.isCollidingWith(portal)) {
			snake.setPosition(getSetPosition());
		}
		
		//what to do if the snake dies or goes out of bounds
		if (snake.isDead() || snake.isOutOfBounds(size)) {
			isOver = true;
		}
	}
	
	public boolean isOver() {
		return isOver;
	}
	
	/*
	 * generate a random point
	 */
	private Point2D getRandomPosition() {
		return new Point2D(random.nextInt(size), random.nextInt(size));
	}
	
	/*
	 * return a set position for testing purposes
	 */
	private Point2D getSetPosition() {
		return new Point2D(200, 200);
	}
	
	public Snake getSnake() {
		return snake;
	}

	public Food getFood() {
		return food;
	}
	
	/*
	 * for changing the direction of the snake
	 */
	public void setDirection(Direction direction) {
		snake.setDirection(direction);
	}
}
