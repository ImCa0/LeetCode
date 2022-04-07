import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // map: 课程序号: 状态
    // 状态 0: 未学习
    // 状态 1: 正在学习（dfs 递归中）
    // 状态 2: 已学习
    Map<Integer, Integer> status = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      boolean flag = dfs(i, prerequisites, status);
      if (flag == false) {
        return false;
      }
    }
    return true;
  }

  boolean dfs(int num, int[][] prerequisites, Map<Integer, Integer> status) {
    if (status.getOrDefault(num, 0) == 1) {
      return false;
    }
    if (status.getOrDefault(num, 0) == 2) {
      return true;
    }
    status.put(num, 1);
    for (int[] pre : prerequisites) {
      if (pre[0] == num) {
        boolean flag = dfs(pre[1], prerequisites, status);
        if (flag == false) {
          return false;
        }
      }
    }
    status.put(num, 2);
    return true;
  }
}
// @lc code=end
