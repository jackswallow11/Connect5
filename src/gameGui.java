
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class gameGui extends JFrame {
	
	private static JButton play;
	private static JButton exit;
	private static JRadioButton humanHuman;
	private static JRadioButton humanComputer;
	private static ButtonGroup optionGroup;

	public gameGui() {
		//Creating the Frame
        JFrame menuFrame = new JFrame("Welcome to Connect 5");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500, 500);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
        menuFrame.setResizable(false);
        menuFrame.getContentPane().setBackground(Color.BLUE);
        play = new JButton("START");
        exit = new JButton("EXIT");
        humanHuman = new JRadioButton("Human vs Human"); 
        humanComputer = new JRadioButton("Human Vs Computer"); 
        optionGroup = new ButtonGroup(); //creating Button Group so so user can only pick ONE option of the two radio button
        optionGroup.add(humanHuman); //add the human vs human button to the group
        optionGroup.add(humanComputer); //add human vs computer button to the group
        play.setBounds(190,200,100,40);//x axis, y axis, width, height  
        exit.setBounds(190,350,100,40); 
        humanHuman.setBounds(155,250,170,40);
        humanComputer.setBounds(155,300,170,40);
        JLabel name = new JLabel();
        name.setText("Connect 5");
        name.setFont(new Font("Calibri", Font.BOLD, 24));
        name.setForeground(Color.WHITE);
        name.setBounds(180, 100, 100, 40);
        
        menuFrame.add(play);
        menuFrame.add(exit);
        menuFrame.add(humanHuman);
        menuFrame.add(humanComputer);
        menuFrame.add(name);
        
        exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		System.exit(0);
        	}
        });
        play.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		if(humanHuman.isSelected()) {
        			System.out.println("Human vs Human Game");
        			humanVsHumanGame.game();
        	
        			}
        		else if(humanComputer.isSelected()) {
        			System.out.println("Human vs Computer Game");
        			humanVsAiGame.humanvAi();
        		}
        		else {
        			System.out.println("PLEASE SELECT ONE OF THE OPTION");
        		}
        		
        	}
        });

	
	}
	

	
}
