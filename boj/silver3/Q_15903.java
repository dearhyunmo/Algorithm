package Q_15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_15903 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cardCnt = Integer.parseInt(st.nextToken()); // 카드 갯수
		int set = Integer.parseInt(st.nextToken()); // 몇 세튼지
		long Array[] = new long [cardCnt]; // 카드 값
		long answer = 0; // 정답
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<cardCnt; i++) {
			Array[i] = Long.parseLong(st.nextToken()); // 배열에 값 넣기
		}
		
		for(int i=0; i<set; i++) { // 세트 반복
			Arrays.sort(Array); // 배열 정렬하기
			long sum = Array[0]+Array[1]; // 가장 작은 두 수 더하기
			Array[0] = sum; // 더한 값 넣기 
			Array[1] = sum; // 더한 값 넣기
		}
		
		for(int i=0; i<cardCnt; i++) {
			answer += Array[i]; // 다 더해주기
		}
		
		System.out.println(answer); // 출력
	}
}

/*
3 1       // 첫 수는 카드 갯수, 가장 작은 두 수의 세트 갯수
3 2 6   //  배열 정렬 하면
2 3 6 // 정렬 한 값 
5 5 6 // 더해진거 정렬하기


 */
