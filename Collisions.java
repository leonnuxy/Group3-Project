import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Collisions {

	public static void borderCollisions(Group snakeBody, Rectangle topBorder, Rectangle bottomBorder, Rectangle leftBorder,
			Rectangle rightBorder) {
		if (snakeBody.getBoundsInParent().intersects(rightBorder.getBoundsInParent()) || 
				snakeBody.getBoundsInParent().intersects(leftBorder.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(bottomBorder.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
			LevelActions.endGame();
		}
	}
	
	public static void Level1SpecificCollisions(Group snakeBody, Rectangle slamUP, Rectangle slamDOWN, Rectangle slamDOWN1, 
			Rectangle slamUP1, Rectangle slamMID, Collectible aCol, Rectangle col, Pane root) {
		if (snakeBody.getBoundsInParent().intersects(slamDOWN.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(slamUP.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(slamDOWN1.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(slamUP1.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(slamMID.getBoundsInParent())) {
			LevelActions.endGame();
		}
		if (col.getBoundsInParent().intersects(slamDOWN.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(slamUP.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(slamDOWN1.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(slamUP1.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(slamMID.getBoundsInParent())) {
			aCol.setXPos();
			aCol.setYPos();
			col.relocate(aCol.getXPos(), aCol.getYPos());       
			col.getBoundsInParent();
			root.getChildren().remove(col);
			root.getChildren().add(col);
		}
	}
	
	public static void Level2SpecificCollisions(Group snakeBody, Circle big, Polygon center, Collectible aCol, Rectangle col, Pane root) {
		if (snakeBody.getBoundsInParent().intersects(big.getBoundsInParent()) || 
				snakeBody.getBoundsInParent().intersects(center.getBoundsInParent())) {
			LevelActions.endGame();
		}
		if (col.getBoundsInParent().intersects(big.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(center.getBoundsInParent())) {
			aCol.setXPos();
			aCol.setYPos();
			col.relocate(aCol.getXPos(), aCol.getYPos());       
			col.getBoundsInParent();
			root.getChildren().remove(col);
			root.getChildren().add(col);
		}
	}
	
	public static void Level3SpecificCollisions(Group snakeBody, Rectangle rectTop, Rectangle rectCen, Rectangle rectBott, Rectangle rectRight, 
			Rectangle rectLeft, Rectangle rectBottRight, Rectangle rectBottLeft, Rectangle rectTopRight, Collectible aCol, Rectangle col, Pane root) {
		if (snakeBody.getBoundsInParent().intersects(rectTop.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(rectCen.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(rectBott.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(rectRight.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(rectLeft.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(rectBottRight.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(rectBottLeft.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(rectTopRight.getBoundsInParent())) {
			LevelActions.endGame();
		}
		if (col.getBoundsInParent().intersects(rectTop.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(rectCen.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(rectBott.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(rectRight.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(rectLeft.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(rectBottRight.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(rectBottLeft.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(rectTopRight.getBoundsInParent())) {
			aCol.setXPos();
			aCol.setYPos();
			col.relocate(aCol.getXPos(), aCol.getYPos());       
			col.getBoundsInParent();
			root.getChildren().remove(col);
			root.getChildren().add(col);
		}
	}
	
	public static void Level4SpecificCollisions(Group snakeBody, Polygon poly1, Polygon poly2, Polygon poly3, Polygon poly4, Collectible aCol,
			Rectangle col, Pane root) {
		if (snakeBody.getBoundsInParent().intersects(poly1.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(poly2.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(poly3.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(poly4.getBoundsInParent())) {
			LevelActions.endGame();
		}
		if (col.getBoundsInParent().intersects(poly1.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(poly2.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(poly3.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(poly4.getBoundsInParent())) {
			aCol.setXPos();
			aCol.setYPos();
			col.relocate(aCol.getXPos(), aCol.getYPos());       
			col.getBoundsInParent();
			root.getChildren().remove(col);
			root.getChildren().add(col);
		}
	}
	
	public static void Level5SpecificCollisions(Group snakeBody, Rectangle fan, Rectangle wall1, Rectangle wall2, Rectangle wall3, 
			Collectible aCol, Rectangle col, Pane root) {
		if (snakeBody.getBoundsInParent().intersects(fan.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(wall1.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(wall2.getBoundsInParent()) ||
				snakeBody.getBoundsInParent().intersects(wall3.getBoundsInParent())) {
			LevelActions.endGame();
		}
		if (col.getBoundsInParent().intersects(fan.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(wall1.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(wall2.getBoundsInParent()) ||
				col.getBoundsInParent().intersects(wall3.getBoundsInParent())) {
			aCol.setXPos();
			aCol.setYPos();
			col.relocate(aCol.getXPos(), aCol.getYPos());       
			col.getBoundsInParent();
			root.getChildren().remove(col);
			root.getChildren().add(col);
		}
	}
	
	public static void collectibleCollision(Node tail, Node tail2, Rectangle col, Collectible aCol, Pane root, double tailX, 
			double tailY, ObservableList<Node> snake, int TILE_SIZE) {
		if (tail.getBoundsInParent().intersects(col.getBoundsInParent()) ||
				tail2.getBoundsInParent().intersects(col.getBoundsInParent())){
			
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
			Score.setScore(1);
			snake.add(rect);

		}
	}
	
	public static void snakesCollide(Node tail, Node tail2) {
		if (tail.getBoundsInParent().intersects(tail2.getBoundsInParent())) {
			LevelActions.endGame();
		}
	}
	
	public static void selfCollision(ObservableList<Node> snake, Node tail, double tailX, double tailY) {
		for (Node rect: snake) {				
			if (rect != tail && tailX == rect.getTranslateX() && tailY == rect.getTranslateY()) {
				LevelActions.endGame();
			}
		}
	}
	
}
