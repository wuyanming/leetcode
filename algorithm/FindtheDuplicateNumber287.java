package HighFrequence.Summary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindtheDuplicateNumber287 {
    //Approach #1 Sorting [Accepted]
    //Time complexity : O(nlgn)O(nlgn)
    //The sort invocation costs O(nlgn)O(nlgn) time in Python and Java, so it dominates the subsequent linear scan.

    //Space complexity : O(1)O(1) (or O(n)O(n))
    //Here, we sort nums in place, so the memory footprint is constant. If we cannot modify the input array,
    // then we must allocate linear space for a copy of nums and sort that instead.
    public int findDuplicateFirst(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }

    //Approach #2 Set [Accepted]
    //Time complexity : O(n)O(n)
    //Set in both Python and Java rely on underlying hash tables, so insertion and lookup have amortized constant time complexities.
    // The algorithm is therefore linear, as it consists of a for loop that performs constant work nn times.
    //
    //Space complexity : O(n)O(n)
    //In the worst case, the duplicate element appears twice, with one of its appearances at array index n-1n−1.
    //In this case, seen will contain n-1n−1 distinct values, and will therefore occupy O(n)O(n) space.
    public int findDuplicateSec(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

    //Approach #3 Floyd's Tortoise and Hare (Cycle Detection) [Accepted]
    //https://leetcode.com/articles/find-the-duplicate-number/
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        //Time complexity : O(n)O(n)
        //For detailed analysis, refer to Linked List Cycle II.
        //Space complexity : O(1)O(1)
        //For detailed analysis, refer to Linked List Cycle II.

        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

}
