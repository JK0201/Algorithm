import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<int[]>> grid = new HashMap<>();
    static Map<Integer, Integer> costs = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n + 1; i++) grid.put(i, new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            grid.get(v1).add(new int[]{cost, v2});
            grid.get(v2).add(new int[]{cost, v1});
        }

        bfs();
        System.out.println(costs.get(n));
        br.close();
    }

    static void bfs() {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(value -> value[0]));
        pq.offer(new int[]{0, 1});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_cost = cur[0];
            int cur_v = cur[1];

            if (!costs.containsKey(cur_v)) {
                costs.put(cur_v, cur_cost);

                for (int[] next : grid.get(cur_v)) {
                    int next_cost = cur_cost + next[0];
                    int next_v = next[1];
                    pq.offer(new int[]{next_cost, next_v});
                }
            }
        }
    }
}