import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            dequeFn(command);
        }

        System.out.println(sb);
        br.close();
    }

    static void dequeFn(String[] command) {
        int length = command.length;
        String method = command[0];

        if (length == 1) {
            Integer num;
            switch (method) {
                case "front":
                    num = q.peekFirst();
                    if (num != null) {
                        sb.append(num).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "back":
                    num = q.peekLast();
                    if (num != null) {
                        sb.append(num).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "pop_front":
                    num = q.pollFirst();
                    if (num != null) {
                        sb.append(num).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "pop_back":
                    num = q.pollLast();
                    if (num != null) {
                        sb.append(num).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                default:
                    if (q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
            }
            return;
        }

        int num = Integer.parseInt(command[1]);
        if (method.equals("push_back")) {
            q.offerLast(num);
        } else {
            q.offerFirst(num);
        }
    }
}