import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Level3 extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane group = new Pane();
		
		// Done
		Rectangle rectTop = new Rectangle(200, 0, 400, 150);
		rectTop.setFill(Color.RED);
		
		// Done
		Rectangle rectTopRight = new Rectangle(700, 0, 100, 100);
		rectTopRight.setFill(Color.RED);
		
		// Done
		Rectangle rectRight = new Rectangle(650, 200, 150, 400);
		rectRight.setFill(Color.RED);
		
		// Done
		Rectangle rectBottRight = new Rectangle(700, 700, 100, 100);
		rectBottRight.setFill(Color.RED);
		
		// Done
		Rectangle rectBott = new Rectangle(200, 650, 400, 150);
		rectBott.setFill(Color.RED);
		
		// Done
		Rectangle rectBottLeft = new Rectangle(0, 700, 100, 100);
		rectBottLeft.setFill(Color.RED);
		
		// Done
		Rectangle rectLeft = new Rectangle(0, 200, 150, 400);
		rectLeft.setFill(Color.RED);
		
		// Done
		Rectangle rectCen = new Rectangle(300, 350, 200, 100);
		rectCen.setFill(Color.RED);
		
		
		
		Label pos = new Label();
		group.getChildren().addAll(pos, rectTop, rectCen, rectBott, 
				rectRight, rectLeft, rectBottRight, rectBottLeft, rectTopRight);
		group.setOnMouseMoved((evt) -> { 
			String pos1 = ("x = "+ evt.getX() +",  y = " + evt.getY());
			pos.setLayoutX(5);
			pos.setText(pos1);
			pos.setLayoutY(5);		} );

		Scene scene = new Scene(group, 800, 800, Color.YELLOW);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
