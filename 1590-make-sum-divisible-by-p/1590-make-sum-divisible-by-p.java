import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {

        long total = 0;

        for (int num : nums) {
            total += num;
        }

        int rem = (int)(total % p);

        // Already divisible
        if (rem == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        // Prefix remainder 0 occurs before the array
        map.put(0, -1);

        long prefix = 0;
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {

            prefix = (prefix + nums[i]) % p;

            int current = (int) prefix;

            int required = (current - rem + p) % p;

            if (map.containsKey(required)) {
                answer = Math.min(
                    answer,
                    i - map.get(required)
                );
            }

            // Store latest index
            map.put(current, i);
        }

        return answer == nums.length ? -1 : answer;
    }
}