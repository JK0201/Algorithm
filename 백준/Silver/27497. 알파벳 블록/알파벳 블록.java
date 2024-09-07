import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Character> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();

        while (n-- > 0) {
            String command = br.readLine();
            char operation = command.charAt(0);

            char cur_char;
            switch (operation) {
                case '1':
                    cur_char = command.charAt(2);
                    q.offerLast(cur_char);
                    s.push(1);
                    break;

                case '2':
                    cur_char = command.charAt(2);
                    q.offerFirst(cur_char);
                    s.push(2);
                    break;

                case '3':
                    if (!q.isEmpty() && !s.isEmpty()) {
                        int del_order = s.pop();
                        if (del_order == 1) {
                            q.pollLast();
                        } else {
                            q.pollFirst();
                        }
                    }
                    break;
            }
        }

        if (!q.isEmpty()) {
            for (char w : q) {
                sb.append(w);
            }
        } else {
            sb.append('0');
        }

        System.out.println(sb);
        br.close();
    }
}