import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1797 lang=java
 *
 * [1797] 设计一个验证系统
 */

// @lc code=start
class AuthenticationManager {

  int timeToLive;

  Map<String, Integer> token = new HashMap<>();
  
  public AuthenticationManager(int timeToLive) {
    this.timeToLive = timeToLive;
  }

  public void generate(String tokenId, int currentTime) {
    token.put(tokenId, currentTime + timeToLive);
  }

  public void renew(String tokenId, int currentTime) {
    if (token.getOrDefault(tokenId, 0) > currentTime) {
      token.put(tokenId, currentTime + timeToLive);
    }
  }

  public int countUnexpiredTokens(int currentTime) {
    int count = 0;
    for(int expiredTime : token.values()) {
      if (expiredTime > currentTime) {
        count++;
      }
    }
    return count;
  }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
// @lc code=end
