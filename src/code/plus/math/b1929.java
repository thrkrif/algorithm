package code.plus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        /*
         * a ~ b 사이에 소수를 전부 구해서 한 줄 씩 출력하기
         * 소수란 ? 1과 자기 자신만 약수로 가지는 수
         * for문을 돌려서 하나하나 확인해봐야하나? 시간 초과 뜰 것 같은데
         * 왜냐하면 for문 이용해서 데이터 담고, for문 이용해서 2부터 나눠보면서 체크해야함.
         * 2부터 나누는데 자기 자신 전에 count가 1 올라가면 바로 break 하면 되나?
         */

        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = a; i <= b; i++){
            numList.add(i);
        }

        for (int j = 0; j < numList.size(); j++){

        }


    }
}
