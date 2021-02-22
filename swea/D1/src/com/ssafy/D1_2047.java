package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1_2047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		String msg = in.readLine(); // 엔터 전까지만 입력 받아서 사용 가능;
		char[] cha = msg.toCharArray();
		for(int i=0;i<msg.length();i++) {
			if((int)cha[i]>=97&&(int)cha[i]<=122) {
				cha[i] -= 32;
			}
		}
		for(int i=0;i<cha.length;i++)
			System.out.print(cha[i]);
	}
}
