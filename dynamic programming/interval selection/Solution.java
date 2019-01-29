import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/interval-selection/problem

public class Solution {
	static Interval[] intArray;
	static int result;
	static int length;
	public static void main(String[] args) {
		Interval[] intArray;
		int result=0;
		Solution sol = new Solution();
		Scanner scan = new Scanner(System.in);
		int repeat = scan.nextInt();
		for (int i = 0; i < repeat; i++) {
			length = scan.nextInt();
			intArray = new Interval[length];
			for (int j = 0; j < length; j++) {
				intArray[j] = sol.new Interval(scan.nextInt(), scan.nextInt());
			}
			Arrays.sort(intArray, sol.new CustomComparator());
			ArrayList<Interval> list = new ArrayList<Solution.Interval>();
			for(int j = 0; j<length;j++){
				ArrayList<Interval> temp = new ArrayList<Solution.Interval>();
				if(test(list,temp,intArray[j])==true){
					list.add(intArray[j]);
					result++;
				}
			}
			System.out.println(result);
			result=0;
		}	
	}

	public static boolean test(ArrayList<Interval> list,ArrayList<Interval> temp, Interval element){
		Solution s = new Solution();
		int number = list.size();
		for(int i=0;i<number;i++){
			if(collision(element,list.get(i))){
				int number2= temp.size();
				for(int j=0;j<number2;j++){
					if(collision(temp.get(j),list.get(i))){
						return false;
					}
				}
//				Interval intNew= new Interval(Math.max(list.get(i).start,element.start),Math.min(list.get(i).end,element.end));
		//		intNew.start=Math.max(list.get(i).start,element.start);
				
				Interval t = s.new Interval(0,0);
				t.start=Math.max(list.get(i).start,element.start);
				t.end=Math.min(list.get(i).end,element.end);
				temp.add(t);
			}			
			// collision method u ekle varsa eger temp arraylist ine ekle
			
		}
/*		for(int i=0;i<temp.size();i++){
			System.out.println(temp.get(i).start + " " + temp.get(i).end );
		}*/
		return true;
	}
	public static boolean collision(Interval temp1, Interval temp2){
		if((temp1.start>temp2.end)||(temp2.start>temp1.end)){
			return false;
		}
		return true;
	}
	class Interval {
		int start;
		int end;
//		int size;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
//			this.size=end-start;
		}
	}
	public static int intlength(Interval temp){
		return temp.end-temp.start;
	}
	class CustomComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval arg0, Interval arg1) {
			int dif =  arg0.end - arg1.end;
			if(dif == 0) {
				dif = arg0.start - arg1.start;
			}
			return dif;
		}
	}
}
