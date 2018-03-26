//package game.snake;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;


/**
  creates the playable snake to be used in the games application and to be initialized elsewhere
 */
public class Snake {
	
  //Instane variables
  private Direction direction = Direction.RIGHT;
  private Point2D head;
  private Point2D tail;
  private List<Point2D> body = new ArrayList<>();
  
  /*
   * Constructor for the creation of the snake that includes the addition of body parts
   */
  public Snake(Point2D postion){
    this.head = postion;
    this.tail = head;
    body.add(head);
  }
  
  /*
   * sets the position of the heat to a point htat is passed in
   */
  public void setPosition(Point2D position) {
		this.head = position;
	}
  
  /*
   * Sets the initial direction of travel
   */
  public void setDirection(Direction direction){
    this.direction = direction;
  }
  
  /*
   * updates the direction for both the head and the tail if the snake has a tail
   */
  public void update(){
    head = head.add(direction.vector);
    tail = body.remove(body.size() - 1);
    body.add(0, head);
  }
  
  /*
   * gets the position of the head of the snake
   */
  public Point2D getPosition(){
    return head;
  }
  
  /*
   * checks for collision with a food item
   */
  public boolean isCollidingWith(Food food) {
	 return head.equals(food.getPosition());
  }
  
  
  /*
   * checks for collision with a portal
   */
  public boolean isCollidingWith(Portal portal) {
	  return head.equals(portal.getPosition());
  }
  
  
  /*
   * makes the body grow
   */
  public void grow() {
	body.add(tail);
  }
  
  /*
   * returns the length of the body of the snake
   */
  public int getLength() {
	 return body.size(); 
  }

  /*
   * return the body as its list of 2D points
   */
  public List<Point2D> getBody() {
	return body;
  }

  /*
   * checks to see if the snake is out of bounds.
   */
  public boolean isOutOfBounds(int size) {
	return head.getX() < 0 || head.getY() > 0
			|| head.getX() > size || head.getY() > size;
  }
  
  /*
   * checks to see if the snake is dead
   */
  public boolean isDead() {
	return body.lastIndexOf(head) > 0;
	}

}


