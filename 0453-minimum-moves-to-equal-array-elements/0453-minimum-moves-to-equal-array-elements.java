
class Solution {
    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;

        // Find the minimum element.
        for (int num : nums) {
            min = Math.min(min, num);
        }

        // Calculate total difference.
        int moves = 0;

        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}