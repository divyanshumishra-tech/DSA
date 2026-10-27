import java.util.*;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        Map<Integer, Integer> frequency = new HashMap<>();

        frequency.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            count += frequency.getOrDefault(
                prefixSum - goal, 0
            );

            frequency.put(
                prefixSum,
                frequency.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }
}