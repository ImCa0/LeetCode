/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class SolveSudoku {
  boolean[][] row = new boolean[9][9];
  boolean[][] col = new boolean[9][9];
  boolean[][][] cube = new boolean[3][3][9];

  public void solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '1';
          row[i][num] = true;
          col[j][num] = true;
          cube[i / 3][j / 3][num] = true;
        }
      }
    }
    dfs(board, 0, 0);
  }

  boolean dfs(char[][] board, int x, int y) {
    if (y == 9) {
      return dfs(board, x + 1, 0);
    }
    if (x == 9) {
      return true;
    }
    if (board[x][y] != '.') {
      return dfs(board, x, y + 1);
    }
    boolean flag = false;
    for (int i = 0; i < 9; i++) {
      if (!row[x][i] && !col[y][i] && !cube[x / 3][y / 3][i]) {
        flag = true;
        board[x][y] = (char) ('1' + i);
        row[x][i] = col[y][i] = cube[x / 3][y / 3][i] = true;
        if (dfs(board, x, y + 1)) {
          break;
        } else {
          flag = false;
          board[x][y] = '.';
          row[x][i] = col[y][i] = cube[x / 3][y / 3][i] = false;
        }
      }
    }
    return flag;
  }
}
// @lc code=end
