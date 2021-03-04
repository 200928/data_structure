package Trees.TrieTree;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/3 - 21:09
 * @ Description: Trees.PrefixTree
 * @ Version: 1.0
 */
public class trieTree {

    // 前缀树节点
    static class TrieNode {
        int pass;   // 记录进过了几次
        int end;    // 记录以当前节点为尾的字符串
        TrieNode[] nexts;   // 记录 'a'-'z' 的路径

        public TrieNode() {
            nexts = new TrieNode[26];
        }
    }

    // 前缀树实现
    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int size() {
            return root.pass;
        }

        // 插入一段字符串
        public void insert(String word) {
            if (word == null) {
                return;
            }
            TrieNode node = root;
            node.pass++;
            int index = 0;  // 记录字母
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a'; // a 对应 0, b 对应 1.....
                if (node.nexts[index] == null) {    // 如果未出现过该字母,则创建
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        // 删除一段字符
        public void delete(String word) {
            if (search(word) == 0) {
                return;
            }
            TrieNode node = root;
            node.pass--;
            char[] chars = word.toCharArray();
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                }
                node = node.nexts[index];
            }
            node.end--;
            return;
        }

        // 查询字符在树中出现的次数
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            TrieNode node = root;
            char[] chars = word.toCharArray();
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                // 如果未在树中存在该路径则直接返回 0
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // 所有加入的字符串中，计算有多少个是以 pre 为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            TrieNode node = root;
            char[] chars = pre.toCharArray();
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String string0 = "abc";
        String string1 = "abc";
        String string2 = "acdefg";
        String string3 = "minghuifan";

        trie.insert(string0);
        trie.insert(string1);
        trie.insert(string2);
        trie.insert(string3);

        trie.delete(string1);

        System.out.println(trie.size());
        System.out.println(trie.search("abc"));
    }

}
