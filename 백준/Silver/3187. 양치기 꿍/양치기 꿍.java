import java.io.*;
import java.util.*;

public class Main {
    static int row;
    static int col;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int wolves = 0;
    static int sheep = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        grid = new char[row][col];
        visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            char[] rowInfo = br.readLine().toCharArray();
            for (int c = 0; c < col; c++) {
                grid[r][c] = rowInfo[c];
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if ((grid[r][c] == 'v' || grid[r][c] == 'k') && !visited[r][c]) {
                    bfs(r, c);
                }
            }
        }

        sb.append(sheep).append(" ").append(wolves);
        System.out.println(sb);
        br.close();
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int bfs_wolves = 0;
        int bfs_sheep = 0;

        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];

            if (grid[cur_r][cur_c] == 'v') bfs_wolves++;
            else if (grid[cur_r][cur_c] == 'k') bfs_sheep++;

            for (int i = 0; i < 4; i++) {
                int next_r = cur_r + dr[i];
                int next_c = cur_c + dc[i];

                if (grid[next_r][next_c] != '#' && !visited[next_r][next_c]) {
                    q.offer(new int[] {next_r, next_c});
                    visited[next_r][next_c] = true;
                }
            }
        }

        if (bfs_wolves >= bfs_sheep) wolves += bfs_wolves;
        else sheep += bfs_sheep;
    }
}