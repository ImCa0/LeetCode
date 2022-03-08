import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {
  boolean isInteger();

  Integer getInteger();

  List<NestedInteger> getList();
}
/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
// /**
// * // This is the interface that allows for creating nested lists.
// * // You should not implement it, or speculate about its implementation
// * public interface NestedInteger {
// *
// * // @return true if this NestedInteger holds a single integer, rather than a
// * nested list.
// * public boolean isInteger();
// *
// * // @return the single integer that this NestedInteger holds, if it holds a
// * single integer
// * // Return null if this NestedInteger holds a nested list
// * public Integer getInteger();
// *
// * // @return the nested list that this NestedInteger holds, if it holds a
// * nested list
// * // Return empty list if this NestedInteger holds a single integer
// * public List<NestedInteger> getList();
// * }
// */

// public class NestedIterator implements Iterator<Integer> {
class NestedIterator implements Iterator<Integer> {

  Deque<Integer> queue = new ArrayDeque<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    dfs(nestedList);
  }

  @Override
  public Integer next() {
    return queue.pollFirst();
  }

  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }

  void dfs(List<NestedInteger> nestedList) {
    for (NestedInteger item : nestedList) {
      if (item.isInteger()) {
        queue.addLast(item.getInteger());
      } else {
        dfs(item.getList());
      }
    }
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end
