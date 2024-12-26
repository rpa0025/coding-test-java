import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader: 사용자 입력(키보드 입력)을 읽어오는 도구입니다.
		//InputStreamReader: 입력 데이터를 읽을 때, 컴퓨터가 이해할 수 있는 형식으로 변환해주는 역할을 합니다.
		
		int N= Integer.parseInt(br.readLine());
		long A[]= new long[N];
		
		for (int i = 0; i < N; i++) {
			A[i]= Long.parseLong(br.readLine());
		}
		Arrays.sort(A);
		//Arrays.sort(A)는 A 배열의 모든 요소를 오름차순으로 정렬합니다.
		
		int MaxC=1; //최빈값을 구하려는 변수
		int TempC=1; //빈도수를 임시로 저장하는 변수
		long MaxV=A[0];
		for (int i = 1; i < N; i++) { // i=1부터 시작
		    if (A[i] == A[i - 1]) { // 이전 값과 비교
		        TempC++;
		    } else {
		        TempC = 1;
		    }

			
			if(MaxC < TempC) { //초기에 저장했떤 MaxC가 tempC보다 작다면
				MaxC= TempC;
			MaxV=A[i];//Maxv변수에 a[i]번째 값을 저장한다
			
			
		}
	}
	System.out.println(MaxV);
	}
}


