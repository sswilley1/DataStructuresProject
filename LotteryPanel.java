package lotteryProject;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LotteryPanel extends JPanel {
 
 JButton quickPick, store, button3;
 JLabel label1, label2, label3;
 JTextArea list;
 JScrollPane pane;
 private int width, height;
 
 public LotteryPanel() {
  width = 640;
  height = 480;
  
  quickPick = new JButton("Quick Pick");
  store = new JButton("Store");
  button3 = new JButton("Test Button Three");
  
  label1 = new JLabel("Test Label One");
  label2 = new JLabel("Test Label Two");
  label3 = new JLabel("Test Label Three");
  
  list = new JTextArea();
  pane = new JScrollPane(list);
  pane.setPreferredSize(new Dimension(width/3,height));
  
  Font largeFont = new Font("CenturyGothic",Font.PLAIN,18);
  quickPick.setFont(largeFont);
  store.setFont(largeFont);
  button3.setFont(largeFont);
  
  Font smallFont = new Font("CenturyGothic",Font.PLAIN,14);
  label1.setFont(smallFont);
  label2.setFont(smallFont);
  label3.setFont(smallFont);
  list.setFont(smallFont);
  
  //quickPick.addActionListener(parent);
  //store.addActionListener(parent);
  //button3.addActionListener(parent);
  
  JPanel upperPanel = new JPanel();
  upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.PAGE_AXIS));
  upperPanel.setPreferredSize(new Dimension(width/2,height/4));
  upperPanel.add(quickPick);
  upperPanel.add(Box.createRigidArea(new Dimension(0,10)));
  upperPanel.add(label1);
  
  JPanel middlePanel = new JPanel();
  middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.PAGE_AXIS));
  middlePanel.setPreferredSize(new Dimension(width/2,height/4));
  middlePanel.add(store);
  middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
  middlePanel.add(label2);
  
  JPanel lowerPanel = new JPanel();
  lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.PAGE_AXIS));
  lowerPanel.setPreferredSize(new Dimension(width/2,height/4));
  lowerPanel.add(button3);
  lowerPanel.add(Box.createRigidArea(new Dimension(0,10)));
  lowerPanel.add(label3);
  
  JPanel sidePanel = new JPanel();
  sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));
  sidePanel.setPreferredSize(new Dimension(width/2,height));
  sidePanel.add(Box.createRigidArea(new Dimension(0,20)));
  sidePanel.add(upperPanel);
  sidePanel.add(Box.createRigidArea(new Dimension(0,100)));
  sidePanel.add(middlePanel);
  sidePanel.add(Box.createRigidArea(new Dimension(0,100)));
  sidePanel.add(lowerPanel);
  
  setLayout(new BorderLayout());
  add(sidePanel, BorderLayout.WEST);
  add(pane, BorderLayout.EAST);
 }
}