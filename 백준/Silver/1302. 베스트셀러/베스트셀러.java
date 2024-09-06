import java.io.*;
import java.util.*;

public class Main {
    static LinkedHashMap<String, Integer> bookSet = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] title = new String[n];

        for (int i = 0; i < n; i++) {
            title[i] = br.readLine();
        }

        Arrays.sort(title);

        for (int i = 0; i < n; i++) {
            if (!bookSet.containsKey(title[i])) {
                bookSet.put(title[i], 1);
            } else {
                bookSet.put(title[i], bookSet.get(title[i]) + 1);
            }
        }

        int bestSeller = Collections.max(bookSet.values());

        for (Map.Entry<String, Integer> entry : bookSet.entrySet()) {
            if (entry.getValue() == bestSeller) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}