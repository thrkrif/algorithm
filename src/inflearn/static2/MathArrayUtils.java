package inflearn.static2;

import java.util.Arrays;

public class MathArrayUtils {

    // 객체를 생성하지 못하도록 막는 방법 : 생성자를 private로 선언
    private MathArrayUtils(){

    }
    public static int sum(int[] array){
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static double average(int[] array){
        int sum = sum(array);
        return (double) sum / array.length;
    }

    public static int min(int[] array){
        int min = array[0];
        for (int i : array) {
            if (min >= i) min = i;
        }
        return min;
    }

    public static int max(int[] array){
        int max = array[0];
        for (int i : array) {
            if (max <= i) max = i;
        }
        return max;

    }

}
