package code.plus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 입력 받기 String
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 두 수의 최대공약수, 최소 공배수 구하기 - 유클리드 호제법 + 재귀 사용
        int gcd = gcd(a,b);
        int lcm = a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int gcd(int a, int b){
        int r = a % b; // 나머지

        if (r != 0) {
            return gcd(b, r); // r == 0 일 때까지 재귀
        }
        return b;
    }
}
