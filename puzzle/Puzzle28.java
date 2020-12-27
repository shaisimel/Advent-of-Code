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

public class Puzzle28 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 27\\input.txt";
	public static final int BIT_LENGTH = 36;

	public static void main(String[] args) {
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      long zeroMask = ((long) Math.pow(2, BIT_LENGTH))-2;
		      String currentMask = new String();
		      HashMap<Long, Long> map = new HashMap<Long, Long>();
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.startsWith("mask")) {
		        	currentMask = data.substring(7);
		        } else {
		        	long address = Long.valueOf(data.substring(data.indexOf("[")+1, data.indexOf("]")));
		        	long value = Long.valueOf(data.substring(data.lastIndexOf(" ")+1));
		        	ArrayList<Long> addresses = new ArrayList<Long>();
		        	addresses.add(0l);
		        	for(int i=0; i<BIT_LENGTH; i++) {
		        		ArrayList<Long> nextAddresses = new ArrayList<Long>();
		        		for(long add : addresses) {
		        			add <<= 1;
		        			if(currentMask.charAt(i)=='0') {
		        				add |= (address >> (BIT_LENGTH-1-i)) & 1;
		        				nextAddresses.add(add);
		        			} else if (currentMask.charAt(i)=='1') {
		        				add |= 1;
		        				nextAddresses.add(add);
		        			} else {
		        				nextAddresses.add(add & zeroMask); // Set LSB to 0
		        				nextAddresses.add(add | 1); // Set LSB to 1
		        			}
		        		}
		        		addresses = nextAddresses;
		        	}
		        	
		        	for(long add : addresses) {
		        		map.put(add,value);
		        	}
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

