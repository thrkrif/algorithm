package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1417 {
    /*
     * 득표 수 조작하기, 우선 순위 큐 + 그리디 알고리즘
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n명의 후보자

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 오름차순
        int dasom = Integer.parseInt(br.readLine()); // 다솜이의 득표 수
        for (int i = 2; i <= n; i++) {
            pq.offer(Integer.parseInt(br.readLine())); // pq에는 다솜이를 제외한 후보자의 득표수가 존재함.
        }
        /*
         * 오름차순으로 정렬되었으므로 큐를 poll 하면 최대 득표수가 나옴
         * 최대 득표수가 다솜이의 득표수보다 크면 최대 득표수--; 다솜이의 득표수++; count++ 다시 pq에 offer
         * pq를 poll 했는데 다솜이의 득표수보다 적다? 로직 종료, count -> 매수한 표의 수
         */
        int count = 0;
        while (!pq.isEmpty() && pq.peek() >= dasom){
            int maxValue = pq.poll();
            maxValue--;
            dasom++;
            count++;
            pq.offer(maxValue);
        }
        System.out.println(count);
    }
}
