class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] freq = new int[101];

        // Count frequency
        for (int num : nums) {
            freq[num]++;
        }

        // Convert frequency into prefix count
        for (int i = 1; i <= 100; i++) {
            freq[i] += freq[i - 1];
        }

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                answer[i] = 0;
            } else {
                answer[i] = freq[nums[i] - 1];
            }
        }

        return answer;
    }
}