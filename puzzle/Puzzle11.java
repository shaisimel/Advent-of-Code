package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle11 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 11\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int total = 0;
		      HashSet<Character> set = new HashSet<Character>();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.length()==0) {
		        	total += set.size();
		        	set = new HashSet<Character>();
		        } else {
		        	for (char c : data.toCharArray()) {
		        		set.add(c);
		        	}
		        }
		      }
		      total += set.size();
		      System.out.println(total);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

