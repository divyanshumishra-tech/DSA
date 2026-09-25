class Solution {
    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                // Pair is correct, go right
                left = mid + 2;
            } else {
                // Single element is here or on the left
                right = mid;
            }
        }

        return nums[left];
    }
}