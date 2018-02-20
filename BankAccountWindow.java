import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// Some Classes in this Porgram were gotten from the textbook and are identified below.
// Creates the class for with the application is named.
public class BankAccountWindow extends Application {

  Stage window;
  Scene scene2;

//The BankAccount class which also references "getCustomer" method through
// the Customer class within it and assigns it to "b1.getCustomer".
  BankAccount b1 = new BankAccount();
  Button withdraw_button;
  Button deposit_button;
  Button create_button;
  TextField txtWithdraw, txtDeposit;
  Label customer_balance;

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    BorderPane root = new BorderPane();
    root.setPadding(new Insets(10,10,10,10));

    // displayes the balance of customer
    double bank_balance = b1.getBalance();
    root.setTop(new Label("Hello Mr/Mrs/Miss "+ b1.getCustomer() + " Deposit and Withdraw from Account")); //"/* + c1.getName()+*/ "
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


    create_button = new Button("Create");
    create_button.setOnAction(e -> window.setScene(scene2));
    VBox layout1 = new VBox(20);
    layout1.getChildren().addAll(create_button, customer_balance);
    scene2 = new Scene(layout1, 450, 150);
    center.add(create_button, 0, 2);


    txtWithdraw = new TextField("0");
    txtWithdraw.setPrefWidth(100);
    txtDeposit = new TextField("0");
    txtDeposit.setPrefWidth(100);
    center.add(txtWithdraw, 1, 0);
    center.add(txtDeposit, 1, 1);
    root.setCenter(center);

    // Class referenced from textbook.
    // method for handling "deposit" inputs.



    deposit_button.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event) {
        double deposit_amount = Double.parseDouble(txtDeposit.getText());
        b1.deposit(deposit_amount);
        double bank_balance = b1.getBalance();
        customer_balance.setText("Your balance is " + bank_balance);
      }
    }
    );

    // Class referenced from the textbook.
    // method for handling "withdraw" inputs.
    withdraw_button.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event) {
        double withdraw_amount = Double.parseDouble(txtWithdraw.getText());
        b1.withdraw(withdraw_amount);
        double bank_balance = b1.getBalance();
        customer_balance.setText("Your balance is " + bank_balance);
      }
    }
    );

    Scene sceneBank = new Scene(root, 450, 150);
    window.setTitle("Group3 Financial Bank");
    window.setScene(sceneBank);
    window.show();

  }
}
