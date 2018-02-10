import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.AnimationTimer;

public class BankAccountWindow extends Application {
    
    String name = "";
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Widget Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
        VBox root = new VBox();
        Label deposit = new Label("Deposit");
        Label withdraw = new Label("Withdraw");
        root.getChildren().add(deposit);
        root.getChildren().add(withdraw);
        
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        
        root.getChildren().add(depositButton);
        root.getChildren().add(withdrawButton);
        
        TextField entry = new TextField();
        entry.setPrefWidth(50);
        root.getChildren().add(entry);
        name = entry.getText();
    }
    
}
