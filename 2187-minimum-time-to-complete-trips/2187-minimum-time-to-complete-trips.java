
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long min = Long.MAX_VALUE;

        for (int t : time) {
            min = Math.min(min, t);
        }

        long low = 1;
        long high = min * totalTrips;

        while (low < high) {
            long mid = low + (high - low) / 2;

            long trips = 0;

            for (int t : time) {
                trips += mid / t;

                if (trips >= totalTrips) {
                    break;
                }
            }

            if (trips >= totalTrips) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}