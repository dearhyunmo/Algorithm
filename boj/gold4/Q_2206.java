package gold4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2206 {
	
	static int[] goX = {-1, 1, 0, 0};
	static int[] goY = {0, 0, -1, 1};
	
	static class Point {
		private int x;
		private int y;
		private int wall;
		public Point(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
	}
	
	static int bfs(int N, int M, int[][] map, boolean[][][] visited) {
		Queue<Point> q = new LinkedList<>();
		int[][] distance = new int[N][M]; 
		q.add(new Point(0,0,0));
		distance[0][0] = 1;
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int curX = q.peek().x;
			int curY = q.peek().y;
			int wall = q.peek().wall; 
			q.poll();
			if(curX==N-1 && curY==M-1) 
				return distance[N-1][M-1];
			
			for(int i=0; i<4; i++) {
				int nX = curX + goX[i];
				int nY = curY + goY[i];
				
				if(0<=nX && nX<N && 0<=nY && nY<M) {
					if(map[nX][nY]==0 && !visited[nX][nY][wall]) {
						visited[nX][nY][wall] = true;
						q.add(new Point(nX,nY,wall));
						distance[nX][nY] = distance[curX][curY] + 1;
					}
					else if(map[nX][nY]==1 && wall==0 && !visited[nX][nY][wall+1]) { 
						visited[nX][nY][wall+1] = true;
						q.add(new Point(nX,nY,wall+1));
						distance[nX][nY] = distance[curX][curY] + 1;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0'; 
			}
		}
		
		boolean[][][] visited = new boolean[N][M][2];
		
		System.out.println(bfs(N,M,map,visited));
		
	}
}