import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/*
 * This Connect 5 game is contributed by Mony Puthichak Leak (Jack) 29993. This Program is inspired by the algorithm by a connect 4 game  
 * from MahdiVarposhti. https://github.com/MahdiVarposhti/Connect-Four
 */


public class humanVsHumanGame {
	
	//Board Array with 7 columns and 8 rows
		public static int[][] board = new int[7][8]; //Value of: 0 -> empty, 1 -> Player 1 piece, 2 -> Player 2 piece
		public static JLabel[][] circles = new JLabel[7][8]; //board to show circle
		
		static int playersTurn = 1;
		
		//The main frame of the program
		static JFrame frame = new JFrame();
		
		//Name of the players
		static String p1Name = "Player 1";
		static String p2Name = "Player 2";
		
		public static String selectedCol;
		
		static ArrayList<Integer> playTurnList =  new ArrayList<Integer>();
		static ArrayList<Integer> colList =  new ArrayList<Integer>();
		static ArrayList<Integer> rowList =  new ArrayList<Integer>();
		public static void game()  {
				
			
			ActionListener listener = new ActionListener(){ //ActionListener for the 7 buttons
				public void actionPerformed(ActionEvent e){
					selectedCol = ((JButton) e.getSource()).getText();
					//System.out.print(selectedRow);
					if(inputPiece(Integer.parseInt(selectedCol),playersTurn)){
						
						//Change turn
						if(playersTurn==1){
							playersTurn = 2;
							System.out.println(p1Name +" Turn (Red)");
							
							playTurnList.add(playersTurn-1);
						}else{
							playersTurn = 1;
							System.out.println(p2Name+" Turn (Yellow)");
							playTurnList.add(playersTurn+1);
						}
						
						int winner = gameDetection.hasWon(); //check win 0-no player won, 1 - player 1 won, 2 player 2 won
						if(winner!=0){
							
							if(winner==1){
							
								JOptionPane.showMessageDialog(null, p1Name + " Is The Winner"+ JOptionPane.INFORMATION_MESSAGE); //Show dialog
							}
							else {
								
								JOptionPane.showMessageDialog(null, p2Name + " Is The Winner"+ JOptionPane.INFORMATION_MESSAGE); //Show dialog
							}
							
							resetBoard(); //when the game is restart reset the board to all 0
							
						}else if(gameDetection.isTie()){
							JOptionPane.showMessageDialog(null,"Tie!", "Tie", JOptionPane.INFORMATION_MESSAGE);
							resetBoard();
						}
					}
				}
			};
			
			

			frame.setTitle("Connect 5");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.getContentPane().setPreferredSize(new Dimension(520,700));
			frame.setResizable(false);
			frame.getContentPane().setBackground(Color.GREEN);
			frame.setLayout(new GridLayout(9,7));
			
			
			
			
			
			JButton[] buttons = new JButton[7]; //add 7 buttons at the top
			int btnText = 1;
			JPanel btnPanel;
			
			for(int i = 0; i<7; i++){ 
				buttons[i] = new JButton("" + btnText);
				buttons[i].setPreferredSize(new Dimension(45, 30));
				btnPanel = new JPanel(new GridBagLayout());
				btnPanel.setPreferredSize(new Dimension(60, 60));
				btnPanel.setBackground(Color.GREEN);
				btnPanel.add(buttons[i]);
				buttons[i].addActionListener(listener);
				frame.add(btnPanel);
				btnText++;
				//set the button to the Jframe
			}
			
			for(int r=0; r<8; r++){
				for(int c=0; c<7; c++){
					circles[c][r] = new JLabel();
					circles[c][r].setIcon(new ImageIcon(humanVsHumanGame.class.getResource("whiteCircle.png")));
					circles[c][r].setHorizontalAlignment(SwingConstants.CENTER); 
					frame.add(circles[c][r]);
					//set the circle to the jframe
				}
			}
			
		    MainMenu.mainMenu(); //main menu button that contains recall save pause and reset
		
			
			//initialize the board array
			for(int br = 0; br<8; br++){
				for(int bc = 0; bc<7; bc++){
					board[bc][br] = 0; //loop through the array and set the board to 0
				}
			}
			
			frame.pack();
			frame.setVisible(true);
			
		}
		
		 
		
		
		
		//this function is for insert circle into the board grid
		public static boolean inputPiece(int col,int player){
			int c = col-1;
			int r;
			for(r = 0; r<8; r++){
				if(board[c][r]!=0){
					if(r==0){
						return false; //Return false if column is already filled
					}
					r--;
					break;
				}else if(r==7){ //set the circle to first put the last circle in the grid
					break;
				}
			}
			board[c][r] = player; //value of the player to the position of the board
			
			boardInputPiece(c,r,player);
			colList.add(c);
			rowList.add(r);
			return true;
		}
		
		public static void boardInputPiece(int col,int row,int player){
			String circleImage;
			if(player == 1){
				circleImage = "redCircle.png"; //image red circle to player 1
			}else{
				circleImage = "yellowCircle.png"; //image yellow circle to player 2
			}
			circles[col][row].setIcon(new ImageIcon(humanVsHumanGame.class.getResource(circleImage)));
			
		}
		
		public static boolean checkConnected(int a,int b,int c,int d, int e){
			if(a==b && a==c && a==d && a==e ){ //when all the 5 circle are same player
				return true;
			}
			
			return false;
		}
		
		
		
		
		
		
		//Method for looping through the board and setting all values to 0
		public static void resetBoard(){
			for(int br = 0; br<8; br++){
				for(int bc = 0; bc<7; bc++){
					board[bc][br] = 0;
				}
			}
			for(int r=0; r<8; r++){
				for(int c=0; c<7; c++){
					circles[c][r].setIcon(new ImageIcon(humanVsHumanGame.class.getResource("whiteCircle.png")));
				}
			}
			playersTurn = 1;
		}
		

		
		
		
	
}

