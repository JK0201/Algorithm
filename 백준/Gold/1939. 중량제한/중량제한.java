import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<int[]>> graph = new HashMap<>();
    static Map<Integer, Integer> costs = new HashMap<>();
    static int target_v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n + 1; i++) graph.put(i, new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(n1).add(new int[]{cost, n2});
            graph.get(n2).add(new int[]{cost, n1});
        }

        st = new StringTokenizer(br.readLine());
        int start_v = Integer.parseInt(st.nextToken());
        target_v = Integer.parseInt(st.nextToken());

        bfs(start_v);
        sb.append(costs.get(target_v));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start_v) {
        Queue<int[]> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(value -> value[0])));
        pq.offer(new int[]{Integer.MAX_VALUE, start_v});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_cost = cur[0];
            int cur_v = cur[1];

            if (!costs.containsKey(cur_v) || costs.get(cur_v) < cur_cost) {
                costs.put(cur_v, cur_cost);
                if (cur_v == target_v) break;

                for (int[] next : graph.get(cur_v)) {
                    int next_cost = Math.min(cur_cost, next[0]);
                    int next_v = next[1];
                    pq.offer(new int[]{next_cost, next_v});
                }
            }
        }
    }
}