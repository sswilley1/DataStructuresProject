package com.edu;

import java.sql.*;

public class DBConnector {

    private static String url = "jdbc:mysql://localhost:3306/lottery_database?allowPublicKeyRetrieval=true&useSSL=false&requireSSL=false";
    private static String user = "root";
    private static String password = "Fam0uscl0ud#1";

    static void dbConnect() {
        try {

            // Get a connection to database
            Connection myConn = DriverManager.getConnection(url, user, password);

        } catch (Exception exc) {
            exc.printStackTrace();

        }
        System.out.println("Connection complete.");
    }

    public static void main(String[] args) {

        DBConnector connectNow = new DBConnector();
        connectNow.dbConnect();

    }

}
