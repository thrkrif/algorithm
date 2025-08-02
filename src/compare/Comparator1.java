package compare;

import java.util.*;

public class Comparator1 {
    public static void main(String[] args) {
        String[] strArr = {"Cat", "Dog", "lion"};

        Arrays.sort(strArr); // String의 Comparable 구현에 의한 정렬
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 안함
        System.out.println("strArr = " + Arrays.toString(strArr));

        System.out.println("역순 정렬 옛날 방식");
        Arrays.sort(strArr, new Descending()); // 역순 정렬 -> 옛날 방식이다.
        System.out.println("strArr = " + Arrays.toString(strArr));

        System.out.println("역순 정렬 최근 방식 1");
        Arrays.sort(strArr, Collections.reverseOrder()); // reverseOrder는 Comparator?
        System.out.println("strArr = " + Arrays.toString(strArr));

        System.out.println("역순 정렬 최근 방식 2");
        Arrays.sort(strArr, (s1,s2) -> s2.compareTo(s1)); // 람다식 이용
        System.out.println("strArr = " + Arrays.toString(strArr));


    }
}

class Descending implements Comparator{
    public int compare(Object o1 ,Object o2){
        if (o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1; // -1을 곱해서 기본 정렬방식의 역으로 변경한다.
            // 또는 c2.compareTo(c1)과 같이 순서를 바꿔도 된다.
        }
        return -1;
    }
}
