package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle7 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 7\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      int total = 0;
		      
		      HashSet<String> currSet = genSet();
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.length()==0) {
		        	if(currSet.size()==0 || (currSet.size()==1 && currSet.contains("cid"))) {
		        		total++;
		        	}
		        	currSet = genSet();
		        } else {
		        	for(String p : data.split(" ")) {
		        		String[] kv = p.split(":");
		        		currSet.remove(kv[0]);
		        	}
		        }
		      }
		      System.out.println(total);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	private static HashSet<String> genSet(){
		HashSet<String> fields = new HashSet<String>();
		/*byr (Birth Year)
		iyr (Issue Year)
		eyr (Expiration Year)
		hgt (Height)
		hcl (Hair Color)
		ecl (Eye Color)
		pid (Passport ID)
		cid (Country ID)*/		
		
		fields.add("byr");
		fields.add("iyr");
		fields.add("eyr");
		fields.add("hgt");
		fields.add("hcl");
		fields.add("ecl");
		fields.add("pid");
		fields.add("cid");
		
		return fields;
	}
}

