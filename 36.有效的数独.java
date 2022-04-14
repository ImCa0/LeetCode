/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class IsValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cube = new boolean[3][3][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '1';
          if (row[i][num] || col[j][num] || cube[i / 3][j / 3][num]) {
            return false;
          }
          row[i][num] = true;
          col[j][num] = true;
          cube[i / 3][j / 3][num] = true;
        }
      }
    }
    return true;
  }
}
// @lc code=end
