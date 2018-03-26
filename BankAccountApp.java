import java.util.Random;
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


public class BankAccountApp extends Application {
	
	//This will be the file handling app
	////BankInterface bi = new BankInterface();
	//instance variables
	//String cust_name;
	SavingsAccount s1 = new SavingsAccount();
	ChequingAccount ca1 = new ChequingAccount();
	Button create_chq_acc;
	Button create_sav_acc;
	Button withdraw_button_chq;
	Button deposit_button_chq;
	Button withdraw_button_sav;
	Button deposit_button_sav;
	Button submit_sav_acc;
	Button submit_chq_acc;
	TextField txtWithdrawChq, txtDepositChq, txtWithdrawSav, txtDepositSav, txtNameChq, txtNameSav;
	Label customer_ID_label, customer_name_label_sav, customer_name_label_chq;
	Label customer_balance_chq, customer_balance_sav, error_chq, error_sav;
	int customer_ID;
	Random rand = new Random();
	
	@Override
	  public void start(Stage primaryStage) throws Exception {
		//New account creation
	    BorderPane root = new BorderPane();
	    root.setPadding(new Insets(10,10,10,10));
	    root.setTop(new Label("Please select an account to create: "));
	    GridPane layout1 = new GridPane();
	    layout1.setVgap(10);
	    layout1.setHgap(5);
	    create_sav_acc = new Button("Create Savings Account");
	    layout1.add(create_sav_acc, 0, 0);
	    create_chq_acc = new Button("Create Chequing Account");
	    layout1.add(create_chq_acc, 0, 1);
	    root.setCenter(layout1);
	    
	    //Savings Account Creation
	    GridPane layout2 = new GridPane();
	    layout2.setVgap(10);
	    layout2.setHgap(5);
	    customer_ID = rand.nextInt(9999 - 1000 + 1) + 1000;
	    customer_ID_label = new Label("Customer ID is: " + customer_ID);
	    txtNameSav = new TextField("Enter name here");
	    submit_sav_acc = new Button("Sumbit");
	    layout2.add(customer_ID_label, 0, 0);
	    layout2.add(txtNameSav, 0, 1);
	    layout2.add(submit_sav_acc, 0, 2);
	    
	    //Chequing Account Creation
	    GridPane layout3 = new GridPane();
	    layout3.setVgap(10);
	    layout3.setHgap(5);
	    customer_ID = rand.nextInt(9999 - 1000 + 1) + 1000;
	    customer_ID_label = new Label("Customer ID is: " + customer_ID);
	    txtNameChq = new TextField("Enter name here");
	    submit_chq_acc = new Button("Sumbit");
	    layout3.add(customer_ID_label, 0, 0);
	    layout3.add(txtNameChq, 0, 1);
	    layout3.add(submit_chq_acc, 0, 2);
	    
	    //Chequing Account Information and Deposit + Withdraw
	    GridPane layout4 = new GridPane();
	    layout4.setVgap(10);
	    layout4.setHgap(5);
	    double bank_balance_chq = ca1.getBalance();
	    customer_balance_chq = new Label("");
	    customer_balance_chq.setText("Your balance is " + bank_balance_chq);
	    withdraw_button_chq = new Button("Withdraw");
	    layout4.add(withdraw_button_chq, 0, 1);
	    deposit_button_chq = new Button("Deposit");
	    layout4.add(deposit_button_chq, 0,2);
	    txtWithdrawChq = new TextField("0");
	    txtWithdrawChq.setPrefWidth(100);
	    txtDepositChq = new TextField("0");
	    txtDepositChq.setPrefWidth(100);
	    error_chq = new Label("");
	    customer_name_label_chq = new Label("");
	    layout4.add(customer_name_label_chq, 0, 0);
	    layout4.add(txtWithdrawChq, 1, 1);
	    layout4.add(txtDepositChq, 1, 2);
	    layout4.add(customer_balance_chq, 1, 3);
	    layout4.add(error_chq, 1, 4);
	    
	    //Savings Account Information and Deposit + Withdraw
	    GridPane layout5 = new GridPane();
	    layout5.setVgap(10);
	    layout5.setHgap(5);
	    double bank_balance_sav = ca1.getBalance();
	    customer_balance_sav = new Label("");
	    customer_balance_sav.setText("Your balance is " + bank_balance_sav);
	    withdraw_button_sav = new Button("Withdraw");
	    layout5.add(withdraw_button_sav, 0, 1);
	    deposit_button_sav = new Button("Deposit");
	    layout5.add(deposit_button_sav, 0, 2);
	    txtWithdrawSav = new TextField("0");
	    txtWithdrawSav.setPrefWidth(100);
	    txtDepositSav = new TextField("0");
	    txtDepositSav.setPrefWidth(100);
	    error_sav = new Label("");
	    customer_name_label_sav = new Label("");
	    layout5.add(customer_name_label_sav, 0, 0);
	    layout5.add(txtWithdrawSav, 1, 1);
	    layout5.add(txtDepositSav, 1, 2);
	    layout5.add(customer_balance_sav, 1, 3);
	    layout5.add(error_sav, 1, 4);
	    
	    create_sav_acc.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  	Scene scene2 = new Scene(layout2, 400, 400);
	    	  	primaryStage.setScene(scene2);
	      }
	    }
	    );
	    
	    
	    create_chq_acc.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  	Scene scene3 = new Scene(layout3, 400, 400);
	    	  	primaryStage.setScene(scene3);
	      }
	    }
	    );
	    
	    submit_chq_acc.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  	String cust_name_chq = txtNameChq.getText();
	    	  	Customer c2 = new Customer(cust_name_chq, customer_ID);
	    	  	customer_name_label_chq.setText("Hello " + c2.getName() + " " + c2.getID());
	    	  	ca1.setCustomer(c2);
	    	  	Scene scene4 = new Scene(layout4, 400, 400);
	    	  	primaryStage.setScene(scene4);
	      }
	    }
	    );
	    
	    submit_sav_acc.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  	String cust_name_sav = txtNameSav.getText();
	    	  	Customer c1 = new Customer(cust_name_sav, customer_ID);
	    	  	customer_name_label_sav.setText("Hello " + c1.getName() + " " + c1.getID());
	    	  	s1.setCustomer(c1);
	    	  	Scene scene5 = new Scene(layout5, 400, 400);
	    	  	primaryStage.setScene(scene5);
	      }
	    }
	    );
	    
	    //Uses layout4
	    withdraw_button_chq.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  	  try {
		    	  	  double withdraw_amount_chq = Double.parseDouble(txtWithdrawChq.getText());
		          ca1.withdraw(withdraw_amount_chq);
		          double bank_balance_chq = ca1.getBalance();
		          customer_balance_chq.setText("Your balance is "+ bank_balance_chq);
		    	  	  //System.out.println(ca1);
		          error_chq.setText("");
	    	  	  }
	    	  	  catch (NumberFormatException e) {
	    	  		  error_chq.setText("Error, you must input a number. ");
	    	  	  }
	      }
	    }
	    );
	    
	    //Uses layout5
	    deposit_button_chq.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  	  try {
		    	  	  double deposit_amount_chq = Double.parseDouble(txtDepositChq.getText());
		          ca1.deposit(deposit_amount_chq);
		          double bank_balance_chq = ca1.getBalance();
		          customer_balance_chq.setText("Your balance is "+ bank_balance_chq);
		          error_chq.setText("");
		    	  	  //System.out.println(ca1);
	    	  	  }
	    	  	  catch (NumberFormatException e) {
	    	  		  error_chq.setText("Error, you must input a number. ");
	    	  	  }
	      }
	    }
	    );
	    
	    
		withdraw_button_sav.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	      try {
		    	  	  double withdraw_amount_sav = Double.parseDouble(txtWithdrawSav.getText());
		          s1.withdraw(withdraw_amount_sav);
		          double bank_balance_sav = s1.getBalance();
		          customer_balance_sav.setText("Your balance is "+ bank_balance_sav);
		          error_sav.setText("");
		    	  	  System.out.println(s1);
	    	      }
	    	      catch (NumberFormatException e) {
	    	    	  	  error_sav.setText("Error, you must input a number. ");
	    	      }
	      }
	    }
	    );
	    
	    deposit_button_sav.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	      try {
		    	  	  double deposit_amount_sav = Double.parseDouble(txtDepositSav.getText());
		          s1.deposit(deposit_amount_sav);
		          double bank_balance_sav = s1.getBalance();
		          customer_balance_sav.setText("Your balance is "+ bank_balance_sav);
		          error_sav.setText("");
		    	  	  System.out.println(s1);
	    	      }
	    	      catch (NumberFormatException e) {
	    	    	  	  error_sav.setText("Error, you must input a number. ");
	    	      }
	      }
	    }
	    );
	    
	    
	    Scene scene = new Scene(root, 450, 150);
	    primaryStage.setTitle("Group3 Financial Bank");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	}
	
}
