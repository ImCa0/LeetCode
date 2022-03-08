import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class FindMedianSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int mid = (n + m) / 2;
    int i = 0, j = 0;
    List<Integer> ls = new ArrayList<>();
    while (i < n && j < m) {
      if (nums1[i] < nums2[j]) {
        ls.add(nums1[i]);
        i++;
      } else {
        ls.add(nums2[j]);
        j++;
      }
    }
    while (i < n) {
      ls.add(nums1[i]);
      i++;
    }
    while (j < m) {
      ls.add(nums2[j]);
      j++;
    }
    if ((n + m) % 2 != 0) {
      return ls.get(mid);
    } else {
      return (ls.get(mid) + ls.get(mid - 1)) / 2.0;
    }
  }
}
// @lc code=end
