package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Puzzle19 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 19\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      ArrayList<Long> values = new ArrayList<Long>();
		      values.add(0l);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        values.add(Long.valueOf(data));
		      }
		      myReader.close();
		      
		      Collections.sort(values);
		      values.add(values.get(values.size()-1)+3);
		      
		      int oneDiff = 0;
		      int threeDiff = 0;
		      for (int i=0; i<values.size()-1; i++) {
		    	 long diff = values.get(i+1)-values.get(i);
		    	 if(diff==1l) {
		    		 oneDiff++;
		    	 } else if(diff==3l) {
		    		 threeDiff++;
		    	 }
		      }
	
		      int result = oneDiff * threeDiff;
		      System.out.println(result);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

