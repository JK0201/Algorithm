import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println("10");
            return;
        }

        int time = 1;
        while (true) {
            if ((n - Math.pow(2, time)) == 0) {
                break;
            } else if((n - Math.pow(2, time) < 0)) {
                time -= 1;
                break;
            }
            time++;
        }

        System.out.println(time + 10);
        br.close();
    }
}