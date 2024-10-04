import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] children;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        children = new int[n];
        memo = new int[n];

        for (int i = 0; i < n; i++) {
            children[i] = Integer.parseInt(br.readLine());
            memo[i] = 1;
        }

        dp();
        int max_len = Arrays.stream(memo).max().orElse(1);
        System.out.println(n - max_len);
        br.close();
    }

    static void dp() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (children[j] > children[i]) {
                    memo[j] = Math.max(memo[j], memo[i] + 1);
                }
            }
        }
    }
}