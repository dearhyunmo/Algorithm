package Q_11497;

import java.io.*;
import java.util.*;

public class Q_11497 {
	static int t,n;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        
        while(t>0) {
            t--;
            n = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            arr = new int[n];
            String[] t = br.readLine().split(" ");
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(t[i]);
            }
            
            int ans[] = new int[n];
            int left = 0;
            int right = n-1;
            
            Arrays.sort(arr);
            
            for(int i=0; i<n; i++) {
                if(i%2!=0) {
                    ans[left] = arr[i];
                    left+=1;
                }
                else {
                    ans[right] = arr[i];
                    right-=1;
                }
            }
            min = Math.abs(ans[0]-ans[n-1]);
            for(int i=1; i<n; i++) {
                min = Math.max(min, Math.abs(ans[i]-ans[i-1]));
            }
            System.out.println(min);
        }
        
    }
}