package Q_2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
		StringBuilder sb = new StringBuilder(); // 출력 테스트용 StringBuilder
		
		int N = Integer.parseInt(br.readLine()); // 줄 잘라줘서 몇가지 질문할건지 받기
		
		String[] numbers = new String[N]; // 민혁이가 질문하는 숫자
		int[] strikeCnt = new int [N]; // 영수의 스트라이크 답
		int[] ballCnt = new int [N]; // 영수의 볼 답
				
		for(int i=0; i<N; i++) { // 민혁이가 질문한 횟수만큼 반복문 
			StringTokenizer st = new StringTokenizer(br.readLine()," "); // 공백을 기준으로 토큰화 
			
			numbers[i] = st.nextToken(); // 질문하는 숫자에 값 대입
//			if(numbers[i].charAt(1)==2) {
//				System.out.println(numbers[i].charAt(1)); // 문자로 인식
//				System.out.println(numbers[i].charAt(1)-'0'); // 숫자로 인식
//			}
			
			strikeCnt[i] = Integer.parseInt(st.nextToken()); // 스트라이크 갯수 값 대입
			ballCnt[i] = Integer.parseInt(st.nextToken()); // 볼 갯수 값 대입
			sb.append("제시 : "+numbers[i] + "(" + strikeCnt[i] + " 스트라이크, " + ballCnt[i] + " 볼)\n"); // 값 테스트용
		}
		
		int cnt=0; // 영수가 생각하고 있을 가능성이 있는 답의 총 갯수
		for(int i=1; i<=9; i++) { // 0이 안되고 1~9사이의 숫자
			for(int j=1; j<=9;j++) { // 0이 안되고 1~9사이의 숫자
				if(i!=j) { // i랑 j랑 같을 수 없음
					for(int k=1; k<=9; k++) { // 0이 안되고 1~9사이의 숫자
						if(k!=i && k!=j) { //k도 i랑 j랑 같을 수 없음
							boolean ans = true; // 스트라이크 볼 숫자가 맞으면 가능성 있는 답 갯수 ++해주기 위해
							for(int s=0; s<N; s++) { // 질문한 횟수
								int strike=0; // 스트라이크 갯수
								int ball=0; // 볼 갯수
								String str = numbers[s];
								if(str.charAt(0)-'0'==i) strike++; // i랑 첫자리랑 같으면 스트라이크
								if(str.charAt(1)-'0'==j) strike++; // j랑 둘째 자리랑 같으면 스트라이크
								if(str.charAt(2)-'0'==k) strike++; // k랑 셋째 자리랑 같으면 스트라이크
								if(str.charAt(0)-'0'==j||str.charAt(0)-'0'==k) ball++; // 첫번째 자리랑 두번째 숫자가 같거나, 첫번째 자리랑 세번째 숫자가 같으면 볼
								if(str.charAt(1)-'0'==i||str.charAt(1)-'0'==k) ball++; // 두번째 자리랑 첫번째 숫자가 같거나, 두번째 자리랑 세번째 숫자가 같으면 볼
								if(str.charAt(2)-'0'==i||str.charAt(2)-'0'==j) ball++; // 세번째 자리랑 첫번째 숫자가 같거나, 세번째 자리랑 두번째 숫자가 같으면 볼
								
								if(strikeCnt[s]!=strike||ballCnt[s]!=ball) { // 스트라이크랑 볼 갯수 둘 중에 하나다로 다르다면
									ans=false; // 답 갯수 안더해주고 취소
									break; // 다시 시작
								}
							}
							if(ans) cnt++; // 갯수 같으면 카운트 ++
						}
					}
				}
			}
		}
		
//		System.out.println(sb.toString()); // 테스트용 출력
		
		System.out.println(cnt); // 갯수 출력
	}
}
