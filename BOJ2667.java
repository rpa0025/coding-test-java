import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt(); // 지도 크기
        map = new int[N][N];
        visited = new boolean[N][N];
        
        // 지도 정보 입력받기
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        List<Integer> result = new ArrayList<>(); // 단지별 집의 개수를 저장할 리스트를 만든다
        
        // 모든 좌표 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    // (i, j) 위치가 **집(1)**이고 방문하지 않았으면, 새로운 단지로 간주하고 bfs 호출한다
                    int houseCount = bfs(i, j);
                    result.add(houseCount);
                }
            }
        }
        
        // 결과 출력
        Collections.sort(result); // 단지 크기 오름차순 정렬
        System.out.println(result.size()); // 단지 수 출력
        for (int count : result) {
            System.out.println(count); // 각 단지의 집 개수 출력
        }
    }
   
    
    //bfs를 활용한 메서드를 만든다
    private static int bfs(int x, int y) {
    	
        Queue<int[]> queue = new LinkedList<>();
        //BFS에서는 2차원 배열에서 탐색하므로, (x, y) 좌표를 저장하기 위해 인트 배열을 넣은 큐를 만든다
        //링크드 리스트는 노드 연결만 변경하면 되므로, 리스트의 처음과 끝에서 삽입/삭제가 빠릅니다.
        //일반 리스트는 List는 순서대로 데이터를 저장하지만, 데이터의 삽입/삭제 위치를 개발자가 임의로 지정할 수 있습니다.
        //FIFO 동작을 보장하지 않기 때문에, 큐의 역할로는 적합하지 않습니다.
        
        Queue<int[]> q = new LinkedList<>();
        //bfs에서는 2차원 배열에서 탐색하므로 x,y 좌료플 저장하기 위해 인트 배열을 넣은 큐를 만든다
  
        queue.add(new int[] {x, y});
        //특정 좌표를 저장한 인트 배열을 큐에 넣는다
        visited[x][y] = true;

        int count = 1; // 현재 단지의 집 개수
        
        while (!queue.isEmpty()) {
        	//큐가 비어있지 않다면
            int[] current = queue.poll();
            // 큐에서 가장 먼저 들어온 요소를 꺼낸다
            
            int[] c = q.poll();
            //큐에서 가장 먼저 들어온 인트 배열 요소를 꺼낸다
 
            
            int cx = current[0]; //인트 배열에서 첫번째 요소를 꺼낸다
            int cy = current[1];
            
            // 상하좌우 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d]; //dx는 x축 방향 이동값이고, 상하 이동
                int ny = cy + dy[d]; //y축으로 좌우 방향 이동
                
                // 범위 내에 있고, 집이 있으며, 방문하지 않았다면
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }
        
        return count; // 단지 내 집의 개수 반환
    }
}
