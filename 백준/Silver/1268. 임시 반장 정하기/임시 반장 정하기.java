import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> table = new HashMap<>();
    static Map<Integer, Set<Integer>> res = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int std = Integer.parseInt(br.readLine());

        for (int i = 1; i < std + 1; i++) table.put(i, new ArrayList<>());

        for (int i = 1; i < std + 1; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                table.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < std + 1; i++) {
            List<Integer> cur_std = table.get(i);
            res.put(i, new HashSet<>());

            for (int j = 1; j < std + 1; j++) {
                if (i == j) continue;
                List<Integer> other_std = table.get(j);

                for (int k = 0; k < 5; k++) {
                    int cur_grade = cur_std.get(k);
                    int other_grade = other_std.get(k);

                    if(cur_grade == other_grade) {
                        res.get(i).add(j);
                    }
                }
            }
        }

        int max_len = Integer.MIN_VALUE;
        int target = 0;
        for (int i = 1; i < std + 1; i++) {
            int size = res.get(i).size();

            if (size > max_len) {
                max_len = size;
                target = i;
            } else if (size == max_len && target > i) {
                target = i;
            }
        }

        System.out.println(target);
        br.close();
    }
}