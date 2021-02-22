package silver2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11053 {	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 배열 갯수
		
		int arr[] = new int[N]; // 배열 값
		
		int arr2[] = new int[N]; // 증가하는 배열인지 순서 넣는 값 => 답

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 배열 값 넣고
		}

		arr2[0] = 1; // 처음이 스타트니 1

		for (int i = 1; i < N; i++) { // 반복 ㄱㄱ
			arr2[i] = 1; // 값 1로 초기화해주고
			for (int j = 0; j < i; j++) { // i전까지 반복
				if (arr[j] < arr[i] && arr2[i] <= arr2[j]) { //  비교 구문
					arr2[i] = arr2[j] + 1;
				}
			}
		}

		int max = 0; // 최고 길이 변수
		for (int i : arr2) {
			max = Math.max(max, i); // 반복돌려서 젤 큰 수 ㄱ
		}

		System.out.println(max);
	}
}
