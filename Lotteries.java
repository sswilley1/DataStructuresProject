package lotteryProject;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Lotteries extends JPanel implements ActionListener {
 
 private LotteryPanel megaMillions;
 private LotteryPanel powerball;
 private int count1, count2, count3;
 
 public Lotteries() {
  megaMillions = new LotteryPanel(this);
  powerball = new LotteryPanel(this);
  
  JTabbedPane tp = new JTabbedPane();
  tp.add("MegaMillions", megaMillions);
  tp.add("Powerball", powerball);
  add(tp);
 }
 
 public void actionPerformed(ActionEvent event) {
  if (event.getSource() == megaMillions.quickPick) {
   System.out.println("MegaMillions Button 1 pushed.");
  }
  
  if (event.getSource() == megaMillions.store) {
   System.out.println("MegaMillions Button 2 pushed.");
  }
  
  if (event.getSource() == megaMillions.button3) {
   System.out.println("MegaMillions Button 3 pushed.");
  }
  
  if (event.getSource() == powerball.quickPick) {
   System.out.println("Powerball Button 1 pushed.");
  }
  
  if (event.getSource() == powerball.store) {
   System.out.println("Powerball Button 2 pushed.");
  }
  
  if (event.getSource() == powerball.button3) {
   System.out.println("Powerball Button 3 pushed.");
  }
 }
}