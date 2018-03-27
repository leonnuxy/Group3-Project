
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	////BankInterface bi = new BankInterface();
	//instance variables
	//String cust_name;
	static final String file_name = "Assign9/bank_file.txt";
	public static boolean check = false;
	static SavingsAccount s1 = new SavingsAccount();
	static ChequingAccount ca1 = new ChequingAccount();
	Button withdraw_button, deposit_button, create_sav_acc, create_chq_acc, submit;
	TextField txtWithdraw, txtDeposit;
	static TextField txtName;
	Label customer_ID_label, customer_name_label, acctType_label, customer_balance, error;
	static int customer_ID;
	static double gen_bal;
	static String accountType;
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
	    
	    //Both Account Creation
	    GridPane layout2 = new GridPane();
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
	    GridPane layout3 = new GridPane();
	    layout3.setVgap(10);
	    layout3.setHgap(5);
	    if (accountType == "ChequingAccount") {
	    	gen_bal = ca1.getBalance();
	    }
	    if (accountType == "SavingsAccount") {
	    	gen_bal = s1.getBalance();
	    }
	    double bank_balance_chq = gen_bal;
	    customer_balance = new Label("");
	    customer_balance.setText("Your balance is " + bank_balance_chq);
	    withdraw_button = new Button("Withdraw");
	    
	    layout3.add(withdraw_button, 0, 2);
	
	    deposit_button = new Button("Deposit");
	    
	    layout3.add(deposit_button, 0,3);
	    
	    txtWithdraw = new TextField("0");
	    txtWithdraw.setPrefWidth(100);
	    txtDeposit = new TextField("0");
	    txtDeposit.setPrefWidth(100);
	    error = new Label("");
	    customer_name_label = new Label("");
	    
	    layout3.add(customer_name_label, 0, 1);
	    layout3.add(txtWithdraw, 1, 2);
	    layout3.add(txtDeposit, 1, 3);
	    layout3.add(customer_balance, 1, 4);
	    layout3.add(error, 1, 5);
	    
	    // For the last Screen
	    GridPane layout4 = new GridPane();
	    layout4.setVgap(10);
	    layout4.setHgap(5);
	    if (accountType == "ChequingAccount") {
	    	gen_bal = ca1.getBalance();
	    }
	    if (accountType == "SavingsAccount") {
	    	gen_bal = s1.getBalance();
	    }
	    double bank_balance = gen_bal;
	    customer_balance = new Label("");
	    customer_balance.setText("Your balance is " + bank_balance);
	    withdraw_button = new Button("Withdraw");
	    
	    layout4.add(withdraw_button, 0, 2);
	
	    deposit_button = new Button("Deposit");
	    
	    layout4.add(deposit_button, 0,3);
	    
	    txtWithdraw = new TextField("0");
	    txtWithdraw.setPrefWidth(100);
	    txtDeposit = new TextField("0");
	    txtDeposit.setPrefWidth(100);
	    error = new Label("");
	    customer_name_label = new Label("");
	    
	    layout4.add(customer_name_label, 0, 1);
	    layout4.add(txtWithdraw, 1, 2);
	    layout4.add(txtDeposit, 1, 3);
	    layout4.add(customer_balance, 1, 4);
	    layout4.add(error, 1, 5);
	    
	    // Create button for ChequingAccount
	    // Goes to same screen as SavingsAccount.
	    create_sav_acc.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  	accountType = "SavingsAccount";
		    	acctType_label = new Label(""+accountType+"");
		    	layout2.add(acctType_label, 0, 0);
	    	  	Scene scene2 = new Scene(layout2, 400, 400);
	    	  	primaryStage.setScene(scene2);
	      }
	    }
	    );
	    
	    // Create button for ChequingAccount
	    // Goes to same screen as SavingsAccount.
	    create_chq_acc.setOnAction(new EventHandler<ActionEvent>(){
	      @Override
	      public void handle(ActionEvent event) {
	    	accountType = "ChequingAccount";
	    	acctType_label = new Label(""+accountType+"");
	    	layout2.add(acctType_label, 0, 0);
    	  	Scene scene2 = new Scene(layout2, 400, 400);
    	  	primaryStage.setScene(scene2);
    	  	
    	  	
	      }
	    }
	    );
	    
	    // Submit button for ChequingAccount & SavingsAccount
	    submit.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
    	  	String cust_name = txtName.getText();
    	  	Customer c2 = new Customer(cust_name, customer_ID);
    	  	customer_name_label.setText("Hello " + c2.getName() + " " + c2.getID());
    	  	ca1.setCustomer(c2);
    	  	s1.setCustomer(c2);
    	  	acctType_label = new Label(""+accountType+"");
        	layout3.add(acctType_label, 0, 0);
    	  	Scene scene4 = new Scene(layout3, 400, 400);
    	  	primaryStage.setScene(scene4);
	      }
	    }
	    );
	    
	    // Last screen 
	    // Withdraw button for ChequingAccount & SavingsAccount
	    //Uses layout3
	    withdraw_button.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
    	  	  try {
	    	  	  double withdraw_amount = Double.parseDouble(txtWithdraw.getText());
	    	  	if (accountType == "ChequingAccount") {
	    	  		ca1.withdraw(withdraw_amount);
		    	  	double bank_balance = ca1.getBalance();
		    	  	customer_balance.setText("Your balance is "+ bank_balance);
	    	    }
	    	    if (accountType == "SavingsAccount") {
	    	    	s1.withdraw(withdraw_amount);
	    	    	double bank_balance = s1.getBalance();
	    	    	customer_balance.setText("Your balance is "+ bank_balance);
	    	    }
	    		  //System.out.println(ca1);
	    	  	  error.setText("");
    	  	  }
    	  	  catch (NumberFormatException e) {
    	  		  error.setText("Error, you must input a number. ");
    	  	  }
	      }
	    }
	    );
	    
	    // Last screen 
	    // Deposit button for ChequingAccount & SavingsAccount
	    //Uses layout3
	    deposit_button.setOnAction(new EventHandler<ActionEvent>()
	    {
	      @Override
	      public void handle(ActionEvent event) {
	    	  
    	  	  try {
	    	  	  double deposit_amount = Double.parseDouble(txtDeposit.getText());
	    	  	if (accountType == "ChequingAccount") {
	    	  		ca1.deposit(deposit_amount);
		    	  	double bank_balance = ca1.getBalance();
		    	  	customer_balance.setText("Your balance is "+ bank_balance);
	    	    }
	    	    if (accountType == "SavingsAccount") {
	    	    	s1.deposit(deposit_amount);
	    	    	double bank_balance = s1.getBalance();
	    	    	customer_balance.setText("Your balance is "+ bank_balance);
	    	    }
	    	  	  error.setText("");
	    	  	  //System.out.println(ca1);
    	  	  }
    	  	  catch (NumberFormatException e) {
    	  		  error.setText("Error, you must input a number. ");
    	  	  }
	      }
	    }
	    );
	   
	   // if (BankInterface.check) {
	    Scene scene = new Scene(root, 450, 150);
	 	primaryStage.setTitle("Group3 Financial Bank");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    //}
	    //else {
	    	//
//	    	 Scene scene5 = new Scene(root, 450, 150);
//	 	    primaryStage.setTitle("Group3 Financial Bank");
//	    	primaryStage.setScene(scene5);
	    //}
	    
	}
	// if file does not exist
	public static void write_file(){
		if (check) {
			BufferedWriter file_in = null;
			FileWriter file_w = null;
			String name = txtName.getText();
			
			try {
				file_w = new FileWriter(BankInterface.file_name);
				file_in = new BufferedWriter(file_w);
				
				//write id, acct type, balance.
				file_in.write(accountType); file_in.newLine();
				file_in.write(name); file_in.newLine();
				String id = Integer.toString(customer_ID);
				file_in.write(id); file_in.newLine();
				if (accountType == "ChequingAccount") {
		    	  	double bank_balance = ca1.getBalance();
		    	  	String bal = Double.toString(bank_balance);
		    	  	file_in.write(bal);
	    	    }
	    	    if (accountType == "SavingsAccount") {
	    	    	double bank_balance = s1.getBalance();
	    	    	String bal = Double.toString(bank_balance);
	    		    file_in.write(bal);
	    	    }
				
							
				//Close file
				file_in.flush();
				file_in.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void read_file(){
		BufferedReader file_out = null;
		FileReader file_r = null;
		String name, id, account_Type, balance;
		try {
			file_r = new FileReader(file_name);
			file_out = new BufferedReader(file_r);
		
			//read actual lines
			account_Type = Files.readAllLines(Paths.get(file_name)).get(0);
			name = Files.readAllLines(Paths.get(file_name)).get(1);
			// Convert to integer
			id = Files.readAllLines(Paths.get(file_name)).get(2);
			int newInt = Integer.parseInt(id);
			// Convert to double
			balance = Files.readAllLines(Paths.get(file_name)).get(3);
			double newBal = Double.parseDouble(balance);
			
			
			//Set Variables
			Customer c3 = new Customer(name, newInt);
			ca1.setCustomer(c3);
			s1.setCustomer(c3);
			accountType = account_Type;
			if (accountType == "ChequingAccount") {
				ca1.setBalance(newBal);
	    	  	double bank_balance_read = ca1.getBalance();
	    	  	
			}
    	    if (accountType == "SavingsAccount") {
    	    	s1.setBalance(newBal);
    	    	double bank_balance_read = s1.getBalance();
    	    	 		    
    	    }
			
			System.out.println(accountType);
			System.out.println(name);
			System.out.println(id);
			System.out.println(balance);
			
			//close file
			file_out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			check = true;
			System.out.println("File not found creating a new file.");
			// Call BankAccountApp
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		if (check) {
			launch(args);
			write_file();
		}
		read_file();
		launch(args);
			
	}

}
