package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class B18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // System.in 사용하니까 시간 초과 떠서 추가
        int N = Integer.parseInt(br.readLine());

        queue = new LinkedList<>();

        for (int i = 0; i < N; i++){
            String[] command = br.readLine().split(" "); // split은 공백이 없어도 에러가 나지 않는다.
            // push를 위해서 split을 이용하였다.
            switch (command[0]){
                case "push":
                    int x = Integer.parseInt(command[1]);
                    push(x);
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

    static Deque<Integer> queue;
    static void push(int X){
        queue.add(X);
    }

    static int pop(){
        return !queue.isEmpty() ? queue.poll() : -1;
    }

    static int size(){
        return queue.size();
    }

    static int empty(){
        return queue.isEmpty() ? 1 : 0;
    }

    static int front(){
        return !queue.isEmpty() ? queue.peek() : -1;
    }

    static int back(){
        return !queue.isEmpty() ? queue.peekLast() : -1;
    }
}
