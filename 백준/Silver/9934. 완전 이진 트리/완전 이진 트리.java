import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        k = (int) Math.pow(2, k) - 1;
        nums = new int[k];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(st.nextToken());

        TreeNode root = add_node(k);
        add_value(root);
        level_order(root);

        System.out.println(sb);
        br.close();
    }

    static void level_order(TreeNode root) {
        Queue<Nodes> q = new LinkedList<>();
        q.offer(new Nodes(root, 0));
        int depth = 0;

        while (!q.isEmpty()) {
            Nodes cur_root = q.poll();
            TreeNode cur_node = cur_root.root;
            int cur_depth = cur_root.depth;

            if (depth != cur_depth) {
                sb.append("\n");
                depth = cur_depth;
            }

            sb.append(cur_node.value).append(" ");

            if (cur_node.left != null) q.offer(new Nodes(cur_node.left, cur_depth + 1));
            if (cur_node.right != null) q.offer(new Nodes(cur_node.right, cur_depth + 1));
        }
    }

    static TreeNode add_node(int k) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode();
        q.offer(root);

        while ((k -= 2) > 0) {
            TreeNode cur_node = q.poll();

            cur_node.left = new TreeNode();
            q.offer(cur_node.left);

            cur_node.right = new TreeNode();
            q.offer(cur_node.right);
        }

        return root;
    }

    static void add_value(TreeNode cur_node) {
        if (cur_node == null) return;

        add_value(cur_node.left);

        cur_node.value = nums[idx];
        idx++;

        add_value(cur_node.right);
    }

    static class Nodes {
        TreeNode root;
        int depth;

        Nodes(TreeNode root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this.value = 0;
            this.left = null;
            this.right = null;
        }
    }
}