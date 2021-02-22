package silver3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1004 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<T;i++){
			
			 st = new StringTokenizer(br.readLine());
			 
			int sx=Integer.parseInt(st.nextToken()); //출발점x
			int sy=Integer.parseInt(st.nextToken()); //출발점y
			int ex=Integer.parseInt(st.nextToken()); //도착점x
			int ey=Integer.parseInt(st.nextToken()); //도착점y
			
			st = new StringTokenizer(br.readLine());
			
			int n=Integer.parseInt(st.nextToken()); //행성 갯수n
			
			int cnt=0;
			
			for(int j=0;j<n;j++){
				st = new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken()); //중점x
				int y=Integer.parseInt(st.nextToken()); //중점y
				int r=Integer.parseInt(st.nextToken()); //반지름
				boolean c1=check(x,sx,y,sy,r);
				boolean c2=check(x,ex,y,ey,r);
				if(c1&&c2) continue;
				else if(c1||c2) cnt++;
			}
			System.out.println(cnt);
		}
	}
	private static boolean check(int x,int xx,int y,int yy,int r){
		return (x-xx)*(x-xx)+(y-yy)*(y-yy)<r*r; // 계산법
	}
}
