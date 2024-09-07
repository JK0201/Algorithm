import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            char[] charList = br.readLine().toCharArray();

            if (charList[0] == '.') {
                break;
            }

            if (validParentheses(charList)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static boolean validParentheses(char[] charList) {
        Stack<Character> pv = new Stack<>();
        for (char c : charList) {
            switch (c) {
                case '(':
                    pv.push(')');
                    break;

                case '[':
                    pv.push(']');
                    break;

                default:
                    if (c == ')' || c == ']') {
                        if (pv.isEmpty() || c != pv.pop()) {
                            return false;
                        }
                    }
                    break;
            }
        }

        return pv.isEmpty();
    }
}