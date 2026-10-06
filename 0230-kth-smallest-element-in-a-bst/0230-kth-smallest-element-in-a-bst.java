class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Go as far left as possible — smallest values first
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Visit the node (simulates the in-order "process" step)
            curr = stack.pop();
            if (--k == 0) {
                return curr.val;
            }

            // Move to the right subtree
            curr = curr.right;
        }

        return -1; // unreachable given k <= n
    }
}