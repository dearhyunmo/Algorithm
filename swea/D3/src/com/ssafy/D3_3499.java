package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3499 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String [] ans = new String[T];
		for(int tc=0; tc<T; tc++) {
			int dek = Integer.parseInt(br.readLine());
			String [] cards = new String[dek];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < dek; i++) {
				cards[i] = st.nextToken();
				//System.out.println(cards[j]);
			}
			System.out.print("#"+ (tc+1));
			for(int i=0; i<dek; i++) {
				if(i%2==0) {
					System.out.print(" "+cards[i/2]);
				} else if(dek%2==0) {
					System.out.print(" "+cards[dek/2+i/2]);
				} else
					System.out.print(" "+cards[dek/2+1+i/2]);
			}
			
		}
	}

}
