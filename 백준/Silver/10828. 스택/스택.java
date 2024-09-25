import java.io.*;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String operation = br.readLine();
            stackOperation(operation);
        }

        System.out.println(sb);
        br.close();
    }

    public static void stackOperation(String operation) {
        String[] o = operation.split(" ");
        if (o[0].equals("push")) {
            int num = Integer.parseInt(o[1]);
            stack.push(num);
        } else {
            int res;
            switch (o[0]) {
                case "pop":
                    res = stack.isEmpty()? -1 : stack.pop();
                    sb.append(res).append("\n");
                    break;

                case "size":
                    res = stack.size();
                    sb.append(res).append("\n");
                    break;

                case "empty":
                    res = stack.isEmpty()? 1 : 0;
                    sb.append(res).append("\n");
                    break;

                default:
                    res = stack.isEmpty()? -1 : stack.peek();
                    sb.append(res).append("\n");
                    break;
            }
        }
    }
}