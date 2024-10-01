import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            br.readLine();

            Queue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) pq.offer(Long.parseLong(st.nextToken()));

            long res = 0;
            while (pq.size() > 1) {
                long first_doc = pq.poll();
                long second_doc = pq.poll();
                long merged_file = first_doc + second_doc;

                res += merged_file;
                pq.offer(merged_file);
            }

            sb.append(res).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}