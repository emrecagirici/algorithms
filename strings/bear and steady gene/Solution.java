import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		int asciiCharValue = 97;
		int wordLength = scan.nextInt();
		String word = scan.next();
		int[] res = new int[4];
		for(int i=0; i<res.length;i++){
			res[i] = 0;
		}
		
		for(int i=0; i<word.length();i++){
			if(word.charAt(i)=='A'){
				res[0]++;
			}
			else if(word.charAt(i)=='T')
			{
				res[1]++;
			}
			else if(word.charAt(i)=='G')
			{
				res[2]++;
			}
			else if(word.charAt(i)=='C'){
				res[3]++;
			}
		}
		
		for(int i=0; i<res.length;i++){
			res[i] = Math.max(0, res[i]-word.length()/4);
			if(res[i]==0){
				res[i] = -1*(word.length());
			}
		}
		
		int result = 0;
		for(int i=0; i<res.length;i++){
			if(res[i]>0){
				result = Integer.MAX_VALUE;
			}
		}
		
		int start = 0;
		int end = 0;
		
		boolean check = false;
		while(end<word.length()&&result!=0){
			if(checkCondition(res)){
				while(checkStartValue(res, word.charAt(start))){
					if(word.charAt(start)=='A'){
						res[0]++;
					}
					else if(word.charAt(start)=='T'){
						res[1]++;
					}
					else if(word.charAt(start)=='G'){
						res[2]++;
					}
					else if(word.charAt(start)=='C'){
						res[3]++;
					}
					start++;
					if(result>end-start){
						result = end-start;
					}
				}
			}
			
			if(word.charAt(end)=='A'){
				res[0]--;
			}
			else if(word.charAt(end)=='T'){
				res[1]--;
			}
			else if(word.charAt(end)=='G'){
				res[2]--;
			}
			else if(word.charAt(end)=='C'){
				res[3]--;
			}
			end++;
		}
		
		while(checkStartValue(res, word.charAt(start))&&result!=0){
			if(word.charAt(start)=='A'){
				res[0]++;
			}
			else if(word.charAt(start)=='T'){
				res[1]++;
			}
			else if(word.charAt(start)=='G'){
				res[2]++;
			}
			else if(word.charAt(start)=='C'){
				res[3]++;
			}
			start++;
			if(result>end-start){
				result = end-start;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean checkStartValue(int[] list, char value){
		if(value == 'A'){
			if(list[0]<0){
				return true;
			}
		}
		else if(value == 'T'){
			if(list[1]<0){
				return true;
			}
		}
		else if(value == 'G'){
			if(list[2]<0){
				return true;
			}
		}
		else if(value == 'C'){
			if(list[3]<0){
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean checkCondition(int[] list){
		for(int i=0;i<list.length;i++){
			if(list[i]>0){
				return false;
			}
		}
		
		return true;
	}
}
