package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle4 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 3\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int total = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] s = data.split(" ");
		        String[] v = s[0].split("-");
		        int pos1 = Integer.valueOf(v[0])-1;
		        int pos2 = Integer.valueOf(v[1])-1;
		        char c = s[1].charAt(0);
		        String pass = s[2];
		        
		        if((pass.charAt(pos1)==c && pass.charAt(pos2)!=c) ||
		        		(pass.charAt(pos1)!=c && pass.charAt(pos2)==c)) {
		        	total++;
		        }
		        
		      }
		      System.out.println(total);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		
	}

}
