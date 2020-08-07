/********************************************
 * This class simulates a human playing Nim 
 * against a computer in one of two modes,
 * stupid or smart. Moves are based on the 
 * number of remaining marbles in a pile. 
 * 
 * Stephen Wright
 * svw2112
 *******************************************/ 
import java.util.Scanner; //import scanner to get human player input

public class Human{

	//declares instance variables
	private int choice; //number of marbles the human player selects
	private Scanner input;

	//constructor class to initiate human player selections
	public Human(){

		input = new Scanner(System.in); //initializes Scanner object to get user input
		choice = -1; //value indicates that no choice has been made
	}

	//move method that allows human player to make a selection based on marbles left
	public void move(int marblesLeft){

		System.out.println("How many marbles would you like to take?");
		choice=input.nextInt(); //stores user input under the choice variable

		//prompts for user input choice while invalid entry
		if (marblesLeft > 1){
			while (choice < 1  || choice > marblesLeft / 2)
			{
				System.out.println("Invalid entry. Please pick a number between 1 and " + marblesLeft / 2);
				choice = input.nextInt(); //stores user input under the choice variable        
			}  
		} 
		else //if marblesLeft is equal to one then the only choice is one
		{
			while (choice != 1) //prompt for valid choice if not equal to one
			{
				System.out.println("Invalid entry. Only one marble remains.");
				choice = input.nextInt(); //stores user input under the choice variable        
			}    
		}
	}

	//method to return human player choice
	public int getChoice(){
		return choice;
	}

}