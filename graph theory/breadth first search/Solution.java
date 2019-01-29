import java.util.ArrayList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/bfsshortreach/problem

public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Solution sol = new Solution();
		int totalRepeat = scan.nextInt();
		for(int i=0; i<totalRepeat; i++){
			int vertexCount = scan.nextInt();
			int edgeCount = scan.nextInt();
			Node[] nodes = new Node[vertexCount];
			for(int j=0; j<vertexCount; j++){
				nodes[j] = sol.new Node();
			}
			for(int j=0; j<edgeCount; j++){
				int firstValue = scan.nextInt()-1;
				int secondValue = scan.nextInt()-1;
				nodes[firstValue].nextNodes.add(nodes[secondValue]);
				nodes[secondValue].nextNodes.add(nodes[firstValue]);
			}
			int sourceNodeIndex = scan.nextInt() - 1;
			nodes[sourceNodeIndex].type = 1;
			nodes[sourceNodeIndex].distance = 0;
			nodes[sourceNodeIndex].predecessor = null;
			Queue queue = sol.new Queue();
			queue.enqueue(nodes[sourceNodeIndex]);
			while(queue.front!=null){
				Node item = queue.dequeue();
				for(int j=0; j<item.nextNodes.size();j++){
					if(item.nextNodes.get(j).type==0){
						item.nextNodes.get(j).type = 1;
						item.nextNodes.get(j).distance = item.distance+1;
						item.nextNodes.get(j).predecessor = item;
						queue.enqueue(item.nextNodes.get(j));
					}
				}
				item.type = 2;
			}
			
			for(int j=0; j<vertexCount; j++){
				if(j!=sourceNodeIndex){
					if(nodes[j].distance==Integer.MAX_VALUE){
						System.out.print(-1 + " ");
					}
					else{
						System.out.print((nodes[j].distance*6) + " ");
					}
				}
			}
			System.out.println();
		}
		
		
	}
	
	class Node{
		int type;
		int distance;
		Node predecessor;
		ArrayList<Node> nextNodes = new ArrayList<Solution.Node>();
		Node next;
		public Node(){
			this.type = 0;
			this.distance = Integer.MAX_VALUE;
			this.predecessor = null;
		}
	}
	
	class Queue{
		Node front, back;
		void enqueue(Node item){
			if(front==null){
				back = item;
				front = back;
			}
			else{
				back.next = item;
				back = back.next;
			}
		}
		
		Node dequeue(){
			if(front!=null){
				Node item = front;
				front = front.next;
                if(front==null){
					back=null;
				}
				return item;
			}
			else{
				return null;
			}
		}
	}
}
