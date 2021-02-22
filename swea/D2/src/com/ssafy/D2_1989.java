package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] ans = new int[T];
		StringBuffer strBuff = new StringBuffer();
		for (int tc = 0; tc < T; tc++) {
			String word = br.readLine();
			strBuff.append(word);
			String reverse = strBuff.reverse().toString();

			strBuff.append(word);

			if (word.length() % 2 == 0) {
				if (word.substring(0, word.length() / 2).equals(reverse.substring(0, word.length() / 2))) {
					ans[tc] = 1;
				} else {
					ans[tc] = 0;
				}
			} else {
				if (word.substring(0, word.length() / 2).equals(reverse.substring(0, word.length() / 2))) {
					ans[tc] = 1;
				} else {
					ans[tc] = 0;
				}
			}
		}
		for (int tc = 0; tc < T; tc++)
			System.out.println("#" + (tc + 1) + " " + ans[tc]);
	}

}
