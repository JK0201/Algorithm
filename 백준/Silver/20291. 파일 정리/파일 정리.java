import java.io.*;
import java.util.*;

public class Main {
    static LinkedHashMap<String, Integer> extSet = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sortedByExt = new String[n];

        for (int i = 0; i < n; i++) {
            sortedByExt[i] = br.readLine().split("\\.")[1];
        }
        
        Arrays.sort(sortedByExt);
        
        for (int i = 0; i < n; i++) {
            if (!extSet.containsKey(sortedByExt[i])) {
                extSet.put(sortedByExt[i], 1);
            } else {
                extSet.put(sortedByExt[i], extSet.get(sortedByExt[i]) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        extSet.forEach((k, v) -> sb.append(k + " " + v + "\n"));
        System.out.println(sb);
    }
}