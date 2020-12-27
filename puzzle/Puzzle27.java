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

public class Puzzle27 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 27\\input.txt";
	
	public static void main(String[] args) {
		
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      
		      long zerosMask = 0l;
		      long onesMask = 0l;
		      HashMap<Long, Long> map = new HashMap<Long, Long>();
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.startsWith("mask")) {
		        	zerosMask = 0l;
		        	onesMask = 0l;
		        	for(char c : data.substring(7).toCharArray()) {
		        		zerosMask <<= 1;
		        		onesMask <<= 1;
		        		if(c=='1') {
		        			onesMask |= 1l;
		        			zerosMask |= 1l;
		        		} else if (c=='X') {
		        			zerosMask |= 1l;
		        		}
		        	}
		        } else {
		        	long address = Long.valueOf(data.substring(data.indexOf("[")+1, data.indexOf("]")));
		        	long value = Long.valueOf(data.substring(data.lastIndexOf(" ")+1));
		        	value &= zerosMask;
		        	value |= onesMask;
		        	map.put(address,value);
		        }
		      }
		      myReader.close();

		      long sum = 0;
		      
		      for(long val : map.values()) {
		    	  sum += val;
		      }
		      System.out.println(sum);
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
}

