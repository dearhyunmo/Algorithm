package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_20200729 {
	public static class Car {
        int r, c; // 전차 좌표
        char dir; // 방향
 
        public Car(int r, int c, char dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
 
        @Override
        public String toString() {
            return "Car [r=" + r + ", c=" + c + ", dir=" + dir + "]";
        }
 
    }
 
    public static int H, W, N; // map의 높이 H 너비 W 길이 N인 command
    public static char[][] map; //지도
    public static String cmd; // 커맨드
    public static Car car; //자동차 클래스 불러오기
    public static BufferedReader br;
 
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));// system setin 하고 나서 해야함
        StringBuilder ans = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            inIt();// INIT END
            for (int i = 0; i < N; i++) {
                games(cmd.charAt(i));
            }
            ans.append("#" + tc + " ");
            for (char[] m : map) {
                for (char x : m) {
                    ans.append(x);
                }
                ans.append("\n");
            }
        } // TESTCASE END
        System.out.println(ans);
        br.close();
    }
 
    public static void inIt() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
 
        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                    car = new Car(i, j, map[i][j]);
                }
            }
        } // MAP INIT END
 
        N = Integer.parseInt(br.readLine());
 
        cmd = br.readLine();
    }
 
    public static void games(char cs) {
        switch (cs) {
        case 'U':
            // 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
            car.dir = '^';
            if (isIn(car.r - 1, car.c) && map[car.r - 1][car.c] == '.') {
                map[car.r][car.c] = '.';
                car.r--;
            }
            map[car.r][car.c] = car.dir;
            break;
        case 'D':
            // 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
            car.dir = 'v';
            if (isIn(car.r + 1, car.c) && map[car.r + 1][car.c] == '.') {
                map[car.r][car.c] = '.';
                car.r++;
            }
            map[car.r][car.c] = car.dir;
            break;
        case 'L':
            // 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
            car.dir = '<';
            if (isIn(car.r, car.c - 1) && map[car.r][car.c - 1] == '.') {
                map[car.r][car.c] = '.';
                car.c--;
            }
            map[car.r][car.c] = car.dir;
            break;
        case 'R':
            // 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
            car.dir = '>';
            if (isIn(car.r, car.c + 1) && map[car.r][car.c + 1] == '.') {
                map[car.r][car.c] = '.';
                car.c++;
            }
            map[car.r][car.c] = car.dir;
            break;
        case 'S':
            // 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
            Shoot();
            break;
        }
    }
 
    public static void Shoot() {
        int dr = 0, dc = 0;
        switch (car.dir) {
        case '<':
            dc = -1;
            break;
        case '>':
            dc = 1;
            break;
        case '^':
            dr = -1;
            break;
        case 'v':
            dr = 1;
            break;
        }
        int sr = car.r + dr;
        int sc = car.c + dc;
        while (isIn(sr, sc)) {// 게임 맵 밖으로 나갈 때 까지
            if (map[sr][sc] == '#') // 강철벽
                break;
            if (map[sr][sc] == '*') { // 벽돌벽
                map[sr][sc] = '.';
                break;
            }
            sr += dr;
            sc += dc;
        }
    }
 
    public static boolean isIn(int r, int c) {
        return (0 <= r && r < H && 0 <= c && c < W);
    }
}