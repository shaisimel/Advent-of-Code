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

public class Puzzle26 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 25\\input.txt";
	public static final long START_TIME = 0;// 100000000000000l;
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int myEstimatedTime = Integer.valueOf(myReader.nextLine());
		      String[] data = myReader.nextLine().split(",");
		      myReader.close();
		      
		      HashMap<Long, Long> rules = new HashMap<Long, Long>();
		      long maxRule = 0;
		      long maxBusLine = 0;
		      for(int i=0; i<data.length; i++) {
		    	  if(!data[i].equals("x")) {
		    		  long val = Long.valueOf(data[i]);
		    		  rules.put((long) i, val);
		    		  if(val>maxBusLine) {
		    			  maxBusLine = val;
		    			  maxRule = i;
		    		  }
		    	  }
		      }
		      boolean isValid = false;
		      long interval = maxBusLine;
		      long currentTime = 100034795862987l;//START_TIME + maxRule;
		      long checkpoint = currentTime + 10000000000l;

		      while((currentTime+maxRule)%interval!=0) {
		    	  currentTime++;
		      }
		      
		      while(!isValid) {
		    	  currentTime += interval;
		    	  if(currentTime>checkpoint) {
		    		  System.out.println("checkpoint " + currentTime);
		    		  checkpoint = currentTime + 10000000000l;
		    	  }
		    	  isValid = true;
		    	  for(long key : rules.keySet()) {
		    		if((currentTime+key)%rules.get(key)!=0) {
		    			isValid = false;
		    			break;
		    		}
		    	  }
		      }
		      
		      System.out.println(currentTime);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
}

