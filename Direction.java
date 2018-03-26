//package game.snake;

import javafx.geometry.Point2D;

/*
 * Responsible for handling the direction of the snake, moves it relative to its last position
 */
public enum Direction {
	RIGHT(new Point2D(1, 0)),

	LEFT(new Point2D(-1, 0)),

	UP(new Point2D(0, -1)),

	DOWN(new Point2D(0, 1));

	final Point2D vector;

	Direction(Point2D vector){
		this.vector = vector;
  }

}
