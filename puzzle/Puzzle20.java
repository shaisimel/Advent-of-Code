package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Puzzle20 {

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
		      
		      long[] dp = new long[values.size()];
		      dp[values.size()-1] = 1l;
		      
		      for(int i = values.size()-2; i>=0; i--) {
		    	  dp[i]=dp[i+1];
		    	  if(i+2<values.size() && (values.get(i+2)-values.get(i)<=3)) {
		    		  dp[i] += dp[i+2];
		    	  }
		    	  if(i+3<values.size() && (values.get(i+3)-values.get(i)<=3)) {
		    		  dp[i] += dp[i+3];
		    	  }
		      }
		      
		      System.out.println(dp[0]);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

