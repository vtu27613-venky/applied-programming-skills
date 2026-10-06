import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // key = (col, row), value = all node values at that exact position
        Map<Integer, Map<Integer, List<Integer>>> cols = new TreeMap<>();
        dfs(root, 0, 0, cols);

        List<List<Integer>> result = new ArrayList<>();
        for (Map<Integer, List<Integer>> rows : cols.values()) {   // cols in ascending order
            List<Integer> column = new ArrayList<>();
            for (List<Integer> vals : rows.values()) {             // rows top-to-bottom
                Collections.sort(vals);                            // same (row, col): sort by value
                column.addAll(vals);
            }
            result.add(column);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col,
                     Map<Integer, Map<Integer, List<Integer>>> cols) {
        if (node == null) return;
        cols.computeIfAbsent(col, c -> new TreeMap<>())
            .computeIfAbsent(row, r -> new ArrayList<>())
            .add(node.val);
        dfs(node.left, row + 1, col - 1, cols);
        dfs(node.right, row + 1, col + 1, cols);
    }
}