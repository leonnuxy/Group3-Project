import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Group group = new Group();
		Circle big = new Circle(150, Color.BLACK);
		big.setCenterX(400); big.setCenterY(400);
		//26 values to be computed 
		Polygon center = new Polygon(380, 200, 420, 200, 
				420, 380, 600, 380, 600, 420, 420, 420, 
				420, 600, 380, 600, 380, 420, 200, 420, 
				200, 380, 380, 380, 380, 200);
		PathTransition path = new PathTransition();
		path.setDuration(Duration.seconds(5));
		Circle small = new Circle(1);
		small.setCenterX(400); small.setCenterY(400);
		path.setNode(center); path.setPath(small);
		path.setCycleCount(PathTransition.INDEFINITE);
		path.setAutoReverse(true);
		path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		path.play();
		
		group.getChildren().addAll(big, center);
		Scene scene = new Scene(group, 800, 800, Color.YELLOW);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
		
	}
}
