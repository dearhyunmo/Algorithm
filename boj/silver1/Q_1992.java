package silver1;


import java.util.Scanner;

public class Q_1992 {
	
	Scanner sc;
	int n;
	int[][] map;
	String result;

	public void setValue() {
		String tStr;
		char[] values;
		sc = new Scanner(System.in);
		result = "";
		n = sc.nextInt();
		sc.nextLine();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			tStr = sc.nextLine();
			values = tStr.toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = (int) (values[j] - '0');
			}
		}
		
	}
	
	public String divid(int Row1, int Col1, int Row2, int Col2) {
		String upLeft, upRight, downLeft, downRight;
		if (Row2 - Row1 <= 0) {
			return map[Row1][Col1] + "";
		}
		// 좌상
		upLeft = divid(Row1, Col1, (Row1 + Row2) / 2, (Col1 + Col2) / 2);
		// 우상
		upRight = divid(Row1, (Col1 + Col2) / 2 + 1, (Row1 + Row2) / 2, Col2);
		// 좌하
		downLeft = divid((Row1 + Row2) / 2 + 1, Col1, Row2, (Col1 + Col2) / 2);
		// 우하
		downRight = divid((Row1 + Row2) / 2 + 1, (Col1 + Col2) / 2 + 1, Row2, Col2);
		if (upLeft.length() == 1 && upLeft.equals(upRight) && upRight.equals(downLeft) && downLeft.equals(downRight)) {
			return upLeft;
		} else {
			return "(" + upLeft + upRight + downLeft + downRight + ")";
		}
	}
	
	public void solve() {
		setValue();
		System.out.println(divid(0, 0, n - 1, n - 1));
	}
	
	public static void main(String[] args) {
		Q_1992 m = new Q_1992();
		m.solve();
	}
}
