import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                grid[i][j] = input[j];
            }
        }

        int norm = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs_norm(i, j);
                    norm++;
                }
            }
        }

        visited = new boolean[n][n];
        int blind = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs_blind(i, j);
                    blind++;
                }
            }
        }

        System.out.println(norm + " " + blind);
        br.close();
    }

    static void bfs_norm(int start_r, int start_c) {
        Queue<int[]> q = new LinkedList<>();
        visited[start_r][start_c] = true;
        q.offer(new int[]{start_r, start_c});

        char cur_color = grid[start_r][start_c];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];

            for (int i = 0; i < 4; i++) {
                int next_r = cur_r + dr[i];
                int next_c = cur_c + dc[i];

                if (next_r >= 0 && next_r < n && next_c >= 0 && next_c < n) {
                    if (cur_color == grid[next_r][next_c] && !visited[next_r][next_c]) {
                        visited[next_r][next_c] = true;
                        q.offer(new int[]{next_r, next_c});
                    }
                }
            }
        }
    }

    static void bfs_blind(int start_r, int start_c) {
        Queue<int[]> q = new LinkedList<>();
        visited[start_r][start_c] = true;
        q.offer(new int[]{start_r, start_c});

        char cur_color = grid[start_r][start_c];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];

            for (int i = 0; i < 4; i++) {
                int next_r = cur_r + dr[i];
                int next_c = cur_c + dc[i];

                if (next_r >= 0 && next_r < n && next_c >= 0 && next_c < n) {
                    if (!visited[next_r][next_c]) {
                        if ((cur_color == 'R' || cur_color == 'G') && (grid[next_r][next_c] == 'R' || grid[next_r][next_c] == 'G')) {
                            visited[next_r][next_c] = true;
                            q.offer(new int[]{next_r, next_c});
                        } else if(cur_color == 'B' && grid[next_r][next_c] == 'B') {
                            visited[next_r][next_c] = true;
                            q.offer(new int[]{next_r, next_c});
                        }
                    }
                }
            }
        }
    }
}