
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Wall extends Application {
	static protected Rectangle obstacle;
	final static double W = 800;
	final static double GAP = 100;
	final static double LEN = W - GAP;
	final static double THICK = 50;
	final static double SPEED = 20.0;
	static Node f;
	static Rectangle fan;
	
	
//	private static Point2D position;
//	double x = position.getX();
//	double y = position.getY();
	private final double height = 20;
	
//	public Obstacle(Point2D position) {	
//	}
	public Wall() {	}
	
	public static double getPosX() {
		double pointX = obstacle.getX();
		return pointX; }
	public static double getPosY() {
		double pointY = obstacle.getY();
		return pointY; }
	
	
	public void setObstacle(Point2D position){
		obstacle = new Rectangle(position.getX(), position.getY(), height, height);	}
	
	public Rectangle getFan() {
		Rectangle fan = new Rectangle(W/2-(THICK/2), GAP*2, THICK, W/2-GAP);
		return fan; 	}
	
	public Rectangle getWall1() {
		Rectangle wall = new Rectangle(GAP, GAP+THICK, THICK, LEN-GAP*3);
		return wall;
	}
	public Rectangle getWall2() {
		Rectangle wall = new Rectangle(LEN-THICK, GAP+THICK, THICK, LEN-GAP*3);
		return wall;
	}
	public Rectangle getWall3() {
		Rectangle wall = new Rectangle(GAP, W-GAP*2-THICK-5, LEN-GAP, THICK);
		return wall;
	}
	
	public Rectangle getObstacle() {
		return obstacle; }
	
	public Parent test_creation() {
		Pane pane = new Pane();
		setObstacle(new Point2D(W/2+150,GAP+200));
		fan = new Rectangle(W/2-(THICK/2), GAP*2, THICK, W/2);
		Circle cyc = new Circle(W/2, W/2, 5);
		cyc.setRadius(height/4);
		PathTransition trans = new PathTransition();
		trans.setDuration(Duration.seconds(SPEED));
		trans.setNode(fan);
		trans.setPath(cyc);
		trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		trans.setCycleCount(PathTransition.INDEFINITE);
		System.out.println(trans.nodeProperty());
		
		if ((obstacle.getX() > fan.getX()+fan.getWidth())	||
				(obstacle.getX() + obstacle.getWidth() < fan.getX()) ||
				(obstacle.getY() > fan.getY()+fan.getHeight()) ||
				(obstacle.getY() + obstacle.getHeight() < fan.getY())) { System.out.println("Test");
				obstacle.setFill(Color.BLUE);}
		
		trans.play();
		f = trans.getNode();
		

		if (obstacle.getBoundsInLocal().intersects(fan.getLayoutBounds())) {
			System.out.println("Test");
		}
		
		Label pos = new Label();
		//pane.getChildren().add(getWall1());
		//pane.getChildren().add(getWall2());
		//pane.getChildren().add(getWall3());
		pane.getChildren().add(obstacle);
		pane.getChildren().add(fan);
		pane.getChildren().add(pos);
		
		pane.setOnMouseMoved((evt) -> { 
			String pos1 = ("x = "+ evt.getX() +",  y = " + evt.getY());
			pos.setLayoutX(5);
			pos.setText(pos1);
			pos.setLayoutY(5);		} );
		
		return pane;
	}
	
	@Override
	public void start(Stage test_stage) {
		// TODO Auto-generated method stub
		test_stage.setTitle("Python");
		Scene scene = new Scene(test_creation(), W, W);
		scene.setFill(Color.AQUA);
		test_stage.setScene(scene);
		test_stage.show();
	}
	
	public static void main(String[] args) {
		
		
		launch(args);	
		
	}
}
