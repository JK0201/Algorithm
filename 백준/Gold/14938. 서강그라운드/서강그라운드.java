import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static Map<Integer, List<int[]>> graph = new HashMap<>();
    static Map<Integer, Integer> items = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items.put(i, Integer.parseInt(st.nextToken()));
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(v1).add(new int[]{cost, v2});
                graph.get(v2).add(new int[]{cost, v1});
            }
        }

        int max_items = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int total_items = bfs(i);
            if (max_items < total_items) max_items = total_items;
        }

        System.out.println(max_items);
        br.close();
    }

    static int bfs(int start_v) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        Map<Integer, Integer> costs = new HashMap<>();
        pq.offer(new int[]{0, start_v});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_cost = cur[0];
            int cur_v = cur[1];

            if (!costs.containsKey(cur_v)) {
                costs.put(cur_v, cur_cost);

                for (int[] next : graph.get(cur_v)) {
                    int next_cost = cur_cost + next[0];
                    int next_v = next[1];
                    pq.offer(new int[]{next_cost, next_v});
                }
            }
        }

        int total_items = 0;
        for (Map.Entry<Integer, Integer> entry : costs.entrySet()) {
            if (entry.getValue() <= m) total_items += items.get(entry.getKey());
        }

        return total_items;
    }
}