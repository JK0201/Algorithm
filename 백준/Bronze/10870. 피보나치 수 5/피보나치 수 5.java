import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] memo;
        System.out.println(fibo(n));
        br.close();
    }

    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        }

        else if (n <= 2) {
            return 1;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, fibo(n-1) + fibo(n-2));
        }

        return memo.get(n);
    }
}