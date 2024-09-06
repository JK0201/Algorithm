import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int towerA = 1;
        int towerB = 2;
        int towerC = 3;
        towerOfHanoi(n, towerA, towerB, towerC);
        System.out.println(count);
        System.out.println(sb);
    }

    static void towerOfHanoi(int n, int towerA, int towerB, int towerC) {
        count++;
        if (n == 1) {
            sb.append(towerA).append(" ").append(towerC).append("\n");
            return;
        }

        towerOfHanoi(n-1, towerA, towerC, towerB);
        sb.append(towerA).append(" ").append(towerC).append("\n");

        towerOfHanoi(n-1, towerB, towerA, towerC);
    }
}
