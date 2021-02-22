package silver1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str1[] = br.readLine().split(" ");
		int D = Integer.parseInt(str1[0]);
		int K = Integer.parseInt(str1[1]);
		int array[][] = new int[31][2];
		array[1][0] = 1;
		array[2][1] = 1;
		for (int i = 3; i <= D; i++) {
			for (int j = 0; j < 2; j++)
				array[i][j] = array[i - 2][j] + array[i - 1][j];
		}
		for (int i = 1; i <= K; i++) {
			if ((K - array[D][0] * i) % array[D][1] == 0) {
				sb.append(i + "\n");
				sb.append(String.valueOf((K - array[D][0] * i) / array[D][1]));
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
