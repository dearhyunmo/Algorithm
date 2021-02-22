package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_3234 {
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String[] s = null;
		int N = 0;
		int[] weight = null;
		boolean[] select = null;
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			select = new boolean[N];
			cnt = 0;
			s = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(s[i]);
			}
			dfs(0, weight, 0, 0, 0, select);
			bw.write("#"+t+" "+cnt+"\n");
		}
		br.close();
		bw.close();
	}
	
	static void dfs(int depth, int[] weight, int nSum, int left, int right, boolean[] select) {
		if(depth == weight.length) {
			cnt++;
			return;
		}
		for(int i=0; i<weight.length; i++) {
			if(select[i]) continue;
			select[i] = true;
			dfs(depth+1, weight, nSum, left+weight[i], right, select);
			nSum = right + weight[i];
			if(nSum <= left) {
				dfs(depth+1, weight, nSum, left, nSum, select);
			}
			select[i] = false;
		}
		
	}
}