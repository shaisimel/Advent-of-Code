package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle12 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 11\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int total = 0;
		      HashMap<Character, Integer> set = new HashMap<Character, Integer>();
		      int peopleInGroup = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.length()==0) {
		        	for(int v : set.values()) {
		        		if(v==peopleInGroup) {
		        			total++;
		        		}
		        	}
		        	set = new HashMap<Character, Integer>();
		        	peopleInGroup=0;
		        } else {
		        	peopleInGroup++;
		        	for (char c : data.toCharArray()) {
		        		if(!set.containsKey(c)) {
		        			set.put(c,1);
		        		} else {
		        			set.put(c,set.get(c)+1);
		        		}
		        	}
		        }
		      }
		      for(int v : set.values()) {
	        		if(v==peopleInGroup) {
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

