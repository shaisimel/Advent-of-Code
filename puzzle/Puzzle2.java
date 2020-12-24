package puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle2 {

	public static final String inputLocation ="D:\\Advent of Code\\2020\\Puzzle 1\\input.txt";
	
	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		try {
		      File myObj = new File(inputLocation);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        int currentNum = Integer.valueOf(data);
		        nums.add(currentNum);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		HashMap<Integer, ArrayList<Integer>> muls = new HashMap<Integer, ArrayList<Integer>>();
		int l = nums.size();
		for(int i=0; i<l; i++) {
			for(int j=i+1; j<l; j++) {
				ArrayList<Integer> res = new ArrayList<Integer>();
				res.add(nums.get(i));
				res.add(nums.get(j));
				muls.put(nums.get(i) + nums.get(j), res);
			}
		}
		
		for (int n : nums) {
			int target = 2020 - n;
			if(muls.containsKey(target)) {
				System.out.println("num 1 = " + n);
				System.out.println("num 2 = " + muls.get(target).get(0));
				System.out.println("num 3 = " + muls.get(target).get(1));
				int val = n * muls.get(target).get(0) *muls.get(target).get(1); 
				System.out.println("result = " + val);
				break;
			}
		}
		
	}

}
