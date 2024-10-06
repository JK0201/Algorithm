import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Map<Integer, List<Integer>> grid = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n + 1; i++) grid.put(i, new ArrayList<>());

        while (true) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if (v1 == -1 && v2 == -1) break;

            grid.get(v1).add(v2);
            grid.get(v2).add(v1);
        }

        int min_score = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            int cur_score = bfs(i);

            if (min_score > cur_score) min_score = cur_score;

            List<Integer> member_list = res.getOrDefault(cur_score, new ArrayList<>());
            member_list.add(i);
            res.put(cur_score, member_list);
        }

        List<Integer> president = res.get(min_score);
        sb.append(min_score).append(' ').append(president.size()).append('\n');

        for (int p : president) {
            sb.append(p).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int start_v) {
        Queue<int[]> q = new LinkedList<>();
        Map<Integer, Integer> costs = new HashMap<>();
        q.offer(new int[]{0, start_v});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_cost = cur[0];
            int cur_v = cur[1];

            if (!costs.containsKey(cur_v)) {
                costs.put(cur_v, cur_cost);

                for (int next_v : grid.get(cur_v)) {
                    q.offer(new int[]{cur_cost + 1, next_v});
                }
            }
        }

        return Collections.max(costs.values());
    }
}