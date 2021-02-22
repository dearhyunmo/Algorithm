package gold5;


import  java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1034 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int Lamp[][];
	static int cntarray[];
	static boolean cntarray2[];
	public static void main(String args[])throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행의 갯수
		int M = Integer.parseInt(st.nextToken()); // 열의 갯수
		Lamp = new int [N][M]; // 램프 배열
		cntarray = new int [N]; //갯수 카운트
		cntarray2 = new boolean [N];
		for(int i=0; i<N; i++)
		{
			String s = br.readLine();
			for(int j=0; j<M; j++)
			{
				
				Lamp[i][j]=Character.getNumericValue(s.charAt(j));
			}
		}
		int K = Integer.parseInt(br.readLine());
		if(K==0)
		{
			int cnt2=0;
			for(int i=0; i<N; i++)
			{
				int cnt=0;
				
				for(int j=0; j<M; j++)
				{
					if(Lamp[i][j]==1)
					{
						cnt++;
					}
				}
				if(cnt==M)
				{
					cnt2++;
				}
			}
			System.out.println(cnt2);
		}
		for(int i=0; i<N; i++)
		{
			int cnt = 0;
			for(int j=0; j<M; j++)
			{
				if(Lamp[i][j]==0)
				{
					cnt++;
				}
			}
			cntarray[i]=cnt;
		}
		for(int i=0; i<N; i++)
		{
			if(cntarray[i]%2==1 && cntarray[i]<=K && K%2==1)
			{
				cntarray2[i]=true;
			}
			else if(cntarray[i]%2==0 && cntarray[i]<=K && K%2==0)
			{
				cntarray2[i]=true;
			}
			else 
			{
				cntarray2[i]=false;
			}
		}
		int answerarray[] = new int [N];
		for(int i=0; i<N; i++)
		{
			int cnt = 0;
			if(cntarray2[i]==true)
			{
				for(int j=0; j<N; j++)
				{
					if(Arrays.equals(Lamp[i], Lamp[j]))
					{
						cnt++;
					}
				}
				answerarray[i]=cnt;
			}
		}
		Arrays.sort(answerarray);
		if(K!=0)
		{
			System.out.println(answerarray[N-1]);
		}
	}
}