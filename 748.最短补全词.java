import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=748 lang=java
 *
 * [748] 最短补全词
 */

// @lc code=start
class ShortestCompletingWord {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < licensePlate.length(); i++) {
      char ch = Character.toLowerCase(licensePlate.charAt(i));
      if ('a' <= ch && ch <= 'z') {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
    }
    int[] length = new int[words.length];
    for (int i = 0; i < length.length; i++) {
      length[i] = isCompletingWord(map, words[i]);
    }
    String completingWord = "00000000000000000000";
    for (int i = 0; i < length.length; i++) {
      if (length[i] > 0 && length[i] < completingWord.length()) {
        completingWord = words[i];
      }
    }
    return completingWord;
  }

  int isCompletingWord(Map<Character, Integer> map, String word) {
    Map<Character, Integer> test = new HashMap<>();
    test.putAll(map);
    for (int i = 0; i < word.length(); i++) {
      char ch = Character.toLowerCase(word.charAt(i));
      if (test.containsKey(ch)) {
        test.put(ch, test.get(ch) - 1);
      }
    }
    for (char ch : test.keySet()) {
      if (test.get(ch) > 0) {
        return -1;
      }
    }
    return word.length();
  }
}
// @lc code=end
