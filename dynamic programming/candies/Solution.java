import java.util.Scanner;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/candies/problem

public class Solution {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] list = new int[size];
		int[] count = new int[size];
		for(int i=0;i<list.length;i++){
			list[i] = scan.nextInt();
			count[i] = 1;
		}
		for(int i=0;i<list.length;i++){
			if(i==0){
				int value = checkMinValue(list, i);
				count[i] = Math.max(value+1, 1);
			}
			else{
				int value = checkMinValue(list, i);
				if(list[i]==list[i-1]){
					count[i] = value+1;
				}
				else if(list[i]<list[i-1]){
					count[i] = value+1;
				}
				else{
					count[i] = Math.max(value+1, count[i-1]+1);
				}
			}
		}
		long sum = 0;
		for(int i=0;i<list.length;i++){
			//System.out.println("i : " + i + " count = " + count[i]);
			sum += count[i];
		}
		System.out.println(sum);
		
		
	}
	static int checkMinValue(int[] list, int value){
		int res = 0;
		for(int i=value; i<list.length-1; i++){
			if(list[i]>list[i+1]){
				res++;
			}
			else{
				i = list.length;
			}
		}
		
		return res;
	}
}