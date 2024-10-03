import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Boolean> status = new HashMap<>();
    static int t;
    static int gender;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < t + 1; i++) {
            int cur_status = Integer.parseInt(st.nextToken());
            status.put(i, cur_status == 1);
        }

        int std = Integer.parseInt(br.readLine());
        while (std-- > 0) {
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());

            change_switch();
        }

        for (int i = 1; i < t + 1; i++) {
            boolean cur_status = status.get(i);
            sb.append(cur_status? 1 : 0).append(' ');
            if (i % 20 == 0) sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    static void change_switch() {
        if (gender == 1) {
            for (int i = num; i <= t; i += num) status.put(i, !status.get(i));
        } else {
            int left = num - 1;
            int right = num + 1;

            status.put(num, !status.get(num));

            while (left >= 1 && right <= t) {
                if (status.get(left).equals(status.get(right))) {
                    status.put(left, !status.get(left));
                    status.put(right, !status.get(right));
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
    }
}