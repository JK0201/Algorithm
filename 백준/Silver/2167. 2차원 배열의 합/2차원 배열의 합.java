import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] grid = new int[row][col];

        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < col; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < k; idx++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for (int r = i; r <= x; r++) {
                for (int c = j; c <= y; c++) {
                    sum += grid[r][c];
                }
            }
            System.out.println(sum);
        }
    }
}