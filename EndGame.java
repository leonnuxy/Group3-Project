import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EndGame extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		Button butt = new Button("Play Again");
		Button butt2 = new Button("Quit");
		butt.setLayoutX(100);
		butt.setLayoutY(150);
		butt2.setLayoutX(200);
		butt2.setLayoutY(150);
		TimerS.setEndTime();
		Label lab = new Label("Your Final Score is "+ Score.getScore() * TimerS.getTotalTime());
		lab.setLayoutX(10);
		lab.setLayoutY(200/2);
		root.getChildren().addAll(butt, butt2, lab);
		Scene newScene = new Scene(root, 300,300, Color.RED);
		primaryStage.setScene(newScene);
		primaryStage.show();
		butt.setOnAction(e -> {
			primaryStage.close();
			Menu menu = new Menu();
			LevelActions.timeline = new Timeline();
			menu.start(primaryStage);
		});
		
		butt2.setOnAction(e -> {
			System.exit(0);
		});
		
	}

}
