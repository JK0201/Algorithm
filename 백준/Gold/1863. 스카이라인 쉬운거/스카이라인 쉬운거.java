import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                count++;
            }

            if (stack.isEmpty() || stack.peek() < y) stack.push(y);
        }

        while (!stack.isEmpty()) {
            if (stack.pop() > 0) count++;
        }

        System.out.println(count);
        br.close();
    }
}