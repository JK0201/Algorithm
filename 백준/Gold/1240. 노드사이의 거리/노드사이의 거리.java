import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<int[]>> graph = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = atoi(st.nextToken());
        int m = atoi(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int n1 = atoi(st.nextToken());
                int n2 = atoi(st.nextToken());
                int cost = atoi(st.nextToken());

                graph.get(n1).add(new int[]{cost, n2});
                graph.get(n2).add(new int[]{cost, n1});
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int start_v = atoi(st.nextToken());
                int target_v = atoi(st.nextToken());

                bfs(start_v, target_v);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start_v, int target_v) {
        Queue<int[]> q = new LinkedList<>();
        Map<Integer, Integer> costs = new HashMap<>();
        q.offer(new int[]{0, start_v});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_cost = cur[0];
            int cur_v = cur[1];

            if (!costs.containsKey(cur_v)) {
                costs.put(cur_v, cur_cost);

                if (cur_v == target_v) {
                    sb.append(costs.get(cur_v)).append('\n');
                    break;
                }

                for (int[] next : graph.get(cur_v)) {
                    int next_cost = cur_cost + next[0];
                    int next_v = next[1];
                    q.offer(new int[]{next_cost, next_v});
                }
            }
        }
    }

    static int atoi(String str) {
        return Integer.parseInt(str);
    }
}