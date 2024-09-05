import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, String> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            System.out.println(topDown(n));
        }

        br.close();
    }

    static String topDown(int n) {
        if (n == 0) {
            return "-";
        }

        if (n == 1) {
            return "- -";
        }

        if (!memo.containsKey(n)) {
            StringBuilder sb = new StringBuilder();
            sb.append(topDown(n-1));
            sb.append((" ").repeat((int) Math.pow(3, n-1)));
            sb.append(topDown(n-1));
            memo.put(n, sb.toString());
        }

        return memo.get(n);
    }
}
