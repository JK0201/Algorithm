import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int init_hammer = Integer.parseInt(st.nextToken());
        int hammer = init_hammer;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int giant = Integer.parseInt(st.nextToken());
            max_pq.offer(giant);
        }

        while (hammer != 0) {
            int giant = max_pq.peek();
            boolean height_check = centi > giant || giant == 1;

            if (height_check) break;
            else {
                int cur_giant = max_pq.poll();
                max_pq.offer(cur_giant / 2);
                hammer--;
            }
        }

        if (centi > max_pq.peek()) sb.append("YES").append("\n").append(init_hammer - hammer);
        else sb.append("NO").append("\n").append(max_pq.peek());

        System.out.println(sb);
        br.close();
    }
}