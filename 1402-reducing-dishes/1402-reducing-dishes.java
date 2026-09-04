import java.util.*;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);

        int prefixSum = 0;
        int result = 0;

        // Traverse from largest to smallest
        for (int i = satisfaction.length - 1; i >= 0; i--) {

            prefixSum += satisfaction[i];

            if (prefixSum <= 0) {
                break;
            }

            result += prefixSum;
        }

        return result;
    }
}