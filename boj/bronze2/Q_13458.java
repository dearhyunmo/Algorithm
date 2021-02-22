package bronze2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_13458 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        Long ans = (long) N;
        int cntC;
        for(int i = 0 ; i < N ; i++) {
            people[i] -= B;
            if(people[i] > 0) {
                cntC = people[i]/C;
                if(people[i]%C != 0) {
                    cntC++;
                }
                ans += cntC;
            }
        }
        
        System.out.println(ans);
        
    }

}
