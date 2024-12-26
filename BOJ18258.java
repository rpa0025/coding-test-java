import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ18258 {
	
	Queue<Integer> queue= new LinkedList<>();
	
	public void pushX(Queue<Integer> queue, int n) {
			
	            queue.add(n);
	}
	
	public void pop(Queue<Integer> queue, int n) {
		
		if (queue.isEmpty()) {
			System.out.println("-1");	
		}else {
			System.out.println(queue.poll());
		}
      
}//end pop
	
	public void size(Queue<Integer> queue) {
		
		System.out.println(queue.size());
}
	
	public void empty(Queue<Integer> queue) {
		
		if (queue.isEmpty()) {
			System.out.println("1");	
		}else {
			System.out.println("0");
		}
}
	
	public void front(Queue<Integer> queue, int n) {
		
		if (queue.isEmpty()) {
			System.out.println("-1");	
		}else {
			System.out.println(queue.poll());
		}
      
}

	public void back(Queue<Integer> queue) {
		
		if (queue.isEmpty()) {
			System.out.println("-1");	
		}else {
			for (int i = 0; i < queue.size(); i++) {
				
				if (i == queue.size()-2) {
					System.out.println(queue.peek());
				}else {
					queue.poll();
				}
				
			}
		}
      
}
	
	
	
	
	public static void main(String[] args) {		

//		정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//		push X: 정수 X를 큐에 넣는 연산이다.
//		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		size: 큐에 들어있는 정수의 개수를 출력한다.
//		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		
//		public int add(int a, int b) {
//	    return a + b;
//	}
		
		 Scanner sc = new Scanner(System.in);
		 
	
		         Queue<Integer> queue = new LinkedList<>();
		         int lastElement = -1; // 큐의 마지막 요소를 추적하기 위한 변수

		         int n = sc.nextInt(); // 명령어의 개수
		         sc.nextLine(); // 버퍼 비우기

		         for (int i = 0; i < n; i++) {
		             String command = sc.nextLine();

		             if (command.startsWith("push")) {
		                 int x = Integer.parseInt(command.split(" ")[1]);
		                 queue.add(x);
		                 lastElement = x; // 마지막 요소 갱신
		             } else if (command.equals("pop")) {
		                 if (queue.isEmpty()) {
		                     System.out.println(-1);
		                 } else {
		                     System.out.println(queue.poll());
		                 }
		             } else if (command.equals("size")) {
		                 System.out.println(queue.size());
		             } else if (command.equals("empty")) {
		                 System.out.println(queue.isEmpty() ? 1 : 0);
		             } else if (command.equals("front")) {
		                 if (queue.isEmpty()) {
		                     System.out.println(-1);
		                 } else {
		                     System.out.println(queue.peek());
		                 }
		             } else if (command.equals("back")) {
		                 if (queue.isEmpty()) {
		                     System.out.println(-1);
		                 } else {
		                     System.out.println(lastElement);
		                 }
		             }
		         }
		     }
		 }

