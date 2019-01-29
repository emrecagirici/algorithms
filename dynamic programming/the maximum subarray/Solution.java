import java.util.Scanner;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/maxsubarray/problem

public class Solution {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		int repeat = scan.nextInt();
		for(int i=0; i<repeat; i++){
			int size = scan.nextInt();
			int[] list = new int[size];
			long cont = 0;
			long contTemp = 0;
			long notCont = 0;
			for(int j = 0; j <size; j++){
				list[j] = scan.nextInt();
				if(list[j]>0){
					notCont += list[j];
				}
				
				if(contTemp>=0){
					contTemp += list[j];
					if(cont<contTemp){
						cont = contTemp;
					}
				}
				else{
					contTemp = 0;
				}
				
				if(contTemp<0){
					contTemp = 0;
				}
			}
			int tempMaxElement = Integer.MIN_VALUE;
			for(int j = 0; j <size; j++){
				if(tempMaxElement<list[j]){
					tempMaxElement = list[j];
				}
			}
			if(tempMaxElement<0){
				cont = tempMaxElement;
				notCont = tempMaxElement;
			}
			
			System.out.println(cont + " " + notCont);
		}
	}
}