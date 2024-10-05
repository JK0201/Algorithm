import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = dp(n);

        System.out.println(res);
        br.close();
    }

    static int dp(int coins) {
        if (coins < 0) return -1;
        if (coins == 0) {
            return 0;
        }

        if (!memo.containsKey(coins)) {
            int cnt5 = dp(coins - 5);
            int cnt2 = dp(coins - 2);

            if (cnt5 == -1 && cnt2 == -1) memo.put(coins, -1);
            else if (cnt5 == -1) memo.put(coins, cnt2 + 1);
            else if (cnt2 == -1) memo.put(coins, cnt5 + 1);
            else memo.put(coins, Math.min(cnt5, cnt2) + 1);
        }

        return memo.get(coins);
    }
}