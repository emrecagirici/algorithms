import java.util.Scanner;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/stockmax/problem

// full counting sort question
public class Solution {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		int repeat = scan.nextInt();
		for(int i=0; i<repeat; i++){
			int size = scan.nextInt();
			int[] list = new int[size];
			for(int j=0; j<list.length; j++){
				list[j] = scan.nextInt(); 
			}
			int tempMax = 0;
			long sum = 0;
			for(int j=list.length-1; j>=0; j--){
				if(tempMax<list[j]){
					tempMax = list[j];
				}
				else{
					sum = sum + tempMax - list[j];
				}
			}
			System.out.println(sum);
		}
	}
}