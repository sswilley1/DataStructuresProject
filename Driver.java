package com.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Driver {       // Frankie & Anthony

    private static String url = "jdbc:mysql://localhost:3306/lottery_database?useSSL=false&requireSSL=false";
    private static String user = "root";
    private static String password = "";
    private static String date, num_1, num_2, num_3, num_4, num_5, money_ball, multiplier, delete;
    private static int count = 0;
    private static int id;

    Driver() {
    }

    public static void main(String[] args) throws FileNotFoundException {

        try {
            // 1. Get a connection to database
            Connection myConn = DriverManager.getConnection(url, user, password);

            // 2. Create a statement
            Statement myStmt = myConn.createStatement();

            // 2a. Create database by scanning files
            // File mmFile = new File("C:\\Users\\WaterCloud Vapes\\IdeaProjects\\Data_Structures\\src\\mm_winningNumbers.txt");
            File pbFile = new File("C:\\Users\\WaterCloud Vapes\\IdeaProjects\\Data_Structures\\src\\pb_winningNumbers.txt");

            // Scanner sc = new Scanner(mmFile)
            Scanner sc = new Scanner(pbFile);

            while (sc.hasNext()) {
                date = sc.next();
                num_1 = sc.next();
                num_2 = sc.next();
                num_3 = sc.next();
                num_4 = sc.next();
                num_5 = sc.next();
                money_ball = sc.next();
                multiplier = sc.next();
                // delete = sc.next();
                count++;
                id = count;

                /* System.out.println(date + ", " + num_1 + ", " + num_2 + ", " + num_3 + ", " + num_4 + ", " + num_5 +
                    ", " + money_ball + ", " + multiplier); */

                /* MM TEST!!! Create SQL query String from txt file to transfer to database
                String sq1 = "INSERT INTO mega_millions "
                    + "(id, date, num_1, num_2, num_3, num_4, num_5, money_ball, multiplier)"
                    + " VALUES ('" + id + "', '" + date + "', '" + num_1 + "', '" + num_2 + "', '" + num_3 + "', '" + num_4 + "', '"
                    + num_5 + "', '" + money_ball + "', '" + multiplier + "')"; */

                // PB TEST!!!
                String sq1 = "INSERT INTO powerball "
                        + "(id, date, num_1, num_2, num_3, num_4, num_5, money_ball, multiplier)"
                        + " VALUES ('" + id + "', '" + date + "', '" + num_1 + "', '" + num_2 + "', '" + num_3 + "', '" + num_4 + "', '"
                        + num_5 + "', '" + money_ball + "', '" + multiplier + "')";

                // System.out.println();
                // System.out.println(sq1);


                // 3. Execute SQL query
                myStmt.executeUpdate(sq1);
            }

            // 3a. Execute SQL Query (to show table data)
            ResultSet myRs = myStmt.executeQuery("select * from mega_millions");
            ResultSet myRs = myStmt.executeQuery("select * from powerball");

            // System.out.println();
            String complete = "Insert complete.\n";
            String numOfRecords = ("Number of records: " + count + "\n");
            System.out.println(complete + numOfRecords);

            // 4. Process the result set
            while (myRs.next()) {

                // Mega Millions output
                System.out.println("ID: " + myRs.getString("id") + " || Date: " + myRs.getString("date") +
                        " || Winning Numbers: " + myRs.getString("num_1") + ", " + myRs.getString("num_2") +
                        ", " + myRs.getString("num_3") + ", " + myRs.getString("num_4") + ", " +
                        myRs.getString("num_5") + " || Mega Ball: " + myRs.getString("money_ball") +
                        " || Megaplier: " + myRs.getString("multiplier"));

                // Powerball output
                System.out.println("ID: " + myRs.getString("id") + " || Date: " + myRs.getString("date") +
                        " || Winning Numbers: " + myRs.getString("num_1") + ", " + myRs.getString("num_2") +
                        ", " + myRs.getString("num_3") + ", " + myRs.getString("num_4") + ", " +
                        myRs.getString("num_5") + " || Power Ball: " + myRs.getString("money_ball") +
                        " || Multiplier: " + myRs.getString("multiplier"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();

        }
    }

}
