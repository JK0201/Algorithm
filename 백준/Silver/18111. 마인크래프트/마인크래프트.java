import java.io.*;
import java.util.*;

public class Main {
    static int[] level = new int[257];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());

        int min_height = Integer.MAX_VALUE;
        int max_height = Integer.MIN_VALUE;

        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < col; c++) {
                int cur_level = Integer.parseInt(st.nextToken());
                if (min_height > cur_level) min_height = cur_level;
                if (max_height < cur_level) max_height = cur_level;
                level[cur_level] += 1;
            }
        }

        int req_time = Integer.MAX_VALUE;
        int req_height = 0;

        for (int target_h = min_height; target_h <= max_height; target_h++) {
            int cur_time = 0;
            int req_block = 0;
            int inventory = block;

            for (int cur_level = 0; cur_level <= 256; cur_level++) {
                if (level[cur_level] > 0) {
                    if (cur_level > target_h) {
                        cur_time += (cur_level - target_h) * level[cur_level] * 2;
                        inventory += (cur_level - target_h) * level[cur_level];
                    } else if (target_h > cur_level) {
                        cur_time += (target_h - cur_level) * level[cur_level];
                        req_block += (target_h - cur_level) * level[cur_level];
                    }
                }
            }

            if (req_block <= inventory) {
                if (cur_time < req_time) {
                    req_time = cur_time;
                    req_height = target_h;
                }

                if (cur_time == req_time && req_height < target_h) {
                    req_height = target_h;
                }
            }
        }

        sb.append(req_time).append(' ').append(req_height);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}