import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> frequency = new HashMap<>();

        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {

            frequency.put(
                fruits[right],
                frequency.getOrDefault(fruits[right], 0) + 1
            );

            while (frequency.size() > 2) {

                int fruit = fruits[left];

                frequency.put(fruit, frequency.get(fruit) - 1);

                if (frequency.get(fruit) == 0) {
                    frequency.remove(fruit);
                }

                left++;
            }

            maxFruits = Math.max(
                maxFruits,
                right - left + 1
            );
        }

        return maxFruits;
    }
}