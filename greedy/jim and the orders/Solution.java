import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/jim-and-the-orders/problem

public class Solution {
	public static void main(String[] args){ 
		int totalSize;
		Scanner scan = new Scanner(System.in);
		Solution sol = new Solution();
		totalSize = scan.nextInt();
		Node[] nodeList = new Node[totalSize];
		for(int i = 0; i<totalSize; i++)
		{
			int value = scan.nextInt() + scan.nextInt();
			
			
			nodeList[i] = sol.new Node(value, i);
		}
		Arrays.sort(nodeList, sol.new CustomComparator());
		for(int i=0; i<totalSize;i++){
			if(i<totalSize-1){
				System.out.print(nodeList[i].index +1 + " ");
			}
			else
			{
				System.out.print(nodeList[i].index + 1);
			}
		}

	}
	
	class Node {
		int value;
		int index;
		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	class CustomComparator implements Comparator<Node>{
		@Override
		public int compare(Node arg0, Node arg1) {
			int dif =  arg0.value - arg1.value;
			if(dif == 0){
				dif = arg0.index - arg1.index;
			}
			return dif;
		}
	}
}