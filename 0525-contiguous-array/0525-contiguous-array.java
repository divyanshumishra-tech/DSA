import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> first = new HashMap<>();

        // Prefix sum 0 exists before the array
        first.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (first.containsKey(sum)) {
                int length = i - first.get(sum);
                maxLength = Math.max(maxLength, length);
            } else {
                // Store only the first occurrence
                first.put(sum, i);
            }
        }

        return maxLength;
    }
}