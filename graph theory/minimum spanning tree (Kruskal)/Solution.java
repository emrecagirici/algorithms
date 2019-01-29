import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/kruskalmstrsub/problem

public class Solution {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		Solution sol = new Solution();
		int vertexCount = scan.nextInt();
		int edgeCount = scan.nextInt();
		Node[] nodeArray = new Node[edgeCount];
		for(int i=0;i<edgeCount; i++){
			nodeArray[i] = sol.new Node(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		int startPoint = scan.nextInt();
		boolean[] nodeUsed = new boolean[vertexCount];
		for(int i=0;i<nodeUsed.length;i++){
			nodeUsed[i] = false;
		}
		Arrays.sort(nodeArray, sol.new CustomComparator());
		int result = 0;
		result += nodeArray[0].weight;
		nodeUsed[nodeArray[0].firstNode-1] = true;
		nodeUsed[nodeArray[0].secondNode-1] = true;
		for(int i=1;i<edgeCount; i++){
			for(int j=1; j<edgeCount;j++){
				if((nodeUsed[nodeArray[j].firstNode-1]&&!nodeUsed[nodeArray[j].secondNode-1])||(!nodeUsed[nodeArray[j].firstNode-1]&&nodeUsed[nodeArray[j].secondNode-1])){
					result += nodeArray[j].weight;
					nodeUsed[nodeArray[j].firstNode-1] = true;
					nodeUsed[nodeArray[j].secondNode-1] = true;
					j = edgeCount;
				}
			}
		}
		System.out.println(result);
	}
	
	
	class Node {
		int firstNode;
		int secondNode;
		int weight;
		public Node(int firstNode, int secondNode, int weight){
			this.firstNode = firstNode;
			this.secondNode = secondNode;
			this.weight = weight;
		}
	}
	
	class CustomComparator implements Comparator<Node>{
		public int compare(Node arg0, Node arg1) {
			if(arg0.weight < arg1.weight){
				return -1;
			}
			else{
				return 1;
			}
		}
	}
}