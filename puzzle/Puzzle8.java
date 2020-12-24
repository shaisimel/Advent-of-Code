package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle8 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 7\\input.txt";
	public static HashSet<String> eyeColors = new HashSet<String>();
	
	public static void main(String[] args) {
		
		eyeColors.add("amb");
		eyeColors.add("blu");
		eyeColors.add("brn");
		eyeColors.add("gry");
		eyeColors.add("grn");
		eyeColors.add("hzl");
		eyeColors.add("oth");
		
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
		        		if(isValid(kv[0], kv[1])) {
		        			currSet.remove(kv[0]);
		        		} else {
		        			System.out.println(p + " is invalid");
		        		}
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
	
	private static boolean isValid(String k, String v) {
		/*
		 * byr (Birth Year) - four digits; at least 1920 and at most 2002.
			iyr (Issue Year) - four digits; at least 2010 and at most 2020.
			eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
			hgt (Height) - a number followed by either cm or in:
			If cm, the number must be at least 150 and at most 193.
			If in, the number must be at least 59 and at most 76.
			hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
			ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
			pid (Passport ID) - a nine-digit number, including leading zeroes.
			cid (Country ID) - ignored, missing or not.
		 */
		Integer val = null;
		
		switch(k) 
        { 
            case "byr": 
                val = Integer.valueOf(v);
                return val>= 1920 && val <=2002;                
            case "iyr": 
            	val = Integer.valueOf(v);
                return val>= 2010 && val <=2020;   
            case "eyr": 
            	val = Integer.valueOf(v);
                return val>= 2020 && val <=2030;   
            case "hgt": 
                int l = v.length();
                String type = v.substring(l-2);
                if(type.equals("cm") || type.equals("in")) {
	                int h = Integer.valueOf(v.substring(0, l-2));
	                if(type.equals("cm")) {
	                	return h>=150 && h<=193;
	                }
	                return h>=59 && h<=76;
                }
                return false;
            case "hcl": 
                if(v.charAt(0)=='#') {
                	int chars=6;
                	
                	for(int i=1; i<v.length(); i++) {
                		char c = v.charAt(i);
                		if((c>='0' && c<='9') || (c>='a' && c<='f')) {
                			chars--;
                		}
                	}
                	
                	return chars==0;
                }
                
                return false;
            case "ecl": 
                return eyeColors.contains(v);
            case "pid": 
            	int n = 0;
                for(char c : v.toCharArray()) {
                	if(c>='0' && c<='9') {
                		n++;
                	}
                }
                return n==9; 
            case "cid": 
                return true;
        } 
		
		return false;
	}
}

