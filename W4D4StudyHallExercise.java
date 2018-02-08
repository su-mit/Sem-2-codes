package w4d2StudyHall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class W4D4StudyHallExercise {

	
	/**********************************************************************************************
	 * The following static variables are used by the main method to hold the key state and 
	 * objects that must exist and be available across the various methods of this class (the
	 * mainline).
	 */

	static Scanner keyboard = new Scanner(System.in);		// The scanner for the keyboard
	static String [] secretWords;						    // This array holds the secret words
	static Random random = new Random();					// A random number generator
	private static String usersName;
	private static char inputFromUser;
	private static char previousInputFromUser = Character.MIN_VALUE;
	private static char menuCharacter;
	private static int ind;
	private static int b;
	private static String theResult;
	private static String theFakeResult;
	private static int losse = 0;
	private static int win = 0;
	private static char restCommand;
	private static int numberOfGamesplayed = 0;
	private static String statiscticData [];
	private static boolean s = false;
	
	/**********************************************************************************************
	 * The following static method take in two strings and returns a new string where each letter
	 * in the first string (theWord) is checked to see if it is in the second string 
	 * (theGuessedLetters). For each letter that has been guessed, it will be present in the output
	 * string.  If the letter has NOT been guessed, all occurrences of that letter will be replaced
	 * by the question mark character.
	 */
	public static String displayVersion(String theWord, String theGuessedLetters) {
		// Make a copy of the input parameter
		theResult = theWord;
		
		// Set up a local variable to hold each of the letters in theWord
		char aCharacter = '?';
		
		// Use a For Loop to access each and every letter in theWord
		for (int ndx = 0; ndx < theWord.length(); ndx++) 
		{
			
			// Access each letter, one at a time, from theWord
			aCharacter = theWord.charAt(ndx);
			
			// Check to see if that letter appears somewhere in theGuessedLetters
			if (theGuessedLetters.indexOf(aCharacter) != -1)
				
				// If so, replace all occurrences of it with a question mark
				theResult = theResult.replace(aCharacter, '?');
		}
		
		// Return the word with all unguessed letters being replaced by question marks
		return theResult;
	}
	
	/******************************************
	 * This method calculate whether the user won or loses
	 * @param value1
	 * @param value2
	 * @return 
	 */
	public static String outcome(int value1, int value2) {
        String lossStatement = "Loose";
        String wonStatement = "Won";
        String noWonNoLoss ="No loose no won";
        
		if(value1<value2) {
			return lossStatement;
		}
		
		else if(value1>value2) {
			return wonStatement;
		}
	    
		else {
			return noWonNoLoss;
		}
	}
	
	/**********
	 * This private method reads in a list of words from a specified input file
	 * 
	 * @param theFileName	A String parameter that specifies the name of the file to use
	 * @return				The methods returns an array of words if the file is there
	 * 
	 * @exception			A File not found exception results in program termination
	 */
	private static String[] readInTheWords(String theFileName){
		// Set up local variable so the method can read the file that contains the secret words
		// based on the name that is passed into the method via theFileName parameter.
		
		Scanner fileReader = null;		// Establish a local variable outside the try/catch
								    	// block so it will be available after it completes
		try {							
			// Try opening the file and set up a scanner to read it.  If the file is there,
			// the program will continue to the statement following this try/catch block.
			fileReader = new Scanner(new File(theFileName));
		} 
		catch (FileNotFoundException e) {
			// If the file is not there, an exception will be thrown and the program flow
			// will directed here.  An error message is displayed tp the console and the 
			// program stops.
			System.out.println("*** Error *** The file 'SecretWords.txt' was not found!");
			System.out.println("The program terminates with an error now.");
			System.exit(0);
		}

		// If we get here, the file is there and can be read.  So we use the "hasNextInt" method
		// to see if there is a number in the first line that we can used to determine how many 
		// words to read in.  
		int numWords = 0;				// Establish a local variable of the number of words
										// here so it will be available after the if statement.
		if (fileReader.hasNextInt()) {
			numWords = fileReader.nextInt();
		} 
		else {
			System.out.println("*** Error *** The first line of file 'SecretWords.txt' does not "
					+ "start with and integer that specifies the number of secret words to be "
					+ "read!");
			System.out.println("The program terminates with an error now.");
			System.exit(0);
		}

		// If we get here, it means that the file containing the secret words properly start with
		// an integer. We then use that integer to allocate an array of just the right size 
		String [] words = new String[numWords];

		// We then use the size to drive a for loop to read in the words and store them into
		// the array, converting the letters to UPPER CASE
		for (int ndx = 0; ndx < numWords; ndx ++)
			if (fileReader.hasNext())
				words[ndx] = fileReader.next();
			else {
				// If we get here, it means that we have run out of words to be read in before we
				// have filled the array of words.  Therefore, we will inform the user of this 
				// error condition and terminate the program.
				System.out.println("*** Error *** The file does not contain enough secret word to "
						+ "satisfy the number specified at the beginning of the file!");
				System.out.println("The program terminates with an error now.");
				System.exit(0);
			}
		
		return words;
	}

	public static void main(String[] args) {
		/* Initialize the Text Hangman game */
		Scanner keyboard = new Scanner(System.in);
		// Open access to the console keyboard so the user can enter information
 				
		/* Welcome the user and request the user to enter a name */
        System.out.println("Welcome!"+"\n");
        System.out.println("Please enter your name followed by a return ");
		usersName = keyboard.nextLine();
				        
while (true) {
			/* Display menu */
        System.out.print(usersName +", please enter a command letter followed by a return! \n");
        System.out.println("   p -> Play the game");
        System.out.println("   s -> View statistics");
        System.out.println("   q -> Quit");
        
        /* Read the menu character */
        menuCharacter = keyboard.next().charAt(0);
			
        /* Play the game? */
        if(menuCharacter == 'p') {
            b = 0;
        	numberOfGamesplayed ++;
        	
        System.out.println("Play the game command recognized.");
        
        /**********************************************************************************************
    	 * The following main method display a title, and then asks the user to enter two input strings
    	 * which will be processed by the above method and then the result is returned and displayed.
    	 */
       
        System.out.println(previousInputFromUser);
                		     		   		
     		// Request the user to enter in the letter that have already been guessed
     		System.out.print("Enter the letters already guessed: ");
     		
     		String guessedLetters = keyboard.next().trim();

	    
		// Try to read in the array of words and store them into the class instance variable
		secretWords = readInTheWords("SecretWords.txt");

		// If the execution reaches this point, the reading was successfully accomplished,
		// so inform the user of this
		System.out.println("The program has successfully read in the set of secret words.");
		System.out.println();
		
		// Display the words in a nicely formatted list
		System.out.println("The follwing are those words:");
		int ndx = random.nextInt(secretWords.length -1);
		theFakeResult = secretWords[ndx];
	    // Compute the display version of the secret word and display it.
 		System.out.println("The display version of the secret word: " + displayVersion(theFakeResult, guessedLetters));
 		
 		// Close access to the console keyboard
 	
 	for (int a = 0; a < 6 ; a++ ){
 	System.out.println("Guess the words at the question mark");
 	
 	inputFromUser = keyboard.next().charAt(0);
 	
 	ind = theFakeResult.indexOf(inputFromUser);
 	
 	System.out.println(ind);
 	
 	if(ind !=-1) {
 	 	
 	    theResult.replace(theResult.charAt(ind), inputFromUser);
 	 	System.out.println("You made a valid move");
 	 	System.out.println("Now the secrete word is :");
 	 	System.out.print(theResult);     	
 	 	
 	 	}
 	else if (previousInputFromUser == inputFromUser){
     	
     	System.out.println("This move has been already made, thus you made an invalid move");
     	System.out.print("Secrete word is still :");
     	System.out.println(theResult);	
     	
 	}
 	
 	 	     	
 	else {
 		System.out.println("This is an invalid move");
     	System.out.println("Secrete word is still :");
     	System.out.print(theResult);
     	
 	}
 	
 	
 	for(int z = 0; z < theResult.length(); z++ ) {
 		
 		if(theResult.indexOf('?') == -1) 
 		s = true;	
 		
 		else 
 	    s = false;
 		
 	}
 	
 	if (s == true)
 		break;
    
 	}
 	
 	

 	if (s == true)
 	{System.out.println("Congratulations you have won the game");}
 	else
 	{   System.out.println("Your chances are over now");
 		System.out.println("Unfortunately you lose");}
	
 	statiscticData[b] = outcome(win,losse);
    b++;
        }
    			
    /* View the statistics? */
    else if(menuCharacter == 's') {
    
    System.out.println("View the statistics command recognized.");
    System.out.println("You results are \n");
    for(int i = 1; i<=numberOfGamesplayed; i++) {
    System.out.print("Game" + i + statiscticData[b] );	
    b++;
    }
    
    System.out.println("Do you want to reset the statictics");
    restCommand = keyboard.next().charAt(0);
    
    if(restCommand == 'Y' || restCommand == 'y') {
    
    
    for(b= 0 ; b>0 ; b++) {
    
    	statiscticData[b] = null;        	
    }      
    
    System.out.println("Rest succesfull");  }
    
    }
    
		
    /* Quit the game? */
    else if(menuCharacter == 'q') {
    	
    	System.out.println("Quit the game command recognized");
    	System.out.println("Thanks for playing, " + usersName + "!");
    	break;
        
    	 }
		
    /* Display error (if command is none of the above) */
    else 
    {	    	
    	System.out.println("*** Error ***");
    	System.out.println("   Invalid menu item entered. It must be p, s, or q!");
    	System.out.println("   The input found was: " + menuCharacter);
    	} 
   previousInputFromUser = inputFromUser;}
keyboard.close();}
}


