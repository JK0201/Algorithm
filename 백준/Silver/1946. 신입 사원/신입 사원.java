import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        while (test_case-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Applicants> pq = new PriorityQueue<>(Comparator.comparingInt(applicant -> applicant.test));

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int test = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                pq.offer(new Applicants(test, interview));
            }

            int target_rank = pq.poll().interview;
            int count = 1;
            while (!pq.isEmpty()) {
                int cur_rank = pq.poll().interview;
                if (cur_rank < target_rank) {
                    target_rank = cur_rank;
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Applicants {
        int test;
        int interview;

        public Applicants(int test, int interview) {
            this.test = test;
            this.interview = interview;
        }
    }
}