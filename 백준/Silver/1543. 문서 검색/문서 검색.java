import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Character> q = new LinkedList<>();
        char[] document = br.readLine().toCharArray();
        char[] words = br.readLine().toCharArray();

        for (char i : document) {
            q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            if (q.size() < words.length) break;
            boolean flag = true;

            Queue<Character> temp_q = new LinkedList<>(q);
            for (int i = 0; i < words.length; i++) {
                if (temp_q.peek() == words[i]) temp_q.poll();
                else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
                for (int i = 0; i < words.length; i++) q.poll();
            } else q.poll();
        }

        System.out.println(count);
        br.close();
    }
}