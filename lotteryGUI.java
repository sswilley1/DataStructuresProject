import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lotteryGUI extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
   //This initilizes the lavels and buttons.
   JLabel l1, l2;
   JButton b1,b2,b3, b4;
   JTextField t1, t2;
   lotteryGUI()
{
//This is to add text to the labels & buttons.
l1 = new JLabel("How Many Tickets? ");
l2 = new JLabel("Number of Quick Picks");
b1 = new JButton("SUBMIT");
b2 = new JButton("EXIT");
b3 = new JButton("I WANT RANDOM NUMBERS");
b4 = new JButton("HOTTEST NUMBERS");
t1 = new JTextField(30);
t2 = new JTextField(30);

//This is to add the labels and buttons.
add(l1);
add(t1);
add(l2);
add(t2);
add(b1);
add(b2);
add(b3);
add(b4);

b2.addActionListener(new CloseListener());

setSize(800,600);

setLayout(new GridLayout(5,2));

setTitle("Lottery Ticket Generator");
}

 public void actionPerformed(ActionEvent ae)
{
float a, b;
}
 
public static void main(String args[])
{
  lotteryGUI a = new lotteryGUI();
  a.setVisible(true);
  a.setLocation(200, 200);
}

}
//This is to exit the program.
class CloseListener implements ActionListener
{
public void actionPerformed(ActionEvent e) 
{
System.exit(0);
} 
}
