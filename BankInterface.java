import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class BankInterface {
	
	public BankInterface() {}
	
	private static final String file_name = "Assign9/bank_file.txt";
	public static boolean check = false;
	
	// if file exists 
	public static void read_file(){
		BufferedReader file_out = null;
		FileReader file_r = null;
		String name, id, name1, accountType, balance;
		try {
			file_r = new FileReader(file_name);
			file_out = new BufferedReader(file_r);
		
			//read actual line
			name = Files.readAllLines(Paths.get(file_name)).get(0);
			id = Files.readAllLines(Paths.get(file_name)).get(1);
			accountType = Files.readAllLines(Paths.get(file_name)).get(2);
			balance = Files.readAllLines(Paths.get(file_name)).get(3);
			name1 = Files.readAllLines(Paths.get(file_name)).get(4);
			
			System.out.println(accountType);
			System.out.println(name1);
			System.out.println(balance);
			System.out.println(name);
			System.out.println(id);
			
				//close file
				file_out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			check = true;
			System.out.println("File not found creating a new file.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// if file does not exist
	public static void write_file(){
		if (check) {
			BufferedWriter file_in = null;
			FileWriter file_w = null;
			
			String name = "Matt & Jon";
			String id = "112"; 
			String accountType = "Savings";
			String balance = "100.6";
			String name1 = "noel";
			
			try {
				file_w = new FileWriter(file_name);
				file_in = new BufferedWriter(file_w);
				
				//write id, acct type, balance.
				file_in.write(name);file_in.newLine();
				file_in.write(balance); file_in.newLine();
				file_in.write(id); file_in.newLine();
				file_in.write(name1); file_in.newLine();
				file_in.write(accountType);
				
				//Close file
				file_in.flush();
				file_in.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		read_file();
		write_file();
		
		
		
	}
}
