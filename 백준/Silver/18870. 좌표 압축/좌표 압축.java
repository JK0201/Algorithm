import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted_nums = Arrays.stream(nums).sorted().toArray();

        Map<Integer, Integer> memo = new HashMap<>();
        int rank = 0;
        for (int num : sorted_nums) {
            if (!memo.containsKey(num)) memo.put(num, rank++);
        }

        for (int num: nums) {
            sb.append(memo.get(num)).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}