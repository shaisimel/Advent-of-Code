package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle6 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 5\\input.txt";
	
	public static void main(String[] args) {
		
		int a = check(1,1);
		int b = check(3,1);
		int c = check(5,1);
		int d = check(7,1);
		int e = check(1,2);
		
		int total = a * b * c * d * e;
		
		System.out.println(total);
	}
	public static int check(int right, int down) {
		int total = 0;
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      
		      int row = 0;
		      myReader.nextLine();
		      while (myReader.hasNextLine()) {
		    	String data = "";  
		    	for(int i=0; i< down; i++) {
		    		data = myReader.nextLine();
		    	}
		        row += right;
		        row %= data.length();
		        if(data.charAt(row)=='#') {
		        	total++;
		        }
		      }
		      
		      myReader.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return total;
	}
}
