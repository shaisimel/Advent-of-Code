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

public class Puzzle24 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 23\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      
		      int waypointHor = 10;
		      int waypointVert = 1;
		      
		      int shipHor = 0;
		      int shipVert = 0;
		      		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        char command = data.charAt(0);
		        int val = Integer.valueOf(data.substring(1));
		        
		        switch(command) 
	        	{
	        		case 'E':
	        			waypointHor += val;
	        			break;
	        		case 'W':
	        			waypointHor -= val;
	        			break;
	        		case 'S':
	        			waypointVert -= val;
	        			break;
	        		case 'N':
	        			waypointVert += val;
	        			break;
	        		case 'L':
	        			for(int i=1; i<=(val/90); i++) {
        					int temp = -1 * waypointVert;
        					waypointVert = waypointHor;
        					waypointHor = temp;
	        			}
	        			break;
	        		case 'R':
	        			for(int i=1; i<=(val/90); i++) {
        					int temp = -1 * waypointHor;
        					waypointHor = waypointVert;
        					waypointVert = temp;
	        			}
	        			break;
	        		case 'F':
	        			shipHor += val*waypointHor;
	        			shipVert += val*waypointVert;
	        			break;
	        	}
		        
		        
		      }
		      myReader.close();
		      
		      int result = Math.abs(shipHor)+Math.abs(shipVert);
		      
		      
		      System.out.println(result);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
}

