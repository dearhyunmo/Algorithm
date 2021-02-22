package gold5;


import java.io.*;
import java.util.*;

public class Q_17471 {
	public static int N;
	public static int people[];
	public static int isLinked[][];
	public static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 

		people = new int[N + 1];
		int team[] = new int[N + 1];

		String str = br.readLine();
		String[] temp = str.split(" ");
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(temp[i - 1]);
		}

		isLinked = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			str = br.readLine();
			temp = str.split(" ");
			for (int j = 1; j < temp.length; j++) {
				isLinked[i][Integer.parseInt(temp[j])] = 1;
				isLinked[Integer.parseInt(temp[j])][i] = 1;
			}
		}
 
		setTeam(team, 1); 
		if (answer == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(answer);

	}

	public static void setTeam(int team[], int index) {
		if (index == N + 1) {
			if (checkLinked(team, 0) && checkLinked(team, 1))
				answer = Math.min(answer, solve(team));
			return;
		} 
		team[index] = 1;
		setTeam(team, index + 1);
		team[index] = 0;
		setTeam(team, index + 1);
	}

	public static boolean checkLinked(int team[], int team_idx) {
		boolean visited[] = new boolean[N + 1];

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (team[i] == team_idx) {
				list.addLast(i);
				visited[i] = true;
				break;
			}
		}
		while (!list.isEmpty()) {
			int now = list.pollFirst();
			for (int i = 1; i <= N; i++) {
				if (visited[i])
					continue;
				if (team[i] != team_idx)
					continue;
				if (isLinked[now][i] == 0)
					continue;
				list.addLast(i);
				visited[i] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (team[i] != team_idx)
				continue;
			if (visited[i] == false)
				return false;
		}

		return true;
	}

	public static int solve(int team[]) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 1; i <= N; i++) {
			if (team[i] == 1)
				sum1 += people[i];
			else if (team[i] == 0)
				sum2 += people[i];
		}
		return Math.abs(sum1 - sum2);
	}

}