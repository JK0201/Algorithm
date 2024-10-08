import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, int[]> board = new HashMap<>();
        boolean[][] status = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }

        int count = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int calls = Integer.parseInt(st.nextToken());
                count++;

                int[] coordinate = board.get(calls);
                int cur_r = coordinate[0];
                int cur_c = coordinate[1];
                status[cur_r][cur_c] = true;

                int bingo = getBingo(status);
                if (bingo >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }

        br.close();
    }

    private static int getBingo(boolean[][] status) {
        int bingo = 0;
        for (int r = 0; r < 5; r++) {
            boolean row_flag = true;
            boolean col_flag = true;

            for (int c = 0; c < 5; c++) {
                if (!status[r][c]) {
                    row_flag = false;
                    break;
                }
            }

            for (int c = 0; c < 5; c++) {
                if (!status[c][r]) {
                    col_flag = false;
                    break;
                }
            }

            if (row_flag) bingo++;
            if (col_flag) bingo++;
        }

        boolean left_cross = true;
        for (int k = 0; k < 5; k++) {
            if (!status[k][k]) {
                left_cross = false;
            }
        }
        if (left_cross) bingo++;

        boolean right_cross = true;
        for (int k = 0; k < 5; k++) {
            if (!status[k][4 - k]) {
                right_cross = false;
            }
        }
        if (right_cross) bingo++;

        return bingo;
    }
}