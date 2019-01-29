import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/sherlock-and-minimax/problem

public class Solution {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		int listSize = scan.nextInt();
		int[] list = new int[listSize];
		for(int i=0; i<listSize; i++)
		{
			list[i] = scan.nextInt();
		}
		int downLimit = scan.nextInt();
		int upLimit = scan.nextInt();
		
		int downDiff = Integer.MAX_VALUE;
		int upDiff = Integer.MAX_VALUE;
		
		Arrays.sort(list);
		int value = 0;
		int diff = Integer.MIN_VALUE;
		int result = downLimit;

		for(int i=0; i<listSize-1; i++)
		{
			if(downDiff> Math.min(Math.abs(downLimit-list[i]),Math.abs(downLimit-list[i+1]))){
				downDiff = Math.min(Math.abs(downLimit-list[i]),Math.abs(downLimit-list[i+1]));
			}
			
			if(upDiff> Math.min(Math.abs(upLimit-list[i]),Math.abs(upLimit-list[i+1]))){
				upDiff= Math.min(Math.abs(upLimit-list[i]),Math.abs(upLimit-list[i+1]));
			}
		}
		
		for(int i=0; i<listSize-1; i++)
		{
			value = (int)((list[i]+list[i+1])/2);
			
			if(diff < (int)((list[i+1]-list[i])/2) && value < upLimit && value>downLimit){
				diff = (int)((list[i+1]-list[i])/2);
				result = value;
			}
		}
		
		if(downDiff>=diff && downDiff>=upDiff){
			result = downLimit;
		}
		else if(upDiff>diff){
			result = upLimit;
		}
		System.out.println(result);
	}
}
