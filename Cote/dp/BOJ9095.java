package Cote.dp;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ9095 {


	/*
	 *정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
	 */
	
	/*5를 만드는 방법:
		마지막이 1: ways[4]의 모든 경우에 +1
		예: 1 + 1 + 1 + 1 + 1, 1 + 2 + 1 + 1, ...
		마지막이 2: ways[3]의 모든 경우에 +2
		예: 1 + 1 + 1 + 2, 2 + 1 + 2, ...
		마지막이 3: ways[2]의 모든 경우에 +3
		예: 1 + 1 + 3, 2 + 3 
		
		*/
	 public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(br.readLine());
       int[] dp = new int[12];
       dp[1] = 1;
       dp[2] = 2;
       dp[3] = 4;
       StringBuilder sb = new StringBuilder();
       for (int i = 4; i <= 11; i++) {
           dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
       }
       for (int i = 0; i < t; i++) {
           int n = Integer.parseInt(br.readLine());
           sb.append(dp[n] + "\n");
       }
       System.out.print(sb);
   }
}