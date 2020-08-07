/********************************************
 * This class runs the Nim game by calling 
 * the move methods created for the players
 * in the Human and Computer classes.
 * 
 * 
 * Stephen Wright
 * svw2112
 *******************************************/ 

public class Game{

	//declares instance variables
    private int marbles; //number of marbles in the pile
	private Human humanPlayer; //identifies human player
	private Computer computerPlayer; //identifies computer player
	private int currentPlayer; // indicates player turn 0 = computer, 1 = human

	//class constructor accepts int for level of difficulty
    public Game(int difficulty){
        
		marbles = (int) (Math.random() * 91 + 10); //generates marbles between 10-100

        //balanced random difficulty generator determines player one
		if(Math.random() < 0.5) //random number between 0 and 1 to determine player one
		{
			currentPlayer = 0; //then computer player turn
            System.out.println("First Move: Computer");
		}
		else
		{
			currentPlayer = 1; //otherwise human player turn
            System.out.println("First Move: Human");
		}

		humanPlayer = new Human(); //creates new object of type Human
		computerPlayer = new Computer(difficulty); //creates new object of type Computer
	}

	//method to play Nim game
    public void play(){
        
		while(true) //infinite loop breaks when game ends
		{
			System.out.println("Marbles Left: " + marbles); //print quantity of marbles left
            if(currentPlayer == 0) //computer player turn
			{
				computerPlayer.move(marbles); //computer player makes a selection
				int choice = computerPlayer.getChoice(); //quantity of marbles selected by computer
				System.out.println("Computer Choice: " + choice); //print selection amount
                marbles = marbles - choice; //calculates quantity of marbles left
				if(marbles == 0) //if marbles quantity equals zero
				{
					System.out.println("Human wins!"); //then print Human wins!
					break; //and the game is over
				}
				currentPlayer = 1; //otherwise human player turn
			}
			else
			{
				humanPlayer.move(marbles); //human player makes a selection
				int choice = humanPlayer.getChoice(); //quantity of marbles selected by human
				marbles = marbles - choice; //calculates quantity of marbles left
				if(marbles == 0) //if marbles quantity equals zero
				{
					System.out.println("Computer wins!"); //then print Computer wins!
					break; //and the game is over
				}
				currentPlayer = 0; //otherwise computer player turn
			}			
		}
		System.out.println("GAME OVER"); //print GAME OVER
	}
}