
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
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

public class Level1 extends Application {
	static protected Rectangle obstacle;
	final static double W = 800;
	final static double GAP = 100;
	final static double LEN = W - GAP;
	final static double THICK = 50;
	final static double SPEED = 20.0;
	static Node f;
	static Rectangle fan;
	private static final int TILE_SIZE = 10;
	private static final double APP_W = W;
	private static final double APP_H = W;
	private int score;
	private Label scoreLabel = new Label();
	private static boolean moved = false;
	private boolean running = false;
	private double difficulty = 0.1;
	private Timeline timeline = new Timeline();
	Snake obj = new Snake();
	private ObservableList<Node> snake = obj.getSnake();
	Direction direction;
	boolean collision = false;
	private final double height = 20;
	
	public Parent level1() {
		Pane pane = new Pane();
		Rectangle fan = new Rectangle(W/2-(THICK/2), GAP, THICK, W/2-GAP);
		Rectangle wall1 = new Rectangle(GAP, GAP+THICK, THICK, W-(GAP*2));
		Rectangle wall2 = new Rectangle(LEN-THICK, GAP+THICK, THICK, W-(GAP*2));
		Rectangle wall3 = new Rectangle(GAP, 600-THICK-5, LEN-GAP, THICK);
		Circle cyc = new Circle(W/2, 350, 5);
		cyc.setRadius(height/4);
		PathTransition trans = new PathTransition();
		trans.setDuration(Duration.seconds(SPEED));
		trans.setNode(fan);
		trans.setPath(cyc);
		trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		trans.setCycleCount(PathTransition.INDEFINITE);	
		trans.play();
		
		Label pos = new Label();
		pane.getChildren().addAll(fan, pos, wall1, wall2, wall3);
		
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
		Scene scene = new Scene(level1(), W, W);
		scene.setFill(Color.AQUA);
		test_stage.setScene(scene);
		test_stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);	
		
	}
}
