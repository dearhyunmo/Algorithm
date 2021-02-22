package gold5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_15961{
    private static int N, d, k, c, arr[], visit[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        visit = new int[d+1];
        arr = new int[N];
        for(int i=0; i<N;i++)
            arr[i] = Integer.parseInt(br.readLine());
        System.out.println(slide());
    }
    
    private static int slide(){
        int tot = 0, max = 0;
        for(int i=0; i< k; i++){
            if(visit[arr[i]] == 0)
                tot++;
            visit[arr[i]]++;
        }
        max = tot;
        
        for(int i=1; i<N; i++){
            if(max<=tot){
                if(visit[c] == 0)
                    max = tot+1;
                else
                    max = tot;
            }
            visit[arr[i-1]]--;
            if(visit[arr[i-1]] == 0)
                tot--;
            if(visit[arr[(i+k-1)%N]]==0)
                tot++;
            visit[arr[(i+k-1)%N]]++;
        }
        return max;
    }
}