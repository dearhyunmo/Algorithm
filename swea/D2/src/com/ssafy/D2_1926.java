package com.ssafy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D2_1926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		Pattern pattern = Pattern.compile("[369]");
		String dashes;
		Matcher matcher;
				
		for(int i=1; i<=num;i++) {
			matcher = pattern.matcher(String.valueOf(i));
			dashes = "";
			while(matcher.find()) dashes +="-";
			if(dashes.contentEquals(""))
				System.out.format("%d ", i);
			else
				System.out.format("%s ", dashes);
		}
	}

}
