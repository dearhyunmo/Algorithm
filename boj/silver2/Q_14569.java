package silver2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_14569 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuffer sb = new StringBuffer();

		int numClass = Integer.parseInt(st.nextToken());
		long[] Classes = new long[numClass];

		for (int i = 0; i < numClass; i++) {
			st = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(st.nextToken());
			long tmp = 0;
			long t = 1;
			for (int a = 0; a < k; a++)
				tmp |= t << Integer.parseInt(st.nextToken());
			Classes[i] = tmp;
		}

		st = new StringTokenizer(in.readLine());
		int numStudent = Integer.parseInt(st.nextToken());

		long[] isPossible = new long[numStudent];
		for (int i = 0; i < numStudent; i++) {
			st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken());
			long t = 1;
			for (int a = 0; a < p; a++)
				isPossible[i] |= t << Long.parseLong(st.nextToken());
		}

		for (long student : isPossible) {
			int answer = 0;
			for (long timetable : Classes) {
				if ((timetable & student) == timetable)
					answer++;
			}
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
