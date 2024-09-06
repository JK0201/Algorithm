import java.io.*;
import java.util.*;

public class Main {
    static HashSet<String> stringSet = new HashSet<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase = br.readLine();
        int len = testCase.length();

        for (int i = 0; i < len; i++) {
            int l = 0;
            int r = i + 1;

            while (r <= len) {
                String words = testCase.substring(l, r);
                stringSet.add(words);
                l++;
                r++;
            }
        }

        System.out.println(stringSet.size());
    }
}