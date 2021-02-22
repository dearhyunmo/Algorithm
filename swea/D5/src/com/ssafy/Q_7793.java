package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7793 {
	static class Info{
		int x,y;
		public Info(int y, int x) {
			this.x=x;
			this.y=y;
		}
	}
	static char arr[][];
	static int check[][];
	static int row,col;
	final static int dx[]= {0,1,0,-1};
	final static int dy[]= {-1,0,1,0};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			
			row =Integer.parseInt(st.nextToken());
			col =Integer.parseInt(st.nextToken());
			
			arr=new char[row][col]; // 맵의 배열
			check=new int[row][col]; // 움직였는지 체크
			Queue<Info> evil = new LinkedList<>(); // 악마 큐
			Queue<Info> su = new LinkedList<>(); // 수연 큐
			
			for(int i=0;i<row;i++) {
				String ss = br.readLine().trim();
				arr[i]=ss.toCharArray();
				for(int j=0;j<ss.length();j++) {
					if(arr[i][j]=='*') 	
						evil.offer(new Info(i,j)); // 악마 값		
					else if(arr[i][j]=='S')		
						su.offer(new Info(i,j)); // 수연 값
				}
			}
			boolean finish=false; // 게임오버 false 등록
			int result=0; // 결과
			Info ii; //info 클래스
			
			while(true) {
				
				//악마 이동
				int len = evil.size();
				for(int i=0;i<len;i++) {
					ii=evil.poll();
					int cx = ii.x;
					int cy = ii.y;
					for(int j=0;j<4;j++) {
						int nx = cx + dx[j];
						int ny = cy + dy[j];
						if(nx>=0 && ny>=0 && nx<col && ny<row && (arr[ny][nx]=='.' || arr[ny][nx]=='S')) {
							arr[ny][nx]='*';
							evil.offer(new Info(ny,nx));
						}
					}
				}
				
				//수연이 이동
				len = su.size();
				for(int i=0;i<len;i++) {
					ii=su.poll();
					int cx = ii.x;
					int cy = ii.y;
					if(arr[cy][cx]=='D') { // 잡힘 ㅠㅠㅠ
						finish=true;
						break;
					}
					for(int j=0;j<4;j++) {
						int nx = cx + dx[j];
						int ny = cy + dy[j];
						if(nx>=0 && ny>=0 && nx<col && ny<row && (arr[ny][nx]=='.' || arr[ny][nx]=='D')) {
							if(arr[ny][nx]!='D')
								arr[ny][nx]='S';
							su.offer(new Info(ny,nx));
						}
					}
				}
				if(finish || su.isEmpty())
					break;				
				result++;
			}
			if(!finish) 
				System.out.println("#"+tc+" "+"GAME OVER");
			else
				System.out.println("#"+tc+" "+result);
		}
	}
}

