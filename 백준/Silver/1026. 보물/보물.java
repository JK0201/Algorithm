import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a.offer(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) b.offer(Integer.parseInt(st.nextToken()));

        int res = 0;
        while (!a.isEmpty() && !b.isEmpty()) {
            res += a.poll() * b.poll();
        }

        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}