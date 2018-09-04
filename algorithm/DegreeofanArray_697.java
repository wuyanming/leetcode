package HighFrequence.Summary;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray_697 {
    //Approach #1: Left and Right Index [Accepted]
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());

        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
    //Complexity Analysis
    //Time Complexity: O(N)O(N), where NN is the length of nums.
    //Every loop is through O(N)O(N) items with O(1)O(1) work inside the for-block.
    //
    //Space Complexity: O(N)O(N), the space used by left, right, and count.
}
