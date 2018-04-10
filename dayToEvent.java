package Practice_Sheet3;

import java.util.Scanner;

public class dayToEvent {

	private static int days_ToGo;
	static int days = 0;
	static int weeks =0;
  	
	private static int weeks(int number_OfDays) {
	   	
		if (number_OfDays <=0 ) return weeks;
		
		++weeks ;
				
		return weeks(number_OfDays-7);
	}
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("This program calcult teh differene to an occuring event in weeks and dasy");
		System.out.println("");
		System.out.print("Enter the day to go for the event: ");
		
		days_ToGo = keyboard.nextInt();
		
		if (days_ToGo <7) {
            days = days_ToGo % 7;
			System.out.println(days + " Days");
		}
		
		else
		{
			days = days_ToGo % 7;
			System.out.println(weeks(days_ToGo - days) + " Weeks and " + days + " Days");
	   }
		keyboard.close();
}

}
