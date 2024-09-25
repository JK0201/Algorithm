import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] testCase = br.readLine().split(" ");
            int m = Integer.parseInt(testCase[0]);
            int target = Integer.parseInt(testCase[1]);

            Deque<Documents> q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.addLast(new Documents(priority, i));
            }

           int count = 0;
           while (!q.isEmpty()) {
               int maxPriority = q.stream().mapToInt(doc -> doc.priority).max().orElse(1);
               Documents curDoc = q.removeFirst();

               if (curDoc.priority == maxPriority) {
                   count++;
                   if (curDoc.idx == target) {
                       sb.append(count).append("\n");
                       break;
                   }
               } else {
                   q.addLast(curDoc);
               }
           }
        }

        System.out.println(sb);
        br.close();
    }

    static class Documents {
        int priority;
        int idx;

        public Documents(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
}