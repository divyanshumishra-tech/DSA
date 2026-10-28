import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();

        frequency.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            int remainder = ((prefixSum % k) + k) % k;

            count += frequency.getOrDefault(remainder, 0);

            frequency.put(
                remainder,
                frequency.getOrDefault(remainder, 0) + 1
            );
        }

        return count;
    }
}