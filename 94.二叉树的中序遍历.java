import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
class InorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    dfs(root, list);
    return list;
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
