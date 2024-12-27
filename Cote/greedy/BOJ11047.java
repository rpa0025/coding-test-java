package Cote.greedy;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11047 {

	/*
	 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
	 * 
	 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
	 * 
	 * 
	 * 동전의 단위 1 5 10 50 100 500 1000 5000 10000 50000
	 * 
	 * 출처 : https://www.acmicpc.net/problem/11047
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		arr[0] = 1;
		
        // 동전의 가치 배열
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // 최소 동전 개수 계산
        int count = 0;
        for (int i = n - 1; i >= 0; i--) { // 큰 동전부터 사용
            if (coins[i] <= k) {
                count += k / coins[i]; // 현재 동전으로 만들 수 있는 개수
                k %= coins[i];         // 남은 금액
            }
        }

        // 결과 출력
        System.out.println(count);

        sc.close();
    }
}