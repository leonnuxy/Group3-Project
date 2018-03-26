//package game.snake;

import javafx.geometry.Point2D;

/*
 * Basic 2D Point class for the Food that the snake will eat.
 */
public class Food {

	//2D point is the only variable needed
	private Point2D position;
	
	/*
	 * Constructor to set the poisiton of the food to the position passed in
	 */
	public Food(Point2D position) {
		this.position = position;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}
}
