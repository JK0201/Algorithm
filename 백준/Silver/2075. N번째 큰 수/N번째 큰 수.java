import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (pq.size() < n) {
                    pq.offer(num);
                } else if (pq.peek() < num){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        System.out.println(pq.peek());
        br.close();
    }
}