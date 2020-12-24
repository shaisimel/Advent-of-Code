package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle1 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 1\\input.txt";
	
	public static void main(String[] args) {
		
		HashSet<Integer> map = new HashSet<Integer>();
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        int currentNum = Integer.valueOf(data);
		        int target = 2020 - currentNum;
		        if(map.contains(target)) {
		        	System.out.println("num 1 = " + currentNum);
		        	System.out.println("num 2 = " + target);
		        	int val = currentNum * target;
		        	System.out.println("num 1 = " + val);
		        	break;
		        } else {
		        	map.add(currentNum);
		        }
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}
