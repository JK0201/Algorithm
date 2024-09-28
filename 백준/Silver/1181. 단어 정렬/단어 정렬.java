import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();
        while (n-- > 0) {
            String input = br.readLine();
            words.add(input);
        }

        words.stream().sorted((a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            else return Integer.compare(a.length(), b.length());
        }).forEach(word -> sb.append(word).append("\n"));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}