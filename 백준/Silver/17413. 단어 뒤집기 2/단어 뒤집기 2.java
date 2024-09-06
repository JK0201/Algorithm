import java.io.*;
import java.util.*;

public class Main {
    static Deque<Character> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine() + "\n";
        char[] words = input.toCharArray();

        for (char t : words) {
            if (t == '<') {
                stringBuilder(true);
                q.offerLast(t);
                continue;
            } else if (t == '>') {
                q.offerLast(t);
                stringBuilder(false);
                continue;
            } else if (t == ' ') {
                if (!q.contains('<')) {
                    stringBuilder(true);
                    sb.append(' ');
                    continue;
                }
            } else if (t == '\n') {
                stringBuilder(true);
            }

            q.offerLast(t);
        }

        System.out.println(sb);
        br.close();
    }

    static void stringBuilder(boolean isLast) {
        while (!q.isEmpty()) {
            if (isLast) {
                sb.append(q.pollLast());
            } else {
                sb.append(q.pollFirst());
            }
        }
    }
}