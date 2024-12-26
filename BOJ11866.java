import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람 수
        int K = sc.nextInt(); // 제거할 간격

        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지 큐에 추가
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 요세푸스 순열 출력
        System.out.print("결과: ");
        while (!queue.isEmpty()) { //큐가 비어있지 않다면 
            // K번째 사람을 제거하기 위해 K-1번 앞의 사람들을 뒤로 보냄
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }

            // K번째 사람 제거 및 출력
            System.out.print(queue.poll());

            // 남아있는 경우 쉼표 추가
            if (!queue.isEmpty()) {
                System.out.print(", ");
            }
        }
    }
}
