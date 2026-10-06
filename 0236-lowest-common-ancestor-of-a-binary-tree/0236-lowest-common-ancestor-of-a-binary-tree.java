class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: hit the bottom, or found one of the targets
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Found one target on each side → current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return whichever side found something (or null)
        return left != null ? left : right;
    }
}