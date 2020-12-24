package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle5 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 5\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int total = 0;
		      int row = 0;
		      myReader.nextLine();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        row += 3;
		        row %= data.length();
		        if(data.charAt(row)=='#') {
		        	total++;
		        }
		      }
		      System.out.println(total);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		
	}

}
