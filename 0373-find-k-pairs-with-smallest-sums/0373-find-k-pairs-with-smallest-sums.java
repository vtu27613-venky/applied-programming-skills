import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap over index pairs, ordered by nums1[i] + nums2[j]
        // Each entry: {i, j, nums1[i] + nums2[j]}
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );

        // Seed with (i, 0) for every i — the smallest j in nums2
        // Only need to push at most k entries from nums1
        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.offer(new int[]{i, 0, nums1[i] + nums2[0]});
        }

        while (k > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            int i = cur[0];
            int j = cur[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Advance to the next element in nums2 for this row
            if (j + 1 < nums2.length) {
                heap.offer(new int[]{i, j + 1, nums1[i] + nums2[j + 1]});
            }
        }

        return result;
    }
}