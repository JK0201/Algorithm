import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<CharOrder> q = new ArrayDeque<>();

        int order = 0;
        while (n-- > 0) {
            String command = br.readLine();
            char operation = command.charAt(0);

            char cur_char;
            switch (operation) {
                case '1':
                    cur_char = command.charAt(2);
                    q.offerLast(new CharOrder(cur_char, order));
                    order++;
                    break;

                case '2':
                    cur_char = command.charAt(2);
                    q.offerFirst(new CharOrder(cur_char, order));
                    order++;
                    break;

                default:
                    if (!q.isEmpty()) {
                        int first_order = q.peekFirst().getOrder();
                        int last_order = q.peekLast().getOrder();

                        if (first_order > last_order) {
                            q.pollFirst();
                        } else {
                            q.pollLast();
                        }
                    }
                    break;
            }
        }

        if (!q.isEmpty()) {
            for(CharOrder c : q) {
                sb.append(c.getWord());
            }
        } else {
            sb.append('0');
        }
        System.out.println(sb);
    }

    static class CharOrder {
        private char word;
        private int order;

        public CharOrder(char word, int order) {
            this.word = word;
            this.order = order;
        }

        public char getWord() {
            return this.word;
        }

        public int getOrder() {
            return this.order;
        }
    }
}