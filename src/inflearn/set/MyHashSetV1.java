package inflearn.set;

import java.util.Arrays;
import java.util.LinkedList;

// 해시 알고리즘을 사용하도록 개선
// 해시 알고리즘을 사용한 덕분에 등록, 검색, 삭제 모두 평균 O(1)로 연산 속도를 크게 개선했다.
// 마지막 남은 문제 : 지금 hashIndex는 숫자밖에 사용 못함. 문자는 어떻게 사용할건데?
// 아스키코드, hashCode
public class MyHashSetV1 {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    LinkedList<Integer>[] buckets;

    private int size = 0;

    // final이 아니므로 언제든 바뀔 수 있음. -> 사용자가 크기 설정 가능하도록 하려고
    // 사용자가 용량을 지정안한다면 기본 생성자로 16 크기의 배열이 생성된다.
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    // 기본 생성자
    public MyHashSetV1() {
        initBuckets();
    }

    // 사용자가 용량을 설정 할 수 있도록 함.
    public MyHashSetV1(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }


    // 배열에다가 링크드 리스트 생성해주는 메서드
    private void initBuckets() {
        buckets = new LinkedList[capacity]; // 이번엔 buckets도 링크드 리스트로 만드네? 전에는 배열로 만들더니
        for (int i = 0; i < capacity; i++) {
//            LinkedList<Integer> buket = new LinkedList<>();
//            buckets[i] = buket;
            buckets[i] = new LinkedList<>(); // 위(변수 사용)에나 아래(직접 할당)나 코드 똑같은 거임.
        }
    }

    // 중복된 값이 있는지 확인해야함
    // 해시 인덱스 사용해야함.
    public boolean add(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }

    // 1.모든 배열을 순회 + 2.배열 안의 배열을 순회 -> 최악은 O(n^2) 아님? 물론 해시 충돌의 경우가 거의 없어서 O(n) 정도의 성능이 나올거 같음.
    // 위의 주석의 1을 방지하기 위해 원래 링크드 리스트에 contains가 존재하지만 contains라는 메서드 재정의
    // 1번을 해시 인덱스를 이용하여 O(n) -> O(1)로 성능을 좋게 만들어버림. 2번도 해시 충돌 날 일이 거의 없기 때문에 O(1)의 성능이 나올거임
    // 결론적으로 O(1)의 성능을 얻을 수 있음.
    // 해시 인덱스를 이용하여 데이터가 어느 배열 안에 있는지 바로 찾을 수 있음.
    public boolean contains(int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }

    private int hashIndex(int value) {
        return Math.abs(value) % capacity;
    }

    public boolean remove(int value){
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        boolean result = bucket.remove(Integer.valueOf(value));
        if (result){
            size--;
            return true;
        } else {
            return false;
        }
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
