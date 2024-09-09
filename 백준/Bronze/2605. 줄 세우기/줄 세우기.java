import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> order = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++) {
            int num = Integer.parseInt(st.nextToken());

            while (num-- > 0) {
                int student = order.pop();
                stack.push(student);

            }

            order.push(i+1);

            while (!stack.isEmpty()) {
                int student = stack.pop();
                order.push(student);
            }
        }

        for (int o : order) {
            sb.append(o).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}