package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        /*
         * 배열이 ArrayList보다 캐시 친화적, 오버헤드가 적다, 메모리 성능이 높다.
         * 연속된 데이터 저장.
         */
        // 화폐 등록
        int[] coins = new int[n];
        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        /*
         * k == 0이 될 때까지 반복
         * array의 index 역순으로 시작, k - array[index] < 0 이면 index--
         * k - array[index] > 0 이면 음수가 될 때까지 계속 빼주기
         */
        int count = 0;
        for (int i = n-1; i >= 0; i--){
            if (k - coins[i] >= 0){
                count += k / coins[i];
                k %= coins[i];
            }
        }
        System.out.println(count);


    }
}
