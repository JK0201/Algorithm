import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                int min_num = min_pq.isEmpty() ? 0 : min_pq.poll();
                sb.append(min_num).append("\n");
            } else {
                min_pq.offer(num);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
