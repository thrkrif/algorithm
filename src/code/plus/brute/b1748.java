package code.plus.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1~N까지 계속 연결해서 작성하면 그게 몇자리 수일까?

        /*
         * 되게 간단한 문제라고 생각함. 그냥 sb.append 한 다음에 sb.length로 길이를 구하면 되는거 아닌가?
         * -> 메모리가 엄청 커질 수 있음.
         * String.valueOf.length를 쓰면? 애초에 sb.length랑 차이가 뭔데?
         * 근데 String.valueOf.length는 시간 복잡도가 O(NlogN) 이래
         * 수학적 방식을 사용하면 시간 복잡도가 O(logN) 이래
         */
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i <= N; i++){
//            sb.append(i);
//        }
//        System.out.println(sb.length());

        /*
         * 이전까지는 어떻게 구현할지에 대하여 고민만 하였는데 난이도가 조금씩 올라가면서
         * 시간 제한, 입력값의 범위, 메모리 에 따른 시간복잡도를 확인하고,
         * 그에 맞는 알고리즘으로 구현을 해야겠다는 생각이 들었다.
         * 지금 문제는 입력값이 최대 1억, 시간 제한 0.15초, 메모리 제한 128MB이다.
         * 보통 1초에 1억까지 가능하다고 한다. O(N)기준, 그러나 시간 제한이 0.15초이므로
         * 지금 문제는 O(logN)으로 풀어야 한다.
         * O(logN)으로 어떻게 구현을 해야할까?
         */
        int count = 0; // 숫자의 개수 -> 정답으로 호출 할 변수
        int digits = 1; // 현재 자릿수
        int start = 1; // 현재 자릿수의 시작 숫자

        while(start <= N){ // start가 N보다 커지면 루프를 빠져나온다. -> 필터링 (1) : 1, 10, 100 단위로 N을 거른다.
            int end = 10 * start - 1; // start는 1, 10, 100, end는 9, 99, 999,
            if (end > N) end = N; // 필터링 (2) : 실제 N을 찾아낸다.

            count += (end - start + 1) * digits;
            // 위의 if문을 통과하지 못했다? 실제 N을 못 찾아낸 경우이고 아직 입력된 N이 자릿수가 더 커서 그런거임.
            // if문을 통과하면 그제서야 자릿수가 결정이 되고 정확한 count를 찾아내고 로직이 종료된다.
            // 9 - 1 + 1 * 1 = 9개
            // 99 - 10 + 1 * 2 = 90 * 2 = 180개
            digits++; // 1자릿수, 2자릿수, ,,
            start *= 10; // 이 로직이면 O(logN)의 시간 복잡도를 가진다.
        }

        System.out.println(count);



    }
}
