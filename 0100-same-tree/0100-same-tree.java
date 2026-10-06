import java.util.*;

class Solution {
    // ---------- Recursive ----------
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;    // both absent → same here
        if (p == null || q == null) return false;   // only one absent → differ
        if (p.val != q.val) return false;           // values differ → not same
        return isSameTree(p.left, q.left)           // same left child
            && isSameTree(p.right, q.right);        // same right child
    }
}