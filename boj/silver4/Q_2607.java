package Q_2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2607 {
	static int[][] arp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arp = new int[n][26]; //알파벳 들어갈거야
		int strLength = 0;  // 첫번째 문자열 길이
		int result = 0; // 결과
		
		for(int i=0; i<n; i++) {
			String str = br.readLine(); // 한줄읽기
			if(i==0) { //첫번째 케이스
				strLength = str.length(); 
				for(int j=0; j<str.length();j++) {
					arp[i][str.charAt(j)-65]++; // 몇갠지 값 대입
				}
			}
			else { // 첫번째 아닐때
				if(strLength == str.length() || strLength == str.length()+1 || strLength == str.length()-1) {
					// 줄 수 같거나 ± 1 일 때
					for(int j=0; j<str.length();j++) {
						arp[i][str.charAt(j)-65]++; // 값 넣기
					}
					int ansCnt = 0;
					int life = 1; // 목숨
					for(int j=0; j<26; j++) {
						if(arp[0][j] == arp[i][j]) { //똑같으면 정답
							ansCnt++; // 정답 갯수
						}else {
							if (arp[i][j] - arp[0][j] == 1 || arp[i][j] - arp[0][j] == -1) {
								//정답 오차 ± 1
								life--; // 목숨 깎기
							}
						}
						if(ansCnt == 26) { // 다른거 없어 다 같아
							result++; // 결과 ++
						}
						else if(ansCnt == 25 && life == 0) { // 1개만 다르거나
							result++; // 결과 ++
						}
						else if(ansCnt == 24 && life == -1) { // 2개 다르면 목숨 -1이어야함
							result++; // 결과 ++
						}
					}
				}
			}
		}			
		System.out.println(result);
	}
}
