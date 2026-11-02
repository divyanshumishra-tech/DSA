
class Solution {

    public long findMaximumNumber(long k, int x) {

        long low = 0;
        long high = 1L << 60;

        while (low < high) {

            long mid = low + (high - low + 1) / 2;

            if (calculatePrice(mid, x, k) <= k) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private long calculatePrice(long n, int x, long k) {

        long total = 0;

        for (int pos = x; pos <= 60; pos += x) {

            long cycle = 1L << pos;
            long half = cycle >> 1;

            long count = ((n + 1) / cycle) * half;

            long remainder = (n + 1) % cycle;

            count += Math.max(0L, remainder - half);

            if (count > k - total) {
                return k + 1;
            }

            total += count;
        }

        return total;
    }
}