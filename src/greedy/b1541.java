package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1541 {
    public static void main(String[] args) throws IOException {
        /*
         * 첫번째 - 가 나오면 그 뒷부분 모두 빼주는게 최솟값
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String expression = br.readLine();

        String[] groups = expression.split("-");

        int result = sumGroup(groups[0]);

        for (int i = 1; i < groups.length; i++){
            result -= sumGroup(groups[i]);
        }
        System.out.println(result);
    }

    // static으로 하는 이유는? 정적 -> 인스턴스 생성 안해도 된다.
    // static 작성 안하면 psvm 내부에 b1541 name = new b1541();
    private static int sumGroup(String group){
        String[] numbers = group.split("\\+");
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
