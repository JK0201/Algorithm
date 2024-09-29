import java.io.*;
import java.util.*;

public class Main {
    static int row = 10;
    static int col = 10;
    static char[][] grid = new char[row][col];
    static boolean[][] visited = new boolean[row][col];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int r = 0; r < row; r++) {
            char[] input = br.readLine().toCharArray();
            grid[r] = input;
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 'B' && !visited[r][c]) {
                    bfs(r, c);
                }
            }
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
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];
            int cur_count = cur[2];

            if (grid[cur_r][cur_c] == 'L') {
                sb.append(cur_count - 1);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int next_r = cur_r + dr[i];
                int next_c = cur_c + dc[i];

                if (gridCheck(next_r, next_c)) {
                    if (grid[next_r][next_c] != 'R' && !visited[next_r][next_c]) {
                        visited[next_r][next_c] = true;
                        q.offer(new int[]{next_r, next_c, cur_count + 1});
                    }
                }
            }
        }
    }

    static boolean gridCheck(int next_r, int next_c) {
        return (next_r >= 0 && next_r < row) && (next_c >= 0 && next_c < col);
    }
}