package priorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueEx1 {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("상훈1", 100));
        pq.add(new Student("상훈2", 80));
        pq.add(new Student("상훈3", 700));

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
