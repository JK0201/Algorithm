import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int s = 0; s < i; s++) {
                sb.append('*');
            }

            for (int s = 0; s < 2 * (n-i); s++) {
                sb.append(' ');
            }

            for (int s = 0; s < i; s++) {
                sb.append('*');
            }
            sb.append("\n");
        }

        for (int i = n-1; i > 0; i--) {
            for (int s = 0; s < i; s++) {
                sb.append('*');
            }

            for (int s = 0; s < 2 * (n-i); s++) {
                sb.append(' ');
            }

            for (int s = 0; s < i; s++) {
                sb.append('*');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}