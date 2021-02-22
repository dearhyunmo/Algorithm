package silver4;
import java.io.*;
import java.util.*;

public class Q_10815 {
	// TC
	
	// 5
	// 6	3	2	10	-10
	
	// 8 
	// 10	9	-5	2	3	4	5	-10
	//	o	x	x	o	o	x	x	o				<- 카드 존재 여부
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기

		int n = Integer.parseInt(br.readLine()); // 상근's 카드 갯수
		int[] arr = new int[n]; //카드 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine()); // 카드 읽기

		for (int i = 0; i< n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 카드 배열에 넣기
		}
		
		Arrays.sort(arr); // 정렬
		
		int size = Integer.parseInt(br.readLine()); // 비교할 카드 갯수
		st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder(); // 답 대입용 SB
		for (int i = 0; i< size; i++) { // 카드 갯수만큼
			int num = Integer.parseInt(st.nextToken()); // 비교할 숫자
			if (Arrays.binarySearch(arr, num) >= 0) // 이진탐색
				sb.append(1); // 있으면 1추가
			else // 없으면
				sb.append(0); // 0추가
			sb.append(" "); //띄어쓰기
		}		
		System.out.print(sb); // 답 출력

	}

}
