import java.util.Scanner;

// https://www.hackerrank.com/challenges/task-scheduling/problem

public class Solution {
	public static void main(String[] args){ 
		int listSize;
		Scanner scan = new Scanner(System.in);
		Solution sol = new Solution();
		listSize = scan.nextInt();
		int[] firstElements = new int[listSize];
		int[] secondElements = new int[listSize];
		for (int i = 0; i < listSize; i++) {
			firstElements[i] = scan.nextInt();
			secondElements[i] = scan.nextInt();			
		}
		int maxElement = 0;
		for (int i = 0; i < listSize; i++) {
			if(firstElements[i]>maxElement){
				maxElement = firstElements[i];
			}
		}
		Node[] nodes = new Node[maxElement+1];
		for(int i = maxElement; i > 0; i--){			
			nodes[i] = sol.new Node(i);
		}
		for(int i = maxElement-1; i > 1; i--){			
			nodes[i].before = nodes[i-1];
			nodes[i].after = nodes[i+1];
		}
		nodes[maxElement].before = nodes[maxElement-1];
		nodes[1].after = nodes[2];
		int overShoot = 0;
		int tempLimit;
		int tempValue;
		for (int i = 0; i < listSize; i++) {
			tempLimit = firstElements[i];
			tempValue = secondElements[i];
			Node tempNode = nodes[tempLimit];
			while(tempValue != 0 && tempNode != null){
				if(tempNode.value <= tempLimit){
					if(tempNode.available){
						tempValue = tempValue -1;
						tempNode.available = false;
						if(tempNode.value > 1 && tempNode.value<maxElement){
							tempNode.after.before = tempNode.before;
							tempNode.before.after = tempNode.after;
						}
						else if(tempNode.value==maxElement){
							nodes[maxElement] = nodes[maxElement].before;
							
						}
					}
				}
				tempNode = tempNode.before;
			}
			overShoot += tempValue; 
			System.out.println(overShoot);
		}
	}
	
	
	public class Node {
		int value;
		Node before;
		boolean available;
		Node after;
		public Node(int value) {
			this.value = value;
			this.available = true;
			this.before = null;
			this.after = null;
		}
	}
}