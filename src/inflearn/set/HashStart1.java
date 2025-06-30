package inflearn.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart1 {
    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // 밖은 10 짜리 Array(배열) 이고 안에는 링크드 리스트, 아직 링크드 리스트는 존재하지 않는 상태
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];

        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>(); // 이제 배열 안에 링크드 리스트들이 생성됨.
        }

        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9); //중복
        System.out.println("buckets = " + Arrays.toString(buckets));
//검색
        int searchValue = 9;
        boolean contains = contains(buckets, searchValue);
        System.out.println("buckets.contains(" + searchValue + ") = " +
                contains);

    }

    // 언제 static을 붙이고 언제 안붙이는지를 모르겠음. 이 메서드에는 왜 static이 붙음?
    private static void add(LinkedList<Integer>[] buckets, int value){
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if(!bucket.contains(value)){
            bucket.add(value);
        }
    }

    /*
     * 원래도 링크드 리스트 내부에 contains가 존재하는데 굳이 왜 만들었을까?
     * 지금 만든 메서드는 내부에서 hashIndex 연산까지 다 해줘버림
     */
    private static boolean contains(LinkedList<Integer>[] bukets, int searchValue){
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> buket = bukets[hashIndex];
        return buket.contains(searchValue);
    }

    static int hashIndex(int value){
        return value % CAPACITY;
    }
}
