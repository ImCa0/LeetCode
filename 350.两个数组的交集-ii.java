import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Intersect {
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return intersect(nums2, nums1);
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums1) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      } else {
        map.put(i, 1);
      }
    }
    int[] res = new int[nums1.length];
    int i = 0;
    for (int num : nums2) {
      if (map.getOrDefault(num, 0) > 0) {
        res[i] = num;
        map.put(num, map.get(num) - 1);
        i++;
      }
    }
    return Arrays.copyOfRange(res, 0, i);
  }
}
// @lc code=end
