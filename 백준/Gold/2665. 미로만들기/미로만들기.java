import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static Map<List<Integer>, Integer> costs = new HashMap<>();
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
        System.out.println(costs.get(Arrays.asList(n - 1, n - 1)));
        br.close();
    }

    static void bfs() {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value[0]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_count = cur[0];
            int cur_r = cur[1];
            int cur_c = cur[2];
            List<Integer> coordinate = Arrays.asList(cur_r, cur_c);

            if (!costs.containsKey(coordinate)) {
                costs.put(coordinate, cur_count);

                for (int i = 0; i < 4; i++) {
                    int next_r = cur_r + dr[i];
                    int next_c = cur_c + dc[i];

                    if (next_r >= 0 && next_r < n && next_c >= 0 && next_c < n) {
                        int next_count = grid[next_r][next_c] == 0? cur_count + 1 : cur_count;
                        pq.offer(new int[]{next_count, next_r, next_c});
                    }
                }
            }
        }
    }
}