package com.ssafy.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q_3124 {

	static int[] parents;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int V = sc.nextInt(); // 정점
			int E = sc.nextInt(); // 간선

			int[][] arr = new int[E][3];
			parents = new int[V + 1];
			Arrays.fill(parents, -1);

			for (int i = 0; i < E; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = sc.nextInt();
			}

			Arrays.sort(arr, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					int i = a[2] - b[2];
					return i;
				}
			});

			int count = 0;
			long result = 0;
			for (int i = 0; i < E; i++) {
				boolean uni = union(arr[i][0], arr[i][1]);
				if (uni) {// 그래프가 합쳐졌으면
					result += arr[i][2];
					count++;
				}
				if (count == V - 1) {
					break;
				}

			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static boolean union(int a, int b) {

		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] < 0)
			return a;
		else { // path compression
			return parents[a] = find(parents[a]);
		}
	}
}