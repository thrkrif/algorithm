package dequeue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class B28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        // 아 모르고 deque를 초기화 안해서 런타임에러 NullPointer 발생함.
        deque = new LinkedList<>();
        /*
         * 큐 문제에서 back() 메서드를 데큐로 풂. 푼 김에 데큐도 같이 풀자.
         */
        for (int i = 0; i < N; i++){
            String[] command = br.readLine().split(" ");

            switch (command[0]){
                case "2":
                    int x = Integer.parseInt(command[1]);
                    offer(x);
                    break;
                case "1":
                    int y = Integer.parseInt(command[1]);
                    offerFirst(y);
                    break;
                case "3":
                    sb.append(poll()).append('\n');
                    break;
                case "4":
                    sb.append(pollLast()).append('\n');
                    break;
                case "5":
                    sb.append(size()).append('\n');
                    break;
                case "6":
                    sb.append(isEmpty()).append('\n');
                    break;
                case "7":
                    sb.append(peek()).append('\n');
                    break;
                case "8":
                    sb.append(peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);

    }

    static Deque<Integer> deque;

    // 2번 덱의 앞에 넣기
    static void offerFirst(int x){
        deque.offerFirst(x);
    }

    // 1번 덱의 뒤에 넣기 : 기본 offer, add, offerLast, addLast
    static void offer(int x){
        deque.offer(x);
    }

    // 3번 덱의 맨 앞에 정수 빼기 : poll ,remove, pollFirst, removeFirst
    static int poll(){
        return !deque.isEmpty() ? deque.poll() : -1;
    }

    // 4번 덱 맨 뒤 정수 빼기 pollLast, removeLast
    static int pollLast(){
        return !deque.isEmpty() ? deque.pollLast() : -1;
    }

    // 5번 size
    static int size(){
        return deque.size();
    }

    // 6번 isEmpty
    static int isEmpty(){
        return deque.isEmpty() ? 1 : 0;
    }

    // 7번 peek, get, peekFirst, getFirst
    static int peek(){
        return !deque.isEmpty() ? deque.peek() : -1;
    }

    // 8번 peekLast, getLast
    static int peekLast(){
        return !deque.isEmpty() ? deque.peekLast() : -1;
    }

}
