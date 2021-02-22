package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Q_7701 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/D4_7701_염라대왕의이름정렬.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            Set<String> set = new TreeSet<>(new Comparator<String>() { 
                @Override
                public int compare(String o1, String o2) {
                    int r = o1.length() - o2.length();
                    if (r == 0)
                        return o1.compareTo(o2);
                    else
                        return r;
                }
            });

            for (int i = 0; i < N; i++) {
                set.add(sc.next());
            }

            System.out.println("#"+tc);

            for (String string : set) {
                System.out.println(string);
            }


        }
    }
}