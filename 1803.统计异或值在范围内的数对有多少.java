/*
 * @lc app=leetcode.cn id=1803 lang=java
 *
 * [1803] 统计异或值在范围内的数对有多少
 */

// @lc code=start
class MyTrie {
  public MyTrie[] f = new MyTrie[2];
  public int count = 0;

  public static int MAX_DEPTH = 15;

  public static MyTrie build(int[] arr) {
    MyTrie root = new MyTrie();
    root.count = arr.length;
    for (int i = 0; i < arr.length; ++i) {
      MyTrie cur = root;
      for (int j = MAX_DEPTH - 1; j >= 0; --j) {
        int bit = arr[i] >> j & 1;
        if (cur.f[bit] == null)
          cur.f[bit] = new MyTrie();
        cur = cur.f[bit];
        cur.count++;
      }
    }
    return root;
  }

  public static int query(MyTrie root, int element, int limit) {
    MyTrie cur = root;
    int res = 0;
    for (int i = MAX_DEPTH - 1; i >= 0; --i) {
      int ei = element >> i & 1, li = limit >> i & 1;
      if (li == 1) {
        if (cur.f[ei] != null) {
          res += cur.f[ei].count;
        }
        if (cur.f[ei ^ 1] != null) {
          cur = cur.f[ei ^ 1];
        } else {
          break;
        }
      } else {
        if (cur.f[ei] != null) {
          cur = cur.f[ei];
        } else
          break;
      }
    }
    return res;
  }

  public static int solve(MyTrie root, int[] arr, int limit) {
    int ans = 0;
    for (int i = 0; i < arr.length; ++i) {
      ans += query(root, arr[i], limit);
    }
    return ans / 2;
  }
}

class CountPairs {
  public int countPairs(int[] nums, int low, int high) {
    MyTrie root = MyTrie.build(nums);
    return MyTrie.solve(root, nums, high + 1) - MyTrie.solve(root, nums, low);
  }
}
// @lc code=end
