package com.ssafy;

import java.io.*;
import java.util.*;

public class Q_2382 {
	static class micro{
		int i, j, cnt, dir;
		public micro(int i, int j, int cnt, int dir) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String[] str = null;
		int n = 0;
		int m = 0;
		int k = 0;
		Queue<micro> q = new LinkedList<micro>();
		int[][] maxMap = null;
		int[][] dirMap = null;
		int[][] sumMap = null;
		int qSize = 0;
		int di = 0;
		int dj = 0;
		int cnt = 0;
		int dir = 0;
		int result = 0;
		micro mic = null;
		for(int t=1; t<=T; ++t) {
			q.clear();
			result = 0;
			str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			k = Integer.parseInt(str[2]);
			maxMap = new int[n][n];
			dirMap = new int[n][n];
			sumMap = new int[n][n];
			for(int i=0; i<k; ++i) {
				str = br.readLine().split(" ");
				di = Integer.parseInt(str[0]);
				dj = Integer.parseInt(str[1]);
				cnt = Integer.parseInt(str[2]);
				dir = Integer.parseInt(str[3]);
				q.offer(new micro(di, dj, cnt, dir));
			}
			for(int i=0; i<m; ++i) {
				qSize = q.size();
				for(int j=0; j<qSize; ++j) {
					mic = q.poll();
					// 상 1 , 하 2 , 좌 3, 우 4
					di = mic.i;
					dj = mic.j;
					cnt = mic.cnt;
					dir = mic.dir;
					if(dir == 1) {
						di--;
					}else if(dir == 2) {
						di++;
					}else if(dir == 3) {
						dj--;
					}else {
						dj++;
					}
					if(dj == 0 || dj == n-1 || di == 0 || di == n-1) {
						if(dir == 1 || dir == 3) {
							dir++;
						}else {
							dir--;
						}
						cnt /= 2;
					}
					if(maxMap[di][dj] != 0) {
						if(maxMap[di][dj] < cnt) {
							maxMap[di][dj] = cnt;
							dirMap[di][dj] = dir;
						}
						sumMap[di][dj] += cnt;
					}else {
						maxMap[di][dj] = cnt;
						dirMap[di][dj] = dir;
						sumMap[di][dj] = cnt;
					}
				}
				
				for(int j=0; j<n; ++j) {
					for(int l=0; l<n; ++l) {
						if(maxMap[j][l] > 0) {							
							
							q.offer(new micro(j, l, sumMap[j][l], dirMap[j][l]));
							if(i != m-1) {
								sumMap[j][l] = 0;
								dirMap[j][l] = 0;
								maxMap[j][l] = 0;
							}
						}
					}
				}
			}
			while(!q.isEmpty()) {
				mic = q.poll();
				result += mic.cnt;
			}
			bw.write("#"+t+" "+result+"\n");
		}
		bw.close();
		br.close();
	}
}
