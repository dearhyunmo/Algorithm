package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Q_1251 { 
	/*union & find*/
	static class Way implements Comparable<Way> {
		int node1, node2;
		double cost;

		Way(int node1, int node2, double cost) {
			this.node1 = node1;
			this.node2 = node2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Way o) {
			return (int) (this.cost - o.cost);
		}
	}

	static int[] root;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			int n = Integer.parseInt(br.readLine());
			double[] xArr = new double[n];
			double[] yArr = new double[n];
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < n; ++i) {
				xArr[i] = Double.parseDouble(str[i]);
			}
			str = br.readLine().split(" ");
			for (int i = 0; i < n; ++i) {
				yArr[i] = Double.parseDouble(str[i]);
			}
			double e = Double.parseDouble(br.readLine());
			root = new int[n];
			for (int i = 0; i < n; ++i) {
				root[i] = i;
			}
			PriorityQueue<Way> pq = new PriorityQueue<Way>();
			for (int i = 0; i < n - 1; ++i) {
				for (int j = i + 1; j < n; ++j) {
					double disX = (xArr[i] - xArr[j]) * (xArr[i] - xArr[j]);
					double disY = (yArr[i] - yArr[j]) * (yArr[i] - yArr[j]);
					double dis = disX + disY;
					pq.offer(new Way(i, j, dis));
				}
			}
			Way w = null;
			double cost = 0;
			while (!pq.isEmpty()) {
				w = pq.poll();
				int x = find(w.node1);
				int y = find(w.node2);
				if (x == y)
					continue;
				union(x, y);
				cost += e * w.cost;
			}
			bw.write("#" + t + " " + Math.round(cost) + "\n");
		}
		bw.close();
		br.close();
	}

	static int find(int x) {
		if (x != root[x])
			return find(root[x]);
		return x;
	}

	static void union(int x, int y) {
		if (x < y) {
			root[y] = root[x];
		} else {
			root[x] = root[y];
		}
	}

}
	/*프림 기법*/
//	static class Info implements Comparable<Info> {
//		int idx;
//		double val;
//		public Info(int idx, double val) {
//			this.idx = idx;
//			this.val = val;
//		}
//		@Override
//		public int compareTo(Info o) {
//			return Double.compare(this.val, o.val);
//		}
//	}
//
//	static boolean flag[];
//	static double x[], y[];
//	static double mul;
//	static List<Info> li[];
//
//	public static void main(String[] args) throws Exception {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int test = Integer.parseInt(br.readLine());
//		for (int t = 1; t <= test; t++) {
//			int num = Integer.parseInt(br.readLine().trim());
//			// 초기화
//			flag = new boolean[num + 1];
//			x = new double[num + 1];
//			y = new double[num + 1];
//			li = new List[num + 1];
//			for(int i=1;i<=num;i++)
//				li[i] = new ArrayList<>();
//
//			String s = br.readLine();
//			StringTokenizer st = new StringTokenizer(s);
//			double vv;
//			for (int i = 1; i <= num; i++) {
//				vv = Double.valueOf(st.nextToken());
//				x[i] = vv;
//			}
//			s = br.readLine();
//			st = new StringTokenizer(s);
//			for (int i = 1; i <= num; i++) {
//				vv = Double.valueOf(st.nextToken());
//				y[i] = vv;
//			}
//			mul = Double.parseDouble(br.readLine().trim());
//			double start_x, start_y, end_x, end_y, dx, dy;
//			for (int i = 1; i < num; i++) {
//				start_x = x[i];
//				start_y = y[i];
//				for (int j = i + 1; j <= num; j++) {
//					end_x = x[j];
//					end_y = y[j];
//					dx = (start_x - end_x) * (start_x - end_x);
//					dy = (start_y - end_y) * (start_y - end_y);
//					li[i].add(new Info(j, dx + dy));
//					li[j].add(new Info(i, dx + dy));
//				}
//			}
//			List<Info> temp;
//			double result = 0;
//			PriorityQueue<Info> pq = new PriorityQueue<>();
//			Deque<Integer> dq = new ArrayDeque<>();
//			dq.add(1);
//			Info ii;
//			while(!dq.isEmpty()) {
//				int curNode =dq.poll();
//				flag[curNode]=true;
//				temp=li[curNode];
//				for(int i=0;i<temp.size();i++) {
//					int next = temp.get(i).idx;
//					if(!flag[next]) {
//						pq.add(new Info(next,temp.get(i).val));
//					}
//				}
//				while(!pq.isEmpty()) {
//					ii=pq.poll();
//					if(!flag[ii.idx]) {
//						flag[ii.idx]=true;
//						dq.add(ii.idx);
//						result+=ii.val;
//						break;
//					}
//				}
//				
//			}
//			System.out.println("#" + t + " " + Math.round(mul * result));
//		}
//	}
//}
/*크루스칼 기법*/
//	static class Info implements Comparable<Info> {
//		int start, end;
//		double val;
//
//		public Info(int start, int end, double val) {
//			this.start = start;
//			this.end = end;
//			this.val = val;
//		}
//
//		@Override
//		public int compareTo(Info o) {
//			return Double.compare(this.val, o.val);
//		}
//	}
//
//	static int root[];
//	static double x[], y[];
//	static double mul;
//	static List<Info> li;
//
//	public static int parent(int idx) {
//		if (root[idx] == idx)
//			return idx;
//		return root[idx] = parent(root[idx]);
//	}
//
//	public static void make_union(int a, int b) {
//		a = parent(a);
//		b = parent(b);
//		if(a<b) root[b]=a;
//		else root[a]=b;
//	}
//
//	public static int find(int a, int b) {
//		a = parent(a);
//		b = parent(b);
//		if(a==b) return 1;
//		else return 0;
//	}
//	
//	public static void main(String[] args) throws Exception {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int test = Integer.parseInt(br.readLine());
//		for (int t = 1; t <= test; t++) {
//			int num = Integer.parseInt(br.readLine().trim());
//			// 초기화
//			x = new double[num + 1];
//			y = new double[num + 1];
//			li = new ArrayList<Info>();
//			root = new int[num + 1];
//
//			for (int i = 1; i <= num; i++)
//				root[i] = i;
//
//			String s = br.readLine();
//			StringTokenizer st = new StringTokenizer(s);
//			double vv;
//			for (int i = 1; i <= num; i++) {
//				vv = Double.valueOf(st.nextToken());
//				x[i] = vv;
//			}
//			s = br.readLine();
//			st = new StringTokenizer(s);
//			for (int i = 1; i <= num; i++) {
//				vv = Double.valueOf(st.nextToken());
//				y[i] = vv;
//			}
//			mul = Double.parseDouble(br.readLine().trim());
//			double start_x, start_y, end_x, end_y, dx, dy;
//			for (int i = 1; i < num; i++) {
//				start_x = x[i];
//				start_y = y[i];
//				for (int j = i + 1; j <= num; j++) {
//					end_x = x[j];
//					end_y = y[j];
//					dx = (start_x - end_x) * (start_x - end_x);
//					dy = (start_y - end_y) * (start_y - end_y);
//					li.add(new Info(i, j, dx + dy));
//				}
//			}
//			Collections.sort(li);
//			int cnt = 0;
//			long result = 0;
//			while (cnt < li.size()) {
//				int start = li.get(cnt).start;
//				int end = li.get(cnt).end;
//				int res = find(start,end);
//				if (res==1) { // 사이클 형성
//					cnt++;
//					continue;
//				}
//				make_union(start,end);
//				result += li.get(cnt).val;
//				cnt++;
//			}
//			System.out.println("#" + t + " " + Math.round(mul*result));
//		}
//	}
//}