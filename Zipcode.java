/********************************************
 * This class converts a five digit zipcode 
 * into a postal service barcode denoting the
 * digits as a series of full and half bars.
 * 
 * 
 * Stephen Wright
 * svw2112
 *******************************************/

//import java scanner to collect user input
import java.util.Scanner;

public class Zipcode{
    
	//declares instance variables
	private int zipcode; //stores zip code as integer
	private String barcode; //stores barcode as string

	//implement constructors 
	public Zipcode(int zipcode)
	{    
		this.zipcode = zipcode; //initializes instance variables with parameter value
	}   

	public Zipcode(String barcode)
	{ 
		this.barcode = barcode; //initializes instance variables with parameter value
	}

    //method to convert barcode string to digit integer
	private static int getDigit(String barcode)
	{
		int digit = -1; //initializes to negative to identify invalide entry
        if(barcode.equals("||:::")) //.equals compares strings
			digit = 0;
		else if(barcode.equals(":::||")) //else if to return digit when match found
			digit = 1;
		else if(barcode.equals("::|:|"))
			digit = 2;
		else if(barcode.equals("::||:"))
			digit = 3;
		else if(barcode.equals(":|::|"))
			digit = 4;
		else if(barcode.equals(":|:|:"))
			digit = 5;
		else if(barcode.equals(":||::"))
			digit = 6;
		else if(barcode.equals("|:::|"))
			digit = 7;
		else if(barcode.equals("|::|:"))
			digit = 8;
		else if(barcode.equals("|:|::"))
			digit = 9;
		return digit; //return digit when match found
	}

	//method to convert digit integer to barcode string
    private static String getBarcode(int digit)
	{
		String code = ""; //initializes empty string to detect errors
		if(digit == 0) //will return empty string as error if not 0-9
			code = "||:::";
		else if(digit == 1) //else if to return string when match found
			code = ":::||";
		else if(digit == 2)
			code = "::|:|";
		else if(digit == 3)
			code = "::||:";
		else if(digit == 4)
			code = ":|::|";
		else if(digit == 5)
			code = ":|:|:";
		else if(digit == 6)
			code = ":||::";
		else if(digit == 7)
			code = "|:::|";
		else if(digit == 8)
			code = "|::|:";
		else if(digit == 9)
			code = "|:|::";
		return code; //return string when match found
	}

	//converts and stores zip code as an array of digits
    private static int[] zipToDigits(int zip)
	{
		int[] result = new int[5]; //creates an array to store five integers
		for(int i = result.length - 1; i >= 0; i--) //works backwards from position four 
		{
			result[i] = zip % 10; //right most digit of unit zipcode
			zip = zip / 10;
		}
		return result; //return each digit in the array digits
	}  

    //method to return full barcode counterpart of entered zip code
	public String getBarcode()
	{
		if (barcode == null) //test if barcode exists
		{
			barcode = ""; //initializes barcode to empty string
			int[] digits = zipToDigits(zipcode); //uses method to split zip code by digit			
			int sumOfDigits = 0; //tracking sum of digits to compute check digit

			for (int digit : digits) //for each loop for each digit in digits array
			{
				barcode += getBarcode(digit); //concatenate barcode with current digit
				sumOfDigits = sumOfDigits + digit; //tracking sum of digits
			}
			int checkDigit = 10 - sumOfDigits % 10; //computes check digit
			barcode += getBarcode(checkDigit); //concatenate barcode with check digit
			barcode = "|" + barcode + "|"; //add bookends to full barcode
		} 
		return barcode; //returns full barcode
	}

	//method to return full zip code counterpart of entered barcode
    public int getZIPcode()
	{
		if (zipcode == 0) //test if zipcode exists
		{
			String fullBarcode = barcode.substring(1, barcode.length() - 6); //remove bookends and check digit
			for(int i = 0; i < fullBarcode.length(); i += 5) //for loop increasing by five through each section
			{
				String code = fullBarcode.substring(i, i + 5);
				int digit = getDigit(code); //converts barcode to a digit
				zipcode = zipcode * 10 + digit; //shift left and add digit for full zipcode
			}
		}		
		return zipcode; //returns full zip code
	}
}