package Calculation;

import java.util.Scanner;

public class errorTerm {

	private static double operand1;               // Stores operand1 value
	private static double operand1ErrorTerm;      // Stores operand1 error term value
	private static double operand2;               // Stores operand2 value
	private static double operand2ErrorTerm;      // Stores operand2 error term value
	private static double result;                 // Stores the computed result
	private static double resultErrorTerm;        // Stores the computed result error term
	private static int menu;                      // To select the operation to be performed 
	private static char input = 'y';

	public static void main(String args[]) {
		System.out.print("This program takes the value along with the error terms and perofm calculation \n");
		
		// Creating an object of scanner class
		 Scanner keyboard = new Scanner(System.in);
		 
		 
/************
 * Here we are using lower and upper bound to compute the result, thus here 'LB' is used as suffix for the Lower Bound
 * and 'UB' as Upper Bound. Since a single operand has a lower and upper bound thus we are taking two variables  
 *  
 */		 
		    double operand1LB;
			double operand1UB;
			double operand2LB;
			double operand2UB;
			double resultLB;
			double resultUB;
			
/***********
 * The user maybe wants to do calculations more than once, there is use of do loop, as it a exit control loop hence to exit
 * user has to give an input.
 * 
 */
			
	do {
			
		// Initializing the variables as '0d' in order to avoid an type of memory loss or 
		// any type of garbage value get stored in the variables
 		operand1LB = 0d;
		operand1UB = 0d;
		operand2LB= 0d;
		operand2UB= 0d;
		resultLB= 0d;
		resultUB= 0d;
		
		System.out.println();
			
		System.out.print("Operand 1 = ");                         
		operand1 = keyboard.nextDouble();                        // taking value of operand1
		
		System.out.print("Operand 1 error term = ");
		operand1ErrorTerm = keyboard.nextDouble();               // taking value of opernd1 error term

		
		System.out.print("\n");                    // giving space between operand1 and opernd2 values 
		System.out.print("Operand 2 = ");
		operand2 = keyboard.nextDouble();                        // taking value of operand2 
		
		System.out.print("Operand 2 error term = ");
		operand2ErrorTerm = keyboard.nextDouble();               // taking value of operand2 error term
	
		// Giving options to the user, to perform desired operation
	    System.out.println("What do you want to perform");
	    System.out.println("1. Addition");                       // '1' is addition
	    System.out.println("2. Subtraction");                    // '2' is subtraction

	    // this integer value reads the value for performing any function 
	    menu = keyboard.nextInt();
	   
	    
	 
	    // If the value of menu is 1, addition function is performed 
	    if(menu == 1){
	    	
	    	operand1LB = operand1 - operand1ErrorTerm;               // creating lower term of operand1
	    	operand1UB = operand1 + operand1ErrorTerm;               // creating upper term of operand1
	    	operand2LB = operand2 - operand2ErrorTerm;               // creating lower term of operand2
	    	operand2UB = operand2 + operand2ErrorTerm;               // creating upper term of operand2
	    	
	    	resultLB = operand1LB + operand2LB;                // computing lower bound of resultant range
	    	resultUB = operand1UB + operand2UB;                // computing upper bound of resultant range 
	    	
	    	// Finding the average value of the resultant range 
	    	result = (resultLB + resultUB)/2;                
	    	
	    	// Finding the error term
	    	resultErrorTerm = (resultUB - resultLB)/2;
	    	
	    }
	    
	    // If the value of menu is 2, subtraction function is performed
	    else if (menu == 2) {
	    	
	    	operand1LB = operand1 - operand1ErrorTerm;               // creating lower term of operand1
	    	operand1UB = operand1 + operand1ErrorTerm;               // creating upper term of operand1
	    	operand2LB = operand2 - operand2ErrorTerm;               // creating lower term of operand2
	    	operand2UB = operand2 + operand2ErrorTerm;               // creating upper term of operand2
	    	
	    	resultLB = operand1LB + operand2LB;                // computing lower bound of resultant range
	    	resultUB = operand1UB + operand2UB;                // computing upper bound of resultant range 
	    	
	    	// Finding the average value of the resultant range 
	    	result = (resultLB + resultUB)/2;                
	    	
	    	// Finding the error term
	    	resultErrorTerm = (resultUB - resultLB)/2;
	    	
	    }
	    
	   	  
	    // If wrong input is entered, program results an error 
	    else
	    	System.out.println("Wrong input");
	   
	    //Displaying the inputs
        System.out.println("Operand1 = " + operand1 + "\t" + "Error Term = " + operand1ErrorTerm);
        System.out.println("Operand1 = " + operand1 + "\t" + "Error Term = " + operand1ErrorTerm);
        
	    // converting the resultant error term to String
		String text = Double.toString(Math.abs(resultErrorTerm));
		// Finding the occurrence of the decimal point in the result error term
		int integerPlaces = text.indexOf('.');
		
	    // If decimal point is present in the error term then rounding it up to one significant
		// digit after decimal point
		 if( integerPlaces != -1){
	    	int x = 1;
	    	for(x += integerPlaces; x < text.length(); x++) {
	         if(text.charAt(x)>1 || text.charAt(x)<9) {       // Checking for the first significant digit
	        	 ++x;                                         
	       	 	 break;}                                      // coming out of the loop if we have encountered the first 
	                                                          // significant digit
	    	}
	    	
/*************
 * After knowing the place of the first significant digit, displaying result up to that index
 * by using the substring method of the String class.
 * 
 */	    	
	        System.out.println("Result =" + result + " " + "\u00B1" + " " +  text.substring(0, x));
	    	
	    }
	   
		// If no decimal point is there then nothing is needed to round off, result is displayed as it is
	    else
	    	System.out.println("Result =" + result + " " + "\u00B1" + " " +  Math.abs(resultErrorTerm));
	       
	   
	    System.out.println("\n \n");
		
	    
		System.out.print("Do you want to do more calculations (y/n):");
		input = keyboard.next().charAt(0);     
          
				
		}while(input == 'Y' || input == 'y');
		
	     // Proper message when quit command is recognized   
		 if(input == 'N' || input =='n') {
				
				System.out.println("Quit command recognized");
				System.out.println("Program terminates successfully");
		        	return;
	          }	
		else {
			System.out.println("Wrong command entered");
		    
		}
		keyboard.close();                             // Scanner object closed
	}	

}
