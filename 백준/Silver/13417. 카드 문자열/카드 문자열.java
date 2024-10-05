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
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Deque<Character> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = st.nextToken().charAt(0);

                if (!q.isEmpty()) {
                    if (q.peekFirst() < c) q.offerLast(c);
                    else q.offerFirst(c);
                } else q.offer(c);
            }

            for (char c : q) {
                sb.append(c);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}