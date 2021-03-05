package Q_11502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11502 {
	static boolean[] isPrime=new boolean[1001]; // false이면 소수, true이면 합성수
	static int[] primeList=new int[1001]; // 찾은 소수 모두 저장
	static int primeCnt; // primeList의 index

	public static void main(String[] args) throws IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] nums = new int[T];
		int max = 0;
		for(int i=0; i<T; i++) {
			nums[i]=Integer.parseInt(br.readLine());
			if(nums[i]>max)
				max = nums[i];
		}
    	
        // primeList 배열은 가장 큰 수까지만 구하면 됨
    	primeSieve(max);
  
    	for (int i = 0; i < T; i++) {
    		int cnt=0;
            
            // 2 + 2 + 홀수인 소수
    		if (!isPrime[nums[i] - 4])
    		{
    			cnt++;
    			System.out.println(2+" "+ 2+" "+ (nums[i] - 4));
    			continue;
    		}
    		
            // 홀수인 소수 3개로 이루어진 경우
    		outerloop:
    		for (int j = 1; j < primeCnt; j++) {
    			for (int k = 1; k < primeCnt; k++) {
    				for (int u = 1; u < primeCnt; u++) {
    					if (primeList[j]+primeList[k]+primeList[u]==nums[i])
    					{
    						cnt++;
    						System.out.println(primeList[j]+" "+ primeList[k]+" "+primeList[u]);
    						break outerloop;
    					}
    				}
    			}
    		}
            // 3개의 소수로 이루어지지 않은 경우
    		if (cnt==0)
    			System.out.println(0);
    	}
    }
	public static void primeSieve(int n) // 소수 구하기
	{
    	// isPrime 배열 구하기
		for (int i = 2; i*i <= n; i++) 
			for (int j = i * i; j <= n; j += i)
				if (!isPrime[j]) 
					isPrime[j] = true;

		// primeList 배열 구하기
		for (int i = 2; i <= n; i++)
			if (!isPrime[i])
				primeList[primeCnt++] = i;
	}
}
