package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Puzzle15 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 15\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      ArrayList<String> commands = new ArrayList<String>();
		      ArrayList<Integer> values = new ArrayList<Integer>();
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] d = data.split(" ");
		        commands.add(d[0]);
		        values.add(Integer.valueOf(d[1]));
		      }
		      myReader.close();
		      
		      HashSet<Integer> visited = new HashSet<Integer>();
		      int cursor = 0;
		      int acc = 0;
		      while (!visited.contains(cursor)) {
		    	  visited.add(cursor);
		    	  if (commands.get(cursor).equals("acc")) {
		    		  acc += values.get(cursor);
		    		  cursor++;
		    	  } else if (commands.get(cursor).equals("jmp")) {
		    		  cursor += values.get(cursor);
		    	  } else {
		    		  cursor++;
		    	  }
		      }
		      
		      System.out.println(acc);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

