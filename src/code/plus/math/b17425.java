package code.plus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 실버 2와 다른 점은 다중 쿼리라는 점이다. 입력이 10^6까지 가능
 * 고정 비용(전처리) vs 반복 비용
 * 여기선 배열에 정보들을 담아두는 누적합 방식을 사용하는 것이 성능이 더 좋다.
 * 제일 처음 작성한 답안은 입력이 있을때마다 매번 N번씩 반복해야한다.
 */
public class b17425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

//        // 전처리 : 미리 g를 다 구해버리기
//        final int MAX_N = 1_000_000; // 문제에서 최대 입력이 10만이므로
//        long[] f = new long[MAX_N + 1];
//        long[] g = new long[MAX_N + 1];
//        f[0] = 0;
//        g[0] = 0;
//
//        // 에라토스테네스의 체 : O(NlogN)
//        for (int i = 1; i <= MAX_N; i++){
//            for (int j = i; j <= MAX_N; j += i){
//                f[j] += i;
//            }
//        }
//        // O(N)
//        for (int i = 1; i <= MAX_N; i++){
//            g[i] = g[i - 1] + f[i];
//        }
//        // ======= 전처리 완료 ==========
//
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 1; i <= T; i++){
//            int N = Integer.parseInt(br.readLine());
//            sb.append(g[N]).append('\n');
//        }
//        System.out.println(sb);


        /*
         * f 구하지 않고 한 번에 g에 포함시켜서 계산하기
         * 위의 방식과 2배 성능 차이가 난다.
         */

        final int MAX_N = 1_000_000;
        long[] g = new long[MAX_N + 1];
        g[0] = 0;

        for (int i = 1; i <= MAX_N; i++){
            for (int j = i; j <= MAX_N; j += i){
                g[j] += i; // 사실 이건 f[i]를 구한 것들임. 각 수들의 약수의 총합
            }
        }

        for (int i = 1; i <= MAX_N; i++){
            g[i] += g[i-1];
            /*
             * g[i] = g[i] + g[i-1] 에서 우변의 g[i]는 f[i]와 같고 g[i-1]은 누적합임.
             * 계산의 결과로 좌변의 g[i]가 실제 누적합으로 바뀜.
             */
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(g[N]).append('\n');
        }
        System.out.println(sb);

        // 시간 차이는 4ms, 메모리 차이는 8000kb로 f를 따로 구하지 않는게 성능이 더 좋긴함.

    }
}

///*
// * 약수의 합 문제인데 이건 왜 골드4임?
// * 약수의 합 2 : 실버2 문제와 다를게 없는데?
// * 단지 입력을 여러번 할 수 있다는 점
// */
//public class b17425 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < T; i++){
//            int N = Integer.parseInt(br.readLine());
//            long sum = 0;
//            for (int j = 1; j <= N; j++){
//                sum += (long) j * (N / j);
//            }
//            System.out.println(sum); // T가 10만회인데 System.out.println으로도 되려나?
//        }
//    }
//}
