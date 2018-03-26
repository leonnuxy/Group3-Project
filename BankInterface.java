package bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class BankInterface {
	
	public BankInterface() {}
	
	private static final String file_name = "src/bank/bank_file.txt";
	
	static String name = "Matt & Jon";
	int id;
	private static boolean check = false;
	
	
	public static void read_file(){
		BufferedReader file_out = null;
		FileReader file_r = null;
		try {
			file_r = new FileReader(file_name);
			file_out = new BufferedReader(file_r);
			//read actual line
			
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
		
		// if file exists 
		
		// if file does not exist
		
	}	
	public static void write_file(){
		if (check) {
			BufferedWriter file_in = null;
			FileWriter file_w = null;
			
			try {
				file_w = new FileWriter(file_name);
				file_in = new BufferedWriter(file_w);
				file_in.write(name);
				//write id, acct type, balnce.
				file_in.flush();
				file_in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		write_file();
		
		
	}
}
