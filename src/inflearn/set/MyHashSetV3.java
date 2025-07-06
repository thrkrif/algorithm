//package inflearn.set;
//
//import java.util.LinkedList;
//
//// 인터페이스를 이용하여 해시 기반이 아닌 다른 자료 구조 기반의 Set도 만들 수 있다.
//public class MyHashSetV3<E> implements MySet<E>{
//    static final int DEFAULT_INITIAL_CAPACITY = 16;
//
//    private LinkedList<E>[] buckets;
//
//    private int size = 0;
//    private int capacity = DEFAULT_INITIAL_CAPACITY;
//
//    public MyHashSetV3(){
//        initBuckets();
//    }
//
//    public MyHashSetV3(int capacity){
//        this.capacity = capacity;
//        initBuckets();
//    }
//
//    private void initBuckets(){
//        buckets = new LinkedList[capacity];
//    }
//}
