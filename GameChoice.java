package Test;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class GameChoice extends JFrame implements ActionListener  {
	
	//intializations
	public static JPanel gameChoicePanel;
	public static JFrame gameChoiceJFrame;
	public static JLabel question;
	public static JFrame Fantasy5Panel;
	public static JFrame PowerballPanel;
	public static JFrame MegaMillionsPanel;
	public static JButton Fantasy5Button;
	public static JButton PowerballButton;
	public static JButton MegaMillionsButton;
    public static ImageIcon fantasy5Icon = new ImageIcon("Fantasy5Logo.jpg");
    public static ImageIcon megaMillionsIcon = new ImageIcon("MegaMillionsLogo.png");
    public static ImageIcon powerballIcon = new ImageIcon("PowerballLogo.png");
	public static JFrame frame;
    
    
    
	private static final long serialVersionUID = 1L;
	//This initializes the labels and buttons.
	JLabel l1, l2;
	JButton b1,b2,b3, b4;
	JTextField t1, t2;
	GameChoice()
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


	
	public static void main(String[] args) {
		
		gameChoicePanel = new JPanel(new GridLayout(4,4,4,4));
        gameChoiceJFrame = new JFrame();
        gameChoiceJFrame.setPreferredSize(new Dimension(500, 600));
        gameChoiceJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameChoiceJFrame.getContentPane().add(gameChoicePanel);
        gameChoiceJFrame.pack();
        
        question = new JLabel("Please choose a lottery: ");
        question.setHorizontalAlignment(JLabel.CENTER);
        gameChoicePanel.add(question);
		MegaMillionsButton = new JButton(megaMillionsIcon);
	    MegaMillionsButton.setSize(100 , 30);
		gameChoicePanel.add(MegaMillionsButton);
		Fantasy5Button = new JButton(fantasy5Icon);
		Fantasy5Button.setSize(100 , 30);
		gameChoicePanel.add(Fantasy5Button);
		PowerballButton = new JButton(powerballIcon);
		PowerballButton.setSize(100 , 30);
		gameChoicePanel.add(PowerballButton);
		gameChoiceJFrame.add(gameChoicePanel);
		gameChoiceJFrame.setVisible(true);
		
		//trying to set where the button is selected then it brings up the other window.
		//having a little bit of trouble.
		if(MegaMillionsButton.isSelected() || Fantasy5Button.isSelected() || PowerballButton.isSelected()) {
			JOptionPane.showMessageDialog(frame, "Great choice! Please enter numbers on next screen.");
		}else if(!MegaMillionsButton.isSelected() || !Fantasy5Button.isSelected() || !PowerballButton.isSelected()) {
		
		} else {
			JOptionPane.showMessageDialog(frame, "You have not made a decision.");
		}
		GameChoice a = new GameChoice();
		a.setVisible(true);
		a.setLocation(200, 200);
		
		
	}
	 public void actionPerformed(ActionEvent ae)
	{
	float a, b;
	}
	 
	//This is to exit the program.
	class CloseListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e) 
	{
	System.exit(0);
	} 
	}
}