package Q_9536;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q_9536 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<N; i++) {
			String nock = sc.nextLine();
			for(String temp1=sc.next(),temp2=sc.next();
					temp2.equals("goes");
					temp1=sc.next(),temp2=sc.next()) {
				String temp3 = sc.next();
				
				StringTokenizer st = new StringTokenizer(nock," ");
				String temp = "";
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					if(token.equals(temp3)) {
					} else {
						temp += token+" ";
					}
				}
				nock=temp;
			}
			sc.next(); //the
			sc.next(); //fox
			sc.next(); //say?
			sc.nextLine();
			System.out.println(nock);
		}
	}
}
