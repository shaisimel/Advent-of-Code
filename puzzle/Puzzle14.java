package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Puzzle14 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 13\\input.txt";
	static HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String,Integer>>();
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] parsed = data.split(" bags contain ");
		        String container = parsed[0];
		        
		        if(!graph.containsKey(container)) {
		        	graph.put(container, new HashMap<String, Integer>());
		        }
		        
		        if(!parsed[1].contains("no other bags")) {
		        	for(String s : parsed[1].split(", ")) {
			        	int start = s.indexOf(" ");
			        	int end = s.indexOf(" bag");
			        	String bagName = s.substring(start+1, end);
			        	if(!graph.containsKey(bagName)) {
			        		graph.put(bagName, new HashMap<String, Integer>());
			        	}
			        	int amount = Integer.valueOf(s.substring(0,start));
			        	graph.get(container).put(bagName, amount);
			        }
		        }
		        
		      }
		      myReader.close();
		      
		      
		      System.out.println(getBagsNeeded("shiny gold")-1);
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	private static int getBagsNeeded(String bagName) {
		int result = 1;
		
		for(String link : graph.get(bagName).keySet()) {
			result += graph.get(bagName).get(link) * getBagsNeeded(link);
		}
		
		return result;
	}
}

