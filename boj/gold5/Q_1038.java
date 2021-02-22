package gold5;
import java.io.*;
import java.util.*;

public class Q_1038 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
        System.out.println(run(N)); // 몇번째 수인지
    }
 
    public static String run(int n) { 
        if(n < 10) // 10 이하일때는 1자리 수니까 바로 리턴
            return String.valueOf(n);
 
        //10 이상이니까
        Queue<String> decreases = new LinkedList<>();
        for (int i = 0; i < 10; i++) // 반복
            decreases.add(String.valueOf(i)); //9까지는 값 넣어줌
 
        int result = 9; // 9까지는 했고
        while(!decreases.isEmpty()) { // 계속 돌거야
            String extract = decreases.poll(); //0 1 2 3 4 5 6 7 8 9
            for (int i = 0; i < (extract.charAt(extract.length() - 1) - '0'); i++) { //
                decreases.add(extract + i);
                result++; // 결과 갯수 더하기
                if(result == n) // 결과랑 같으면 
                    return extract + i; // 마지막 수
            }
        }
 
        return String.valueOf(-1) ; // 없으면 -1
    }

}
