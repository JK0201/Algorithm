import java.io.*;
import java.util.*;

public class Main {
    static int i;
    static boolean[][] visited;
    static int[][] directions = new int[][]
            {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int target_r;
    static int target_c;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int test_case = atoi(br.readLine());

        while (test_case-- > 0) {
            i = atoi(br.readLine());
            visited = new boolean[i][i];

            st = new StringTokenizer(br.readLine());
            int start_r = atoi(st.nextToken());
            int start_c = atoi(st.nextToken());

            st = new StringTokenizer(br.readLine());
            target_r = atoi(st.nextToken());
            target_c = atoi(st.nextToken());

            bfs(start_r, start_c);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        visited[r][c] = true;
        q.offer(new int[]{r, c, 0});

        while (!q.isEmpty()) {
            int[] cur_node = q.poll();
            int cur_r = cur_node[0];
            int cur_c = cur_node[1];
            int cur_count = cur_node[2];

            if (cur_r == target_r && cur_c == target_c) {
                sb.append(cur_count).append('\n');
                break;
            }

            for (int[] next_node : directions) {
                int dr = next_node[0];
                int dc = next_node[1];

                int next_r = cur_r + dr;
                int next_c = cur_c + dc;

                if (gridCheck(next_r, next_c)) {
                    visited[next_r][next_c] = true;
                    q.offer(new int[]{next_r, next_c, cur_count + 1});
                }
            }
        }
    }

    static boolean gridCheck(int next_r, int next_c) {
        return (next_r >= 0 && next_r < i) && (next_c >= 0 && next_c < i) && (!visited[next_r][next_c]);
    }

    static int atoi(String str) {
        return Integer.parseInt(str);
    }
}