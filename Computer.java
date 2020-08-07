/********************************************
 * This class simulates a computer playing
 * Nim against a human in one of two modes, 
 * stupid or smart. Moves are based on the 
 * selected mode and order of initiation.
 * 
 * Stephen Wright
 * svw2112
 *******************************************/ 

public class Computer{

	//declares instance variables
    	private int mode; //contains levels of difficulty 1 = stupid, 2 = smart
	private int choice; //number of marbles the computer selects

	//constructor class initializes instance variables
    	public Computer(int m){
        
		mode = m; //mode starts at int m
		choice = -1; //computer turn begins at -1 and changes as move method is called
	}

    	//method to calculate computer player moves and quantity of marbles
	public void move(int marblesLeft){

		boolean special; //indicates the number of marbles is a power of two minus one
		if(marblesLeft == 3 || marblesLeft == 7 || marblesLeft == 15 || 
				marblesLeft == 31 || marblesLeft == 63) //if any of these numbers
		{
			special = true; //then special is true and it is a power of two minus one
		}
		else
		{
			special = false; //otherwise it is not a power of two minus one
		}

		if(mode == 2  && special == false){ //if smart mode and special is false then human can win
            
			if(marblesLeft > 63) //if statement starting from greatest power of two minus one
			{
				choice = marblesLeft - 63;
			} 
			else if(marblesLeft > 31) 
			{
				choice = marblesLeft - 31;
			}
			else if(marblesLeft > 15)
			{
				choice = marblesLeft - 15;
			}
			else if(marblesLeft > 7)
			{
				choice = marblesLeft - 7;
			}
			else if(marblesLeft > 3)
			{
				choice = marblesLeft - 3;
			}
			else if(marblesLeft > 1) //remove one marble to win
			{
				choice = marblesLeft - 1;
			}
			else
			{
				choice = 1; //computer player loses
			}
		}
		else //random play in stupid mode
		{
			int max = marblesLeft / 2; //max number of marbles allowed to be picked in one turn
			choice = (int) (Math.random() * max + 1); //choice between one and max inclusive
		}
	}

    	//method to return the computer player choice
	public int getChoice(){
		return choice;
	}


}
