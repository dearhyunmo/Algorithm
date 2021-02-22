package gold4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Q_1987 {
    public static int ROW;
    public static int COL;
    public static int[][] arr;
    
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
 
    public static boolean[] visited;
    
    public static int step = 1;
    public static int max_step = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        arr = new int[ROW][COL];
        
        for(int i=0; i < ROW; i++) {
            String str = br.readLine();
            for(int j=0; j < COL; j++) {
                arr[i][j] = (int)str.charAt(j) - 65;
            }
        }
        
        visited = new boolean[26];
        dfs(0, 0);
        System.out.println(max_step);
    }
    
    public static void dfs(int y, int x) {
        int alpha = arr[y][x];
        visited[alpha] = true;
        
        for(int i=0; i < 4; i++) {
            int yy = dy[i] + y;
            int xx = dx[i] + x;
            
            if(yy < 0 || xx < 0 || yy >= ROW || xx >= COL) continue;
            
            int nextAlpha = arr[yy][xx];
            if(visited[nextAlpha]) continue;
            
            max_step = Math.max(max_step, ++step);
            
            dfs(yy, xx);
        }
        step --;
        visited[alpha] = false;
    }
}

