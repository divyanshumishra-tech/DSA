import java.util.*;

class Solution {
    public String removeDuplicates(String s, int k) {

        // stack[i][0] = character
        // stack[i][1] = consecutive count
        Stack<int[]> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;

                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{c, 1});
            }
        }

        StringBuilder result = new StringBuilder();

        for (int[] pair : stack) {
            for (int i = 0; i < pair[1]; i++) {
                result.append((char) pair[0]);
            }
        }

        return result.toString();
    }
}