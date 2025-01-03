package Cote.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {

	// 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여
	// (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한
	// 칸으로만 이동할 수 있다.

	// 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
	// 출처 : https://www.acmicpc.net/problem/2178

	static int[][] map; // 미로 정보
	static boolean[][] visited; // 방문 여부
	static int n, m; // 미로 크기
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 이동
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받기
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0'; // 문자 -> 정수 변환
				// sc.next()를 사용하여 여러 줄을 입력받는 방식은, 입력을 행 단위로 처리하기 때문입니다.sc.next()는 공백 또는 줄바꿈을
				// 기준으로 데이터를 입력받는다
				// '0'의 아스키 코드 값은 48이기 때문에 빼준다
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			String line = sc.next(); //next 공백 또는 줄바꿈을 기준으로 데이터를 입력받는다. 
			for (int j = 0; j < m; j++) {

				map[i][j] = line.charAt(j)-'0'; //string클래스의 charAt메서드는 문자열엥서 특정한 인덱스에 위치한 char를 반환한다
				//char는 내부적으로 정수형 int으로 처리되는데 산술연사은 char타입은 int타입으로 변환된다
				//산술연산은 정수 또는 실수 단위로 처리되는데 char는 본지럭으로 숫자(유티코드 값)으로 저장되므로, 산술연산을 수행하려면 정수형으로 변환되어야 한다ㅏ
			}
		}

		// BFS 탐색
		int result = bfs(0, 0);

		// 결과 출력
		System.out.println(result);

		sc.close();
	}

	static int bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		//Queue 인터페이스의 구현체로 LinkedList를 사용하여 int배열만 요소로 받는 큐를 만든다.

		queue.add(new int[] {x,y}); //익명배열을 생성해 int배열에 인수 x와 y를 요소로 넣고 익명배열을  큐에 추가한다 
		
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll(); // 큐의 첫번째 요소를 가져와서 current배열에 대입힌다 

			//큐의 요소를 바로 배열에 넣는 것은 가능하다 
			int curX = current[0]; //x축이될  배열의 첫번째 요소를 curX에 대입한다
		
			int curY = current[1]; //y축이될 배열의 두번째 요소를 curY에 대입한다 
		
			// 도착점에 도달했으면 거리 반환
			if (curX == n - 1 && curY == m - 1) { //curX와 curY과 각각 n과 m과 같으면 반환한다 
				return map[curX][curY];
			}

			for (int i = 0; i < 4; i++) { // 상하좌우 지표를 만든다음
				//dx와 dy는 각각 X와 Y 축에서 이동할 방향을 정의한 배열입니다.
				
					//dx = {-1, 1, 0, 0}; // X축 이동 (상, 하, 좌, 우)
					//dy = {0, 0, -1, 1}; // Y축 이동 (상, 하, 좌, 우)
				int nx = curX + dx[i]; //각각 curX와 curY에   -1,0(위로이동)  1,0(아래로이동)  0,-1(왼쪽으로 이동)   0,1(오른쪽으로 이동)
				//이렇게 네 방향의 좌표로 만든다음 차례로 다음 if문에 대입히낟 
				int ny = curY + dy[i];

				// 유효한 위치인지, 방문했는지, 이동 가능한지 확인
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) { //만약 nx값이 0보다 작으면 if문을 벗어난다  //이중배열을 벗어나지 않았는지 확인한다 
					if (!visited[nx][ny] && map[nx][ny] == 1) { //방문했던 곳인지, 이동할수 있는 곳인지 확인한다 
						//이중배열의 좌표가 아직 방문하지 않은 곳이고 해당하는 이중배열 map의 값이 1이라면
						visited[nx][ny] = true;
						map[nx][ny] = map[curX][curY] + 1; //기존 거리 값에 1을 추가해서 거리를 업데이트한다
						queue.add(new int[] { nx, ny }); //큐에 새로운 좌표를 기점으로 다시 상하좌우를 탐색할 수 있도록 큐에 넣는다. 
					}
				}
				

				
			}
		}

		return -1; // 도달할 수 없는 경우 (문제 조건상 없음)
	}
}
