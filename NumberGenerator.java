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
    static int[] mainNumbers = new int[5];
    static int num_1, num_2, num_3, num_4, num_5, money_ball, fuck;

    /*
    // MySQL DB Info
    Mega Millions table:  mm_table
    Powerball table:  powerball_table
    MM user quick picks table:  mm_quickpicks
    PB user quick picks table:  powerball_quickpicks
    Primary key (column):  id
    Columns:  id, date, num_1, num_2, num_3, num_4, num_5, money_ball, multiplier
    */

    static int powerBall() {

        money_ball = rand.nextInt(26) + 1;
        return money_ball;

    }

    static int megaBall() {

        money_ball = rand.nextInt(25) + 1;
        return money_ball;

    }

    static int[] powerballNumGenerator() {

        int rNum;
        for (int i = 0; i < 5; i++) {
            rNum = rand.nextInt(69) + 1;
            while (match(mainNumbers, rNum)) {
                rNum = rand.nextInt(69) + 1;
            }

            mainNumbers[i]=rNum;
        }
        sort(mainNumbers);

        return mainNumbers;
    }

    static int[] megaMillionsNumGenerator() {

        int rNum;
        for (int i = 0; i < 5; i++) {
            rNum = rand.nextInt(70) + 1;
            while (match(mainNumbers, rNum)) {
                rNum = rand.nextInt(70) + 1;
            }

            mainNumbers[i]=rNum;
        }
        sort(mainNumbers);

        return mainNumbers;
    }


    static boolean match(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            if (num == a[i]) {
                return true;
            }
        }
        return false;
    }

    static void sort(int[] aNum){
        for(int i =0; i<aNum.length-1; i++){
            for(int j=i+1; j<aNum.length; j++){
                if(aNum[i]>aNum[j]) {
                    int temp = aNum[i];
                    aNum[i] = aNum[j];
                    aNum[j] = temp;
                }
            }
        }

        for (int k = 0; k < aNum.length; k++) {
            if(k==0){
                num_1=aNum[k];
            }else if(k==1){
                num_2=aNum[k];
            }else if(k==2){
                num_3=aNum[k];
            }else if(k==3){
                num_4=aNum[k];
            }else{
                num_5=aNum[k];
            }
        }

    }

    static void printPBQuickPick(int[] mainNumbers) {
        int x;
        int size = mainNumbers.length;
        for (int i = 0; i < size; i++) {
            x = mainNumbers[i];
            System.out.print(x + " ");
        }
        System.out.print(powerBall());
    }

    static void printMMQuickPick(int[] mainNumbers) {
        int x;
        int size = mainNumbers.length;
        for (int i = 0; i < size; i++) {
            x = mainNumbers[i];
            System.out.print(x + " ");
        }
        System.out.print(megaBall());
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

    static String transferMMFinal() {
        return num_1 + " " + num_2 + " " + num_3+ " " + num_4 + " " +num_5 + " " + money_ball;
    }


    static String transferPBFinal() {

        return num_1 + " " + num_2 + " " + num_3+ " " + num_4 + " " +num_5 + " " + money_ball;
    }

    public static void main(String[] args) {

        // NumberGenerator connectNow = new NumberGenerator();
        // connectNow.dbConnect();

        printPBQuickPick(powerballNumGenerator());
        System.out.println();

        System.out.println(transferPBFinal());
        System.out.println();

        printMMQuickPick(megaMillionsNumGenerator());
        System.out.println();

        System.out.println(transferMMFinal());
        System.out.println();
    }

}
