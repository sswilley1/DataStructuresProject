import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameChoice {
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
	}
	

}
