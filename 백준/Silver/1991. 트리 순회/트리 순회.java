import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map <Character, TreeNode> nodes = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (!nodes.containsKey(root)) nodes.put(root, new TreeNode(root));
            TreeNode root_node = nodes.get(root);

            if (left != '.' && !nodes.containsKey(left)) nodes.put(left, new TreeNode(left));
            root_node.left = nodes.get(left);

            if (right != '.' && !nodes.containsKey(right)) nodes.put(right, new TreeNode(right));
            root_node.right = nodes.get(right);
        }

        TreeNode root = nodes.get('A');
        pre_order(root);
        sb.append("\n");

        in_order(root);
        sb.append("\n");

        post_order(root);

        System.out.println(sb);
        br.close();
    }

    static void pre_order(TreeNode root) {
        if (root == null) return;

        sb.append(root.value);
        pre_order(root.left);
        pre_order(root.right);
    }

    static void in_order(TreeNode root) {
        if (root == null) return;

        in_order(root.left);
        sb.append(root.value);
        in_order(root.right);
    }

    static void post_order(TreeNode root) {
        if (root == null) return;

        post_order(root.left);
        post_order(root.right);
        sb.append(root.value);
    }

    static class TreeNode {
        char value;
        TreeNode left;
        TreeNode right;

        TreeNode(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}