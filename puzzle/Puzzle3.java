package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle3 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 3\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int total = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] s = data.split(" ");
		        String[] v = s[0].split("-");
		        int min = Integer.valueOf(v[0]);
		        int max = Integer.valueOf(v[1]);
		        char c = s[1].charAt(0);
		        int count = 0;
		        for(char n : s[2].toCharArray()) {
		        	if(n==c) {
		        		count++;
		        	}
		        }
		        
		        if(count>= min && count <= max) {
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
