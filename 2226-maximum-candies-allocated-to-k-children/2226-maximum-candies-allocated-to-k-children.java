class Solution {
    public int maximumCandies(int[] candies, long k) {

        int high = 0;

        for (int candy : candies) {
            high = Math.max(high, candy);
        }

        int low = 1;
        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canDistribute(candies, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canDistribute(
            int[] candies, long k, int perChild) {

        long children = 0;

        for (int candy : candies) {
            children += candy / perChild;

            if (children >= k) {
                return true;
            }
        }

        return false;
    }
}