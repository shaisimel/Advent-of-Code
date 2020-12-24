package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Puzzle13 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 13\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      
		      HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] parsed = data.split(" bags contain ");
		        String container = parsed[0];
		        
		        if(!graph.containsKey(container)) {
		        	graph.put(container, new ArrayList<String>());
		        }
		        
		        if(!parsed[1].contains("no other bags")) {
		        	for(String s : parsed[1].split(", ")) {
			        	int start = s.indexOf(" ");
			        	int end = s.indexOf(" bag");
			        	String bagName = s.substring(start+1, end);
			        	if(!graph.containsKey(bagName)) {
			        		graph.put(bagName, new ArrayList<String>());
			        	}
			        	graph.get(bagName).add(container);
			        }
		        }
		        
		      }
		      myReader.close();
		      
		      LinkedList<String> queue = new LinkedList<String>();
		      queue.offer("shiny gold");
		      HashSet<String> visited = new HashSet<String>();
		      while(!queue.isEmpty()) {
		    	  String current = queue.poll();
		    	  if(!visited.contains(current)) {
		    		  visited.add(current);
		    		  for(String link : graph.get(current)) {
		    			  queue.offer(link);
		    		  }
		    	  }
		      }
		      
		      
		      System.out.println(visited.size()-1);
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

