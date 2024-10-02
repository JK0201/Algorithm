import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] words1;
        char[] words2;

        words1 = br.readLine().toCharArray();
        words2 = br.readLine().toCharArray();

        if ((words1[0] != words2[0]) || (words1[n-1] != words2[n-1])) {
            System.out.println("NO");
            br.close();
            return;
        }

        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count1.put(words1[i], count1.getOrDefault(words1[i], 0) + 1);
            count2.put(words2[i], count2.getOrDefault(words2[i], 0) + 1);
        }

        if (!count1.equals(count2)) {
            System.out.println("NO");
            br.close();
            return;
        }

        String vowels = "aiuoe";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (vowels.indexOf(words1[i]) == -1) sb1.append(words1[i]);
            if (vowels.indexOf(words2[i]) == -1) sb2.append(words2[i]);
        }

        if (sb1.toString().equals(sb2.toString())) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }
}