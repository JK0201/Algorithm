import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensor = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sensor[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sensor);

        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = sensor[i + 1] - sensor[i];
        }
        Arrays.sort(dist);

        int res = 0;
        for (int i = 0; i < n - k; i++) res += dist[i];

        System.out.println(res);
        br.close();
    }
}