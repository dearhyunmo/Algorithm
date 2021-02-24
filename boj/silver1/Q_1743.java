package Q_1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1743 {
	static int x, y;
	static int[][] map, visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken()); // 세로 길이
		y = Integer.parseInt(st.nextToken()); // 가로 길이
		int forCnt = Integer.parseInt(st.nextToken()); //음식물 쓰레기 갯수

		int result =0;
		
		map = new int [x+1][y+1]; // 통로 좌표용 배열
		visit = new int [x+1][y+1]; // 통로 방문 확인용 배열
		
		for(int i=0; i<forCnt; i++) { // 음식물 쓰레기 갯수
			st = new StringTokenizer(br.readLine()); // 음식물 입력받기
			int r = Integer.parseInt(st.nextToken()); // y좌표
			int c = Integer.parseInt(st.nextToken()); // x좌표
			map[r][c] = 1; //쓰레기 체크
		}

		for(int i=0;i<=x;i++) { // 좌표 반복 돌려
			for(int j=0;j<=y;j++) { 
				if(map[i][j]==1 && visit[i][j]==0) { // 쓰레기 있는데 방문 안한곳 시작					
					result = Math.max(result, fourDirection(i, j)); // 결과값 대입
				}
			}
		}
		System.out.println(result);
	}
	
	public static int fourDirection(int num1, int num2) {
		if(num1<1 ||num2<1||num1>x||num2>y) // 좌표 벗어났을때
			return 0;
		
		if(visit[num1][num2]==1 ) // 방문 이미 했을 때
			return 0;
		
		if(map[num1][num2] != 1 ) // 쓰레기 없을때
			return 0;
		
		int dx[] = new int[] {-1, 0, 1, 0}; // x검사
		int dy[] = new int[] {0, -1, 0, 1}; // y검사
		
		visit[num1][num2] = 1; // 방문했습니다~
		
		int result=1; //결과 값
		for(int i=0; i<4; i++) { // 4방 검사
			int goNum1 = num1 + dx[i];
			int goNum2 = num2 + dy[i];
//			System.out.println(result);
			result += fourDirection(goNum1, goNum2); // 계속 돌리기
		}
		
		return result;
		
	}
}


/*
 3 : 배열 x
 4 : 배열 y
 5 : 반복문
 3 4 5 
 1 0 0 0
 0 1 1 0
 1 1 0 0
 */