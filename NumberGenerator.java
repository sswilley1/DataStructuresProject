package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

class NumberGenerator {

    private static String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9247157?allowPublicKeyRetrieval=true&useSSL=false&requireSSL=false";
    private static String user = "sql9247157";
    private static String password = "ZY9rN5phwb";
    private static Random rand = new Random();
    private static int[] mainNumbers = new int[5];
    private static int money_ball;

    /*
    Mega Millions table:  mm_table
    Powerball table:  powerball_table
    MM user quick picks table:  mm_quickpicks
    PB user quick picks table:  powerball_quickpicks
    Primary key (column):  id
    Columns:  id, date, num_1, num_2, num_3, num_4, num_5, money_ball, multiplier
    */

    static void powerBall() {

        money_ball = rand.nextInt(26) + 1;
        System.out.print(money_ball);

    }

    static void megaBall() {

        money_ball = rand.nextInt(25) + 1;
        System.out.print(money_ball);

    }

    static void powerballNumGenerator() {

        int rNum;
        for (int i = 0; i < 5; i++) {
            rNum = rand.nextInt(69) + 1;

            while (match(mainNumbers, rNum)) {
                rNum = rand.nextInt(69) + 1;
            }

            mainNumbers[i]=rNum;


        }
        sort(mainNumbers);

        for (int i = 0; i < mainNumbers.length; i++) {
            System.out.print(mainNumbers[i] + " ");
        }
    }

    static void megaMillionsNumGenerator() {

        int rNum;
        for (int i = 0; i < 5; i++) {
            rNum = rand.nextInt(70) + 1;

            while (match(mainNumbers, rNum)) {
                rNum = rand.nextInt(70) + 1;
            }

            mainNumbers[i]=rNum;


        }
        sort(mainNumbers);

        for (int i = 0; i < mainNumbers.length; i++) {
            System.out.print(mainNumbers[i] + " ");
        }
    }


    static boolean match(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            if (num == a[i]) {
                return true;
            }
        }
        return false;
    }

    private static void sort(int[] aNum){
        for(int i =0; i<aNum.length-1; i++){
            for(int j=i+1; j<aNum.length; j++){
                if(aNum[i]>aNum[j]) {
                    int temp = aNum[i];
                    aNum[i] = aNum[j];
                    aNum[j] = temp;
                }
            }
        }
    }

    static void numFrequency() {

    }

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

        NumberGenerator connectNow = new NumberGenerator();
        connectNow.dbConnect();

        powerballNumGenerator();
        powerBall();
        System.out.println();

        megaMillionsNumGenerator();
        megaBall();
    }

}
