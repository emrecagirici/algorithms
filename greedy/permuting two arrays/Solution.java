import java.util.Scanner;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/two-arrays/problem

public class Solution {
	public static void main(String[] args){ 
		int repeat;
		Scanner scan = new Scanner(System.in);
		repeat = scan.nextInt();
		for(int i=0; i<repeat; i++)
		{
			int listSize = scan.nextInt();
			int number = scan.nextInt();
			int[] list1 = new int[listSize];
			int[] list2 = new int[listSize];
			for(int j =0; j<listSize;j++){
				list1[j] = scan.nextInt();
			}
			for(int j =0; j<listSize;j++){
				list2[j] = scan.nextInt();
			}
			Arrays.sort(list1);
			Arrays.sort(list2);
			boolean check = true;
			int value = 0;
			for(int j =0; j<listSize;j++){
				value = list1[j] + list2[listSize-1-j];
				if(value<number){
					check = false;
				}
			}
			if(check){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
			
		}
	}
}