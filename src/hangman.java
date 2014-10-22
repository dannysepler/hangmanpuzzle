import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class hangman {
	public static void main(String[] args) {
		System.out.println("Welcome to hangman! Loading....\n");

		char[] answer = grabword();
		char[] userarray = new char[ answer.length ];
		Arrays.fill( userarray, '_' );
			// fills the array with the '_' character

		int score = 0;

		while ((score != 7) && (filled( userarray ) == false)) {
			printhangman( score );
			System.out.println("\nyour word so far....");
			printArray( userarray );
			
			System.out.println("Care to guess a letter?");
			char user_guess = userguess( answer );

			if (user_guess != ' ') 	{// user guessed right
				System.out.println("Correct! Filling in the "+user_guess+"'s");
				userarray = fill( user_guess, answer, userarray );
			}

			else {					// user guessed wrong
				System.out.println("Ouch, that's wrong....");
				score++;
			}
		}

		if (filled (userarray) ) {
			System.out.print( "GREAT JOB! You got it\n"+
								"The word was ");
			printArray( userarray );
		}

		else {
			printhangman( score );
			System.out.print( "Oh no, you lost...\nThe word was ");
			printArray( answer );
		}
	}

	public static char userguess( char[] answer ) {
		// ---------------------------------------------------
		// write this method
		// 
		// 1. get a letter from the user
		// 1. if the letter's in the answer, return that letter
		// 2. if it's not, return a blank (' ') character
		// ---------------------------------------------------
		
	}

	public static boolean filled( char[] userarray ) {
		// ---------------------------------------------------
		// write this method
		// 
		// it checks if the userarray has been completely filled in
		// aka, did the user win the game? if so, return true
		// if not, return false
		// 
		// remember, the user array starts out full of underscores.
		// when the user gets a letter right, the program replaces
		// an underscore with that letter
		// ---------------------------------------------------	
	}
	public static char[] fill( char user_guess, char[] answer, char[] userarray ) {

		// ---------------------------------------------------
		// write this method
		// 
		// this method runs when a user guesses a correct letter.
		// remember, the userarray starts out full of underscores
		// it replaces the corresponding underscore(s) in the userarray 
		// with letter that the user just guessed correctly
		// 
		// return the new userarray at the end
		// ---------------------------------------------------	
	}

	public static char[] grabword() {
		// --------------------------
		// This function generates 
		// a random word
		// --------------------------		
		File dictionary = new File("WordsEn.txt");
			// a text file with 109582 words in it

		int random = (int) (Math.random() * 109582);
		// grab a random number between 1 and 109582

	    try {
	        Scanner sc = new Scanner(dictionary);

	        String word = "";
	        for (int i = 0; i < random; i++ )
	            word = sc.nextLine();

	        sc.close();
	        return toArray( word );
	    } 
	    catch (FileNotFoundException e) {
	        return toArray( "indignant" );
	    }
	}

	public static void printhangman( int progress ) {
		// --------------------------
		// This function prints the
		// game board
		// --------------------------

		char[][] board = {
			// the board is 14 columns x 8 rows
			//0   1   2   3   4   5   6   7   8   9  10  11   12  13 
			{' ',' ',' ',' ',' ','_','_','_','_','_','_','_',' ',' ' },
			{' ',' ',' ',' ','|','/',' ',' ',' ',' ',' ',' ','|',' ' },
			{' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' ',' ' },
			{' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' ',' ' },
			{' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' ',' ' },
			{' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' ',' ' },
			{' ',' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' ',' ' },
			{'_','_','_','_','|','_','_','_','_',' ',' ',' ',' ',' ' }
		};

		// filling it out
		switch (progress) {
			case 7: // right leg
				board[5][13]='\\';

			case 6: // left leg
				board[5][11]='/';

			case 5: // right arm;
				board[3][13]='/';

			case 4: // left arm
				board[3][11]='\\';

			case 3: // bottom half of body
				board[4][12]='|';

			case 2: // top half of body
				board[3][12]='|';

			case 1: // head
				board[2][11]='(';
				board[2][12]='_';
				board[2][13]=')';
				break;

			default: break;
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 14; j++)
				System.out.print( board[i][j] );
			System.out.println();
		}
	}
	public static char[] toArray( String word ) {
		// --------------------------
		// This function converts a
		// string to an array
		// --------------------------		
		char[] wordarray = new char[ word.length() ];
	    for (int i = 0; i < word.length(); i++)
	        wordarray[i] = word.charAt(i);
	    return wordarray;
	}

	public static void printArray(char[] array) {
		// --------------------------
		// This function prints
		// an array
		// --------------------------
		for (int i = 0; i < array.length; i++)
			System.out.print( array[i] );
		System.out.println();
	}
}