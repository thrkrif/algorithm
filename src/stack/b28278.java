package stack;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000) push
2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다. pop
3: 스택에 들어있는 정수의 개수를 출력한다. size
4: 스택이 비어있으면 1, 아니면 0을 출력한다. empty
5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다. top : 그냥 출력만
 */
class b28278 {
    ArrayList<Integer> stack = new ArrayList();

    public b28278(){
        stack = new ArrayList<>(); // 참조값 할당
    }
    private void push(int value){
        stack.add(value);
    }

    private int pop(){
        if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return -1;
    }

    private int size(){
        return stack.size();
    }

    private int empty(){
        return stack.isEmpty() ? 1 : 0;
    }

    private int top(){
        if (!stack.isEmpty()){
            return stack.get(stack.size() - 1);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        b28278 stackImpl = new b28278();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "1":
                    int value = Integer.parseInt(st.nextToken());
                    stackImpl.push(value);
                    break;
                case "2":
                    sb.append(stackImpl.pop()).append("\n");
                    break;
                case "3":
                    sb.append(stackImpl.size()).append("\n");
                    break;
                case "4":
                    sb.append(stackImpl.empty()).append("\n");
                    break;
                case "5":
                    sb.append(stackImpl.top()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
