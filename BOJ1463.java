import java.util.Scanner;

public class BOJ1463 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();

	        // DP 테이블 초기화
	        int[] dp = new int[N + 1]; // 입력받은 수 크기의 배열을 만든다
	        dp[1] = 0; // 1은 이미 1이므로 연산 횟수 0

	        // DP 점화식 계산
	        for (int i = 2; i <= N; i++) { //2부터 for문을 돌려서 
	            // 기본적으로 i에서 1을 뺀 경우
	            dp[i] = dp[i - 1] + 1; //배열 dp의 1번째 인덱스에 1을 더해 다시 dp배열의 2번째 인덱스에 저장한다 

	            // 2로 나누어 떨어질 때 최소 연산
	            if (i % 2 == 0) {
	                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
	            }

	            // 3으로 나누어 떨어질 때 최소 연산
	            if (i % 3 == 0) {
	                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
	            }
	        }

	        // 결과 출력
	        System.out.println(dp[N]);
	    }
	}
