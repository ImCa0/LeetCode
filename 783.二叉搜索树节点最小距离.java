import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树节点最小距离
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class MinDiffInBST {
  public int minDiffInBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    dfs(root, list);
    int min = list.get(1) - list.get(0);
    for (int i = 1; i < list.size(); i++) {
      min = Math.min(min, list.get(i) - list.get(i - 1));
    }
    return min;
  }

  public void dfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    } else {
      dfs(root.left, list);
      list.add(root.val);
      dfs(root.right, list);
    }
  }
}
// @lc code=end
