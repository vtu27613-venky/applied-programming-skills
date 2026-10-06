import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, new StringBuilder(), result);
        return result;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> result) {
        int len = path.length(); // remember where this node's segment starts

        if (len > 0) {
            path.append("->");
        }
        path.append(node.val);

        // Leaf: no children, so the current path is complete
        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            if (node.left != null) dfs(node.left, path, result);
            if (node.right != null) dfs(node.right, path, result);
        }

        path.setLength(len); // backtrack: undo this node's segment
    }
}