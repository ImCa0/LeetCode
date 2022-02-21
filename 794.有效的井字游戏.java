/*
 * @lc app=leetcode.cn id=794 lang=java
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
class ValidTicTacToe {
  public boolean validTicTacToe(String[] board) {
    int x = 0, o = 0;
    char[][] grid = new char[3][3];
    for (int i = 0; i < 3; i++) {
      grid[i] = board[i].toCharArray();
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        x = grid[i][j] == 'X' ? x + 1 : x;
        o = grid[i][j] == 'O' ? o + 1 : o;
      }
    }
    if (x != o && x != o + 1) {
      return false;
    } else if (isWin(grid, 'X') && x != o + 1) {
      return false;
    } else if (isWin(grid, 'O') && x != o) {
      return false;
    } else {
      return true;
    }
  }

  boolean isWin(char[][] grid, char player) {
    for (int i = 0; i < 3; i++) {
      if (player == grid[i][0] && player == grid[i][1] && player == grid[i][2]) {
        return true;
      }
      if (player == grid[0][i] && player == grid[1][i] && player == grid[2][i]) {
        return true;
      }
    }
    if (player == grid[0][0] && player == grid[1][1] && player == grid[2][2]) {
      return true;
    }
    if (player == grid[0][2] && player == grid[1][1] && player == grid[2][0]) {
      return true;
    }
    return false;
  }
}
// @lc code=end
