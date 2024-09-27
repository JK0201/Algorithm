import java.io.*;
import java.util.*;

public class Main {
    static int row = 5;
    static int col = 5;
    static char[][] grid = new char[5][5];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Set<String> combination = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < col; c++) {
                grid[r][c] = st.nextToken().charAt(0);
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                dfs(r, c, 0, "");
            }
        }

        System.out.println(combination.size());
    }

    static void dfs(int cur_r, int cur_c, int count, String str) {
        String newStr = str + grid[cur_r][cur_c];

        if (count == 5) {
            combination.add(newStr);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int next_r = cur_r + dr[i];
            int next_c = cur_c + dc[i];

            if (checkGrid(next_r, next_c)) {
                dfs(next_r, next_c, count + 1, newStr);
            }
        }
    }

    static boolean checkGrid(int next_r, int next_c) {
        return (next_r >= 0 && next_r < row) && (next_c >= 0 && next_c < col);
    }
}