import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (!max_pq.isEmpty()) sb.append(max_pq.poll()).append("\n");
                else sb.append(-1).append("\n");
            } else {
                while (a-- > 0) {
                    int present = Integer.parseInt(st.nextToken());
                    max_pq.offer(present);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}