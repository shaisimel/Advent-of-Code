package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle10 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 9\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int total = 0;
		      HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
		      for(int row = 0; row <128; row++) {
		    	  for(int col=0; col < 8; col++) {		    		  
		    		  map.put((row*8)+col, new int[]{row, col});
		    	  }
		      }
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        int start = 0;
		        int end = 127;
		        int row = (start+end)/2;
		        for(int i=0; i<7; i++) {
		        	char c = data.charAt(i);
		        	if(c=='F') {
		        		end = row;
		        	} else {
		        		start = row+1;
		        	}
		        	row = (start+end)/2;
		        }
		        
		        start = 0;
		        end = 7;
		        int col = (start+end)/2;
		        
		        for(int i=7; i<10; i++) {
		        	char c = data.charAt(i);
		        	if(c=='L') {
		        		end = col;
		        	} else {
		        		start = col+1;
		        	}
		        	col = (start+end)/2;
		        }

		        int id = (row*8)+col;
		        map.remove(id);
		      }
		      
		      for(int k : map.keySet()) {
		    	  int r = map.get(k)[0];
		    	  int c = map.get(k)[1];
		    	  System.out.println("id="+ k + " row="+ r + "col" + c);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

