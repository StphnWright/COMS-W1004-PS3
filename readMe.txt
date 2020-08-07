ZipTest.java

ZipTest.java is the main class and communicates with Zipcode.java through lines
23 and 30 of the main. In Zipcode.java I used else if statements to convert barcodes
to digits and digits to barcodes. The else if statement was used for efficiency, 
given that it will return a digit or string as soon as a match is found. I converted
the zipcode to an array of digits in lines 85-94, starting from the right-most digit
and working backwards. I felt that working backwards would be more efficient and limit
additional steps to compute while isolating digits from the left-most point. I used if
statements in the methods to get barcode and get zipcode. If I were to do it differently,
I would add different layers of validation to block invalid entries in the main class,
such as letters or zipcodes longer than five digits. 


Nim.java

The Nim.java main communicates directly with the Game.java class through line 7 of Nim.java.
Game.java communicates with Human.java and Computer.java through line 15 and 16 of the 
Nim.java. Human.java and Computer.java are self-contained and don’t rely on other classes.
In Game.java I set the random difficulty settings to balanced, to give an equal chance for
each setting in either smart or stupid mode before prompting the user to make a selection.
In the method in Game.java I utilized a significant while loop to count the marbles left,
indicate the computer or human player selection total, and ultimately declare a winner. 
The Human.java move method includes if and else statements with a while loop to prompt the
human player for a selection and advise on whether that selection is within the guidelines
stipulated in the problem set. The Computer.java move method includes a boolean to indicate 
the number of marbles 1 less than a power of 2, between 0 and 100 per the instructions. 
The mode selected and the special numbers determine the computer’s ability to win the game. 
I used an else if loop in this section for algorithm efficiency. 
