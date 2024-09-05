import java.io.*;
import java.util.*;


public class Main {
    static int recursionCnt = 0;
    static int dpCnt = 0;
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        fibo(n);
        dp(n);

        sb.append(recursionCnt)
                .append(" ")
                .append(dpCnt);

        System.out.println(sb);
        br.close();
    }

    static int fibo(int n) {
        if (n == 1 || n == 2) {
            recursionCnt++;
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    static int dp(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (!memo.containsKey(n)) {
            dpCnt++;
            memo.put(n, dp(n - 1) + dp(n - 2));
        }

        return memo.get(n);
    }
}