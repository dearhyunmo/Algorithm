package gold5;
import java.io.*;
import java.util.*;

public class Q_1342 {
	
	//TC
	
	//aabbbaa
	
	//abababa으로 되는 경우를 찾는 것
	
	// 행운의 문자열 -> 다음문자랑 지금 문자랑 다른거
	
	static char[] arr;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		arr = new char[str.length()]; // 입력받은 문자열 배열에 넣기

		for (int i = 0; i < str.length(); i++) { // 문자열 길이만큼
			arr[i] = str.charAt(i); // 배열에 값 넣어주기
		}

		Arrays.sort(arr); // 배열 정렬

		if (check(arr)) //해달 
			ans++;

		while (luckystring()) {
		}

		System.out.println(ans);
	}

	public static boolean check(char[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) // 다음글자랑 같으면
				return false;
		}

		return true;
	}

	public static boolean luckystring() {
		int i = arr.length - 1; // 배열의 길이-1
		while (i > 0 && arr[i - 1] >= arr[i]) { // i가 0이되거나 i-1이랑 i랑 같으면 i--
			i--;
		}

		if (i <= 0) // i가 0보다 같거나 작다면
			return false;

		int j = arr.length - 1; //배열의 길이만큼해서 비교
		while (arr[j] <= arr[i - 1]) {
			j--;
		}

		char temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;

		j = arr.length - 1;
		while (i < j) { // 문자열 위치 바꿔주기
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		if (check(arr)) {
//			System.out.println(arr);
			ans++;
		}
		return true;
	}
}