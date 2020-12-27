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

public class Puzzle25 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 25\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int myEstimatedTime = Integer.valueOf(myReader.nextLine());
		      String[] data = myReader.nextLine().split(",");
		      myReader.close();
		      
		      Integer busLine = null;
		      Integer shortestTime = null;
		      
		      for(String s : data) {
		    	  if(!s.equals("x")) {
		    		  int currentBusLine = Integer.valueOf(s);
		    		  int timeOfArrival = currentBusLine - (myEstimatedTime % currentBusLine);
		    		  if(shortestTime==null || timeOfArrival<shortestTime) {
		    			  shortestTime = timeOfArrival;
		    			  busLine = currentBusLine;
		    		  }
		    	  }
		      }
		      
		      int result = busLine * shortestTime;
		      
		      System.out.println(result);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
}

