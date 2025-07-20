package dequeue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 1. 덱큐 이용하여 구현
 * 2. 직접 메서드까지 작성하여 구현
 */
public class b10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        b10866 deque = new b10866();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();

            if (cmd.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque.push_front(x);
            } else if (cmd.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque.push_back(x);
            } else if (cmd.equals("pop_front")) {
                sb.append(deque.pop_front()).append('\n');
            } else if (cmd.equals("pop_back")) {
                sb.append(deque.pop_back()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(deque.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(deque.empty()).append('\n');
            } else if (cmd.equals("front")) {
                sb.append(deque.front()).append('\n');
            } else if (cmd.equals("back")) {
                sb.append(deque.back()).append('\n');
            }
        }

        System.out.print(sb);

    }
    Deque<Integer> deque;

    public b10866(){
        this.deque = new ArrayDeque<>();
    }

    private void push_front(int x){
        deque.offerFirst(x);
    }

    private void push_back(int x){
        deque.offer(x);
    }

    private int pop_front(){
        if (deque.isEmpty()) return -1;
        return deque.poll();
    }

    private int pop_back(){
        if (deque.isEmpty()) return -1;
        return deque.pollLast();
    }

    private int size(){
        return deque.size();
    }

    private int empty(){
        return deque.isEmpty() ? 1 : 0;
    }

    private int front(){
        if (deque.isEmpty()) return -1;
        return deque.peekFirst();
    }

    private int back(){
        if (deque.isEmpty()) return -1;
        return deque.peekLast();
    }






}
