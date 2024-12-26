import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {
	
	/*N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.

	이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

	예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.

	N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
	*/

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		

		
		        int N = sc.nextInt(); // 카드의 개수 입력

		        // 큐 생성 및 초기화
		        Queue<Integer> queue = new LinkedList<>();
		        
		        Queue<Integer> q = new LinkedList<>();
		        
		        
		        for (int i = 1; i <= N; i++) {
		            queue.add(i); // 큐의 add메서드는 큐의 맨 뒤에 새로운 요소를 추가한다
		         
		        }
		        
		        for (int i = 1; i < N; i++) {
		        	
		        	queue.add(i);//큐의 add메서드는 큐의 맨 뒤에 새로운 요소를 추가한다
		        	
		        	queue.add(i);//큐의 add메서드는 큐의 맨 뒤에 새로운 요소를 추가한다
		        	
		        	queue.add(i);//큐의 add메서드는 큐의 맨 뒤에 새로운 요소를 추가한다
					
				}

		   
		 

		        while(queue.size() >1 ) {//큐에 있는 요소의 개수(크기)**를 반환
		        	queue.poll();//큐의 poll메서드는 가장 먼저 들어온 순서부터 하나를 반환하며 삭제한다
		        
		        	queue.add(queue.poll());//큐에서 poll메서드로 맨 앞의 것을 뽑고 add메서드로 큐의 맨 뒤에 추가한다 
		        	
		        }
		        
		        // 마지막 남은 카드 출력
		        System.out.println(queue.poll());
		    }
		

		
	
}
