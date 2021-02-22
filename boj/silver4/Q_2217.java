package silver4;


import java.io.*;
import java.util.*;

public class Q_2217 {
	
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ropes = new int[n];

        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }

        Arrays.sort(ropes); // 오름차순으로 정렬

        int max = ropes[ropes.length - 1];
        int rope;
        int count = 1;
        List<Integer> result = new LinkedList<Integer>(); // 중량들을 저장하는 리스트

        result.add(max);

        for (int i = ropes.length - 2; i >= 0; i--) { // 각 로프들과의 협력했을 때 최대 얼마의 중량을 들 수 있는지 검사
            rope = ropes[i];
            count++;
            max = count * ropes[i];
            result.add(max);
        }
        System.out.println(Collections.max(result));
	}
}
