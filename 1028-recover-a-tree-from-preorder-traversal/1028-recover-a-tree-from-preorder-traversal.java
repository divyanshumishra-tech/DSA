import java.util.*;

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {

        Deque<TreeNode> stack = new ArrayDeque<>();

        int i = 0;

        while (i < traversal.length()) {

            int depth = 0;

            // Count depth
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Read node value
            int value = 0;

            while (i < traversal.length() &&
                   Character.isDigit(traversal.charAt(i))) {

                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(value);

            // Move to the correct parent
            while (stack.size() > depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {

                TreeNode parent = stack.peek();

                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            stack.push(node);
        }

        // Bottom of stack is the root
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}