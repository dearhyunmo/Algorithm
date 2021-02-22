package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_7699 {
	static int r, c; // row column
    static char[][] arr; // char형 배열
    static int[] visited; // 방문했는지
    
    static int result = 0; // 결과값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과를 append 하여 한번에 출력하기 위해

        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr = new char[r][c];
            visited = new int['Z' + 1]; // 명물을 최대한 많이 보고 싶다고 하여 Z+1 의 사이즈로 배열 지정
            for (int i = 0; i < r; i++) {
                arr[i] = br.readLine().toCharArray(); 
            }
            visited[arr[0][0]]++; 
            result = 1;
            dfs(0, 0, 1); // i,j,max

            sb.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.print(sb);

    }

    private static void dfs(int i, int j, int max) {
        if (max > result)
            result = max;
        if (result == 26)
            return;

        if (0 <= i - 1 && visited[arr[i - 1][j]] == 0) {
            visited[arr[i - 1][j]]++;
            dfs(i - 1, j, max + 1);
            visited[arr[i - 1][j]]--;
        }
        if (i + 1 < r && visited[arr[i + 1][j]] == 0) { 
            visited[arr[i + 1][j]]++;
            dfs(i + 1, j, max + 1);
            visited[arr[i + 1][j]]--;
        }
        if (0 <= j - 1 && visited[arr[i][j - 1]] == 0) {
            visited[arr[i][j - 1]]++;
            dfs(i, j - 1, max + 1);
            visited[arr[i][j - 1]]--;
        }
        if (j + 1 < c && visited[arr[i][j + 1]] == 0) { 
            visited[arr[i][j + 1]]++;
            dfs(i, j + 1, max + 1);
            visited[arr[i][j + 1]]--;
        }
    }
}