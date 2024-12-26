import java.util.Scanner;

public class BOJ10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt(); // 바구니 개수
        int M = sc.nextInt(); // 작업 횟수

        int[] basket = new int[N]; // 바구니 상태 (초기값은 모두 0)
        //인덱스가 n인 배열을 만든다

        // M번 작업 수행
        for (int t = 0; t < M; t++) {
            int i = sc.nextInt(); // 시작 바구니 번호
            int j = sc.nextInt(); // 끝 바구니 번호
            int k = sc.nextInt(); // 공 번호

            // i번 바구니부터 j번 바구니까지 k번 공 넣기
            for (int idx = i - 1; idx < j; idx++) { // i와 j를 1-based에서 0-based로 조정
            	//시작인덱스는 i-1부터 idx가 j보다 작을때까지 basket배열의 idx번째 인덱스에 k값을 저장한다 
            	//i는 처음에 sc.nextInt로 받은 값이다
                basket[idx] = k;
            }
            
            for(int idx = i-1; idx<j; idx++) {
            	basket[idx] = k;
            }
            
            for(int idx = i-1; idx<j; idx++) {
            	basket[idx]=k;
            }
            
            for(int idx= i-1; idx<j; idx++) {
            	basket[idx]=k;
            }
        }

        // 결과 출력
        for (int b : basket) {
            System.out.print(b + " ");
        }

        sc.close();
    }
}
