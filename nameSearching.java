package ItrativeSearch;

import java.util.Scanner;

public class nameSearching {

	// Sring containg names of 10 students
	private static String data[] = {"Keshav", "Pratik", "Tiwari", "Sukrut", "Jaskirat", "Sumit", "Arjun", 
			                            "Prince", "Vaibhav", "Hemant"};
	
	/*************
	 * This method takes the String and the name to be serach and use the itrative method to search the name
	 * in the data. If the name is found in the data then it returns the index of the name index in the data
	 * if isn't found then it returns -1.
	 * 
	 * @param d
	 * @param g
	 * @return
	 */
	public static int search(String d[], String g) {
		
		int ndx = 0;
		while (ndx < d.length && !(g.equalsIgnoreCase(d[ndx]))) ndx++;
		if (ndx >= d.length) return -1;
		if (g.equalsIgnoreCase(d[ndx])) return ndx;         // If name is found then return the index
		else return -1;                                     // If name is not found the return -1
	}
	
	
	public static void main (String [] args) {
		String nameToFind;
		
		Scanner temp = new Scanner(System.in);
		
		nameToFind = temp.next();                // Take input of the name to be search
		
		int index = search(data, nameToFind);
		
		if(index<0)
			System.out.println("The search could not find:" + nameToFind);
		else
			System.out.println(nameToFind + " was found at index: " + index);
		
		temp.close();
		
	}
}
