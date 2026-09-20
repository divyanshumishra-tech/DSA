 class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums, threshold, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isValid(int[] nums, int threshold, int divisor) {

        long sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;

            if (sum > threshold) {
                return false;
            }
        }

        return true;
    }
}