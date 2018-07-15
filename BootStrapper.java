package lotteryProject;

import javax.swing.*;

public class BootStrapper {
 
 public static void main(String[] arg) {
  JFrame frame = new JFrame("Lottery Tabs");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().add(new Lotteries());
  frame.pack();
  frame.setVisible(true);
 }
}