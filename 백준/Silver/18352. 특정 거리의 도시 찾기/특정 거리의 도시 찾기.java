import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> costs = new HashMap<>();
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = atoi(st.nextToken());
        int m = atoi(st.nextToken());
        int k = atoi(st.nextToken());
        int x = atoi(st.nextToken());

        for (int i = 1; i < n + 1; i++) graph.put(i, new ArrayList<>());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int city = atoi(st.nextToken());
            int road = atoi(st.nextToken());
            graph.get(city).add(road);
        }
        bfs(0, x);

        for (int i = 1; i < n + 1; i++) if (costs.containsKey(i) && costs.get(i) == k) sb.append(i).append('\n');
        if (sb.length() == 0) sb.append(-1);
        else sb.deleteCharAt(sb.length() - 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int init_cost, int init_v) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        pq.offer(new int[] {init_cost, init_v});
        costs.put(init_v, init_cost);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_cost = cur[0];
            int cur_v = cur[1];

            if (!costs.containsKey(cur_v)) costs.put(cur_v, cur_cost);

            for (int next_v : graph.get(cur_v)) {
                if (!costs.containsKey(next_v)) {
                    pq.offer(new int[] {cur_cost + 1, next_v});
                }
            }
        }
    }

    static int atoi(String str) {
        return Integer.parseInt(str);
    }
}