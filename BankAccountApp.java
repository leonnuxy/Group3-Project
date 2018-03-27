
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
	static final String file_name = "Assign9/bank_file.txt";
	static File file = new File(file_name);
	public static boolean check;
	
	static BankAccount savings = new SavingsAccount();
	static BankAccount chequing = new ChequingAccount();
	static Customer customer;
	
	GridPane layout1, layout2, layout3, layout4, layout5;
	Button withdraw_button, deposit_button, create_sav_acc, create_chq_acc, submit;
	Label customer_ID_label, customer_label, acctType_label, customer_balance, error;
	TextField txtWithdraw, txtDeposit;
	
	static TextField txtName;
	
	static int customer_ID;
	static double balance;
	static String accountType = "";
	static String ID = "";
	static String name, cust_name;
	Random rand = new Random();
	
	public static boolean file_check() {
		if (file.exists()) {
			check = true;
		}
		return check;
	}
	
	// Reads the file if the Bank Text already exists
	public static void read_file(){
		String id, bal;
		
		try {
			FileReader file_r = new FileReader(file_name);
			BufferedReader file_out = new BufferedReader(file_r);
		
			//read actual lines
			accountType = Files.readAllLines(Paths.get(file_name)).get(0);
			name = Files.readAllLines(Paths.get(file_name)).get(1);
			id = Files.readAllLines(Paths.get(file_name)).get(2);
			ID = id;
			customer_ID = Integer.parseInt(id);
			bal = Files.readAllLines(Paths.get(file_name)).get(3);
			balance = Double.parseDouble(bal);
			
			//Set Variables
			customer = new Customer(name, customer_ID);
			chequing.setCustomer(customer);
			savings.setCustomer(customer);
			
			// Checks the type of account
			if (accountType.contains("ChequingAccount")) {
				chequing.deposit(balance);
			}
			if (accountType.contains("SavingsAccount")) {
    	    	savings.deposit(balance);
    	    }
			
			System.out.println(accountType);
			System.out.println(customer.getName());
			System.out.println(customer.getID());
			System.out.println(chequing.getBalance());
			System.out.println(savings.getBalance());
			
			//close file
			file_out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found creating a new file.");
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//New account creation
	    BorderPane root = new BorderPane();
	    root.setPadding(new Insets(10,10,10,10));
	    root.setTop(new Label("Please select an account to create: "));
	    
	    // Choice: First Screen
	    layout1 = new GridPane();
	    layout1.setVgap(10);
	    layout1.setHgap(5);
	    create_sav_acc = new Button("Create Savings Account");
	    layout1.add(create_sav_acc, 0, 0);
	    create_chq_acc = new Button("Create Chequing Account");
	    layout1.add(create_chq_acc, 0, 1);
	    root.setCenter(layout1);
	    
	    //Both Account Creation in Second Screen
	    layout2 = new GridPane();
	    layout2.setVgap(10);
	    layout2.setHgap(5);
	    customer_ID = rand.nextInt(9999 - 1000 + 1) + 1000;
	    customer_ID_label = new Label("Customer ID is: " + customer_ID);
	    txtName = new TextField("Enter name here");
	    submit = new Button("Sumbit");
	    layout2.add(customer_ID_label, 0, 1);
	    layout2.add(txtName, 0, 2);
	    layout2.add(submit, 0, 3);
	    
	    //Chequing Account & Savings Account Information and Deposit + Withdraw
	    layout3 = new GridPane();
	    layout3.setVgap(10);
	    layout3.setHgap(5);
	    if (accountType.contains("ChequingAccount")) {
	    	balance = chequing.getBalance();
	    }
	    if (accountType.contains("SavingsAccount")) {
	    	balance = savings.getBalance();
	    }
	    customer_balance = new Label("");
	    customer_balance.setText("Your balance is " + balance);
	    withdraw_button = new Button("Withdraw");
	    layout3.add(withdraw_button, 0, 2);
	    deposit_button = new Button("Deposit");
	    layout3.add(deposit_button, 0,3);
	    txtWithdraw = new TextField("0");
	    txtWithdraw.setPrefWidth(100);
	    txtDeposit = new TextField("0");
	    txtDeposit.setPrefWidth(100);
	    error = new Label("");
	    customer_label = new Label("");
	    layout3.add(customer_label, 0, 1);
	    layout3.add(txtWithdraw, 1, 2);
	    layout3.add(txtDeposit, 1, 3);
	    layout3.add(customer_balance, 1, 4);
	    layout3.add(error, 1, 5);
	    
	    // Create button for SavingsAccount
	    create_sav_acc.setOnAction(new EventHandler<ActionEvent>(){
	      @Override
	      public void handle(ActionEvent event) {
	    	  	accountType = "SavingsAccount";
		    	acctType_label = new Label(""+accountType+"");
		    	layout2.add(acctType_label, 0, 0);
		    	layout4.add(acctType_label, 0, 0);
	    	  	Scene scene2 = new Scene(layout2, 400, 400);
	    	  	primaryStage.setScene(scene2);
	      }});
	    
	    // Create button for ChequingAccount
	    create_chq_acc.setOnAction(new EventHandler<ActionEvent>(){
	      @Override
	      public void handle(ActionEvent event) {
	    	accountType = "ChequingAccount";
	    	acctType_label = new Label(""+accountType+"");
	    	layout2.add(acctType_label, 0, 0);
	    	layout4.add(acctType_label, 0, 0);
    	  	Scene scene2 = new Scene(layout2, 400, 400);
    	  	primaryStage.setScene(scene2);
	      }});
	    
	    // Submit button for ChequingAccount & SavingsAccount
	    submit.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
    	  	cust_name = txtName.getText();
    	  	customer = new Customer(cust_name, customer_ID);
    	  	customer_label.setText("Hello " + customer.getName() + " " + customer.getID());
    	  	
    	  	if (accountType.contains("ChequingAccount")) {
    	  		chequing.setCustomer(customer);
    	    }
    	    if (accountType.contains("SavingsAccount")) {
    	    	savings.setCustomer(customer);
    	    }
    	  	
    	  	acctType_label = new Label(""+accountType+"");
        	layout3.add(acctType_label, 0, 0);
    	  	Scene scene4 = new Scene(layout4, 400, 400);
    	  	primaryStage.setScene(scene4);
	      }});	    
	    
	    
	    // For the last Screen when file does not exists.
	    layout4 = new GridPane();
	    layout4.setVgap(10);
	    layout4.setHgap(5);
	    
	    if (accountType.contains("ChequingAccount")) {
	    	balance = chequing.getBalance();
	    	customer_balance = new Label("");
	    	customer_balance.setText("Your balance is " + balance);
	    }
	    if (accountType.contains("SavingsAccount")) {
	    	balance = savings.getBalance();
	    	customer_balance = new Label("");
	    	customer_balance.setText("Your balance is " + balance);
	    }
	    
	    withdraw_button = new Button("Withdraw");
	    deposit_button = new Button("Deposit");
	    txtWithdraw = new TextField("0");
	    txtWithdraw.setPrefWidth(100);
	    txtDeposit = new TextField("0");
	    txtDeposit.setPrefWidth(100);
	    error = new Label("");	    
	    acctType_label = new Label(""+accountType+"");
	    layout4.add(withdraw_button, 0, 2);
	    layout4.add(deposit_button, 0,3);
	    layout4.add(acctType_label, 0, 0);
	    layout4.add(customer_label, 0, 1);
	    layout4.add(txtWithdraw, 1, 2);
	    layout4.add(txtDeposit, 1, 3);
	    layout4.add(customer_balance, 1, 4);
	    layout4.add(error, 1, 5);
	       
	    if (file_check()) {
	    
	    	//	Used by File Reader
	    	// For the last Screen when file exists.
		    layout5 = new GridPane();
		    layout5.setVgap(10);
		    layout5.setHgap(5);
		    
		    customer_balance = new Label("");
		    customer_balance.setText("Your balance is " + balance);
		    withdraw_button = new Button("Withdraw");
		    deposit_button = new Button("Deposit");
		    txtWithdraw = new TextField("0");
		    txtWithdraw.setPrefWidth(100);
		    txtDeposit = new TextField("0");
		    txtDeposit.setPrefWidth(100);
		    error = new Label("");
		    customer_label = new Label("Hello "+name+"  "+ID+"");
		    
		    acctType_label = new Label(""+accountType+"");
		    
		    layout5.add(withdraw_button, 0, 2);
		    layout5.add(deposit_button, 0,3);
		    layout5.add(acctType_label, 0, 0);
		    layout5.add(customer_label, 0, 1);
		    layout5.add(txtWithdraw, 1, 2);
		    layout5.add(txtDeposit, 1, 3);
		    layout5.add(customer_balance, 1, 4);
		    layout5.add(error, 1, 5);
	    } 
	    
	    // Last screen 
	    // Withdraw button for ChequingAccount & SavingsAccount
	    //Uses layout3
	    withdraw_button.setOnAction(new EventHandler<ActionEvent>(){
	      @Override
	      public void handle(ActionEvent event) {
    	  	  try {
    	  		  
	    	  	double withdraw_amount = Double.parseDouble(txtWithdraw.getText());
	    	  	if (accountType.contains("ChequingAccount")){
	    	  		chequing.withdraw(withdraw_amount);
		    	  	customer_balance.setText("Your balance is "+ chequing.getBalance());

		    	  	//write_file();
	    	    }
	    	    if (accountType.contains("SavingsAccount")){
	    	    	savings.withdraw(withdraw_amount);
	    	    	customer_balance.setText("Your balance is "+ savings.getBalance());
	    	    	
	    	    	//write_file();
	    	    }
	    		 
	    	  	  error.setText("");
    	  	  }
    	  	  catch (NumberFormatException e) {
    	  		  error.setText("Error, you must input a number. ");
    	  	  }
	      }});
	    
	    // Last screen 
	    // Deposit button for ChequingAccount & SavingsAccount
	    //Uses layout3
	    deposit_button.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  
    	  	  try {
	    	  	  double deposit_amount = Double.parseDouble(txtDeposit.getText());
	    	  	if (accountType.contains("ChequingAccount")){
	    	  		
	    	  		chequing.deposit(deposit_amount);
	    	  		double bal_1 = chequing.getBalance();
		    	  	customer_balance.setText("Your balance is "+ bal_1);
		    	  	
		    	  	//write_file();
	    	    }
	    	    if (accountType.contains("SavingsAccount")){
	    	    	savings.deposit(deposit_amount);
	    	    	double bal_1 = savings.getBalance();
	    	    	customer_balance.setText("Your balance is "+ bal_1);
	    	    	
	    	    	//write_file();
	    	    }
	    	  	  error.setText("");
	    	  	  
    	  	  }
    	  	  catch (NumberFormatException e) {
    	  		  error.setText("Error, you must input a number. ");
    	  	  }
	      }});
	 	
	   
	 	if (file_check()) {
	 		Scene scene5 = new Scene(layout5, 450, 450);
	 		primaryStage.setScene(scene5);
	 		primaryStage.show();
	 	}
	 	else {
	 		Scene scene = new Scene(root, 450, 150);
		 	primaryStage.setTitle("Group3 Financial Bank");
		 	primaryStage.setScene(scene);
	 		primaryStage.show();
	 	}    
	}
	
	// if file does not exist
	public static void write_file(){

		String name = txtName.getText();
		
		try {
			FileWriter file_w = new FileWriter(file_name);
			BufferedWriter file_in = new BufferedWriter(file_w);
			
			//write id, account type, balance.
			file_in.write(accountType); file_in.newLine();
			file_in.write(name); file_in.newLine();
			String id = Integer.toString(customer.getID());
			System.out.print(id);
			file_in.write(id); file_in.newLine();
			if (accountType.contains("ChequingAccount")){
	    	  	String bal = Double.toString(chequing.getBalance());
	    	  	file_in.write(bal);
    	    }
    	    if (accountType.contains("SavingsAccount")){
    	    	String bal = Double.toString(savings.getBalance());
    		    file_in.write(bal);
    	    }
						
			//Close file
			file_in.flush();
			file_in.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		if (file_check()) {
		read_file();
		launch(args);
		}
		else {
			launch(args);
			write_file();
		}		
	}
}
