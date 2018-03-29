package searchExamples;

import java.util.Arrays;
import java.util.Scanner;
/************
 * This program demostarte the binary search method by taking a number as input and then search it in
 * an un sorted array, by first arranging array automatically in asscending order. 
 * If the number enter is found at the position of its value then program is working true. 
 * @author Mr. Robot
 *
 */

public class IterativeBinarySearch {
	
	private static int data[] = { 1 , 3 , 4 , 9 , 8 , 4 , 5 , 6 , 7 , 0 } ;
	
	public static int iterativeBinarySearch (int d[], int g) {
		Arrays.sort(data);   // Automatically sort the data in asscending order
		
		int left = 0; 
		int middle = (d.length-1)/2;
		int right = d.length-1;
		
		while (d[middle] != g && left <= right) {
			if (d[middle] > g) right = middle-1;
			else left = middle+1;
			middle = (left + right)/2;
		}
		if (d[middle] == g) return middle;
		else return -1;
	}
	
	public static void main (String [] args) {
		int goal;
		Scanner temp = new Scanner(System.in);
		System.out.print("Enter the number to be searched (0-9): ");
		goal = temp.nextInt();
		int result = iterativeBinarySearch(data, goal);
		if (result < 0) System.out.println("The search could not find: " + goal);
		else System.out.println(goal + " was found at index: " + result);
		
		temp.close();
	}

}