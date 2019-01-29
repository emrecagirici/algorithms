import java.util.Scanner;

// https://www.hackerrank.com/challenges/lonely-integer/problem

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int repeat = scan.nextInt();
        int result = 0;
        for (int i = 0; i < repeat; i++) {
            result = result ^ scan.nextInt();
        }

        scan.close();
        System.out.println(result);
    }
}