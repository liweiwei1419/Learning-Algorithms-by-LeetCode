import java.util.HashMap;
import java.util.Map;

//
public class MapSum {

    private class Node {
        private int val;
        private Map<Character, Node> next;

        public Node(boolean isWord, int val) {
            this.val = val;
            this.next = new HashMap<>();
        }

        public Node() {
            this(false, 0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node currNode = root;
        Character c;
        for (int i = 0; i < key.length(); i++) {
            c = key.charAt(i);
            if (currNode.next.get(c) == null) {
                currNode.next.put(c, new Node());
            }
            currNode = currNode.next.get(c);
        }
        currNode.val = val;
    }

    public int sum(String prefix) {
        Node node = root;
        Character c;
        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (node.next.get(c) == null) {
                return 0;
            }
            node = node.next.get(c);
        }
        return find(node);
    }

    // node 为 root 的 val 的和
    // 我把问题想复杂了
    private int find(Node node) {
        // 很关键，起始点不是 0
        int sum = node.val;
        for (Character c : node.next.keySet()) {
            sum += find(node.next.get(c));
        }
        return sum;
    }

    public static void main(String[] args) {
        // write your code here
        MapSum mapSum = new MapSum();

        mapSum.insert("apple", 3);
        int sum1 = mapSum.sum("ap");// Output: 3

        System.out.println(sum1);
        mapSum.insert("app", 2); //Output: Null
        int sum2 = mapSum.sum("ap");//Output: 5
        System.out.println(sum2);
    }
}
