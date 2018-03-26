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

// Some Classes in this Program were taken from the textbook and are identified below.
/** Class creates GUI allowing user to create new bankAccounts and deposit and withdraw from account. */ 
public class BankAccountWindow extends Application {
  
  // Initialization of GUI widgets. New BankAccount object b1 created.
  BankAccount b1 = new BankAccount();
  Button create_button1;
  Label cusId, cusName, newBal;
  TextField id, name, bal;
  Stage window;
  Scene scene1, scene2;
  Button withdraw_button;
  Button deposit_button;
  Button create_button;
  TextField txtWithdraw, txtDeposit;
  Label customer_balance;


  @Override
  public void start(Stage primaryStage) throws Exception {
    
	// Creation of start window displaying balance and greeting message
	// allowing depositing and withdrawing.
	BorderPane roots = new BorderPane();
    roots.setPadding(new Insets(10,10,10,10));
    window = primaryStage;
    double bank_balance = b1.getBalance();
    roots.setTop(new Label("Hello Deposit and Withdraw from Account"));
    customer_balance = new Label("");
    roots.setBottom(customer_balance);
    customer_balance.setText("Your balance is " + bank_balance);
    GridPane layout = new GridPane();
    layout.setVgap(10);
    layout.setHgap(5);
    withdraw_button = new Button("Withdraw");
    layout.add(withdraw_button, 0, 0);
    deposit_button = new Button("Deposit");
    layout.add(deposit_button, 0, 1);
    txtWithdraw = new TextField("0");
    txtWithdraw.setPrefWidth(100);
    txtDeposit = new TextField("0");
    txtDeposit.setPrefWidth(100);
    layout.add(txtWithdraw, 1, 0);
    layout.add(txtDeposit, 1, 1);
    roots.setCenter(layout);

    // Creates of the window responsible for bank account creation 
	// allows for entry of customer ID and customer name.
    create_button = new Button("Create");
    layout.add(create_button, 0, 4);
    create_button.setOnAction(e -> window.setScene(scene2));
    GridPane layout1 = new GridPane();
    layout1.setVgap(10);
    layout1.setHgap(5);
    cusId = new Label("Customer ID:");
    layout1.add(cusId, 0, 0);
    cusName = new Label("Customer Name:");
    layout1.add(cusName, 0, 1);
    newBal = new Label("Start Balance");
    layout1.add(newBal, 0, 2);
    create_button1 = new Button("Create");
    layout1.add(create_button1, 0, 4);
    id = new TextField("");
    id.setPrefWidth(100);
    name = new TextField("");
    name.setPrefWidth(100);
    bal = new TextField("0.0");
    bal.setPrefWidth(100);
    layout1.add(id, 1, 0);
    layout1.add(name, 1, 1);
    layout1.add(bal, 1, 2);

    // Event handler to change the scene and to display
    // the balance and also to create a new BankAccount object.
    create_button1.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event) {
        double startBal = Double.parseDouble(bal.getText());
        b1.setBalance(startBal);
        double bank_balance = b1.getBalance();
        customer_balance.setText("Your balance is " + bank_balance);
        window.setScene(scene1);
        String customerName = name.getText();
        roots.setTop(new Label("Hello " + customerName +
        " Deposit and Withdraw from your Account"));
        int customerId = Integer.parseInt(id.getText());
        Customer customerInfo = new Customer(customerName,customerId);
        BankAccount c = new BankAccount(customerInfo,startBal);
      }
    }
    );
    scene2 = new Scene(layout1, 450, 250);


    // Class referenced from textbook.
    // method for handling "deposit" entry.
    deposit_button.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event) {
        double deposit_amount = Double.parseDouble(txtDeposit.getText());
        b1.deposit(deposit_amount);
        double bank_balance = b1.getBalance();
        customer_balance.setText("Your balance is "+ bank_balance);
      }
    }
    );

    // Class referenced from the textbook.
    // method for handling "withdraw" entry.
    withdraw_button.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event) {
        double withdraw_amount = Double.parseDouble(txtWithdraw.getText());
        b1.withdraw(withdraw_amount);
        double bank_balance = b1.getBalance();
        customer_balance.setText("Your balance is "+ bank_balance);
      }
    }
    );

    // Sets new Scene and shows the first scene (scene1).
    scene1 = new Scene(roots, 450, 250);
    window.setScene(scene1);
    window.setTitle("Group3 Financial Bank");
    window.show();

  }
}
