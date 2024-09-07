import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while (n-- > 0) {
            char[] charList = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();
            for(char c : charList) {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}
