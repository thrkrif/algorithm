package dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeMain {
    public static void main(String[] args) {
        /*
         * deque = Double Ended Queue -> stack ,queue 기능 다 가진다.
         * Deque의 대표적인 구현체는 LinkedList, ArrayDeque가 존재한다.
         * 모든 면에서 ArrayDeque > LinkedList, 특히 ArrayDeque는 원형 큐 자료구조를 이용한다.
         * List에서 ArrayList, LinkedList 성능 비교와 비슷한데 배열 vs 동적 노드 생성 차이임
         *
         */
        Deque<Integer> deque = new ArrayDeque<>();

//        deque.offer(1);
//        deque.offer(2);
//        deque.offer(3); -> [1,2,3], offer = offerLast
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        // -> [3,2,1]
        System.out.println("deque = " + deque);
    }
}
