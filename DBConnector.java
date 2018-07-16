package com.edu;

import java.sql.*;

public class DBConnector {

    private static String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9247157?allowPublicKeyRetrieval=true&useSSL=false&requireSSL=false";
    private static String user = "sql9247157";
    private static String password = "ZY9rN5phwb";

    /*
    Mega Millions table:  mm_table
    Powerball table:  powerball_table
    MM user quick picks table:  mm_quickpicks
    PB user quick picks table:  powerball_quickpicks
    Primary key (column):  id
    Columns:  id, date, num_1, num_2, num_3, num_4, num_5, money_ball, multiplier
    */


    static void dbConnect() {
        try {

            // Get a connection to database
            Connection myConn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection complete.");

        } catch (SQLException exc) {
            exc.printStackTrace();

        }
    }

    public static void main(String[] args) {

        DBConnector connectNow = new DBConnector();
        connectNow.dbConnect();

    }

}
