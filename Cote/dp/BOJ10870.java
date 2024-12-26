package Cote.dp;
import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10870 {

	/* 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
	 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
	 * n=17일때 까지 피보나치 수를 써보면 다음과 같다.
	 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
	 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); 
		
		int[] arr= new int[n];
		
		arr[0]=0;
		arr[1]=1;
		
		for (int i = 2; i <= n-1; i++) {
			arr[i] = arr[i-2]+arr[i-1];
			System.out.println(arr[i]);
		} 
		
		System.out.println("결과 : " +arr[n-1]);
//배열은 0부터 시작하는 인덱스를 사용하기 때문에: 유효한 인덱스는 0부터 n-1까지입니다.
		
	}

}
