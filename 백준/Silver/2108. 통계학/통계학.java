import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());

        }

        sb.append(mean()).append('\n');
        sb.append(median()).append('\n');
        sb.append(mode()).append('\n');
        sb.append(range()).append('\n');

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    static int mean() {
        int sum = Arrays.stream(nums).sum();
        return (int) Math.round((double)sum / n);
    }

    static int median() {
        Arrays.sort(nums);
        return nums[n/2];
    }

    static int mode() {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int n : nums) {
            dict.put(n, dict.getOrDefault(n, 0) + 1);
        }

        int max_frequency = Collections.max(dict.values());
        List<Integer> mode_List = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : dict.entrySet()) {
            if (entry.getValue() == max_frequency) mode_List.add(entry.getKey());
        }

        Collections.sort(mode_List);
        if (mode_List.size() > 1) {
            return mode_List.get(1);
        }

        return mode_List.get(0);
    }

    static int range() {
        int min = Arrays.stream(nums).min().orElse(0);
        int max = Arrays.stream(nums).max().orElse(0);
        return (max - min);
    }
}