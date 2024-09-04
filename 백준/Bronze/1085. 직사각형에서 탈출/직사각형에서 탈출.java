import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int minX = (x < w - x) ? x : (w - x);
        int minY = (y < h - y) ? y : (h - y);

        int minDistance = (minX < minY)? minX : minY;

        System.out.println(minDistance);
        sc.close();
    }
}