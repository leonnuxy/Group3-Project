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

// Creates the class for with the application is named.
public class BankAccountWindow extends Application {

// contsructor to refrence the customer from the
// Customer class and assigns to the variable "c1".
  Customer c1 = new Customer();

// contsructor to refrence the information of
//the customer from the BankAccount class which also references
//the Customer class within it and assigns it to the varaible b.
  BankAccount b1 = new BankAccount(c1);

  //creates required buttons, labels and textfeilds.
  Button withdraw_button;
  Button deposit_button;
  TextField txtWithdraw, txtDeposit;
  Label customer_balance;

  @Override
  //creates the stage/window and adds the labels and appropriate items.
  public void start(Stage primaryStage) throws Exception {

    // creates the borders and sets the areas.
    BorderPane root = new BorderPane();
    root.setPadding(new Insets(10,10,10,10));

    // displayes the balance of customer
    double bank_balance = b1.getBalance();
    root.setTop(new Label("Hello "+ c1.getName()+ " Deposit and Withdraw from Account"));
    customer_balance = new Label("");
    root.setBottom(customer_balance);
    customer_balance.setText("Your balance is " + bank_balance);

    // defines the size of pane.
    GridPane center = new GridPane();
    center.setVgap(10);
    center.setHgap(5);

    // sets the layouts for buttons and textfieldss.
    withdraw_button = new Button("Withdraw");
    center.add(withdraw_button, 0, 0);

    // for deposit button
    deposit_button = new Button("Deposit");
    center.add(deposit_button, 0, 1);

    // for withdraw button.
    txtWithdraw = new TextField("0");
    txtWithdraw.setPrefWidth(100);

    // for deposit textfield box
    txtDeposit = new TextField("0");
    txtDeposit.setPrefWidth(100);

    // for withdraw textfield box.
    center.add(txtWithdraw, 1, 0);
    center.add(txtDeposit, 1, 1);
    root.setCenter(center);

    // method for handling "deposit" inputs.
    deposit_button.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      // handles the input and key actions.
      // prints the current balance of the customer after each deposit
      public void handle(ActionEvent event) {
        double deposit_amount = Double.parseDouble(txtDeposit.getText());
        b1.deposit(deposit_amount);
        double bank_balance = b1.getBalance();
        customer_balance.setText("Your balance is " + bank_balance);
      }
    }
    );

    // method for handling "withdraw" inputs.
    withdraw_button.setOnAction(new EventHandler<ActionEvent>()
    {
      // defines the input and key events.
      // prints the current balance of the customer after each withdrawal
      @Override
      public void handle(ActionEvent event) {
        double withdraw_amount = Double.parseDouble(txtWithdraw.getText());
        b1.withdraw(withdraw_amount);
        double bank_balance = b1.getBalance();
        customer_balance.setText("Your balance is " + bank_balance);
      }
    }
    );

    //Sets the title of the popup window "Group3 Financial Bank".
    Scene scene = new Scene(root, 450, 150);
    primaryStage.setTitle("Group3 Financial Bank");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
