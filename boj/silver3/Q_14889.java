package silver3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_14889 {
	static int n; 
	static int map[][], check[]; 
	static int min = Integer.MAX_VALUE; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		check = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(-1, 0);
		System.out.println(min);

	}

	static void dfs(int start, int cnt) {

		if (cnt == n / 2) { 
			cal(); 
			return;
		}

		for (int i = start + 1; i < n; i++) {
			if (check[i] == 0) {
				check[i] = 1; 
				dfs(i, cnt + 1); 
				check[i] = 0; 
			}
		}

	}

	static void cal() { 
		int start = 0, link = 0; 
		int a[] = new int[n / 2];
		int b[] = new int[n / 2];
		int a_index = 0, b_index = 0; 

		for (int i = 0; i < n; i++) { 
			if (check[i] == 1) {
				a[a_index++] = i;
			} else {
				b[b_index++] = i; 
			}
		}

		start = divide(a);
		link = divide(b);

		int result = Math.abs(start - link);

		min = Math.min(result, min);

	}

	static int divide(int[] arr) { 
		int result = 0;

		for (int i = 0; i < arr.length; i++) { 
			for (int j = i + 1; j < arr.length; j++) { 
				result = result + map[arr[i]][arr[j]] + map[arr[j]][arr[i]]; 
			}
		}

		return result; 
	}

}
