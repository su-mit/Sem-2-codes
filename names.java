package Practice_Sheet3;

import java.util.Scanner;

public class names {

public static void main(String args[]) {
	
        Scanner keyboard= new Scanner(System.in);	
        System.out.print("Entert Given name:");
        String given = keyboard.nextLine();
        
        System.out.print("Entert Middle name:");
        String middle = keyboard.nextLine();
        
        System.out.print("Entert Family name:");
        String family = keyboard.nextLine();

         if(!family.equals("")){
	           if(given.equals("") && middle.equals(""))  
	        	    System.out.println(family);
	           
               else if(given.equals("")) {
		            if(middle.equals(""))          
		            	System.out.println(family );
		            else
		        	   System.out.println(family + ", " + middle);
               }
	
	           else if(middle.equals("")) {
		            if(given.equals(""))			
		            	System.out.println(family + ", ");
		            else
		            System.out.println(family + ", " + given);   
		       }
	           

	     else 
		       System.out.println(family + ", "+given+ " " + middle);
	        
         }
         
         else
        	 System.out.println("Family Name can't be empty");
         
         keyboard.close();
         }

}