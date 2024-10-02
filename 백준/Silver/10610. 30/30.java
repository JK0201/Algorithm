import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = br.readLine();

        if (!n.contains("0")) {
            System.out.println("-1");
            return;
        }

        List<String> nums = new ArrayList<>();
        int sum = 0;
        for(String num : n.split("")) {
            nums.add(num);
            sum += Integer.parseInt(num);
        }

        if (sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        nums.sort(Comparator.reverseOrder());
        for(String num : nums) {
            sb.append(num);
        }

        System.out.println(sb.toString());
        br.close();
    }
}