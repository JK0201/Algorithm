import java.io.*;
import java.util.*;

public class Main {
    static TreeNode root;
    static int a;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        createTree();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int res = post_order(root).value;
            sb.append(res * 10).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static TreeNode post_order(TreeNode cur_node) {
        if (cur_node == null) return null;

        TreeNode left = post_order(cur_node.left);
        TreeNode right = post_order(cur_node.right);

        if (cur_node.value == a || cur_node.value == b) return cur_node;
        if (left != null && right != null) return cur_node;
        return (left != null)? left : right;
    }

    static void createTree() {
        Queue<TreeNode> q = new LinkedList<>();
        int[] nums = new int[1023];
        for (int i = 0; i < 1023; i++) nums[i] = i + 1;

        root = new TreeNode(nums[0]);
        q.offer(root);
        int i = 1;

        while (!q.isEmpty()) {
            TreeNode cur_node = q.poll();

            if(i < nums.length) {
                cur_node.left = new TreeNode(nums[i]);
                q.offer(cur_node.left);
                i++;

                cur_node.right = new TreeNode(nums[i]);
                q.offer(cur_node.right);
                i++;
            }
        }
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}