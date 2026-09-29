 import java.util.Arrays;

class Solution {
    public int[] successfulPairs(
            int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int n = potions.length;
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {

            long required =
                (success + spells[i] - 1) / spells[i];

            int low = 0;
            int high = n;

            while (low < high) {

                int mid = low + (high - low) / 2;

                if (potions[mid] >= required) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            ans[i] = n - low;
        }

        return ans;
    }
}