package silver1;


import java.util.*;

public class Q_1495 {
	public static int n, s, m;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		s = in.nextInt();
		m = in.nextInt();
		int max = -1;
		int[][] arr = new int[n + 1][m + 1];

		int[] v = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			v[i] = in.nextInt();
		}
		arr[0][s] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (arr[i - 1][j] == 1) {
					if (j + v[i] > m && j - v[i] < 0) {
						continue;
					}
					if (j + v[i] <= m) {
						arr[i][j + v[i]] = 1;
					}

					if (j - v[i] >= 0) {
						arr[i][j - v[i]] = 1;
					}
				}
			}
		}

		int result = -1;
		for (int j = 0; j <= m; j++) {
			if (arr[n][j] == 1) {
				if (result < j) {
					result = j;
				}
			}
		}
		System.out.println(result);
	}
}

