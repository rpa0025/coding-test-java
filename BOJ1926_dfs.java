	import java.util.Scanner;
	
	
public class BOJ1926_dfs {

	    static int[][] paper; // 도화지 배열
	    static boolean[][] visited; // 방문 여부 배열
	    static int n, m; // 도화지 크기
	    static int[] dx = {-1, 1, 0, 0}; // 상하이동을 나타내는 int 배열
	    static int[] dy = {0, 0, -1, 1}; // 좌우 이동을 나태내는 int 배열
	    static int count; // 현재 그림의 넓이

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // 입력받기
	        n = sc.nextInt(); // 도화지 세로 크기
	        m = sc.nextInt(); // 도화지 가로 크기

	        paper = new int[n][m]; //이중배열로 도화지 크기를 만든다
	        visited = new boolean[n][m];//각 위치를 방문여부를 저장할 visited 이중배열을 만든다

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                paper[i][j] = sc.nextInt(); //콘솔로 입력받은 값을 차례로 각 도화지의 위치에 넣는다
	            }
	        }

	        int numberOfPictures = 0; // 그림의 개수
	        int maxArea = 0; // 가장 넓은 그림의 넓이

	        // 도화지 탐색
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (paper[i][j] == 1 && !visited[i][j]) { //최초라면 그림 넓이는 초기화한다
	                    count = 0; // 현재 그림의 넓이 초기화
	                    dfs(i, j); // 그림 탐색
	                    numberOfPictures++; // 그림 개수 증가
	                    maxArea = Math.max(maxArea, count); // 최대 넓이 갱신
	                    
	                    //maxArea = Math.max(maxArea, count);는 현재 탐색 중인 그림의 넓이(count)가 기존의 최대 넓이(maxArea)보다 크다면, 최대 넓이를 갱신하기 위해 사용하는 코드입니다.
	                  //도화지의 크기인 n과 m은 도화지의 전체 크기(행 × 열)를 의미

	                }
	            }
	        }

	        // 결과 출력
	        System.out.println(numberOfPictures); // 그림 개수
	        System.out.println(maxArea); // 가장 넓은 그림의 넓이
	    }

	    // DFS 탐색 메서드
	    private static void dfs(int x, int y) {
	        visited[x][y] = true; // 현재 위치 방문 처리
	        count++; // 현재 그림의 넓이 증가

	        // 상하좌우 탐색
	        for (int d = 0; d < 4; d++) {
	        	//int[] dx = {-1, 1, 0, 0}; // 상(-1), 하(+1), 좌(0), 우(0)
	        	//int[] dy = {0, 0, -1, 1}; // 상(0), 하(0), 좌(-1), 우(+1)
	        	
	        	//dx와 dy가 4개의요소로 된 배열이기 때문에 for문의 d <4 이렇게 나오는 것이다  
	        	
	        	
	            int nx = x + dx[d];//dx는 상하를 나타내는 배열
	            //dx[d] 는 현재 위치 x에서 상하 방향으로 이동할 크기를 제공한다
	            //처음 돌때는 dx배열의 0번째 인덱스가 -1이므로 0+-1 -> -1이 된다
	            
	            int ny = y + dy[d];//dy는 좌우를 나타내는 배열
	            //dy[d]는 현재 위치 y에서 좌우 방향으로 이동할 크기를 제공한다 
	            //처음돌때는 dy배열의 0번째 인덱스가 0이므로 그냥 y값이 된다
	            
	            //이런식으로 nx와 ny는 한번 반복에 총 4가지 값을 가지게 되고 그 각각의 값을 가지고 체크 여부를 확인해
	            // 4가지 방향으로 아직 방문하지 않은 좌표이고 도화지의 값이 1이라면 다시 탐색하는 것이다
	            

	            // 유효 범위 체크 및 방문 여부, 값 체크
	            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
	            	//nx < n && ny < m: 좌표가 도화지의 오른쪽 또는 아래쪽 경계 밖으로 나가지 않음.
	            	
	                if (!visited[nx][ny] && paper[nx][ny] == 1) {
	                    dfs(nx, ny); // 연결된 그림 부분 탐색
	                }
	            }
	        }
	    }
	}
