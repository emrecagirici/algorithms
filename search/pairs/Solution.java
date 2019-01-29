import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/pairs/problem

public class Solution {
	public static void main(String[] args) {
		int result=0;
		Scanner scan = new Scanner(System.in);
		int repeat = scan.nextInt();
		int difference = scan.nextInt();
		int[] number=new int[repeat];
		for (int i = 0; i < repeat; i++) {
			number[i] = scan.nextInt();
		}
		Arrays.sort(number);
		for(int i=0;i<repeat;i++){
			for(int j=i;j<repeat;j++){
				if(number[j]-number[i]>difference){
					j=repeat;
				}
				else{
					if(number[j]-number[i]==difference){
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}
}
