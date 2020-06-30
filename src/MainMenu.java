import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainMenu extends humanVsHumanGame {
	
	public static void mainMenu() {
		 // create a frame 
        JFrame f = new JFrame("Connect 5 Menu"); 
  
        // create a menubar 
        JMenuBar menuBar = new JMenuBar(); 
  
        // create a menu 
        JMenu menu = new JMenu("Menu"); 
  
        // create menuitems 
        JMenuItem save = new JMenuItem("Save"); 
        JMenuItem recall = new JMenuItem("Recall"); 
        JMenuItem pause = new JMenuItem("Pause");
        JMenuItem reset = new JMenuItem("Reset");
  
        // add menu items to menu 
        menu.add(save); 
        menu.add(recall); 
        menu.add(pause);
        menu.add(reset);
  
        // add menu to menu bar 
        menuBar.add(menu); 
  
        // add menubar to frame 
        f.setJMenuBar(menuBar); 
  
        // set the size of the frame 
        f.setSize(500,80);
        f.setVisible(true); 
        
        
        reset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		humanVsHumanGame.resetBoard(); //reset the board when reset button is clicked
        	}
        });
        pause.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		System.out.println("Pause");
        		JOptionPane.showMessageDialog(null,"GAME PAUSED, CLICK OK TO RESUME "+ JOptionPane.INFORMATION_MESSAGE); //jOption show pause and resume once clicked Ok
        	}
        });
        save.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		try {
					FileWriter writehandle = new FileWriter("fileSave.txt"); //location depends on which computer address
					BufferedWriter bw = new BufferedWriter(writehandle);
					  for(Integer playerTurn : playTurnList) //iterate through the arrayList of playTurnList
					  {
				            bw.write(playerTurn +" "); 
				        }
					  bw.write(",");
					  for(Integer col : colList) //iterate through the arrayList of colList
					  {
				            bw.write(col +" "); 
				        }
					  bw.write(",");
					  for(Integer row : rowList) //iterate through the arrayList of rowList
					  {
				            bw.write(row +" "); 
				        }
					  
					  
        			bw.close();
        			writehandle.close();
        			System.out.println("Your grid is saved"); //indictor to show it is save for testing purpose
//        			System.out.println(playTurnList);    *debugging purpose to show if the list in store or not
//        			System.out.println(colList+"column");
//        			System.out.println(rowList+"row");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
        		
        	}
        });
        recall.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		try {
            		String line = null;
            		FileReader readhandle = new FileReader("D://JAVA WORKSPACE//Connect5//fileSave.txt"); //store file location depend on local address
            		BufferedReader br = new BufferedReader(readhandle);
            		while ((line=br.readLine()) != null) {
            			String[] a = line.split(" ,"); //split each array  into String array by comma
            			String playerTurn = a[0]; //store array of playerturn
            			String column = a[1]; //store array of column in the grid
            			String row = a[2]; //store array of row in the grid
            			
            			
            			String[] strTurn =playerTurn.split(" "); //split each element by a space to retrieve one element each in the array
            			String[] strCol = column.split(" ");
            			String[] strRow = row.split(" ");
            		
            			
            			for(int i = 0; i<strTurn.length;i++) //iterate through each of the element and pass back the value to input back the piece in the board once its save
            			{
            				humanVsHumanGame.boardInputPiece( Integer.parseInt(strCol[i]),Integer.parseInt(strRow[i]) , Integer.parseInt(strTurn[i])); //recall back the grid position (col,row,player)	
            			}
            		
            			
            		}
            		
            		br.close();
            		readhandle.close();

            		} catch (FileNotFoundException ex) {
            		ex.printStackTrace();
            		}
        			catch (IOException ea)
        			{
            		ea.printStackTrace();
            		
            		}
        	}
        });
        
        
		
	}

}
