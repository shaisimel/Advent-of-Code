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

public class Puzzle29 {

	public static final int TURN_LIMIT = 2020;

	public static void main(String[] args) {
		
		int[] input = new int [] {12,20,0,6,1,17,7};
		int turn = 0;
		int prevNumber = 0;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : input) {
			turn++;
			map.put(i, turn);
			prevNumber = i;
		}
		map.remove(prevNumber);
		
		while(turn<TURN_LIMIT) {
			turn++;
			int nextNum = 0;
			if(map.containsKey(prevNumber)) {
				nextNum = turn - 1 - map.get(prevNumber);
			}
			map.put(prevNumber, turn-1);
			prevNumber = nextNum;
		}
		
		System.out.println(prevNumber);
	}
	
	
}

