class Solution {

    private int min = Integer.MAX_VALUE;
    private int prev = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        if (root == null)
            return -1;

        getMinimumDifference(root.left);

        if (prev != Integer.MAX_VALUE)
            min = Math.min(min, root.val - prev);

        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }
}