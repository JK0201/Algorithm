import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] box;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        box = new int[n];
        memo = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            memo[i] = 1;
        }

        dp();
        int max_cnt = Arrays.stream(memo).max().orElse(1);
        System.out.println(max_cnt);
        br.close();
    }

    static void dp() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (box[j] > box[i]) {
                    memo[j] = Math.max(memo[j], memo[i] + 1);
                }
            }
        }
    }
}