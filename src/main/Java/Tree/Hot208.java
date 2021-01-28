package Tree;

/**
 * 前缀树，只要没有相同的前缀，每次都开辟一个26个字母的数组
 */
public class Hot208 {
        TreeNode node;

        /**
         * Initialize your data structure here.
         */
        public Hot208() {
            node = new TreeNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            for (int i = 0; i < word.length(); i++) {
                char index = word.charAt(i);
                if (node.next[index - 'a'] == null) {
                    node.next[index - 'a'] = new TreeNode();
                }
                node = node.next[index - 'a'];
            }
            node.is_Word = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            for (int i = 0; i < word.length(); i++) {
                char index = word.charAt(i);
                if (node.next[index - 'a'] == null) {
                    return false;
                }
                node = node.next[index - 'a'];
            }
            return node.is_Word;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            for (int i = 0; i < prefix.length(); i++) {
                char index = prefix.charAt(i);
                if (node.next[index - 'a'] == null) {
                    return false;
                }
                node = node.next[index - 'a'];
            }
            return true;
        }

}

/**
 * 相当于next域是一个26个字母的数组
 */
class TreeNode {
    boolean is_Word = false;
    TreeNode[] next = new TreeNode[26];
}