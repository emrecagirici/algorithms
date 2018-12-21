import java.util.Scanner;


public class Solution {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		String word1 = scan.next();
		String word2 = scan.next();
		
		int[][] totalList = new int[word1.length()+1][word2.length()+1];
		for(int i=0; i<totalList.length; i++){
			for(int j=0; j<totalList[i].length; j++){
				totalList[i][j] = 0;
			}
		}
		
		
		for(int i=1; i<totalList.length; i++){
			for(int j=1; j<totalList[i].length; j++){
				if(word1.charAt(i-1)==word2.charAt(j-1)){
					totalList[i][j] = totalList[i-1][j-1] + 1;
				}
				else
				{
					totalList[i][j] = Math.max(totalList[i-1][j], totalList[i][j-1]);
				}
			}
		}
		

		int maxValue = totalList[totalList.length-1][totalList[0].length-1];
		System.out.println(maxValue);
	}	
}
	