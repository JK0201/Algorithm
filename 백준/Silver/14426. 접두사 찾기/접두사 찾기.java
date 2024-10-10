import java.io.*;
import java.util.*;

public class Main{
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Tree tree = new Tree();

        while (n-- > 0) {
            String words = br.readLine();
            tree.add_words(words);
        }

        while (m-- > 0) {
            String words = br.readLine();
            tree.find_prefix(words);
        }

        System.out.println(cnt);
        br.close();
    }

    static class Tree {
        Node root;

        public Tree() {
            this.root = new Node();
        }

        public void add_words(String str) {
            Node cur_node = root;
            for (char c : str.toCharArray()) {
                cur_node.nodes.putIfAbsent(c, new Node());
                cur_node = cur_node.nodes.get(c);
            }
        }

        public void find_prefix(String str) {
            Node cur_node = root;
            for (char c : str.toCharArray()) {
                cur_node = cur_node.nodes.get(c);
                if (cur_node == null) return;
            }

            cnt++;
        }
    }

    static class Node {
        Map<Character, Node> nodes;

        public Node() {
            this.nodes = new HashMap<>();
        }
    }
}