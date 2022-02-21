import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=897 lang=java
 *
 * [897] 递增顺序搜索树
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
class IncreasingBST {
  public TreeNode increasingBST(TreeNode root) {
    TreeNode father = new TreeNode();
    TreeNode ft = father;
    List<Integer> res = new ArrayList<Integer>();
    bst(res, root);
    for (Integer integer : res) {
      ft.right = new TreeNode(integer);
      ft = ft.right;
    }
    return father.right;
  }

  public void bst(List<Integer> res, TreeNode root) {
    if (root == null) {
      return;
    } else {
      bst(res, root.left);
      res.add(root.val);
      bst(res, root.right);
    }
  }
}
// @lc code=end
