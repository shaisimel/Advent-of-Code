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

public class Puzzle23 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 23\\input.txt";
	//public static final int[][] DIRECTIONS = new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static final char[] DIRECTIONS = new char[] {'E','S','W','N'};
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      
		      int hor = 0;
		      int ver = 0;
		      int currentDirectionIndex = 0;
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        char command = data.charAt(0);
		        int val = Integer.valueOf(data.substring(1));
		        if(command=='L') {
		        	currentDirectionIndex = ((currentDirectionIndex + DIRECTIONS.length) - (val/90)) % DIRECTIONS.length;
		        } if(command=='R') {
		        	currentDirectionIndex = ((currentDirectionIndex + DIRECTIONS.length) + (val/90)) % DIRECTIONS.length;
		        } else {
		        	char directionToMove = command;
		        	if(directionToMove=='F') {
		        		directionToMove = DIRECTIONS[currentDirectionIndex];
		        	}
		        	switch(directionToMove) 
		        	{
		        		case 'N':
		        			hor += val;
		        			break;
		        		case 'S':
		        			hor -= val;
		        			break;
		        		case 'W':
		        			ver -= val;
		        			break;
		        		case 'E':
		        			ver += val;
		        			break;
		        	}
		        }
		      }
		      myReader.close();
		      
		      int result = Math.abs(hor)+Math.abs(ver);
		      
		      
		      System.out.println(result);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
}

