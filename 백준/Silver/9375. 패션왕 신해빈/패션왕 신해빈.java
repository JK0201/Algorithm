import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> clothes = new HashMap<>();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String parts = st.nextToken();
                clothes.put(parts, clothes.getOrDefault(parts, 0) + 1);
            }

            int res = 1;
            for (int count : clothes.values()) res *= count + 1;
            sb.append(res - 1).append("\n");
            clothes.clear();
        }

        System.out.println(sb);
        br.close();
    }
}