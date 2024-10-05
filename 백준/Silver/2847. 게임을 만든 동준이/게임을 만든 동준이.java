import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] level = new int[n];
        for (int i = 0; i < n; i++) level[i] = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = n-1; i > 0; i--) {
            if (level[i] <= level[i-1]) {
                int adjust_level = level[i] - 1;
                count += level[i-1] - adjust_level;
                level[i-1] = adjust_level;
            }
        }

        System.out.println(count);
        br.close();
    }
}