package com.edu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.Scanner;

class QuickPick extends NumberGenerator {


    static NumberGenerator gen = new NumberGenerator();
    private static String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9247157?allowPublicKeyRetrieval=true&useSSL=false&requireSSL=false";
    private static String user = "sql9247157";
    private static String password = "ZY9rN5phwb";
    private static Connection myConn;
    private static Statement myStmt;
    private static ResultSet myRs;
    static int id;
    static String str1;

    /*
    Mega Millions table:  mm_table
    Powerball table:  powerball_table
    MM user quick picks table:  mm_quickpicks
    PB user quick picks table:  powerball_quickpicks
    Primary key (column):  id
    Columns:  id, date, num_1, num_2, num_3, num_4, num_5, money_ball, multiplier
    */

    static {
        try {
            myConn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // numberFrequency not finished!!!
    static void mmNumberFrequency(int r, int s, int x, int y, int z) {
        num_1 = r;
        num_5 = z;
        num_2 = s;
        num_3 = x;
        num_4 = y;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT num_1, COUNT(*) c FROM mm_table GROUP BY num_1 HAVING c > 1;");
            System.out.println(myRs.getString(num_1));

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    static void pbQuickPickReset() {
        id = 0;
        try {
            Statement myStmt = myConn.createStatement();
            String sq1 = "TRUNCATE pb_quickpicks_table;";
            myStmt.executeUpdate(sq1);
            System.out.println("Power Ball Quick Picks have been reset.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void mmQuickPickReset() {
        id = 0;
        try {
            Statement myStmt = myConn.createStatement();
            String sq1 = "TRUNCATE mm_quickpicks_table;";
            myStmt.executeUpdate(sq1);
            System.out.println("Mega Millions Quick Picks have been reset.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void selectPBQuickPick() {

        Date date = new Date();
        String DATE_FORMAT = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        try {

            System.out.println();
            System.out.print("Quick Pick #"+id+":\t");
            gen.printPBQuickPick(powerballNumGenerator());
            System.out.println();
            str1 = gen.transferPBFinal();

            String[] strArray = str1.split(" ");
            int[] intArray = new int[strArray.length];
            for(int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }

            num_1 = intArray[0];
            num_2 = intArray[1];
            num_3 = intArray[2];
            num_4 = intArray[3];
            num_5 = intArray[4];
            money_ball = intArray[5];

            String sq1 = "INSERT INTO pb_quickpicks_table "
                    + "(id, date, num_1, num_2, num_3, num_4, num_5, money_ball)"
                    + " VALUES ('" + id + "', '" + sdf.format(date) + "', '" + num_1 + "', '" + num_2 + "', '" + num_3 + "', '" + num_4 + "', '"
                    + num_5 + "', '" + money_ball + "')";

            // System.out.println();
            // System.out.println(sq1);

            // 3. Execute SQL query
            myStmt = myConn.createStatement();
            myStmt.executeUpdate(sq1);

            System.out.println("Quick pick has been stored.");
            System.out.println();

            // 3a. Execute SQL Query (to show table data)
            myRs = myStmt.executeQuery("select * from pb_quickpicks_table");


            // 4. Process the result set
            while (myRs.next()) {

                // Database output
                System.out.println(myRs.getString("id") + " || Date: " + myRs.getString("date") +
                        " || Quick Pick: " + myRs.getString("num_1") + ", " + myRs.getString("num_2") +
                        ", " + myRs.getString("num_3") + ", " + myRs.getString("num_4") + ", " +
                        myRs.getString("num_5") + " || Money Ball: " + myRs.getString("money_ball"));

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        //System.out.println(id);
    }

    static void selectMMQuickPick() {

        Date date = new Date();
        String DATE_FORMAT = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        try {

            System.out.println();
            System.out.print("Quick Pick #"+id+":\t");
            gen.printMMQuickPick(megaMillionsNumGenerator());
            System.out.println();
            str1 = gen.transferMMFinal();

            String[] strArray = str1.split(" ");
            int[] intArray = new int[strArray.length];
            for(int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }

            num_1 = intArray[0];
            num_2 = intArray[1];
            num_3 = intArray[2];
            num_4 = intArray[3];
            num_5 = intArray[4];
            money_ball = intArray[5];

            String sq1 = "INSERT INTO mm_quickpicks_table "
                    + "(id, date, num_1, num_2, num_3, num_4, num_5, money_ball)"
                    + " VALUES ('" + id + "', '" + sdf.format(date) + "', '" + num_1 + "', '" + num_2 + "', '" + num_3 + "', '" + num_4 + "', '"
                    + num_5 + "', '" + money_ball + "')";

            // System.out.println();
            // System.out.println(sq1);

            // 3. Execute SQL query
            myStmt = myConn.createStatement();
            myStmt.executeUpdate(sq1);

            System.out.println("Quick pick has been stored.");
            System.out.println();

            // 3a. Execute SQL Query (to show table data)
            myRs = myStmt.executeQuery("select * from mm_quickpicks_table");


            // 4. Process the result set
            while (myRs.next()) {

                // Database output
                System.out.println(myRs.getString("id") + " || Date: " + myRs.getString("date") +
                        " || Quick Pick: " + myRs.getString("num_1") + ", " + myRs.getString("num_2") +
                        ", " + myRs.getString("num_3") + ", " + myRs.getString("num_4") + ", " +
                        myRs.getString("num_5") + " || Money Ball: " + myRs.getString("money_ball"));

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        //System.out.println(id);
    }

    /*
    static void dbConnect() {
        try {
            // Get a connection to database
            Connection myConn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established...");
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    } */

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("How many quick picks would you like?");
        int amt = in.nextInt();
        for (int i = 0; i < amt; i++) {
            int location = i + 1;
            storeID(location);
            selectMMQuickPick();
        } */
        mmNumberFrequency(1, 2, 3, 4, 5);
        //selectMMQuickPick();
        //selectMMQuickPick();
        // selectMMQuickPick();
        //   quickPickReset();
    }

    private static int storeID(int loca){
        id = loca;
        return id;
    }
}