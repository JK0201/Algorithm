import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        while (test_case-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Applicants> pq = new PriorityQueue<>(Comparator.comparing(applicants -> applicants.test));
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int test = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                pq.offer(new Applicants(test, interview));
            }

            int interview_rank = pq.poll().interview;
            int res = 1;
            while (!pq.isEmpty()) {
                Applicants applicant = pq.poll();
                if (applicant.interview < interview_rank) {
                    interview_rank = applicant.interview;
                    res++;
                }
            }

            sb.append(res).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
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