import java.util.Scanner;
public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int repeat = scan.nextInt();
		for(int i=0; i<repeat; i++){
			long result = getSimilarityValues(scan.next());
			System.out.println(result);
		}
	}


	private static long getSimilarityValues(String value){
		int[] result = new int[value.length()];
		int left = 0;
		int right = 0;
		
		for(int i=1; i<result.length; i++){
			if(i>right){
				right = i;
				left = i;
				while(right<result.length&&value.charAt(right-left)==value.charAt(right)){
					right++;
				}
				result[i] = right - left;
				right--;
			}
			else{
				int tempValue = i - left;
				if(result[tempValue]<right - i + 1){
					result[i] = result[tempValue];
				}
				else
				{
					left = i;
					while(right<result.length&&value.charAt(right-left)==value.charAt(right)){
						right++;
					}
					result[i] = right - left;
					right--;
				}
			}
		}
		
		long sum = value.length();
		for(int i=0; i<result.length; i++){
			sum += result[i];
		}
		return sum;
	}
	
}