package silver1;


import java.util.*;

public class Q_14888 {
	static int[] arr;
    static int[] op;
    static ArrayList<Integer> list; // 최소값과 최대값
    static char[] MH; 
    static int N;
    static int count = 0;
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        N = sc.nextInt();
        arr = new int[N];
        op = new int[4];
        MH = new char[N]; 
 
        list = new ArrayList<Integer>();
 
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
 
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }
 
        DFS(1, arr[0]);
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }
 
    static void DFS(int x, int sum) { // DFS 전체 탐색
        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                op[i]--; // 사용된 연산자 감소
                switch (i) {
                case 0:
                    MH[x - 1] = '+';
                    DFS(x + 1, sum + arr[x]);
                    break;
                case 1:
                    MH[x - 1] = '-'; 
                    DFS(x + 1, sum - arr[x]);
                    break;
                case 2:
                    MH[x - 1] = '*'; 
                    DFS(x + 1, sum * arr[x]);
                    break;
                case 3:
                    MH[x - 1] = '/'; 
                    DFS(x + 1, sum / arr[x]); 
                    break;
                }
                MH[x - 1] = 0; 
                op[i]++; // 사용이 끝났으면 다시 추가
            }
        }
 
        // 카운트가 입력값과 같을 때
        if (x == N) {
//            for (int i = 0; i < N; i++) {
//                System.out.print(arr[i] + " ");
//                System.out.print(MH[i] + " ");
//            }
// 
//            System.out.println("= " + sum);
            list.add(sum);
        }
    }
 
}
