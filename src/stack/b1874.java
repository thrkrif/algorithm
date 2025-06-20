package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());
        int current = 1;
        boolean possible = true;

        for (int i = 0; i < num; i++){
            int target = Integer.parseInt(br.readLine());
            while(current <= target){
                stack.push(current);
                sb.append("+\n");
                current++;
            }

            if (!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                sb.append("-\n");
            }
            else {
                possible = false;
                break;
            }

        }
        if (possible){
            System.out.println(sb.toString());
        }
        else
            System.out.println("NO");

    }
}
