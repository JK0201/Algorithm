import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int computers = atoi(br.readLine());
        int edges = atoi(br.readLine());
        visited = new boolean[computers + 1];

        for (int i = 1; i < computers + 1; i++) graph.put(i, new ArrayList<>());
        while (edges-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c1 = atoi(st.nextToken());
            int c2 = atoi(st.nextToken());
            graph.get(c1).add(c2);
            graph.get(c2).add(c1);
        }

        dfs(1);

        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    static void dfs(int cur_v) {
        visited[cur_v] = true;

        for (int next_v : graph.get(cur_v)) {
            if (!visited[next_v]) {
                count++;
                dfs(next_v);
            }
        }
    }

    static int atoi(String str) {
        return Integer.parseInt(str);
    }
}