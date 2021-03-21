package Q_3005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_3005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[r][c];
		String arrStr[] = new String [400];
		int ansCnt = 0;
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				char ch = str.charAt(j);
				arr[i][j] =ch;
			}
		}
		
		for(int i=0; i<r;i++) {
			boolean check = true;
			for(int j=0; j<c;j++) {
				if(arr[i][j] == '#') {
					check=false;
				}
//				System.out.print(arr[i][j]);
			}
			if(check) {
				String str = Character.toString(arr[i][0])+Character.toString(arr[i][1])+Character.toString(arr[i][2])+Character.toString(arr[i][3]);
				arrStr[ansCnt] = str;
//				System.out.println(arrStr[ansCnt]);
				ansCnt++;
			}
		}
		
		for(int i=0; i<c;i++) {
			boolean check = true;
			for(int j=0; j<r; j++) {
				if(arr[i][j] =='#') {
					check=false;
				}
			}
			if(check) {
				String str = Character.toString(arr[0][i])+Character.toString(arr[1][i])+Character.toString(arr[2][i])+Character.toString(arr[3][i]);
				arrStr[ansCnt] = str;
//				System.out.println(arrStr[ansCnt]);
				ansCnt++;
			}
		}
//		Arrays.sort(arrStr);
		String answer [] = new String [ansCnt];
		for(int i=0; i<ansCnt;i++) {
			answer[i] = arrStr[i];
//			System.out.println(arrStr[i]);
		}
		Arrays.sort(answer);
		
		System.out.println(answer[0]);
		
	}
}
/*


 */