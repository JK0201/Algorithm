import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String formula = br.readLine();
        String[] split_formula = formula.split("-");

        int result = 0;
        for (String num : split_formula[0].split("\\+")) result += Integer.parseInt(num);

        for (int i = 1; i < split_formula.length; i++) {
            for (String num : split_formula[i].split("\\+")) result -= Integer.parseInt(num);
        }

        System.out.println(result);
        br.close();
    }
}