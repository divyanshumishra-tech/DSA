 import java.util.*;

class Solution {
    public List<List<Integer>> queensAttacktheKing(
            int[][] queens, int[] king) {

        boolean[][] board = new boolean[8][8];

        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }

        List<List<Integer>> result = new ArrayList<>();

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        for (int[] dir : directions) {

            int row = king[0] + dir[0];
            int col = king[1] + dir[1];

            while (row >= 0 && row < 8 &&
                   col >= 0 && col < 8) {

                if (board[row][col]) {
                    result.add(Arrays.asList(row, col));
                    break;
                }

                row += dir[0];
                col += dir[1];
            }
        }

        return result;
    }
}