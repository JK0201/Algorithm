import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] n = br.readLine().toCharArray();

        for (char c : n) {
            left.push(c);
        }

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            char[] operation = br.readLine().toCharArray();
            editor(operation);
        }

        for (char c : left) {
            sb.append(c);
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
        br.close();
    }

    public static void editor(char[] o) {
        switch (o[0]) {
            case 'L':
                if (!left.isEmpty()) {
                    char c = left.pop();
                    right.push(c);
                }
                break;

            case 'D':
                if (!right.isEmpty()) {
                    char c = right.pop();
                    left.push(c);
                }
                break;

            case 'B':
                if (!left.isEmpty()) {
                    left.pop();
                }
                break;

            default:
                left.push(o[2]);
        }
    }
}