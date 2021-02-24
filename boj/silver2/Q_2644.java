package Q_2644;

import java.io.*;
import java.util.*;

public class Q_2644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 전체 사람의 수
		
		st = new StringTokenizer(br.readLine()); // 다음 줄 읽기
		int person1 = Integer.parseInt(st.nextToken()); // 촌수 계산해야하는 첫사람
		int person2 = Integer.parseInt(st.nextToken()); //촌수 계산해야하는 뒷사람
		
		st = new StringTokenizer(br.readLine()); //다음 줄 읽기
		int forCnt = Integer.parseInt(st.nextToken()); // 반복문 돌릴겨
		
		int[][] map = new int[n+1][n+1];
		int[] visit = new int[n+1];
		int result = -1;
		
		for(int i=0;i<forCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // x
			int y = Integer.parseInt(st.nextToken()); // y
			map[x][y] = 1; // 서로 엮여있다는 것을 체크
			map[y][x] = 1; // 서로 엮여있다는 것을 체크 (역순으로 해도 가능하도록 값 대입)
			//map[x][y] = 1만 해주게 되면 2번째 줄의 촌 수 계산해야 하는 서로 다른 두 사람의 번호가 역순이 되면 안됨
		}
		
		Queue <Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(map[person1][i]==1) { // 최종 일때
				q.add(i); //queue에 i값 추가
				visit[i]=1; //방문 여부 체크
			}
		}
		
		boolean flag = false;
		
		while(!q.isEmpty()) { // 큐가 빌 때 까지 반복
			int x = q.poll(); // 큐 맨 앞 값 가져오기
			
			for(int i=1; i<=n; i++) { // 사람수 만큼 반복
				if(map[x][i] == 1 && visit[i] ==0) { // 큐 맨 앞과 i를 map에 넣고 확인
					q.add(i); //큐에 다음 관계에 대한 i값 대입해주기
					visit[i] = visit[x] +1; //visit[x]+1만에 방문했다고 체크해줌
					if(i==person2) { //i가 person2가 됐을 때
//						System.out.println(i + " : " + person2); // 사람 버전 확인해보기
						result = visit[i]; //결과는 visit[i]
						flag = true; //종료~~
						break;
					}
				}
			}
			if(flag)break; //종료~
		}
		System.out.println(result);
	}
}
