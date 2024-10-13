import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Tuple> towers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) towers.add(new Tuple(Integer.parseInt(st.nextToken()), i));

        Stack<Tuple> tower = new Stack<>();
        int[] res = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!tower.isEmpty() && tower.peek().tower < towers.get(i).tower) {
                int idx = tower.pop().idx;
                res[idx] = i + 1;
            }
            tower.push(new Tuple(towers.get(i).tower, i));
        }

        for (int r : res) {
            sb.append(r).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Tuple {
        int tower;
        int idx;

        public Tuple(int tower, int idx) {
            this.tower = tower;
            this.idx = idx;
        }
    }
}