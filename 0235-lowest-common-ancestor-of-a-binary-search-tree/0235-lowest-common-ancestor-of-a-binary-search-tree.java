class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                // Both targets are smaller — LCA must be in the left subtree
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                // Both targets are larger — LCA must be in the right subtree
                curr = curr.right;
            } else {
                // Targets split across sides (or one equals curr) — this is the LCA
                return curr;
            }
        }
        return null; // unreachable: p and q are guaranteed to exist
    }
}