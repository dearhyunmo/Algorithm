package silver1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_14891 {
	static int[][] arr;
	static Queue<gear> q;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[4][8];
		q = new LinkedList<gear>();
		for (int i = 0; i < arr.length; i++) {
			String a = sc.nextLine();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = a.charAt(j) - '0';
			}
		}
		int casecnt = sc.nextInt();
		for (int i = 0; i < casecnt; i++) {
			visited = new boolean[4];
			int gearnum = sc.nextInt() - 1;
			int dir = sc.nextInt();
			q.add(new gear(gearnum, dir));
			visited[gearnum] = true;
			bfs();

		}
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[i][0] == 1) {
				if (i == 0) {
					result = result + 1;
				} else if (i == 1) {
					result = result + 2;
				} else if (i == 2) {
					result = result + 4;
				} else if (i == 3) {
					result = result + 8;
				}
			}

		}
		System.out.println(result);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			gear qtemp = q.poll();
			int gearnum = qtemp.gearnum;
			int dir = qtemp.dir;
			check(gearnum, dir);
			int[] temp = new int[8];
			if (dir == 1) {
				
				temp[0]=arr[gearnum][7];
				for (int j = 1; j <= 7; j++) {
					temp[j] = arr[gearnum][j - 1];
				}
			} else {
				temp[7]=arr[gearnum][0];
				for (int j = 6; j >= 0; j--) {
					temp[j]=arr[gearnum][j+1];
				}

			}
			for(int i=0;i<8;i++) {
				arr[gearnum][i]=temp[i];
			}
		}
	}

	private static void check(int gearnum, int dir) {

		if (gearnum != 0 && gearnum != 3) {
			if ((arr[gearnum][2] != arr[gearnum + 1][6]) && visited[gearnum + 1] == false) {
				visited[gearnum]=true;
				q.add(new gear(gearnum + 1, dir * -1));

			}
			if ((arr[gearnum][6] != arr[gearnum - 1][2]) && visited[gearnum - 1] == false) {
				visited[gearnum]=true;
				q.add(new gear(gearnum - 1, dir * -1));
			}

		} else if (gearnum == 0) {
			if ((arr[gearnum][2] != arr[gearnum + 1][6]) && visited[gearnum + 1] == false) {
				visited[gearnum]=true;
				q.add(new gear(gearnum + 1, dir * -1));
			}
		} else {
			if ((arr[gearnum][6] != arr[gearnum - 1][2]) && visited[gearnum - 1] == false) {
				visited[gearnum]=true;
				q.add(new gear(gearnum - 1, dir * -1));
			}
		}

	}
}


class gear {
	int gearnum;
	int dir;

	gear(int gearnum, int dir) {
		this.gearnum = gearnum;
		this.dir = dir;
	}
}