package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D2_2007 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// system setin 하고 나서 해야함
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 0; test_case < T; test_case++)
		{
            String s = br.readLine();
            for(int i = 1; i<=s.length(); i++) {
            	String pattern = s.substring(0,i);
            	String tmp =s.substring(i, i+i);
            	if (pattern.equals(tmp)) {
            		System.out.println("#"+(test_case+1)+" "+pattern.length());
            		break;
            	}
            }
		}
	}

}
