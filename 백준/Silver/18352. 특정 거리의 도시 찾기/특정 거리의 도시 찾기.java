import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Integer> costs = new HashMap<>();
    static boolean[] visited;

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
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) graph.put(i, new ArrayList<>());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int city = atoi(st.nextToken());
            int road = atoi(st.nextToken());
            graph.get(city).add(road);
        }

        bfs(0, x);

        for (int i = 1; i < n + 1; i++) if (costs.containsKey(i) && costs.get(i) == k) sb.append(i).append('\n');
        if (sb.length() == 0) sb.append("-1");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int init_cost, int init_v) {
        Queue<int[]> q = new LinkedList<>();
        visited[init_v] = true;
        costs.put(init_v, init_cost);
        q.offer(new int[] {init_cost, init_v});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_cost = cur[0];
            int cur_v = cur[1];

            for (int next_v : graph.get(cur_v)) {
                if (!visited[next_v]) {
                    visited[next_v] = true;
                    costs.put(next_v, cur_cost + 1);
                    q.offer(new int[] {cur_cost + 1, next_v});
                }
            }
        }
    }

    static int atoi(String str) {
        return Integer.parseInt(str);
    }
}