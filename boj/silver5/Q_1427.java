package Q_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] nums = br.readLine().toCharArray(); //배열로 변환하여 넣기
		
		Arrays.sort(nums); // 정렬
		
		for(int i = nums.length-1; i>=0; i--) { // 배열 길이만큼 반복
			System.out.print(nums[i]); // ㄱㄱ
		}
		
	}
}
