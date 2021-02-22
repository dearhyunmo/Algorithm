package gold4;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_17135 {
	
static int N, M, D, max = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		D = Integer.parseInt(str[2]);
		
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; ++i) {
			str = br.readLine().split(" ");
			for(int j=0; j<M; ++j) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i=0; i<M-2; ++i) {
			for(int j=i+1; j<M-1; ++j) {
				for(int k=j+1; k<M; ++k) {
					
					int[][] tempMap = copyMap(map);
					
					for(int row=N-1; row>=0; --row) {
						play(tempMap, row, i);
						play(tempMap, row, j);
						play(tempMap, row, k);
					}
					
					setMax(tempMap);
					
				}
			}
		}
		System.out.println(max);
		
	}
	
	public static void play(int[][] map, int r, int c) {
		
		for(int d=0; d<D; ++d) {
			int cr = r;
			for(int cc=c-d; cc<=c+d; ++cc) {
				if(cr<0||cc<0||cr>=N||cc>=M) {
					cr = (cc>=c)? cr+1 : cr-1; 
					continue;
				}
				if(map[cr][cc]==(-1-r))
					return;
				if(map[cr][cc]==1) {
					map[cr][cc] = (-1-r);
					return;
				}
				cr = (cc>=c)? cr+1 : cr-1; 	
			}	
		}
	}
	
	public static void setMax(int[][] map) {
		
		int cnt = 0;
		
		for(int i=0; i<N; ++i) {
			for(int j=0; j<M; ++j) {

				if(map[i][j]<0)
					cnt++;
				
			}
		}

		if(cnt>max) {
			max = cnt;
		}
		
	}
	
	public static int[][] copyMap(int[][] map){
		
		int[][] copy = new int[N][M];
		
		for(int i=0; i<N; ++i) {
			for(int j=0; j<M; ++j) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;	
	}
}