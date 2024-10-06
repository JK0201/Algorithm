import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> asc_grid = new HashMap<>();
        Map<Integer, List<Integer>> desc_grid = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            asc_grid.put(i, new ArrayList<>());
            desc_grid.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            asc_grid.get(v1).add(v2);
            desc_grid.get(v2).add(v1);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int taller = bfs(i, asc_grid);
            int smaller = bfs(i, desc_grid);

            if (taller + smaller == n - 1) count++;
        }

        System.out.println(count);
        br.close();
    }

    static int bfs(int start_v, Map<Integer, List<Integer>> grid) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(start_v);
        q.offer(start_v);

        while (!q.isEmpty()) {
            int cur_v = q.poll();

            for (Integer next_v : grid.get(cur_v)) {
                if (!visited.contains(next_v)) {
                    visited.add(next_v);
                    q.offer(next_v);
                }
            }
        }

        return visited.size() - 1;
    }
}