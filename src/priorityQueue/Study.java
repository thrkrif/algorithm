package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Study {
    public static void main(String[] args) {
        /*
         * 우선순위 큐는 기본이 최소 힙 방식이다.
         * 힙의 데이터 조회는 O(1)이 걸린다. 데이터 추가/삭제는 O(logN)이 걸린다.
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println("minHeap");
        pq.add(10);
        pq.add(100);
        pq.add(80);
        pq.add(60);

        System.out.println(pq.poll()); // 10
        System.out.println(pq.poll()); // 60
        System.out.println(pq.poll()); // 80
        System.out.println(pq.poll()); // 100

        System.out.println();

        System.out.println("maxHeap");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙으로 구현
        maxHeap.add(10);
        maxHeap.add(100);
        maxHeap.add(80);
        maxHeap.add(60);

        System.out.println(maxHeap.poll()); // 100
        System.out.println(maxHeap.poll()); // 80
        System.out.println(maxHeap.poll()); // 60
        System.out.println(maxHeap.poll()); // 10

        /*
         * 큐에 클래스를 집어넣는 경우, Comparable 인터페이스 상속 -> compareTo 오버라이딩이 필요하다.
         */
    }
}
