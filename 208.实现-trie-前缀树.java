/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

  private Trie[] children;
  private boolean isEnd;

  public Trie() {
    children = new Trie[26];
    isEnd = false;
  }

  public void insert(String word) {
    Trie root = this;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (root.children[index] == null) {
        root.children[index] = new Trie();
      }
      root = root.children[index];
    }
    root.isEnd = true;
  }

  public boolean search(String word) {
    Trie root = this;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (root.children[index] == null) {
        return false;
      }
      root = root.children[index];
    }
    return root.isEnd;
  }

  public boolean startsWith(String prefix) {
    Trie root = this;
    for (int i = 0; i < prefix.length(); i++) {
      int index = prefix.charAt(i) - 'a';
      if (root.children[index] == null) {
        return false;
      }
      root = root.children[index];
    }
    return root != null;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
