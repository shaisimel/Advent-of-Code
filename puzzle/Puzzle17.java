package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Puzzle17 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 17\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      ArrayList<Long> values = new ArrayList<Long>();
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        values.add(Long.valueOf(data));
		      }
		      myReader.close();
		      
		      int index=25;
		      while(isValid(values, index)) {
		    	  index++;
		      }
		      
		      System.out.println(values.get(index));
		      
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	private static boolean isValid(ArrayList<Long> values, int index) {
		Long target = values.get(index);
		HashSet<Long> set = new HashSet<Long>();
		
		for(int i=index-25; i<index; i++) {
			Long lookingFor = target - values.get(i);
			if(set.contains(lookingFor)) {
				return true;
			}
			set.add(values.get(i));
		}
		
		return false;
	}
}

