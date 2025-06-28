package inflearn.list.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * **문제 설명**
 * 사용자에게 `n` 개의 정수를 입력받아서 `List` 에 저장하고, 입력 순서대로 출력하자.
 * `0` 을 입력하면 입력을 종료하고 결과를 출력한다.
 * 출력시 출력 포멧은 1, 2, 3, 4, 5와 같이 `,` 쉼표를 사용해서 구분하고, 마지막에는 쉼표를 넣지 않아야 한다.
 * 실행 결과 예시를 참고하자.
 * 문제는 `ListEx2` 에 풀자
 */
public class ListEx2 {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
    }
}
