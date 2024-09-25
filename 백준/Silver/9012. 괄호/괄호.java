import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String target = br.readLine();
            System.out.println(vps(target)? "YES":"NO");
        }

        br.close();
    }

    public static boolean vps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}