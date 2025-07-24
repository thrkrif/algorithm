package code.plus.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
 * 날짜 계산을 하시오 1년이 지날 때 마다 E, S, M이 1씩 증가한다.
 */
public class b1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1 16 16 은 16년이다.
        // 5 20 1 은 16 + 4 = 20년이다.
        int year = 1;
        int expE = 1;
        int expS = 1;
        int expM = 1;
        // year 구할 때 까지 무한루프
        while (true){
            if (expE == E && expS == S && expM == M){
                break; // E, S, M의 예상값과 모두 동일하다면 루프 탈출
            }
            // 그게 아니라면 1씩 증가 시킴
            year++;
            expE++;
            expS++;
            expM++;

            if (expE > 15) expE = 1;
            if (expS > 28) expS = 1;
            if (expM > 19) expM = 1;
        }
        System.out.println(year);
    }
}
