package code.plus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 진짜 약수가 모두 주어질 때, N 을 구하시오
 * 진짜 약수란 1과 본인 제외
 */
public class b1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // N
        StringTokenizer st = new StringTokenizer(br.readLine()); // 둘째 줄

        int[] arrayList = new int[n]; // 약수 담는 바구니

//        int i = 0;
//        while (st.hasMoreTokens()){
//            arrayList[i++] = Integer.parseInt(st.nextToken()); // 약수들 담기
//        } -> 이게 왜 안됨? 이 아니라 잘 동작한다. 패키지명 작성되어있는대로 제출하여 런타임 에러 발생함.

        for (int i = 0; i < n; i++){
            arrayList[i] = Integer.parseInt(st.nextToken());
        } // while문과 for문 사용했을 때 메모리, 성능 차이는 거의 없다.

        // 검증 단계
        // 1. 배열의 정렬을 이용하여 푸는 방법
        Arrays.sort(arrayList); // return 값이 없다.
        System.out.println(arrayList[0] * arrayList[n-1]); // 맨 처음 값과 맨 마지막 값을 곱하면 답이 나온다.

        // 2. MAX, MIN 이용하여 푸는 방법
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            min = Math.min(min, arrayList[i]);
            max = Math.max(max, arrayList[i]);
        }
        System.out.println(min * max);

    }
}
