package gold4;
import java.io.*;
import java.util.*;

public class Q_2075 {
	static int[] numArr;

	// TC 
	
	//	5  > 몇개의 줄에 몇개의 수, 찾을 몇번째로 큰 수,
	//	12 7 9 15 5  
	//	13 8 11 19 6
	//	21 10 26 31 16
	//	48 14 28 35 25
	//	52 20 32 41 49

	// 정렬하고 해보면 52 49 48 41 35 순으로 진행
	// 배열 끝에서 N빼주면 되는 간단한 문제	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int idx = 0; // 반복문에서 배열에 계속 값 넣기 위해서 사용
		
		numArr = new int[N * N]; // 배열 사이즈 지정

		for (int i = 0; i < N; i++) { // 줄 입력받는거때문에 이렇게 2중 포문으로 ㄱㄱ
			// 포문 하나로 하니까 런타임 나더라.....ㅠㅠㅠㅠㅠㅠㅠㅠ   /// 아래 참조
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				numArr[idx++] = Integer.parseInt(st.nextToken()); // idx++로 계속 배열에 값 넣고
			}
		}
		
		/*  런타임 오류 나는 이유 ? i%5를 계산해주면서 났던 듯
		for (int i = 0; i < N*N; i++) {
			if(i%5==0)
				st = new StringTokenizer(br.readLine());
				
			numArr[i] = Integer.parseInt(st.nextToken());
			}
		}
		 */

		Arrays.sort(numArr);
		int ans = numArr[numArr.length-N]; 
		
		System.out.println(ans);

	}
	
}
