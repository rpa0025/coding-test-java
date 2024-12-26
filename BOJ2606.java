import java.util.*;

public class BOJ2606 {
    static boolean[] visited; // 방문 여부를 저장하는 배열
     // 그래프를 인접 리스트로 표현
    static List<Integer>[] graph;
    static int count = 0; // 바이러스에 걸린 컴퓨터 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 컴퓨터의 수
        int m = sc.nextInt(); // 네트워크 연결 수

        // 그래프 초기화
   graph = new ArrayList[n + 1];
        //정수를 담는 리스트(List<Integer>)를 저장하는 배열을 선언하고 길이가 n+1인 arrayList를 대입한다
        //List**는 인터페이스이고, **ArrayList**는 그 기능을 실제로 구현한 클래스이기 때문에 대입할 수 있다
   //다형성(Polymorphism)**을 활용하여, ArrayList 객체를 List 변수에 저장할 수 있습니다.
        
        List<Integer>[] g2 = new ArrayList[n+1];
        //인티저 타입을 담는 리스트를 저장하는 배열을 언언하고 길이가 n+1인 arrayList를 대입한다
        //List는 인터페이스이고, arrayList는 그 기능을 구현한 클래스이기 때문에 대입이 가능하다
        
        List<Integer>[] g3 = new ArrayList[n+1];
        
        List<Integer>[] g4 = new ArrayList[n+1];
        //배열을 담는 리스트 선언한다면  List<int[]> list = new ArrayList<>(); 이렇게 된다 
        
        //배열은 고정되 있는 반변 ArrayList를 길이가 동적으로 변할수 있다는 차이가 있고 배열은 기본타입과 객체 모두 사용가능하지만
        //ArrayList는 객체타입만 가능하다
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();  //각각의 arrayList를 정수를 담는 리스트를 요소로 하는 배열에 담는다

        }

        // 네트워크 연결 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            //sc.nextInt()**는 입력 버퍼에서 **공백( )이나 개행(\n)**을 기준으로 숫자를 읽어옵니다.
            
            //한 줄 단위로 처리하고 싶다면 **sc.nextLine()**을 사용

            
            int b = sc.nextInt();
            graph[a].add(b);//배열의 a인덱스의 arrayList에 b를 추가한다
            
            graph[b].add(a); //배열의 b인덱스의 arrayList에 a를 추가한다 
        }

        // 방문 배열 초기화
        visited = new boolean[n + 1];

        // DFS 탐색 시작 (1번 컴퓨터부터 시작)
        dfs(1);

        // 결과 출력 (1번 컴퓨터 제외)
        System.out.println(count - 1);
    }

    public static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문
        count++; // 바이러스에 감염된 컴퓨터 수 증가

        // 연결된 노드 탐색
        for (int i = 0; i < graph[node].size(); i++) {
            int next = graph[node].get(i); //배열에서 node인덱스은 arrayList를 반환한다 
            //배열에서 node번째 인덱스의 arrayList에서 i번째 요소를 가져온다 
            if (!visited[next]) {
                dfs(next); // 방문하지 않은 노드만 재귀 호출
            }
        }
      
    }
    }

