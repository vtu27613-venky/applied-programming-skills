import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !stack.isEmpty()) {
            // Go as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode peek = stack.peek();

            // If a right subtree exists and we haven't finished it, go right
            if (peek.right != null && peek.right != lastVisited) {
                curr = peek.right;
            } else {
                // Both subtrees done (or absent) → visit this node
                result.add(peek.val);
                lastVisited = stack.pop();
            }
        }
        return result;
    }
}