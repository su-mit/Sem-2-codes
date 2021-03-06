package Calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	
	public static double round(double value, int places) {
		    if (places < 0) throw new IllegalArgumentException();
		 
		    BigDecimal bd = new BigDecimal(Double.toString(value));
		    bd = bd.setScale(places, RoundingMode.HALF_UP);
		    bd = bd.setScale(places);
		    return bd.doubleValue();
		}

	public static void main(String args[]) {
		System.out.print("This program takes the value along with the error terms and perofm calculation \n");
		
		// Creating an object of scanner class
		 Scanner keyboard = new Scanner(System.in);
		 
		 			
/***********
 * The user maybe wants to do calculations more than once, there is use of do loop, as it a exit control loop hence to exit
 * user has to give an input.
 * 
 */
			
	do {
			
	
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
	    System.out.println("1. Multiplication");                       // '1' is multiplication
	    System.out.println("2. Division");                    // '2' is division


	    // this integer value reads the value for performing any function 
	    menu = keyboard.nextInt();
	   
	    
	 
	    
	    // If the value of menu is 1, subtraction function is performed
	    if (menu == 1) {

	    	// Finding the result value of the resultant range 
	    	result = (operand1 * operand2);                
	    	
	    	// Finding the error term
	    	resultErrorTerm = (operand1ErrorTerm/operand1 + operand2ErrorTerm/operand2 )*result;
	    	
	    }
	    
	    // If the value of menu is 2, subtraction function is performed
	    else if (menu == 2) {
	    	
	    	// Finding the result value of the resultant range 
	    	result = (operand1/operand2);                
	    	
	    	// Finding the error term
	    	resultErrorTerm = (operand1ErrorTerm/operand1 + operand2ErrorTerm/operand2 )*result;
	    	
	    }
	    
	     
	    // If wrong input is entered, program results an error 
	    else
	    	System.out.println("Wrong input");
	   
	    System.out.println("\n");
	    
	    
	    //Displaying the inputs
        System.out.println("Operand 1 = " + operand1+ "  " + "\u00B1" + "  " +operand1ErrorTerm);
        System.out.println("Operand 2 = " + operand2+ "  " + "\u00B1" + "  "  + operand2ErrorTerm);
        
        
        
	    // converting the resultant error term to String
        Double object = new Double(resultErrorTerm);
        //If the word is in exponential form convert it into normal form
        String text = BigDecimal.valueOf(object).toPlainString();
		
			
		// Finding the occurrence of first significant digit
		int x;
		
	    	for(x = 0; x < text.length(); x++) {
	         if(text.charAt(x)=='1'|| text.charAt(x)=='2'||text.charAt(x)=='3'||text.charAt(x)=='4'||text.charAt(x)=='5'||
	        		 text.charAt(x)=='6'||text.charAt(x)=='7'||text.charAt(x)=='8'||text.charAt(x)=='9') {       
	        	 // Checking for the first significant digit  
	        	 
	       	 	 break;}                                      // coming out of the loop if we have encountered the first 
	                                                          // significant digit
	    	}
	    	
/*************
 * After knowing the place of the first significant digit, displaying result up to that index
 * by using the substring method of the String class.
 * 
 */	       
	   resultErrorTerm = Double.parseDouble(text);
	   
	   
	    result = round(result , x);
	    resultErrorTerm= round(resultErrorTerm , 1);   
	   
	    System.out.println("\n \n");
		
	    System.out.println("Result = " + result + " " + "\u00B1" + " " + resultErrorTerm);
	    
		System.out.print("Do you want to do more calculations (y/n):");
		input = keyboard.next().charAt(0);     
          
				

		
	     // Proper message when quit command is recognized   
		 if(input == 'N' || input =='n') {
				
				System.out.println("Quit command recognized");
				System.out.println("Program terminates successfully");
				
	          }	
				
	}while(input == 'Y' || input == 'y');
	
	if (input != 'y' || input != 'Y' || input != 'n' || input != 'N') {
		System.out.println("Wrong command entered");
		System.out.println("Program terminating");
		
	    
	}
	keyboard.close();                             // Scanner object closed
	}	

}
