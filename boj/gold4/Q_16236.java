package gold4;


import java.util.*;

class shark{
	int x;
	int y;
	int time;
	shark(int x, int y, int time){
		this.x=x;
		this.y=y;
		this.time=time;
	}
}
public class Q_16236 {
	static int[][]arr;
	static int[]dx= {-1,0,1,0};
	static int[]dy= {0,1,0,-1};
	static int result;
	static Queue<shark>q;
	static boolean[][] visited;
	static Queue<shark>list;
	static int maxsize;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int size = sc.nextInt();
		arr= new int[size][size];
		visited=new boolean[size][size];
		list=new LinkedList<shark>();
		q= new LinkedList<shark>();
		result=0;
		maxsize=2;
		cnt=0;
		int count=0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==9) {
					visited[i][j]=true;
					q.add(new shark(i,j,0));
				}if(arr[i][j]<=6&&arr[i][j]>=1) {
					count++;
				}
			}
		}
		if(count==0) {
			System.out.println(0);
		}
		else {
			BFS();
			System.out.println(result);
		}
	}
	private static void BFS() {
		int limittime=Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			shark temp = q.poll();
			int x= temp.x;
			int y= temp.y;
			int time=temp.time;
			if(limittime>time) {
				for(int i=0;i<4;i++) {
					int rx= x+dx[i];
					int ry = y+dy[i];
					if(rx<0||ry<0||rx>=arr.length||ry>=arr.length) {
						continue;
					}if(visited[rx][ry]==true) {
						continue;
					}if(arr[rx][ry]==0||arr[rx][ry]==maxsize||arr[rx][ry]==9) {
						visited[rx][ry]=true;
						q.add(new shark(rx,ry,time+1));
//						System.out.println(rx+" "+ry+" "+(time+1));
						continue;
					}
					if(arr[rx][ry]!=0&&arr[rx][ry]<maxsize) {
						visited[rx][ry]=true;
						limittime=time+1;
						list.add(new shark(rx,ry,time+1));
						System.out.println(rx+" "+ry+" "+(time+1));
						continue;
					}
				}
			}
		}
		if(list.size()!=0) {
			cnt++;
			check();
		}
	}
	private static void check() {
		int MINX=Integer.MAX_VALUE;
		int MINY=Integer.MAX_VALUE;
		int MINtime=Integer.MAX_VALUE;
		while(!list.isEmpty()) {
			shark temp = list.poll();
			int tempx = temp.x;
			int tempy=temp.y;
			int temptime =temp.time;
			if(MINtime>temptime) {
				MINX=tempx;
				MINY=tempy;
				MINtime=temptime;
			}else if(MINtime==temptime) {
				if(MINX>tempx) {
					MINX=tempx;
					MINY=tempy;
					MINtime=temptime;
				}else if(MINX==tempx) {
					if(MINY>tempy) {
						MINX=tempx;
						MINY=tempy;
						MINtime=temptime;
					}
				}
			}
		}
		result=MINtime;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				visited[i][j]=false;
			}
		}
		visited[MINX][MINY]=true;
		arr[MINX][MINY]=0;
		if(cnt==maxsize) {
			cnt=0;
			maxsize++;
			q.add(new shark(MINX,MINY,MINtime));
		}else {
			q.add(new shark(MINX,MINY,MINtime));
		}
		BFS();
	}
}