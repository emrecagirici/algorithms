import java.util.Scanner;

// https://www.hackerrank.com/challenges/missing-numbers/problem

public class Solution {
	public static void main(String[] args){ 
		int firstListSize;
		int secondListSize;
		int min = Integer.MAX_VALUE;
		Scanner scan = new Scanner(System.in);
		firstListSize = scan.nextInt();
		int[] firstElements = new int[firstListSize];
		for (int i = 0; i < firstListSize; i++) {
			firstElements[i] = scan.nextInt();
			if(min>firstElements[i]){
				min = firstElements[i];
			}
		}
		secondListSize = scan.nextInt();
		int[] secondElements = new int[secondListSize];
		for (int i = 0; i < secondListSize; i++) {
			secondElements[i] = scan.nextInt();
			if(min>secondElements[i]){
				min = secondElements[i];
			}
		}
		
		int[] list = new int[101];
		for (int i = 0; i < list.length; i++) {
			list[i] = 0;
		}
		for (int i = 0; i < firstElements.length; i++) {
			list[firstElements[i]-min]++;
		}
		for (int i = 0; i < secondElements.length; i++) {
			list[secondElements[i]-min]--;
		}
		
		String s = "";
		for (int i = 0; i < list.length; i++) {
			if(list[i]!=0){
				s = s + (i+min) + " ";
			}
		}
		System.out.print(s.substring(0,s.length()-1));
	}
	

}