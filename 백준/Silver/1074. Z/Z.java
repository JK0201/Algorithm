import java.io.*;
import java.util.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int gridSize = (int) Math.pow(2, n);
        visitedOrder(gridSize / 2, r, c);
        System.out.println(result);
    }

    static void visitedOrder(int n, int r, int c) {
        if (n == 0) {
            return;
        }

        if (n > r && n > c) {
            visitedOrder(n / 2, r, c);
        } else if (n > r && n <= c) {
            result += n * n;
            visitedOrder(n / 2, r, c - n);
        } else if (n <= r && n > c) {
            result += n * n * 2;
            visitedOrder(n / 2, r - n, c);
        } else if (n <= r && n <= c) {
            result += n * n * 3;
            visitedOrder(n / 2, r - n, c - n);
        }
    }
}
