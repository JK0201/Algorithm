import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nums;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        memo = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            memo[i] = num;
        }
        dp();
        int max_sum = Integer.MIN_VALUE;
        for (int num : memo) {
            max_sum = Math.max(max_sum, num);
        }

        System.out.println(max_sum);
        br.close();
    }

    static void dp() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    memo[j] = Math.max(memo[j], memo[i] + nums[j]);
                }
            }
        }
    }
}