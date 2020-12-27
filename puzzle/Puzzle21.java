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

public class Puzzle21 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 21\\input.txt";
	public static final int[][] DIRECTIONS = new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      
		      
		      ArrayList<char[]> mat = new ArrayList<char[]>();
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        char[] d = new char[data.length()];
		        for(int i=0; i <data.length(); i++) {
		        	d[i] = data.charAt(i);
		        }
		        mat.add(d);
		      }
		      myReader.close();
		      
		      char[][] matrix = new char[mat.size()][mat.get(0).length];
		      
		      for (int i =0; i<mat.size(); i++) {
		    	  matrix[i] = mat.get(i);
		      }
		      
		      int numberOfChanges = 1;
		      
		      while(numberOfChanges!=0) {
		    	  numberOfChanges = 0;
		    	  char[][] nextStep = new char[matrix.length][matrix[0].length];
		    	  for(int row=0; row<matrix.length; row++) {
		    		  for(int col=0; col<matrix[row].length; col++) {
		    			  if(matrix[row][col]=='L' && getTakenAdjacentSeats(matrix, row, col)==0) {
		    				  nextStep[row][col] = '#';
		    				  numberOfChanges++;
		    			  } else if(matrix[row][col]=='#' && getTakenAdjacentSeats(matrix, row, col)>=4) {
		    				  nextStep[row][col] = 'L';
		    				  numberOfChanges++;
		    			  } else {
		    				  nextStep[row][col] = matrix[row][col];
		    			  }
		    		  }
		    	  }
		    	  matrix = nextStep;
		      }
		      int result = 0;
		      
		      for(int row=0; row<matrix.length; row++) {
	    		  for(int col=0; col<matrix[row].length; col++) {
	    			  if (matrix[row][col]=='#') {
	    				  result++;
	    			  }
	    		  }
		      }
		      
		      
		      System.out.println(result);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	private static int getTakenAdjacentSeats(char[][] matrix, int row, int col) {
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		int taken = 0;
		for(int[] dir : DIRECTIONS) {
			int r = row + dir[0];
			int c = col + dir[1];
			if(r >= 0 && r<rowSize && c >=0 && c<colSize && matrix[r][c]=='#') {
				taken++;
			}
		}
		return taken;
	}
}

