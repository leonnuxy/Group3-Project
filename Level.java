
import javafx.animation.PathTransition;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Level{

	public Level() {
	}
	
	public Parent create() {
		Pane group = new Pane();
		// make it start outside the page
		Rectangle slamUP = new Rectangle(100, 400);
		Rectangle slamDOWN = new Rectangle(100, 400);
		Rectangle slamUP1 = new Rectangle(100, 400);
		Rectangle slamDOWN1 = new Rectangle(100, 400);
		Rectangle slamMID = new Rectangle(50, 300);
		Line linemid = new Line(400, 200, 400, 600);
		Line line = new Line(600, 800, 600, 600);
		Line lineup = new Line(600, -100, 600, 200);
		Line line1 = new Line(200, 800, 200, 600);
		Line lineup1 = new Line(200, -100, 200, 200);
		int sec = 2;
		
		// Bottom Right
		PathTransition slamDown = new PathTransition();
		slamDown.setDuration(Duration.seconds(sec));
		slamDown.setNode(slamDOWN);
		slamDown.setPath(line);
		slamDown.setCycleCount(PathTransition.INDEFINITE);
		slamDown.setAutoReverse(true);
		slamDown.play();
		
		// Middle 
		PathTransition slamMid = new PathTransition();
		slamMid.setDuration(Duration.seconds(sec));
		slamMid.setNode(slamMID);
		slamMid.setPath(linemid);
		slamMid.setCycleCount(PathTransition.INDEFINITE);
		slamMid.setAutoReverse(true);
		slamMid.play();
		
		// Top Right
		PathTransition slamUp = new PathTransition();
		slamUp.setDuration(Duration.seconds(sec));
		slamUp.setNode(slamUP);
		slamUp.setPath(lineup);
		slamUp.setCycleCount(PathTransition.INDEFINITE);
		slamUp.setAutoReverse(true);
		slamUp.play();
		
		// Top Left
		PathTransition slamUp1 = new PathTransition();
		slamUp1.setDuration(Duration.seconds(sec));
		slamUp1.setNode(slamUP1);
		slamUp1.setPath(lineup1);
		slamUp1.setCycleCount(PathTransition.INDEFINITE);
		slamUp1.setAutoReverse(true);
		slamUp1.play();
		
		//Bottom Left
		PathTransition slamUp2 = new PathTransition();
		slamUp2.setDuration(Duration.seconds(sec));
		slamUp2.setNode(slamDOWN1);
		slamUp2.setPath(line1);
		slamUp2.setCycleCount(PathTransition.INDEFINITE);
		slamUp2.setAutoReverse(true);
		slamUp2.play();
		
		
		
		Label pos = new Label();
		group.getChildren().add(pos);
		group.getChildren().addAll(slamMID,slamDOWN1,slamUP1, slamUP, slamDOWN );
		
		group.setOnMouseMoved((evt) -> { 
			String pos1 = ("x = "+ evt.getX() +",  y = " + evt.getY());
			pos.setLayoutX(5);
			pos.setText(pos1);
			pos.setLayoutY(5);		} );
		
		return group;
	}

//	@Override
//	public void start(Stage stage) throws Exception {
//		Scene scene = new Scene(create(), 800, 800, Color.YELLOW);
//		stage.setScene(scene);
//		stage.show();
//	}
//	
//	public static void main(String[] args) {
//		launch(args);
//	}
}
