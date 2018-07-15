package DataProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class GameChoice extends JFrame implements ActionListener  {

	
	//initializations
	JFrame frame = new JFrame();
	

	
	private static final long serialVersionUID = 1L;
	
	//This initializes the labels and buttons.
	JLabel l1, l2;
	JButton b1,b2,b3, b4;
	JTextField t1, t2;
	
	public GameChoice()
	{
		
		JPanel panel1 = new JPanel();
		JPanel gameChoicePanel = new JPanel(new GridLayout(4,4,4,4));
		
		JLabel label1 = new JLabel("Lottery");
		JLabel label2 = new JLabel("Number Input");

		JTabbedPane tab = new JTabbedPane();
		
		
		frame.setTitle("Lottery Number Generator");
		tab.add("Lotto", gameChoicePanel);
		tab.add("Number Input", panel1);
		add(tab);
		panel1.setSize(800,600);
		gameChoicePanel.setSize(800,600);
		
		JFrame Fantasy5Panel = new JFrame();
		JFrame PowerballPanel = new JFrame();
		JFrame MegaMillionsPanel = new JFrame();

		ImageIcon fantasy5Icon = new ImageIcon("Fantasy5Logo.jpg");
		ImageIcon megaMillionsIcon = new ImageIcon("MegaMillionsLogo.png");
		ImageIcon powerballIcon = new ImageIcon("PowerballLogo.png");
		JFrame gameChoiceJFrame = new JFrame();
		

		JLabel question = new JLabel("Please choose a lottery: ");
		question.setHorizontalAlignment(JLabel.CENTER);
		gameChoicePanel.add(question);
		
		JButton MegaMillionsButton = new JButton(megaMillionsIcon);
		MegaMillionsButton.setSize(100 , 30);
		gameChoicePanel.add(MegaMillionsButton);
		JButton Fantasy5Button = new JButton(fantasy5Icon);
		Fantasy5Button.setSize(100 , 30);
		gameChoicePanel.add(Fantasy5Button);
		JButton PowerballButton = new JButton(powerballIcon);
		
		PowerballButton.setSize(100 , 30);
		
		gameChoicePanel.add(PowerballButton);
		
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
		panel1.add(l1);
		panel1.add(t1);
		panel1.add(l2);
		panel1.add(t2);
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		panel1.add(b4);

		b2.addActionListener(new CloseListener());

		panel1.setSize(700,600);

		panel1.setLayout(new GridLayout(5,2));
		
	
		frame.add(tab, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(700,600);
		frame.setVisible(true);
	
	}
	
	

	public static void main(String[] args) {

		GameChoice a = new GameChoice();
		a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		a.setVisible(true);
		a.setLocation(800, 600);
		
		
		
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