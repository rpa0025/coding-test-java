package Cote.bruteforce;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2231 {

	/*
	 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우,
	 * M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
	 * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
	 * 
	 * 91+9+1=101
	 * 100+1+0+0=101
	 * 
	 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오. 
	 * 출처 :
	 * https://www.acmicpc.net/problem/2231
	 */

	public static void main(String[] args) {
		

		
		 Scanner sc = new Scanner(System.in);
	   
	        int N = sc.nextInt();
	        int result = 0;

	        // 가장 작은 생성자를 찾기 위해 1부터 시작
	        
	        
	        for (int i = 0; i < N; i++) {
	        	int sum =i;
	        	int temp =i;
	        	
	        	while (temp >0) {
	        		sum += temp%10; //temp를 10으로 나누고 나머지를 sum에 저장한다. 0%10의 결과는 나머지만 반환하므로 0이다.
	        		//sum에는 처음의 i값과 i를 temp로 나눈 나머지가 계속 더해지게 된다. 
	        		// 10으로 나누는 이유는 숫자의 마지막 자리수를 구하기 위해서이다. temp가 123일때 10으로 나누면 마지막 자리수는 3이 반환된다.
	        		temp /= 10; // temp를 10으로 나눠 몫을 다시 temp에 저장한다. 
	        	}
	        	
	        	if (sum == N) { //분배합이 n과 같다면 i는 n의 생성자이므로 result에 ㅓ장하고 반복을 빠져나간다.
	        		result = i;
	        		break;
					
				}
				
			}

	        // 결과 출력 (생성자가 없을 경우 0)
	        System.out.println(result);
	        sc.close();
		
		
	}
}