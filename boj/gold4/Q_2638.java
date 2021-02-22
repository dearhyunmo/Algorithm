package gold4;
import java.util.*;
import java.io.*;

public class Q_2638 {
	//TC
	
	//	8 9  >> 모눈종이 크기 
	//	0 0 0 0 0 0 0 0 0 >> 0은 공기, 1은 치즈
	//	0 0 0 1 1 0 0 0 0
	//	0 0 0 1 1 0 1 1 0
	//	0 0 1 1 1 1 1 1 0
	//	0 0 1 1 1 1 1 0 0
	//	0 0 1 1 0 1 1 0 0
	//	0 0 0 0 0 0 0 0 0
	//	0 0 0 0 0 0 0 0 0
	
	//	모눈종이 끝은 치즈 못들어가니까 (0, 0)에서 DFS
	
	//	탐색 하다가 이동할 장소가 치즈면 값을 +1 해준다. (1 -> 2)
	//	└ 치즈가 만약 1면만 공기와 닿아있다면 2가 될 것이고, 2면이 닿아있다면 3, 3면이면 4, 4면이면 5
	
	//	DFS 탐색 도중 공기(0)면 -1로 값을 바꿔주고 이동하여 추가 DFS 진행
	
	//	DFS 끝나면 2중 for문을 이용 
	//	 └ 3 이상의 값을 갖는 곳은 2면 이상이 공기와 접촉된 치즈이기 때문에 녹여주고(0으로)
	//	 └ -1은 원래 공기였으니 0 
	//	 └ 1이나 2를 갖는 치즈는 공기에 노출되지 않았거나, 한 면만 노출된 치즈이므로 다시 1
	
	//	모두 녹을 때 까지 반복해서 1인 횟수를 세서 출력
	
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {1,-1,0,0};
	public static int n, m, map[][]; // 모눈종이 크기, 모눈종이 배열
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); //모눈종이 크기 받기
		
		map = new int[n][m]; //모눈종이 배열 크기 지정
		
		int ans = 0;
		
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;!allDissolved();i++) {
			dfs(0, 0);
//			System.out.println(i);
			ans = i+1;
		}
		
		sb.append(String.valueOf(ans));
		
		System.out.println(sb);
	}
	
	private static boolean allDissolved(){
		int cnt = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(map[i][j]==1 || map[i][j]==2){ // 3이상이면 2면 이상이 공기랑 접촉해서 녹으니까 1이나 2일때
					map[i][j] = 1; // 1로 수정하고
					cnt++; // 남은 치즈 갯수
				}
                else // 그 외는 다 0으로 수정
                	map[i][j] = 0; 
			}
		}
		return cnt == 0;
	}
	
	
	private static void dfs(int x, int y){
		map[x][y] = -1; // 항상 0,0부터 시작하고 가장자리에는 치즈 없음
		int ax, ay;
		for(int i=0;i<4;i++){ // dx dy로 이동 탐색하는거라서 4까지 반복
			ax = x+dx[i];
			ay = y+dy[i];
			if(range(ax, ay)){ // 범위 안이면
				if(map[ax][ay]==0) // 0이면 dfs 다음거 기준으로 계속돌기
					dfs(ax, ay); 
				else if(map[ax][ay]>0) //0보다 크면
					map[ax][ay]++; // 값 증가
			}
		}
	}
	
	private static boolean range(int x, int y){ // 범위
		return (0<=x&&x<n) && (0<=y&&y<m);
	}
}