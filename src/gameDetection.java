
public class gameDetection extends humanVsHumanGame{
	
	// when board is filled and no winner it IsTie
			public static boolean isTie(){
				boolean boardFull = true;
				for(int br = 0; br<6; br++){
					for(int bc = 0; bc<7; bc++){
						if(board[bc][br]==0){
							boardFull = false;
							break;
						}
					}
				}
				
				if(boardFull && hasWon()==0){
					return true;
				}else{
					return false;
				}
			}
			
			public static int hasWon() //check to see if there are five in the row or vertically or horizontally
			{
				int r,c;
				
				for(r=0; r<8; r++){
					for(c=0; c<7; c++){
						if(board[c][r]!=0){ //If it's not an empty spot
							
							if(r<4){ //check for 5 rows with same player turn r<4 to prevent from out of bound error
								if( checkConnected(board[c][r], board[c][r+1], board[c][r+2], board[c][r+3],board[c][r+4])){ //check if column are connect 5 vertically
									return board[c][r]; //return the play thats won
								}
							}
							
							if(c<2)
							{ 
								if( checkConnected(board[c][r], board[c+1][r], board[c+2][r], board[c+3][r],board[c+4][r]) ){ //check if row are connect 5 horizontally
									return board[c][r]; //return the play thats won
								}
							}
							
							if(r<4&&c<2){ //prevent out of bound error
								if( checkConnected(board[c][r], board[c+1][r+1], board[c+2][r+2], board[c+3][r+3],board[c+4][r+4]) ){ //check down right and diagonal
									return board[c][r]; //Return the winning player
								}
							}
										
							if(r>4&&c<2){ //Prevent out of bound error
								if( checkConnected(board[c][r], board[c+1][r-1], board[c+2][r-2], board[c+3][r-3],board[c+4][r-4]) ){ //check down left and diagonal
									return board[c][r];//return the play thats won
								}
							}
							
						}			
					}
				}

			    return 0; //return 0 means no player won so the game continues
			}
			

	
	

}
