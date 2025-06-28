package inflearn.list.test;


import java.util.ArrayList;
import java.util.List;

public class ListEx1 {

    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};
        int total = 0;
        for (int i = 0; i < students.length; i++) {
            total += students[i];
        }
        double average = (double) total / students.length;
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);

        /*
         * 배열 -> 리스트로 코드 변경하기
         */
        List<Integer> list = new ArrayList<>();
        int total1 = 0;
        list.add(90);
        list.add(80);
        list.add(70);
        list.add(60);
        list.add(50);
        for (int i = 0 ; i < list.size(); i++){
            total1 += list.get(i);
        }
        double average1 = (double) total1 / list.size();
        System.out.println("점수 총합: " + total1);
        System.out.println("점수 평균: " + average1);
    }
}
