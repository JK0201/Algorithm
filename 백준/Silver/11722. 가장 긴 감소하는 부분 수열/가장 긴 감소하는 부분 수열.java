import java.io.*;
import java.util.*;

public class Main {
    static int a;
    static int[] nums;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        a = Integer.parseInt(br.readLine());
        nums = new int[a];
        memo = new int[a];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            memo[i] = 1;
        }

        dp();
        int max_len = Arrays.stream(memo).max().orElse(1);
        System.out.println(max_len);
        br.close();
    }

    static void dp() {
        for (int i = 0; i < a; i++) {
            for (int j = i + 1; j < a; j++) {
                if (nums[i] > nums[j]){
                    memo[j] = Math.max(memo[j], memo[i] + 1);
                }
            }
        }
    }
}