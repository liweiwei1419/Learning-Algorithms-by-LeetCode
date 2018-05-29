import java.util.HashMap;

// https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
// 前缀树的实现其实很简单，不要畏难
public class Trie {

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    private class Node {
        private boolean isWord;
        private HashMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node currNode = root;
        Character currC;
        for (int i = 0; i < word.length(); i++) {
            currC = word.charAt(i);
            if (currNode.next.get(currC) == null) {
                currNode.next.put(currC, new Node());
            }
            currNode = currNode.next.get(currC);
        }
        if (!currNode.isWord) {
            currNode.isWord = true;
            size++;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node currNode = root;
        Character currC;
        for (int i = 0; i < word.length(); i++) {
            currC = word.charAt(i);
            if (currNode.next.get(currC) == null) {
                return false;
            }
            currNode = currNode.next.get(currC);
        }
        return currNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node currNode = root;
        Character currC;
        for (int i = 0; i < prefix.length(); i++) {
            currC = prefix.charAt(i);
            if (currNode.next.get(currC) == null) {
                return false;
            }
            currNode = currNode.next.get(currC);
        }
        return true;
    }

    public static void main(String[] args) {
        // Your Trie object will be instantiated and called as such:
//        Trie obj = new Trie();
//        String word = "hello";
//        obj.insert(word);
//        boolean param_2 = obj.search(word);
//        System.out.println(param_2);
//
//        String prefix = "hel";
//        boolean param_3 = obj.startsWith(prefix);
//        System.out.println(param_3);

        Trie trie = new Trie();
        trie.insert("abc");
        boolean search = trie.search("abc");
        System.out.println(search);
        boolean abc = trie.search("ab");
        System.out.println(abc);

        trie.insert("ab");

        boolean ab = trie.search("ab");
        System.out.println(ab);
    }
}
