import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, Double> dict = new HashMap<>();
        dict.put("A+", 4.5);
        dict.put("A0", 4.0);
        dict.put("B+", 3.5);
        dict.put("B0", 3.0);
        dict.put("C+", 2.5);
        dict.put("C0", 2.0);
        dict.put("D+", 1.5);
        dict.put("D0", 1.0);
        dict.put("F", 0.0);

        double total_degree = 0;
        double total_credit = 0;

        try {
            String input;
            while ((input = br.readLine()) != null) {
                st = new StringTokenizer(input);
                st.nextToken();
                double credit = Double.parseDouble(st.nextToken());
                String degree = st.nextToken();

                if (!degree.equals("P")) {
                    total_degree += (credit * dict.get(degree));
                    total_credit += credit;
                }
            }
        } catch (Exception ex) {
        } finally {
            double res = total_degree / total_credit;
            System.out.println(res);
            br.close();
        }
    }
}