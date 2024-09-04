import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int left = 0;
        int right = 0;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        int cnt = 0;
        int sum = 1;
        while (left <= right) {
            if (sum == n) {
                cnt++;
                sum -= nums[left];
                left++;
            } else if (sum < n) {
                right++;
                sum += nums[right];
            } else {
                sum -= nums[left];
                left++;
            }
        }
        System.out.println(cnt);
    }
}