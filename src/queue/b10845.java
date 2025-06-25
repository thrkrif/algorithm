package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 큐 사용하지 않고 구현해보기.
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

// Deque 사용하지 않고 ArrayList를 이용하여 구현함.
// LinkedList나 Deque로도 구현 해 볼 것.
public class b10845 {
    private ArrayList<Integer> queue;

    public b10845(){
        queue = new ArrayList<>();
    }

    private void push(int value){
        queue.add(value);
    }

    private int pop(){
        if (queue.isEmpty()){
            return -1;
        }

        return queue.remove(0);
    }

    private int size(){
        return queue.size();
    }

    private int empty(){
        return queue.isEmpty() ? 1 : 0;
    }

    private int front(){
        if (queue.isEmpty()){
            return -1;
        }
        return queue.get(0);
    }

    private int back(){
        if (queue.isEmpty()){
            return -1;
        }
        return queue.get(queue.size() - 1 );
    }

    public static void main(String[] args) throws IOException {
        b10845 queueImpl = new b10845();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    queueImpl.push(value);
                    break;
                case "pop":
                    sb.append(queueImpl.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queueImpl.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queueImpl.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queueImpl.front()).append("\n");
                    break;
                case "back":
                    sb.append(queueImpl.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}