import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        int a = Integer.parseInt(testCase[0]);
        int b = Integer.parseInt(testCase[1]);
        int result = 0;

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

       st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        for (int num : setA) {
            if (!setB.contains(num)) {
                result++;
            }
        }

        for (int num : setB) {
            if (!setA.contains(num)) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }
}