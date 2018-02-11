import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BankAccountWindow extends Application {
    BankAccount b1 = new BankAccount();
    Button withdraw_button;
    Button deposit_button;
    TextField txtWithdraw, txtDeposit;
    Label customer_balance;
    
    /**public static void main(String[] args) {
        launch(args);
    }*/
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));
        
        double bank_balance = b1.getBalance();
        root.setTop(new Label("For depositing and withdrawing money from your account."));
        customer_balance = new Label("");
        root.setBottom(customer_balance);
        customer_balance.setText("Your balance is " + bank_balance);
        
        GridPane center = new GridPane();
        center.setVgap(10);
        center.setHgap(5);
        withdraw_button = new Button("Withdraw");
        center.add(withdraw_button, 0, 0);
        deposit_button = new Button("Deposit");
        center.add(deposit_button, 0, 1);
        txtWithdraw = new TextField("0");
        txtWithdraw.setPrefWidth(100);
        txtDeposit = new TextField("0");
        txtDeposit.setPrefWidth(100);
        center.add(txtWithdraw, 1, 0);
        center.add(txtDeposit, 1, 1);
        root.setCenter(center);
        
        deposit_button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                double deposit_amount = Integer.parseInt(txtDeposit.getText());
                b1.deposit(deposit_amount);
                double bank_balance = b1.getBalance();
                customer_balance.setText("Your balance is " + bank_balance);
                
            }
        }
        );
        
        withdraw_button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                double withdraw_amount = Integer.parseInt(txtWithdraw.getText());
                b1.withdraw(withdraw_amount);
                double bank_balance = b1.getBalance();
                customer_balance.setText("Your balance is " + bank_balance);
            }
        }
        );
        
        
        
        Scene scene = new Scene(root, 450, 150);
        primaryStage.setTitle("Bank Account");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
