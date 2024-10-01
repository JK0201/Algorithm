import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
        br.close();
    }

    static int bfs(int start_v, int target_v) {
        Queue<int[]> q = new LinkedList<>();
        int min_cost = 0;
        visited[start_v] = true;
        q.offer(new int[]{0, start_v});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_cost = cur[0];
            int cur_v = cur[1];

            if (cur_v == target_v) {
                min_cost = cur_cost;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int next_v;

                if (i == 0) next_v = cur_v + 1;
                else if (i == 1) next_v = cur_v - 1;
                else next_v = cur_v * 2;

                if (next_v >= 0 && next_v <= 100000 && !visited[next_v]) {
                    visited[next_v] = true;
                    q.offer(new int[]{cur_cost + 1, next_v});
                }
            }
        }

        return min_cost;
    }
}