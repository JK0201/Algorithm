import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        Deque<Integer> group = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            group.addLast(i);
        }

        int i = 1;
        while (group.size() != 1) {
            int curTarget = group.removeFirst();

            if (i == k) {
                sb.append(curTarget).append(", ");
                i = 1;
            } else {
                group.addLast(curTarget);
                i++;
            }
        }

        sb.append(group.removeFirst()).append('>');

        System.out.println(sb);
    }
}