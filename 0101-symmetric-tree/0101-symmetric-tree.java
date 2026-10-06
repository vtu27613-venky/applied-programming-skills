import java.util.*;

class Solution {
    // ---------- Recursive ----------
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;   // both absent → mirror
        if (a == null || b == null) return false;  // only one absent → not a mirror
        return a.val == b.val
            && isMirror(a.left, b.right)            // outer pair
            && isMirror(a.right, b.left);           // inner pair
    }
}