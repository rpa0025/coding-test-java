package Cote.dp;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11726 {

	/*
	 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
	 */
	
	 public static int ways(int n) {
	        if (n <= 0) return 0; //조건문을 실행할 코드가 단일 명령어일 경우 중괄호를 생략할수 있다
	        if (n == 1) return 1;
	        if (n == 2) return 2;

	        int[] dp = new int[n + 1]; // dp[i]는 2×i 직사각형을 채우는 방법의 수
	        dp[1] = 1;
	        dp[2] = 2;

	        for (int i = 3; i <= n; i++) {
	            dp[i] = dp[i - 1] + dp[i - 2];
	        }

	        return dp[n];
	    }
	public static void main(String[] args){
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println("2×" + n + " 직사각형을 채우는 방법의 수: " + ways(n));
	
		/*
		 * 점화식은 문제를 작은 문제로 분해하는 동적 프로그래밍(DP)의 핵심 원칙에 기반한다:

			작은 문제로 분해가 가능하다.
			작은 문제의 해답을 조합하여 큰 문제를 해결할 수 있다.
			동일한 부분 문제가 반복된다.
			이 문제는 타일을 배치하는 두 가지 주요 경우(세로 배치, 가로 배치)를 기준으로 자연스럽게 분할되고, 각 경우는 독립적으로 계산 가능하다.
		*/
	
	}
}