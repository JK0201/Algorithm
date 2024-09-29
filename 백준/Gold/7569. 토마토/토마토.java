import java.io.*;
import java.util.*;

public class Main {
    static int row;
    static int col;
    static int height;
    static int[] dr = new int[]{0, 0, -1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 0, 0, -1, 1};
    static int[] dh = new int[]{-1, 1, 0, 0, 0, 0};
    static int[][][] grid;
    static boolean[][][] visited;
    static int max_day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        grid = new int[height][row][col];
        visited = new boolean[height][row][col];

        Queue<int[]> q = new LinkedList<>();
        boolean bfs_require = false;
        for (int h = 0; h < height; h++) {
            for(int r = 0; r < row; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < col; c++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    grid[h][r][c] = tomato;

                    if (tomato == 1) {
                        visited[h][r][c] = true;
                        q.offer(new int[]{h, r, c, 0});
                    } else if (tomato == 0) bfs_require = true;
                }
            }
        }

        if (!bfs_require) {
            System.out.println("0");
            return;
        }

        bfs(q);

        for (int h = 0; h < height; h++) {
            for(int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (!visited[h][r][c] && grid[h][r][c] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(max_day);
        br.close();
    }

    static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_h = cur[0];
            int cur_r = cur[1];
            int cur_c = cur[2];
            int cur_day = cur[3];

            if (max_day < cur_day) max_day = cur_day;

            for (int i = 0; i < 6; i++) {
                int next_h = cur_h + dh[i];
                int next_r = cur_r + dr[i];
                int next_c = cur_c + dc[i];

                if (gridCheck(next_h, next_r, next_c)) {
                    if (grid[next_h][next_r][next_c] == 0 && !visited[next_h][next_r][next_c]) {
                        visited[next_h][next_r][next_c] = true;
                        q.offer(new int[]{next_h, next_r, next_c, cur_day + 1});
                    }
                }
            }
        }
    }

    static boolean gridCheck(int next_h, int next_r, int next_c) {
        return (next_h >= 0 && next_h < height)
                && (next_r >= 0 && next_r < row)
                && (next_c >= 0 && next_c < col);
    }
}