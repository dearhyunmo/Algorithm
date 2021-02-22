package silver1;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_1697 {
	
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] Min = new int[100001]; // MIn  =  내가 위치한 곳에 햐ㅐ당하는 배열
        Arrays.fill(Min, -1);    //초기값을 다 -1로 설정
        System.out.println(BFS(N, K, Min));
    }
 
    public static int BFS(int N, int K, int[] Min) {
        int nextN = N;
        int[] status = new int[3];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(nextN);
        Min[nextN] = 0; // 내가 왔다
 
        while (!q.isEmpty() && nextN != K) {
 
            nextN = q.poll();
            //다음에 이동할 좌표들
            status[0] = nextN - 1;     //뒤로 한칸
            status[1] = nextN + 1;    //앞으로 한칸
            status[2] = nextN * 2;    //순간이동
 
            for (int i = 0; i < 3; i++) {
                //배열을 벗어나지 않았는지 확인
                if (status[i] >= 0 && status[i] <= 100000) {
                    //이전에 방문했는지 확인
                    if (Min[status[i]] == -1) {
                        //처음 간 곳이라면 큐에 넣고 상태를 전 위치값 +1 을 해준다.
                        q.add(status[i]);
                        Min[status[i]] = Min[nextN] + 1; // 내가 방문한 곳 = 0+1;
 
                    }
                }
            }
        }
        return Min[K];
    }
}
