/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
class MaxDepth {
  public int maxDepth(TreeNode root) {
    // 回归条件 节点为空
    // 定义空节点高度为 0
    if (root == null) {
      return 0;
    } else {
      int leftHeight = maxDepth(root.left);
      int rightHeight = maxDepth(root.right);
      // 非空节点高度为左右子节点高度最大值加 1
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
// @lc code=end
