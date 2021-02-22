package silver2;
import java.io.*;
import java.util.*;

public class Q_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 배열 입력받기
		}
		
		Arrays.sort(arr); // 배열 정렬
		
		int min = 1, max = arr[N-1]-1; // 집 간의 거리 최소(1)랑 최대(배열 제일 큰 값 -1) 해서 기준 정해줄거
		int length=0; // 최대 거리
		
		while(min <= max) { //min이 max보다 커지면 종료
			int avg = (min+max)/2; // 기준 거리는 간격 가능 한 거 반
			int limit = 0; // 간격 제한
			int cnt = 0; // 공유기 갯수
			for( int i = 0; i<N; i++) {
				if(limit<=arr[i]) { // 공유기 간격이 배열을 넘어가진 않는지 체크 
					cnt++; // 안넘어가면 갯수 ++
					limit = arr[i]+avg;
				}
			}
			if(cnt>=C) // 갯수가 C넘어가면
				min = avg+1; // 최소 값을 올려서 평균 구하기
			else // 갯수가 C미달이면
				max = avg-1;  // 최대값을 줄여줌
		}
		length = min-1;
		
		System.out.println(length);
	}
}
