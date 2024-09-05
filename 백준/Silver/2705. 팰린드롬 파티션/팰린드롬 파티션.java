import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(topDown(n));
        }

        br.close();
    }

    static int topDown(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2 || n == 3) {
            return 2;
        }

        if(!memo.containsKey(n)) {
            int result = 1;
            for (int i = 1; i <= n/2; i++) {
                result += topDown(i);
            }
            memo.put(n, result);
        }

        return memo.get(n);
    }
}