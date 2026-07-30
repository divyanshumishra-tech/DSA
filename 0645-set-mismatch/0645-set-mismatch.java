class Solution {
    public int[] findErrorNums(int[] nums) {
        // time : O(n), n = number of elements to loop through
        // space: O(n), n = number of elements store in HashSet

        // i      0 1 2 3
        // nums = 1,2,2,4

        // output = 2,3 -> 2 is repetitive and 3 is missing

        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                result[0] = nums[i];
            }
            set.add(nums[i]);
        }

        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) result[1] = i;
        }

        return result;
    }
}