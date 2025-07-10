package code.plus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1929 {
    private static boolean[] primes;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        getPrime(M, N);
    }

    // M부터 시작
    private static void getPrime(int M, int N) {
        primes = new boolean[N + 1]; // boolean은 default가 false임.

        // false에서 true로 소수 찾으려면 모든 숫자 다 판별해야함. 따라서 true로 두고 소수 아닌거 다 false로 체크
        for (int i = 0; i <= N; i++){
            primes[i] = true;
        }

        // 0과 1은 소수가 아님을 확실히 해두자.
        primes[0] = primes[1] = false;

        /*
         * a = b * c  -> a가 합성수라면 b * c 중 하나는 무조건 a의 제곱근보다 작거나 같은 값임.
         * 즉, b나 c중 하나만 존재해도 소수가 아님이 증명되기 때문에 a의 제곱근까지만 확인하면됨.
         */

        for (int i = 0; i <= Math.sqrt(N); i++){
            if (primes[i]) {
                // 소수를 찾았다? 소수의 배수들은 모두 합성수이므로 false 처리 해주어야함.
                for (int j = i*i; j <= N; j += i){
                    primes[j] = false;
                }
            } else continue; // 소수가 아니면 아무것도 안하고 넘어가면 된다.
        }

        for (int i = M; i <= N; i++){
            if (primes[i]){
                sb.append(i).append('\n');
            }
        }
//        System.out.println(Arrays.toString(primes)); 배열 확인하려 했던건데 주석처리 안해서 출력초과 떴던거임.
        System.out.println(sb.toString());

    }
}






//
//public class b1929 {
//    public static boolean[] prime; // primitive는 기본이 false로 배치
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
//
//        /*
//         * a ~ b 사이에 소수를 전부 구해서 한 줄 씩 출력하기
//         * 소수란 ? 1과 자기 자신만 약수로 가지는 수
//         * for문을 돌려서 하나하나 확인해봐야하나? 시간 초과 뜰 것 같은데
//         * 왜냐하면 for문 이용해서 데이터 담고, for문 이용해서 2부터 나눠보면서 체크해야함.
//         * 2부터 나누는데 자기 자신 전에 count가 1 올라가면 바로 break 하면 되나?
//         * 에라토스테네스의 체를 이용한다.
//         */
//
//        prime = new boolean[b + 1]; // b개 만큼의 배열 생성  true이면 소수, false이면 소수가 아님
////        System.out.println("prime = " + Arrays.toString(prime));
//        getPrime(prime.length);
//
//
//    }
//
//    // 소수 판별기, 0,1은 소수가 아니다
//    private static void getPrime(int n){
//        prime[0] = prime[1] = false; // 기본이 false이지만 확실하게 작성
//
//        /*
//         * prime 내부의 값을 먼저 true로 만드는 이유는? default가 false이므로 소수만 찾아서 true로 바꾸면 되지 않냐는 생각
//         * -> 이러면 모든 수가 다 소수인지 확인해야한다. 따라서 모든 배열을 true로 두고 소수가 아닌 것을 false로
//         * 바꾸는게 훨씬 효율적이다.
//         */
//        for (int i = 2; i < n; i++){
//            prime[i] = true;
//        }
//
//        /*
//         * a가 합성수이면 a = b * c 에서 b 또는 c가 무조건 a의 제곱근보다 작은 값이 나온다
//         * a = b * c 라는것은 합성수라는 의미이므로 제곱근까지만 찾아서 2부터 a라는 수까지 모두 검사할 필요 없이
//         * b 또는 c 중에 하나만 찾아내면 소수가 아님을 증명할 수 있다.
//         */
//        for (int i = 2; i <= Math.sqrt(n); i++){
//            if (prime[i]) { // 해당 수가 소수라면 그 배수들은 모두 합성수이므로 false 처리 해주어야한다.
//                // 2,3,5 ... 에서 중복된 숫자들을 어떻게 처리할 것인가?
//                for (int  )
//            }
//
//        }
//    }
//}
