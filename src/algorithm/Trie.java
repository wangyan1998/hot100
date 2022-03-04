package algorithm;
//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
//        这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//        请你实现 Trie 类：
//        Trie() 初始化前缀树对象。
//        void insert(String word) 向前缀树中插入字符串 word 。
//        boolean search(String word) 如果字符串 word 在前缀树中，返回 true（
//        即，在检索之前已经插入）；否则，返回 false 。
//        boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前
//        缀之一为 prefix ，返回 true ；否则，返回 false 。
//        1 <= word.length, prefix.length <= 2000
//        word 和 prefix 仅由小写英文字母组成
//        insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次




/**
 * @author wy
 * @date 2022/3/3 9:25
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] == null) {
                node.children[ch] = new Trie();
            }
            node = node.children[ch];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] == null) {
                return false;
            }
            node = node.children[ch];
        }
        return node.isEnd;
    }

    public boolean startWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            if (node.children[ch] == null) {
                return false;
            }
            node = node.children[ch];
        }
        return true;
    }
}
