package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Puzzle18 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 17\\input.txt";
	public static final long TARGET = 25918798;
	
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
		      
		      long sum = 0;
		      int start = 0;
		      int end = 0;
		      
		      while(sum!=TARGET) {
		    	  if(sum<TARGET) {
		    		  sum += values.get(end);
		    		  end++;
		    	  } else {
		    		  sum -= values.get(start);
		    		  start++;
		    	  }
		      }
		    	
		      long min = values.get(start);
		      long max = values.get(start);
		      
		      for(int i=start+1; i <= end; i++) {
		    	  min = Math.min(min, values.get(i));
		    	  max = Math.max(max, values.get(i));
		      }
		      
		      long result = min + max;
		      
		      System.out.println(result);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

