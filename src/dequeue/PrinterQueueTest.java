package dequeue;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrinterQueueTest {
    public static void main(String[] args) {
        Queue<String> printQueue = new ArrayDeque<>();
        printQueue.offer("doc1");
        printQueue.offer("doc2");
        printQueue.offer("doc3"); // [doc1, doc2, doc3] 으로 저장되어 있음.
        System.out.println("출력 = " + printQueue.poll());
        System.out.println("출력 = " + printQueue.poll());
        System.out.println("출력 = " + printQueue.poll());
        // poll <- [doc1, doc2, doc3] <- offer

    }
}
