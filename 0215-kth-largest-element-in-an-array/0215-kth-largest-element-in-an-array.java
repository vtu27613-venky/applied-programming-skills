import java.util.Random;

class Solution {
    private final Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        // The kth largest == the (n - k)th smallest (0-indexed)
        int target = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, target);
    }

    private int quickSelect(int[] nums, int lo, int hi, int target) {
        // Random pivot avoids worst-case O(n^2) on already-sorted input
        int pivotIndex = lo + rand.nextInt(hi - lo + 1);
        swap(nums, pivotIndex, hi);

        int pivot = nums[hi];
        int store = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] < pivot) {
                swap(nums, store++, i);
            }
        }
        swap(nums, store, hi); // move pivot to its final sorted position

        if (store == target) {
            return nums[store];
        } else if (store < target) {
            return quickSelect(nums, store + 1, hi, target);
        } else {
            return quickSelect(nums, lo, store - 1, target);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}