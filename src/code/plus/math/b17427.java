package code.plus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 누적합으로 구했지만 O(N^2)으로 시간초과 뜸

* 그렇다면 어떻게 풀어야할까?

* N을 입력하면 1~N의 약수를 모두 구하여 합하는 구조임.

* ex. N = 4, g(4)를 구하시오.

* f(1) = 1

* f(2) = 1 + 2

* f(3) = 1 + 3

* f(4) = 1 + 2 + 4

* 1이 4번, 2가 2번, 3이 1번, 4가 1번 나옴.

* 1이 나온 횟수 = 4 / 1 = 4번

* 2이 나온 횟수 = 4 / 2 = 2번

* 3이 나온 횟수 = 4 / 3 = 1번

* 4이 나온 횟수 = 4 / 4 = 1번

* 즉 모든 합을 구하려면 1 * 4 + 2 * 2 + 3 * 1 + 4 * 1 = 4 + 4 + 3 + 4 = 15 = g(4)가 된다.

* 검색해보니까 이걸 최적화라고 부르더라
*
*
 */
public class b17427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        for (int i = 1; i <= N; i++){
            sum += (long) i * (N / i);
        }
        System.out.println(sum);
    }
}

/*
 * 누적 합 문제 같은데? 4를 입력하면 g(4) = f(1) + f(2) + f(3) + f(4) 를 구하라는거잖아.
 * 근데 g(3) = f(1) + f(2) + f(3)이니까, g(4) = g(3) + f(4)
 * 그러니까 g()의 값을 담을 배열을 만들어서 넣고 g(N) = g(N-1) + f(N) : g(N-1)은 이미 구해져 있으므로 f(N)만 구하면 된다.
 */
//public class b17427 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        // long 타입으로 변경 -> 오버플로우 방지
//        long[] g = new long[N+1]; // g의 값을 담을 배열을 생성, 인덱스 맞추기 위해 N+1로 하고 g[0] = 0
//        g[0] = 0;
//
//        for (int i = 1; i <= N; i++){
//            long f = 0;
//            for (int j = 1; j <= i; j++){
//                if (i % j == 0){
//                    f += j;
//                }
//            }
//            g[i] = g[i-1] + f;
//        }
//
//        System.out.println(g[N]);
//    }
//}
