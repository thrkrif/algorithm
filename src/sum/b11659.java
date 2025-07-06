package sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 누적합을 이용하지 않아서 시간 초과 발생함. S[n] = S[n-1] + a[n]
 * 구해야 하는 거 ex. index 2~4까지를 구하시오 -> S[4] - S[2]로 구하면 된다.
 * 구현은 어떻게 할 것인가? 누적합에 대한 결과를 저장하는 배열을 만든다.
 * 누적합을 이용해서 O(n^2) -> O(n)의 성능을 만듦.
 */
public class b11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()); // readLine 한 줄 전체 받기, String 값만 받을 수 있음.
        int N = Integer.parseInt(st.nextToken()); // nextToken의 반환값은 String이다.
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer numList = new StringTokenizer(br.readLine());
        if (numList.countTokens() != N) {
            return; // N개 만큼의 입력값만 받아야함. 그게 아니라면 프로그램 종료
        }

        int[] prefixSum = new int[N+1]; // N크기의 배열을 생성
        int sum = 0;
        prefixSum[0] = 0;
        for (int i = 1; i <= N; i++){
            sum += Integer.parseInt(numList.nextToken()); // 누적 합
            prefixSum[i] = sum; // 인덱스에 누적 합 더하기
        }
        // [0, 5, 9, 12, 14, 15]

        for (int j = 0; j < M; j++){    // M회 진행
            StringTokenizer index = new StringTokenizer(br.readLine()); // M개 만큼의 인덱스 범위 입력 받기.
            int index1 = Integer.parseInt(index.nextToken());
            int index2 = Integer.parseInt(index.nextToken());
            System.out.println(prefixSum[index2] - prefixSum[index1-1]);
        }
    }

    // 시간 복잡도 O(n^2)
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        StringTokenizer st = new StringTokenizer(br.readLine()); // readLine 한 줄 전체 받기, String 값만 받을 수 있음.
//        int N = Integer.parseInt(st.nextToken()); // nextToken의 반환값은 String이다.
//        int M = Integer.parseInt(st.nextToken());
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        StringTokenizer numList = new StringTokenizer(br.readLine());
//        if (numList.countTokens() != N) {
//            return; // N개 만큼의 입력값만 받아야함. 그게 아니라면 프로그램 종료
//        }
//
//        for (int i = 0; i < N; i++){
//            arrayList.add(Integer.parseInt(numList.nextToken())); // 리스트에 Integer로 값들을 저장함.
//        }
//
//        for (int j = 0; j < M; j++){
//            StringTokenizer index = new StringTokenizer(br.readLine()); // M개 만큼의 인덱스 범위 입력 받기.
//            int index1 = Integer.parseInt(index.nextToken()); // 오토 언박싱 되는건가? (Integer -> int)
//            int index2 = Integer.parseInt(index.nextToken()); // 오토 언박싱 되는건가? (Integer -> int)
//            int sum = 0;
//            for (int k = index1 - 1; k < index2; k++){
//                sum += arrayList.get(k);
//            }
//            System.out.println(sum);
//        }
//    }
}

