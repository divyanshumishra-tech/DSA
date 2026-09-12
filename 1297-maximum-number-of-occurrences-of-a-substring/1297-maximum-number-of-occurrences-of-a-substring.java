import java.util.*;

class Solution {
    public int maxFreq(String s, int maxLetters,
                       int minSize, int maxSize) {

        Map<String, Integer> freq = new HashMap<>();

        int[] count = new int[26];
        int distinct = 0;
        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'a';

            if (count[index] == 0) {
                distinct++;
            }

            count[index]++;

            // Keep window size = minSize
            if (right - left + 1 > minSize) {

                int remove = s.charAt(left) - 'a';

                count[remove]--;

                if (count[remove] == 0) {
                    distinct--;
                }

                left++;
            }

            // Check valid window
            if (right - left + 1 == minSize &&
                distinct <= maxLetters) {

                String sub = s.substring(left, right + 1);

                int current = freq.getOrDefault(sub, 0) + 1;

                freq.put(sub, current);

                answer = Math.max(answer, current);
            }
        }

        return answer;
    }
}