package silver1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1074 {
	static int N, r, c, count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		r = Integer.parseInt(str[1]);
		c = Integer.parseInt(str[2]);

		search(0, 0, getSize(N));

	}

	// D&C를 통해서 Z 순서대로 카운트해간다.
	static void search(int x, int y, int size) {
		if (size == 1) {
			if (x == r && y == c)
				System.out.println(count);
			count++;
			return;
		}
		int s = size / 2;
		search(x, y, s);
		search(x, y + s, s);
		search(x + s, y, s);
		search(x + s, y + s, s);
	}

	static int getSize(int n) {
		int result = 1;
		for (int i = 0; i < n; i++)
			result *= 2;
		return result;
	}
}