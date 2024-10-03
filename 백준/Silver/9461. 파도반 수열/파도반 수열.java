import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp(num)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long dp(int num) {
        if (num == 0) return 0L;
        if (num == 1 || num == 2) return 1L;

        if (!memo.containsKey(num)) {
            memo.put(num, dp(num - 2) + dp(num - 3));
        }

        return memo.get(num);
    }
}