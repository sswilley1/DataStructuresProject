
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Driver { // Frankie & Anthony

	private static String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9247157?allowPublicKeyRetrieval=true&useSSL=false&requireSSL=false";
	private static String user = "sql9247157";
	private static String password = "ZY9rN5phwb";
	private static int date, num_1, num_2, num_3, num_4, num_5, money_ball, multiplier, delete;
	private static int count = 0;
	private static int id;

	Driver() {
	}

	public static void main(String[] args) throws FileNotFoundException {

		try {
			
			List<Integer> mega = new ArrayList();
			List<Integer> power = new ArrayList();
			
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection(url, user, password);

			// 2. Create a statement
			Statement myStmt = myConn.createStatement();

			// 3a. Execute SQL Query (to show table data)
			   ResultSet myRs = myStmt.executeQuery("select * from mm_table");

			// System.out.println();
			// String complete = "Insert complete.\n";
			// String numOfRecords = ("Number of records: " + count + "\n");
			// System.out.println(complete + numOfRecords);

			// 4. Process the result set
			while (myRs.next()) {
				mega.add(Integer.parseInt(myRs.getString("money_ball")));
				mega.add(Integer.parseInt(myRs.getString("multiplier")));
				mega.add(Integer.parseInt(myRs.getString("num_1")));
				mega.add(Integer.parseInt(myRs.getString("num_2")));
				mega.add(Integer.parseInt(myRs.getString("num_3")));
				mega.add(Integer.parseInt(myRs.getString("num_4")));
				mega.add(Integer.parseInt(myRs.getString("num_5")));
				
				
				// Mega Millions output
				 System.out.println("ID: " + myRs.getString("id") + " || Date: " + myRs.getString("date") +
	                        " || Winning Numbers: " + myRs.getString("num_1") + ", " + myRs.getString("num_2") +
	                        ", " + myRs.getString("num_3") + ", " + myRs.getString("num_4") + ", " +
	                        myRs.getString("num_5") + " || Mega Ball: " + myRs.getString("money_ball") +
	                        " || Megaplier: " + myRs.getString("multiplier"));
				
				
				 
			}
			
			ResultSet myRs1 = myStmt.executeQuery("select * from powerball_table");
			
			while (myRs1.next()) {
			power.add(Integer.parseInt(myRs1.getString("money_ball")));
			power.add(Integer.parseInt(myRs1.getString("multiplier")));
			power.add(Integer.parseInt(myRs1.getString("num_1")));
			power.add(Integer.parseInt(myRs1.getString("num_2")));
			power.add(Integer.parseInt(myRs1.getString("num_3")));
			power.add(Integer.parseInt(myRs1.getString("num_4")));
			power.add(Integer.parseInt(myRs1.getString("num_5")));
			
			// Powerball output
			
			System.out.println("ID: " + myRs1.getString("id") + " || Date: " + myRs1.getString("date") +
                    " || Winning Numbers: " + myRs1.getString("num_1") + ", " + myRs1.getString("num_2") +
                    ", " + myRs1.getString("num_3") + ", " + myRs1.getString("num_4") + ", " +
                    myRs1.getString("num_5") + " || Power Ball: " + myRs1.getString("money_ball") +
                    " || Multiplier: " + myRs1.getString("multiplier"));
			
			
			}
			
			getMostFrequentDigitWInNumber(mega,"Mega Million");
			getMostFrequentDigitWInNumber(power, "Power Ball");
			
			
		} catch (Exception exc) {
			exc.printStackTrace();

		}
		
	}


	

	public static void getMostFrequentDigitWInNumber(List<Integer> list2, String name) {
		int[] frequency = new int[500];
		List<Integer>list = new ArrayList();
		int mostFrequentVal = 0;
		
		for(int i=0;i < list2.size(); i++) {
			
			if((int) list2.get(i) != 0) {
				int digit = (int) list2.get(i);
			
				frequency[digit]++;
				
				if (frequency[digit] > mostFrequentVal) {
					mostFrequentVal = frequency[digit];
				}
			}
		}
		
		
		int j=0;
		while (list.size() < 5) {
			
			for(int k =0; k< frequency.length; k++) {
			if (frequency[k] == mostFrequentVal -j && frequency[k] != 0) {
				list.add(k);
				}
			}
			j++;
		}
		System.out.println("Most Frequent Digits "+name+ ":" + list);
		
	}

}
