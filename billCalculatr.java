package Practice_Sheet3;

import java.util.Scanner;

public class billCalculatr{
	
	private static int units;
	
	
	public static int bill(int cns_Units) {
		int amout = 5;
		if(cns_Units <= 400)
		amout+= 5*cns_Units;
		
		else
			amout+= 2000 + 7*(cns_Units - 400);
		
		return amout;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("This program calculte the electricity of bill of a person \n" + "The bill calcultion is  as follows: \n"
				+ "1. For units less than 400 or equal to 400, Rs.5 for each unit \n" + "2. Rs.7 for each unit more than 400 \n" 
				+ "3. Minimum of Rs.5 bill for each month");
		
		System.out.println("");
		System.out.print("Enter the units consumed : ");
		
		units = keyboard.nextInt();
		System.out.println("");
		System.out.println("Bill for consumption of " + units + " is Rs." + bill(units));
		
		keyboard.close();
	}
}