import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] grid = new int[9][9];
        int maxVal = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    maxRow = i + 1;
                    maxCol = j + 1;
                }
            }
        }

        System.out.println(maxVal);
        System.out.println(maxRow + " " + maxCol);
    }
}